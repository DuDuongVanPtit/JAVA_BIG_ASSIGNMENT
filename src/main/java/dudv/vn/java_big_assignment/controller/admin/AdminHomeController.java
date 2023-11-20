package dudv.vn.java_big_assignment.controller.admin;

import dudv.vn.java_big_assignment.dto.CategoryDto;
import dudv.vn.java_big_assignment.dto.ServiceDto;
import dudv.vn.java_big_assignment.service.CategoryService;
import dudv.vn.java_big_assignment.service.ServiceService;
import dudv.vn.java_big_assignment.service.UserService;
import dudv.vn.java_big_assignment.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RequestMapping("admin")
public class AdminHomeController {
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ServiceService serviceService;

    @RequestMapping("")
    public String home(){
        return "/admin/adminHome.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    String listUser(Model model){
        Object list = userService.getAllUser();
        model.addAttribute("list", list);
        return "/admin/user.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/services")
    String services(Model model){
        ServiceDto serviceDto = new ServiceDto();
        model.addAttribute("serviceDto", serviceDto);
        Object serviceList = serviceService.getAllServices();
        model.addAttribute("serviceList", serviceList);
        Object categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "/admin/service.html";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/service/add")
    public String addService(@ModelAttribute ServiceDto serviceDto, @RequestParam("image")MultipartFile multipartFile) throws IOException {
        if(!multipartFile.isEmpty()){
            String tmp = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            System.out.println(serviceDto.getId());
            String fileName = (""+serviceDto.getId()) + tmp.substring(tmp.lastIndexOf("."));
            serviceDto.setThumbnail(fileName);
            ServiceDto saveService = serviceService.addService(serviceDto);
            String upload = Paths.get("src", "main", "resources", "static", "images").toString();

            FileUploadUtil.saveFile(upload, fileName, multipartFile);
        }
        else{
            if(serviceDto.getThumbnail().isEmpty()){
                serviceDto.setThumbnail(null);
                serviceService.addService(serviceDto);
            }
        }
        serviceService.addService(serviceDto);
        return "redirect:/admin/services";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/service/delete/{id}")
    public String deleteService(@PathVariable Integer id){
        serviceService.deleteService(id);
        return "redirect:/admin/services";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    public String categories(Model model) {
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("categoryDto",categoryDto);
        Object categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "/admin/category.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/category/add")
    public String addCategory(@ModelAttribute CategoryDto categoryDto, Model model, RedirectAttributes
            redirectAttributes){
        CategoryDto check = categoryService.getCategoryByName(categoryDto.getName());
        if(check != null){
            model.addAttribute("errorName", "Name already exists");
        }
        categoryService.addCategory(categoryDto);
        redirectAttributes.addFlashAttribute("alert", "add category successfully");
        return "redirect:/admin/categories";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/delete/{id}")
    public String deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/categories";
    }
}
