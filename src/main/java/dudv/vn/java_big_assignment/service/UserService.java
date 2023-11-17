package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.dto.UserDto;
import dudv.vn.java_big_assignment.entities.UserEntity;
import dudv.vn.java_big_assignment.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserEntity> getAllUser(){
        ArrayList<UserEntity> ans = ((ArrayList<UserEntity>) userRepository.findAll());
        ans.sort((o1, o2) -> {
            return o1.getAddress().compareTo(o2.getAddress());
        });
        return ans;
    }

    public UserDto getDetailByPhone(String phoneNumber){
        UserDto userDto = new UserDto();
        UserEntity userEntity = userRepository.findFirstByPhoneNumber(phoneNumber);
        if(userDto != null && userEntity != null){
            BeanUtils.copyProperties(userEntity, userDto);
            return userDto;
        }
        else{
            return null;
        }
    }

    public UserDto getDetailByEmail(String email){
        UserDto userDto = new UserDto();
        UserEntity userEntity = userRepository.findFirstByEmail(email);
        if(userDto != null && userEntity != null){
            BeanUtils.copyProperties(userEntity, userDto);
            return userDto;
        }
        else return null;
    }

    public UserDto addUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userRepository.save(userEntity);
        userDto.setId(userEntity.getId());
        return userDto;
    }

    public Object updateUser(UserDto userDto){
        UserEntity userEntity = userRepository.findById(userDto.getId()).get();
        BeanUtils.copyProperties(userDto, userEntity);
        userRepository.save(userEntity);
        return userDto;
    }

}
