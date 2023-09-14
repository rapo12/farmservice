package com.uir.smartAgri.Controllers;

import com.uir.smartAgri.Entities.Farm;
import com.uir.smartAgri.Entities.User;
import com.uir.smartAgri.Services.FarmService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("farmsrest")
public class FarmControllerRes {
    private FarmService farmService;
    @GetMapping("/")
    public List<Farm> getAllFarms(){
        return farmService.findAll();
    }
    @GetMapping("/ramoveuser")
    public String removeUserFromFarms(@PathParam("username") String username,@PathParam("farmName") String  farmName){
        farmService.deleteUserFromFarm(username,farmName);
        return "Done go and check verify";
    }
    @GetMapping("/users/{farmId}")
    public List<User> getUserByFarmId(@PathVariable("farmId") Long farmId){
        Farm farm=farmService.findById(farmId);
        List<User> getAllUsersByFarm=farm.getUsers();
        return getAllUsersByFarm;
    }
    @GetMapping("/usersnotexist/{farmId}")
    public List<User> getNotFoundUsers(@PathVariable("farmId") Long farmId){
        List<User> getAllUsersNotExistinFarm=farmService.getUsersNotExistInFarm(farmId);
        return getAllUsersNotExistinFarm;
    }

}
