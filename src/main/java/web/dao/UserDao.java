package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao {
    List<User> listAllUser();
    void addUser(User user);
    void removeUser(Long id);
    void updateUser(User user);
    User findByUserName(String name);
    User getUser(Long id);

}
