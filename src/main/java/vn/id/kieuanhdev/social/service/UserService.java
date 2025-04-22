package vn.id.kieuanhdev.social.service;

import org.springframework.stereotype.Service;
import vn.id.kieuanhdev.social.models.User;
import vn.id.kieuanhdev.social.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {

//    public User saveUser(User user);
//
//    public User updateUser(int id ,User user);
//
//    public String deleteUser(User user);
//
//    public List<User> getAllUsers();
//
//    public User getUserById(int id);

    User regitsterUser(User user);

    User findUserById(int id);

    User findUserByEmail(String email);

    User followUser(int userId1, int userId2);

    User updateUser(User user, int userId);


    List<User> getAllUsers();

    String deleteUser(User user);

    List<User> searchUser(String query);

}
