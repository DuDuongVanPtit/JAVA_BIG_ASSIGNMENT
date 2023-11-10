package dudv.vn.java_big_assignment.controller.home;

import dudv.vn.java_big_assignment.dto.UserDto;
import dudv.vn.java_big_assignment.entities.UserEntity;
import dudv.vn.java_big_assignment.repository.UserRepository;
import dudv.vn.java_big_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    String register(@ModelAttribute UserDto userDto, Model model){
        userService.addUser(userDto);
        return "/home/home.html";
    }

}