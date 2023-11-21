package dudv.vn.java_big_assignment.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "service")
public class ServiceEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "code", nullable = false, length = 350)
    private String code;

    @Basic
    @Column(name = "title", nullable = false, length = 350)
    private String name;

    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;

    @Basic
    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Basic
    @Column(name = "thumbnail", nullable = false, length = 500)
    private String thumbnail;

    @Basic
    @Column(name = "description", nullable = false)
    private String description;

    @Basic
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
}
