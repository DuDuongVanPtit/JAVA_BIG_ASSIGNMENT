package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.entities.CategoryEntity;
import dudv.vn.java_big_assignment.entities.UserEntity;
import dudv.vn.java_big_assignment.repository.CategoryRepository;
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
}
