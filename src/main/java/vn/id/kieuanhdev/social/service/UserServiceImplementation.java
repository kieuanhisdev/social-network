package vn.id.kieuanhdev.social.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.id.kieuanhdev.social.models.User;
import vn.id.kieuanhdev.social.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public User regitsterUser(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return userRepository.save(newUser);
    }

    @Override
    public User findUserById(int id) {
        Optional<User> user =  userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user =  userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @Override
    public User followUser(int userId1, int userId2) {
        User user1 = findUserById(userId1); // nguoi di follow
        User user2 = findUserById(userId2); // nguoi bi follow

        user2.getFollowers().add(user1.getId());
        user1.getFollowings().add(user2.getId());
        userRepository.save(user1);
        userRepository.save(user2);

        return user1;
    }

    @Override
    public User updateUser(User user, int userId) {
        Optional<User> user1 = userRepository.findById(userId);

        User oldUser = user1.get();
        if(user.getFirstName()!=null) {
            oldUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null) {
            oldUser.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null) {
            oldUser.setEmail(user.getEmail());
        }
        return userRepository.save(oldUser);

    }

//    public User saveUser(User user) {
//        User newUser = new User();
//        newUser.setEmail(user.getEmail());
//        newUser.setPassword(user.getPassword());
//        newUser.setFirstName(user.getFirstName());
//        newUser.setLastName(user.getLastName());
//        return userRepository.save(newUser);
//    }
//
//    public User updateUser(int id ,User user) {
//        User userToUpdate = userRepository.findById(id).get();
//        userToUpdate.setEmail(user.getEmail());
//        userToUpdate.setPassword(user.getPassword());
//        userToUpdate.setFirstName(user.getFirstName());
//        userToUpdate.setLastName(user.getLastName());
//        return userRepository.save(userToUpdate);
//    }
//
    public String deleteUser(User user) {
        userRepository.delete(user);
        return "User deleted";
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }

    //
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


//
//    public User getUserById(int id) {
//        Optional<User> user =  userRepository.findById(id);
//        return user.orElse(null);
//    }

}
