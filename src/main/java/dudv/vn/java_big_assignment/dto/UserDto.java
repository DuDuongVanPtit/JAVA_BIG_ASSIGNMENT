package dudv.vn.java_big_assignment.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String fullName, email, phoneNumber, address, password, createdAt, updatedAt;
    private Integer deleted;
}
