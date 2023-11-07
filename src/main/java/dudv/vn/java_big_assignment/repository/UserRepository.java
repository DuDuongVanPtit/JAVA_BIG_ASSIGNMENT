package dudv.vn.java_big_assignment.repository;

import dudv.vn.java_big_assignment.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
        ArrayList<UserEntity> findAllByFullName(String fullName);

        UserEntity findFirstByPhoneNumber(String phoneNumber);
}
