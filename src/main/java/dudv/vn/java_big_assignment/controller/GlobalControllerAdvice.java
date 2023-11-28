package dudv.vn.java_big_assignment.controller;
import dudv.vn.java_big_assignment.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

public class GlobalControllerAdvice {
    @Autowired
    BookingService bookingService;

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        String globalValue = "This is a global value!";
        model.addAttribute("globalValue", globalValue);
    }
}
