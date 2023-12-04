package com.example.rently.Controllers;

import com.example.rently.Entities.UsersEntity;
import com.example.rently.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<UsersEntity> getAllUsers() {
        return usersService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public UsersEntity getUserById(@PathVariable int id) {
        return usersService.getUserById(id);
    }

    @PostMapping("/user/save")
    public UsersEntity saveUser(@RequestBody UsersEntity user) {
        return usersService.saveUser(user);
    }

    @PutMapping("/user/update/{id}")
    public UsersEntity updateUser(@PathVariable int id, @RequestBody UsersEntity updatedUser) {
        return usersService.updateUser(id, updatedUser);
    }
    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
    }
}
