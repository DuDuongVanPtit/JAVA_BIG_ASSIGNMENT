package dudv.vn.java_big_assignment.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminHome {
    @RequestMapping("")
    public String home(){
        return "/admin/adminHome.html";
    }
}
