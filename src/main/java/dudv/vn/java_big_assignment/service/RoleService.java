package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.entities.RoleEntity;
import dudv.vn.java_big_assignment.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public ArrayList<RoleEntity> getAllRoles(){
        return (ArrayList<RoleEntity>) roleRepository.findAll();
    }
}
