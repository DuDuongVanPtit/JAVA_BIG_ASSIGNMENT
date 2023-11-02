package dudv.vn.java_big_assignment.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("home.html")
    public String home(){
        return "/test/home.html";
    }
}
