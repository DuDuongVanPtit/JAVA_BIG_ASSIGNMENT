package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.dto.CategoryDto;
import dudv.vn.java_big_assignment.dto.UserDto;
import dudv.vn.java_big_assignment.entities.CategoryEntity;
import dudv.vn.java_big_assignment.entities.UserEntity;
import dudv.vn.java_big_assignment.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ArrayList<CategoryEntity> getAllCategories(){
        return ((ArrayList<CategoryEntity>) categoryRepository.findAll());
    }

    public CategoryDto getCategoryByName(String name){
        CategoryDto categoryDto = new CategoryDto();
        CategoryEntity categoryEntity = categoryRepository.findFirstByName(name);
        if(categoryDto != null && categoryEntity != null){
            BeanUtils.copyProperties(categoryEntity, categoryDto);
            return categoryDto;
        }
        else{
            return null;
        }
    }

    public CategoryDto addCategory(CategoryDto categoryDto){
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryDto, categoryEntity);
        categoryRepository.save(categoryEntity);
        categoryDto.setId(categoryEntity.getId());
        return categoryDto;
    }

    public void deleteCategory(Integer categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
