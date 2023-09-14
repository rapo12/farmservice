package com.uir.smartAgri.Controllers;

import com.uir.smartAgri.Entities.Farm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("test")
@Controller
public class testController {
    @GetMapping("/")
    public  String getFarms(Model model) {
        return "Hello from rapo";
    }
    @GetMapping("/sginin")
    public  String signin(Model model) {
        return "pages/sign-in";
    }
    @GetMapping("/home")
    public  String home(Model model) {
        return "pages/index";
    }


}
