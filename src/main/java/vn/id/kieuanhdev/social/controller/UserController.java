package vn.id.kieuanhdev.social.controller;

import org.springframework.web.bind.annotation.*;
import vn.id.kieuanhdev.social.models.User;
import vn.id.kieuanhdev.social.repository.UserRepository;
import vn.id.kieuanhdev.social.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //post (create)
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    //get (1 user || all user)
    //1 user
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {

        return userService.getUserById(id);
    }
    //all user
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //put (updateuser)
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
       return userService.updateUser(id, user);
    }
    //delete (delete user)
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return userService.deleteUser(user);
    }



}
