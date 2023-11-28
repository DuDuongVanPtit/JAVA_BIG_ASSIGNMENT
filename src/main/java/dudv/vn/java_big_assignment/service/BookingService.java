package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.dto.BookingDto;
import dudv.vn.java_big_assignment.entities.BookingEntity;
import dudv.vn.java_big_assignment.repository.BookingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;

@Service
@Transactional
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public ArrayList<BookingEntity> getAllBooking(){
        ArrayList<BookingEntity> arr = (ArrayList<BookingEntity>) bookingRepository.findAll();
        Collections.reverse(arr);
        return arr;
    }

    public ArrayList<BookingEntity> getAllBookingByUserId(Integer userId){
        ArrayList<BookingEntity> arr = (ArrayList<BookingEntity>) bookingRepository.findAllByUserId(userId);
        Collections.reverse(arr);
        return arr;
    }

    public BookingDto getDetailBookingById(Integer id){
        BookingDto bookingDto = new BookingDto();
        BookingEntity bookingEntity = bookingRepository.findFirstById(id);
        if(bookingDto != null && bookingEntity != null){
            BeanUtils.copyProperties(bookingEntity, bookingDto);
            return bookingDto;
        }
        else{
            return null;
        }
    }

    public void addBooking(String fullName, String email,
                           String phoneNumber, String address, String title, String thumbnail, Integer totalMoney,
                           Integer userId){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setFullName(fullName);
        bookingEntity.setEmail(email);
        bookingEntity.setPhoneNumber(phoneNumber);
        bookingEntity.setAddress(address);
        bookingEntity.setTitle(title);
        bookingEntity.setThumbnail(thumbnail);
        bookingEntity.setTotalMoney(totalMoney);
        bookingEntity.setUserId(userId);
        bookingRepository.save(bookingEntity);
    }
}
