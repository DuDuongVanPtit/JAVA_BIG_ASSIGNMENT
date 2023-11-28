package dudv.vn.java_big_assignment.repository;

import dudv.vn.java_big_assignment.entities.CategoryEntity;
import dudv.vn.java_big_assignment.entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ServiceRepository extends JpaRepository <ServiceEntity, Integer> {
    ArrayList <ServiceEntity> findAllByCategoryId(Integer categoryId);

    ServiceEntity findFirstById(Integer id);
}
