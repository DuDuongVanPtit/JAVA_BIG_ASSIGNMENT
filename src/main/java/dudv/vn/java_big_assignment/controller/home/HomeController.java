package dudv.vn.java_big_assignment.controller.home;

import dudv.vn.java_big_assignment.dto.UserDto;
import dudv.vn.java_big_assignment.entities.CategoryEntity;
import dudv.vn.java_big_assignment.entities.UserEntity;
import dudv.vn.java_big_assignment.repository.UserRepository;
import dudv.vn.java_big_assignment.service.CategoryService;
import dudv.vn.java_big_assignment.service.ServiceService;
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
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ServiceService serviceService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String home(Model model) {
        Object categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "/home/home.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    String registerForm(@RequestParam(required = false) String fullName, Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "/user/createUser.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    String loginForm(@RequestParam(required = false) String fullName, Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "/user/userLogin.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/loginSuccessful")
    String Successful(@ModelAttribute UserDto userDto, Model model, RedirectAttributes redirectAttributes){
        UserDto a = userService.getDetailByEmail(userDto.getEmail());
        if(a == null){
            model.addAttribute("emailError", "Email not registered");
            return "/user/userLogin.html";
        }
        if(userDto.getPassword().compareTo("") == 0){
            model.addAttribute("passwordError", "Please enter your password");
            return "/user/userLogin.html";
        }
        if(a.getPassword().compareTo(userDto.getPassword()) != 0){
            model.addAttribute("passwordError", "Invalid password");
            return "/user/userLogin.html";
        }
        redirectAttributes.addFlashAttribute("loggedInUser", a);
        return "redirect:/home";
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
        if(userDto.getPassword().compareTo(userDto.getRePassword()) != 0){
            model.addAttribute("passwordError", "Passwords do not match");
            return "/user/createUser.html";
        }
        userService.addUser(userDto);
        return "/home/home.html";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/category/{id}")
    public String categoryDetails(@PathVariable Integer id,Model model){
        Object listServices = serviceService.getServicesByCategoryId(id);
        model.addAttribute("listServices", listServices);
        return "/category/services.html";
    }
}