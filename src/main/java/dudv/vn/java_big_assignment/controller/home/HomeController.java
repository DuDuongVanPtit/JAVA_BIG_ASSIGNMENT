package dudv.vn.java_big_assignment.controller.home;

import dudv.vn.java_big_assignment.dto.BookingDto;
import dudv.vn.java_big_assignment.dto.ServiceDto;
import dudv.vn.java_big_assignment.dto.UserDto;
import dudv.vn.java_big_assignment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    RoleService roleService;
    @Autowired
    BookingService bookingService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String home(Model model) {
        Object categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        Object bestTourList = serviceService.getServicesByCategoryId(4);
        Object bestRoomList = serviceService.getServicesByCategoryId(1);
        model.addAttribute("bestRoomList", bestRoomList);
        model.addAttribute("bestTourList", bestTourList);
        return "/home/home.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    String registerForm(@RequestParam(required = false) String fullName, Model model){
        UserDto userDto = new UserDto();
        Object roleList = roleService.getAllRoles();
        model.addAttribute("userDto", userDto);
        model.addAttribute("roleList", roleList);
        return "/user/createUser.html";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    String register(@Valid @ModelAttribute UserDto userDto,BindingResult bindingResult,
                    Model model, RedirectAttributes redirectAttributes){
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
        return "redirect:/home/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("error", false);
        return "/user/userLogin.html";
    }
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String email, @RequestParam String password,
                          Model model) {
        boolean isAuthenticated = userService.authenticate(email, password);
        UserDto userDto = userService.getDetailByEmail(email);
        if (isAuthenticated) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", true);
            return "/user/userLogin.html";
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/category/{id}")
    public String categoryDetails(@PathVariable Integer id,Model model){
        Object listServices = serviceService.getServicesByCategoryId(id);
        model.addAttribute("categoryId", id);
        model.addAttribute("listServices", listServices);
        return "/category/services.html";
    }

    @RequestMapping( "/booking")
    public String reDirect() {
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/booking/bookingList/{userId}")
    public String bookingList(@PathVariable Integer userId,Model model){
        Object bookingList = bookingService.getAllBookingByUserId(userId);
        model.addAttribute("bookingList", bookingList);
        return "/booking/bookingList.html";
    }

    @RequestMapping(method = RequestMethod.GET,
                    value = "/{categoryId}/services/booking/{userId}/{serviceId}")
    public String addBooking(@PathVariable Integer userId,
                           @PathVariable Integer serviceId,
                           @PathVariable Integer categoryId ,Model model,
                             RedirectAttributes redirectAttributes){
        ServiceDto serviceDto = serviceService.getServiceById(serviceId);
        UserDto userDto = userService.getDetailById(userId);
        bookingService.addBooking(
                userDto.getFullName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getAddress(),
                serviceDto.getName(),
                serviceDto.getThumbnail(),
                (serviceDto.getPrice() - serviceDto.getDiscount()),
                userDto.getId()
        );
        return "redirect:/home/category/" + categoryId;
    }

}