package edu.birzeit.ecommerce.services;

import edu.birzeit.ecommerce.models.User;
import edu.birzeit.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }



    public User updateUser(int id, User user) {
        User existingUser = getUser(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        return userRepository.save(existingUser);
    }

    public void deleteUser(int id) {
     userRepository.deleteById(id);

    }


}
