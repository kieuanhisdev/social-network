package vn.id.kieuanhdev.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.id.kieuanhdev.social.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getUserById(Integer id);
}
