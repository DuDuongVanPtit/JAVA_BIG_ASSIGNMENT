package dudv.vn.java_big_assignment.repository;

import dudv.vn.java_big_assignment.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
    ArrayList <BookingEntity> findAllByUserId(Integer userId);

    BookingEntity findFirstById(Integer id);
}
