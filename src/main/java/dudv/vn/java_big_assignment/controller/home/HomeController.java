package dudv.vn.java_big_assignment.controller.home;

import dudv.vn.java_big_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    String listUser(@RequestParam(required = false) String fullName, Model model){
        Object list = userService.getAllUser();
        model.addAttribute("list", list);
        return "/user/createUser.html";
    }

}