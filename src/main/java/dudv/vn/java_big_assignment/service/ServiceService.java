package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.dto.ServiceDto;
import dudv.vn.java_big_assignment.entities.ServiceEntity;
import dudv.vn.java_big_assignment.repository.ServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public ArrayList<ServiceEntity> getAllServices(){
        return (ArrayList<ServiceEntity>) serviceRepository.findAll();
    }

    public ArrayList<ServiceEntity> getServicesByCategoryId(Integer categoryId){
        ArrayList<ServiceEntity> arr = serviceRepository.findAllByCategoryId(categoryId);
        arr.sort((o1, o2) -> {
            return o2.getDiscount() - o1.getDiscount();
        });
        return arr;
    }

    public ServiceDto getServiceById(Integer id){
        ServiceDto serviceDto = new ServiceDto();
        ServiceEntity serviceEntity = serviceRepository.findFirstById(id);
        if(serviceDto != null && serviceEntity != null){
            BeanUtils.copyProperties(serviceEntity, serviceDto);
            return serviceDto;
        }
        else{
            return null;
        }
    }
    public ServiceDto addService(ServiceDto serviceDto){
        ServiceEntity serviceEntity = new ServiceEntity();
        BeanUtils.copyProperties(serviceDto, serviceEntity);
        serviceRepository.save(serviceEntity);
        serviceDto.setId(serviceEntity.getId());
        return serviceDto;
    }
    public void deleteService(Integer serviceId){
        serviceRepository.deleteById(serviceId);
    }
}
