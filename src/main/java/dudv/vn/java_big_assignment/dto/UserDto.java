package dudv.vn.java_big_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String createdAt;
    public UserDto(){}
}
