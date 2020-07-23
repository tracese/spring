package community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(@RequestParam(name = "name",required = false,defaultValue = "luojiji") String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
