package edu.birzeit.ecommerce.controllers;

import edu.birzeit.ecommerce.models.User;
import edu.birzeit.ecommerce.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User>getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User user){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
