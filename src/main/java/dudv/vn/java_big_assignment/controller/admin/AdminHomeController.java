package dudv.vn.java_big_assignment.controller.admin;

import dudv.vn.java_big_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@RequestMapping("admin")
public class AdminHomeController {
    @Autowired
    UserService userService;

    @RequestMapping("")
    public String home(){
        return "/admin/adminHome.html";
    }

    @RequestMapping("/category")
    public String category(){
        return "/admin/category.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    String listUser(Model model){
        Object list = userService.getAllUser();
        model.addAttribute("list", list);
        return "/admin/user.html";
    }
}
