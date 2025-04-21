package vn.id.kieuanhdev.social.service;

import org.springframework.stereotype.Service;
import vn.id.kieuanhdev.social.models.User;
import vn.id.kieuanhdev.social.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return userRepository.save(newUser);
    }

    public User updateUser(int id ,User user) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        return userRepository.save(userToUpdate);
    }

    public String deleteUser(User user) {
        userRepository.delete(user);
        return "User deleted";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> user =  userRepository.findById(id);
        return user.orElse(null);
    }

}
