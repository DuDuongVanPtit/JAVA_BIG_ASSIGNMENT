package dudv.vn.java_big_assignment.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
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
    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Basic
    @Column(name = "created_at", nullable = false, length = 50)
    private String createdAt;

}

