package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.entities.CategoryEntity;
import dudv.vn.java_big_assignment.entities.ServiceEntity;
import dudv.vn.java_big_assignment.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public ArrayList<ServiceEntity> getServicesByCategoryId(Integer categoryId){
        return (ArrayList<ServiceEntity>) serviceRepository.findAllByCategoryId(categoryId);
    }
}
