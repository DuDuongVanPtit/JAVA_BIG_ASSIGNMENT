package dudv.vn.java_big_assignment.controller.home;

import dudv.vn.java_big_assignment.dto.UserDto;
import dudv.vn.java_big_assignment.entities.UserEntity;
import dudv.vn.java_big_assignment.repository.UserRepository;
import dudv.vn.java_big_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class HomeController {
    @RequestMapping("")
    public String home() {
        return "/home/home.html";
    }

    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET, value = "/register")
    String registerForm(@RequestParam(required = false) String fullName, Model model){
        Object list = userService.getAllUser();
        model.addAttribute("list", list);
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "/user/createUser.html";
    }

    @RequestMapping("/login")
    String loginForm(){
        return "/user/userLogin.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    String register(@Valid @ModelAttribute UserDto userDto,BindingResult bindingResult, Model model, RedirectAttributes
            redirectAttributes){
        if(bindingResult.hasErrors()){
            System.out.println("lỗi nhập vào");
            return "/user/createUser.html";
        }
        if(userService.getDetailByPhone(userDto.getPhoneNumber()) != null){
            model.addAttribute("phoneError", "Phone number already exists");
            return "/user/createUser.html";
        }
        if(userDto.getPassword().compareTo(userDto.getRePassword()) != 0){
            model.addAttribute("passwordError", "Passwords do not match");
            return "/user/createUser.html";
        }
        userService.addUser(userDto);
        return "/home/home.html";
    }

}