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

    public User regitsterUser(User user);

    public User findUserById(int id);

    public User findUserByEmail(String email);

    public User followUser(int userId1, int userId2);

    public User updateUser(User user, int userId);


    public List<User> getAllUsers();

    public String deleteUser(User user);

    public List<User> searchUser(String query);

}
