package com.uir.smartAgri.Controllers;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import com.uir.smartAgri.Entities.User;
import java.util.List;
import com.uir.smartAgri.Services.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private  UserService UserService;

    @GetMapping("/list")
    public List<User> get_users(){
        return UserService.list_user();
    }
    @PostMapping("/add")
    public User add_user(@RequestBody User user){
       return UserService.add_user(user);
    }
    @PutMapping("/update/{id}")
    public User update_user(@PathVariable Long id, @RequestBody User user){
        return UserService.update_user(id,user);
    }
    @DeleteMapping("/delete/{id}")
    public String delete_user(@PathVariable  Long id){
        return UserService.delete_user(id);
    }

}
