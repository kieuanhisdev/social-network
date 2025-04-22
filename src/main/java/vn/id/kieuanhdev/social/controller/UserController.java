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
        return userService.regitsterUser(user);
    }

    //get (1 user || all user)
    //1 user
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {

        return userService.findUserById(id);
    }
    //all user
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //put (updateuser)
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
       return userService.updateUser(user, id);
    }
    //delete (delete user)
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return userService.deleteUser(user);
    }

    @PutMapping("/users/follow/{userId1}/{userId2}")
    public User followUserHandel(@PathVariable Integer userId1, @PathVariable Integer userId2) {
        return userService.followUser(userId1, userId2);
    }

    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query){

        return userService.searchUser(query);
    }



}
