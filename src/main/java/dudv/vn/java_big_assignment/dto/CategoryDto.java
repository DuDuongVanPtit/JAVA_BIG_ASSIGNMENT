package dudv.vn.java_big_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class CategoryDto {
    public CategoryDto(){}
    private Integer id;

    @NotBlank(message = "Please enter category name")
    private String name;
}
