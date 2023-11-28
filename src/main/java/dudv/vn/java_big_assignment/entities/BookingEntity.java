package dudv.vn.java_big_assignment.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "booking")
public class BookingEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Basic
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Basic
    @Column(name = "address", nullable = false, length = 200)
    private  String address;

    @Basic
    @Column(name = "title", nullable = false, length = 500)
    private  String title;

    @Basic
    @Column(name = "thumbnail", nullable = false, length = 200)
    private  String thumbnail;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booking_date", nullable = false, updatable = false)
    private Date orderedAt;

    @Basic
    @Column(name = "total_money", nullable = false, length = 50)
    private Integer totalMoney;

    @Basic
    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
