package com.uir.smartAgri.Services;


import com.uir.smartAgri.Entities.User;

import java.util.List;

public interface UserService {
    User add_user(User user);
    List<User> list_user();
    User update_user(Long id,User user);
    String delete_user(Long id);
    User findByUserLogin(String username);

}
