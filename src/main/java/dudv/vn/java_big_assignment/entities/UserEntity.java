package dudv.vn.java_big_assignment.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Basic
    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Basic
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Basic
    @Column(name = "address", nullable = false, length = 200)
    private  String address;

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Basic
    @Column(name = "created_at", nullable = false, length = 50)
    private String createdAt;

    @Basic
    @Column(name = "role_id", nullable = false, length = 50)
    private Integer roleId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList= new ArrayList<>();
        if(this.roleId != null){
            System.out.println(this.roleId);
            grantedAuthorityList.add(new SimpleGrantedAuthority("" + this.roleId));
        }
        return grantedAuthorityList;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

