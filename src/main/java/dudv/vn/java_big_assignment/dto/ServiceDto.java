package dudv.vn.java_big_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceDto {
    public ServiceDto(){}

    private Integer id;
    private String name;
    private Integer price;
    private Integer discount;
    private String thumbnail;
    private String description;
    private Integer categoryId;

}
