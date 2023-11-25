package dudv.vn.java_big_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class UserDto {
    public UserDto(){}
    private Integer id;
    @NotBlank(message = "Full name can't be left blank")
    private String fullName;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Phone number is required")
//    @Digits(message = "Phone number format is incorect")
    private String phoneNumber;
    private String address;
    @NotBlank(message = "Password is required")
    private String password;
    private String createdAt;

    @NotBlank(message = "RePassword is required")
    private String rePassword;

    private String roleId;
}
