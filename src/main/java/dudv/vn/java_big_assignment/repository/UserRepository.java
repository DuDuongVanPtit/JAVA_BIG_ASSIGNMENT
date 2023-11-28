package dudv.vn.java_big_assignment.repository;

import dudv.vn.java_big_assignment.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

        UserEntity findFirstByPhoneNumber(String phoneNumber);

        UserEntity findFirstByEmail(String email);

        UserEntity findFirstById(Integer id);
}
