package com.uir.smartAgri.Services;

import com.uir.smartAgri.Entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.uir.smartAgri.Repositories.UserRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService{
    private final UserRepository UserRepository;
    @Override
    public User add_user(User user) {
        return UserRepository.save(user);
    }

    @Override
    public List<User> list_user() {
        return UserRepository.findAll();
    }

    @Override
    public User update_user(Long id, User user) {
       return UserRepository.findById(id).map(u->{
            u.setEmail(user.getEmail());
            u.setUsername(user.getUsername());
            u.setName(user.getName());
            u.setPhone(user.getPhone());
            u.setPassword(user.getPassword());
            return UserRepository.save(u);
        }).orElseThrow(()->new RuntimeException("User not found"));
    }

    @Override
    public String delete_user(Long id) {
        UserRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public User findByUserLogin(String username) {
        return UserRepository.findByUsername(username);
    }
}
