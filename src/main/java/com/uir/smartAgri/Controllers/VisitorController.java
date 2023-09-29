package com.uir.smartAgri.Controllers;


import com.uir.smartAgri.Entities.Farm;
import com.uir.smartAgri.Services.FarmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/visitor")
@AllArgsConstructor
public class VisitorController {
    private FarmService farmService;
    @GetMapping("")
    public String listFarms(Model model) {
        List<Farm> farms = farmService.findAll();
        model.addAttribute("farms", farms);
        return "pages/visitor/visitor-home";
    }
}
