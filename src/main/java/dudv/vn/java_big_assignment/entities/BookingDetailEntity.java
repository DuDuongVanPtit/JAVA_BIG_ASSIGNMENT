package dudv.vn.java_big_assignment.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "booking_detail")
public class BookingDetailEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;

    @Basic
    @Column(name = "total_money", nullable = false, length = 50)
    private Integer totalMoney;

    @Basic
    @Column(name = "booking_id", nullable = false)
    private Integer bookingId;

    @Basic
    @Column(name = "service_id", nullable = false)
    private Integer userId;

}
