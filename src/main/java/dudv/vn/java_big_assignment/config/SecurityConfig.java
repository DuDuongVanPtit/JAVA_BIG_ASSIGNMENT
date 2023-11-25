package dudv.vn.java_big_assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests((authz) -> authz
                        //phân quyền cho admin
                        .antMatchers("/admin").hasAnyAuthority("1")
                        .antMatchers("/admin/*").hasAnyAuthority("1")
                        // đường dẫn bắt đầu bằng /backend thì bắt buộc phải đăng nhập
                        // admin** đệ quy(): cứ đường dẫn nào có /backend là chặn
                        // admin* chỉ chặn những yêu cầu /backend/user nhưng nếu /backend/user/list thì không chặn
                        .antMatchers("/admin/**").authenticated()
                        .anyRequest().permitAll()// các đường dẫn còn lại thì truy cập không bị chặn
                )

                .formLogin((form) -> {
                    form.loginPage("/home/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .loginProcessingUrl("/doLogin")
                            .defaultSuccessUrl("/home")
                            .failureUrl("/home/login");
                })

                .logout((logout) -> {
                    logout.logoutUrl("/logout")
                            .deleteCookies("JSESSIONID");
                })
        ;
        return http.build();
    }
}
