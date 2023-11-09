package dudv.vn.java_big_assignment.controller.register;


import dudv.vn.java_big_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    String listUser(Model model){
        Object list = userService.getAllUser();
        model.addAttribute("list", list);
        return "/user/listUser.html";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    String detaiUser(@PathVariable Integer id, Model model){
        Object u = userService.getDetailById(id);
        model.addAttribute("userDto", u);
        return "/user/create.html";
    }
}
