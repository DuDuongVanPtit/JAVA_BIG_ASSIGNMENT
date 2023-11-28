package dudv.vn.java_big_assignment.service;

import dudv.vn.java_big_assignment.dto.UserDto;
import dudv.vn.java_big_assignment.entities.UserEntity;
import dudv.vn.java_big_assignment.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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

    public UserDto getDetailById(Integer id){
        UserDto userDto = new UserDto();
        UserEntity userEntity = userRepository.findFirstById(id);
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
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
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

    public boolean authenticate(String email, String password) {
        UserEntity userEntity = userRepository.findFirstByEmail(email);
        return userEntity != null && passwordEncoder.matches(password, userEntity.getPassword());
    }

}
