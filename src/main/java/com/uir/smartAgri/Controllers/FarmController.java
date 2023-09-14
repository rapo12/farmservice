package com.uir.smartAgri.Controllers;


import com.uir.smartAgri.Entities.Farm;

import com.uir.smartAgri.Entities.User;
import com.uir.smartAgri.Services.FarmService;


import com.uir.smartAgri.Services.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/farms")
@AllArgsConstructor
public class FarmController {
    private  FarmService farmService;
    private UserService userService;
    @GetMapping("/list")
    public String listFarms(Model model) {
        List<Farm> farms = farmService.findAll();
        model.addAttribute("farms", farms);
        return "pages/farmsHome";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("farm", new Farm());
        return "pages/add-farm";
    }
    @PostMapping("/add")
    public String addFarm(@ModelAttribute("farm") @Valid Farm farm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("notification", "Farm not added, please check your input information");
            return "redirect:/farms/add";
        }
        try{
            farmService.save(farm);
            redirectAttributes.addFlashAttribute("notification", "Farm added successfully");
            return "redirect:/farms/list";
        }catch(DataIntegrityViolationException e){
            redirectAttributes.addFlashAttribute("notification", "Farm name must be unique and not exceed 30 characters");

            return "redirect:/farms/add";
        }
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Farm farm = farmService.findById(id);
        model.addAttribute("farm", farm);
        return "pages/edit-farm";
    }
    @PostMapping("/edit/{id}")
    public String editFarm(@PathVariable("id") Long id, @ModelAttribute("farm") @Valid Farm farm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("notification", "Farm not updated, please check your input information");
            farm.setIdFarm(id);
            return "redirect:/farms/edit/" + id;
        }
        try{
            farmService.updateFarm(id,farm);
            redirectAttributes.addFlashAttribute("notification", "Farm Updated successfully");
            return "redirect:/farms/list";
        }catch(DataIntegrityViolationException e){
            redirectAttributes.addFlashAttribute("notification", "Farm name must be unique and not exceed 30 characters");
            farm.setIdFarm(id);
            return "redirect:/farms/edit/" + id;
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteFarm(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if(farmService.findById(id)!=null){
            farmService.delete(id);
            redirectAttributes.addFlashAttribute("notification", "Farm with id=" + id + " deleted successfully");
            return "redirect:/farms/list";
        }
        else{
            redirectAttributes.addFlashAttribute("notification", "Farm with id=" + id + " Not exist");
            return "redirect:/farms/list";
        }


    }
    @GetMapping("/users")
    public String mangedUserAndFarms(Model model) {
        List<Farm> allFarms=farmService.findAll();
        model.addAttribute("farms", allFarms);
        return "pages/users-farms.html";
    }
    @GetMapping("/selectFarm")
    public String selectFarm(@RequestParam(name = "selectedFarmId", required = false) Long selectedFarmId, Model model) {
        // Retrieve the list of farms and users as needed, and update the model
        List<Farm> farms = farmService.findAll();
        model.addAttribute("farms", farms);

        if (selectedFarmId != null) {
            Farm selectedFarm = farmService.getFarmById(selectedFarmId);
            List<User> usersForFarm = selectedFarm.getUsers();
            model.addAttribute("users", usersForFarm);
        }

        return "pages/users-farms.html"; // Replace with the name of your Thymeleaf template
    }
    @GetMapping("/userFarm")
    public String userFarm(@RequestParam("farmsid") Long selectedFarmId,@RequestParam("user")String selectedUser, RedirectAttributes redirectAttributes) {
            Farm f = farmService.findById(selectedFarmId);
            Boolean result = farmService.deleteUserFromFarm(selectedUser,f.getName());
            if(result){
                redirectAttributes.addFlashAttribute("notification", "User : " + selectedUser + " has removed from manage Farm :  "+f.getName());
                return "redirect:/farms/users";
            }else{
                redirectAttributes.addFlashAttribute("notification", "User : " + selectedUser + " has Not removed from manage Farm :"+f.getName()+"Due to error");
                return "redirect:/farms/users";
            }

    }
    @GetMapping("/userFarmnotexist")
    public String userFarmnotexist(@RequestParam("farmsid") Long selectedFarmId,@RequestParam("user")String selectedUser, RedirectAttributes redirectAttributes) {
        Farm f = farmService.findById(selectedFarmId);
        Boolean result = farmService.addUserToFarm(selectedUser,f.getName());
        if(result){
            redirectAttributes.addFlashAttribute("notification", "User : " + selectedUser + " has added TO manage Farm :  "+f.getName());
            return "redirect:/farms/users";
        }else{
            redirectAttributes.addFlashAttribute("notification", "User : " + selectedUser + " has Not added TO manage Farm :"+f.getName()+"Due to error");
            return "redirect:/farms/users";
        }

    }

}
