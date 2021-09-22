package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService  {
    List<User> listUser();
    void addUser(User user);
    void removeUser(Long id);
    public User getUser(Long id);
    public void updateUser(User user);
    User findByUserName(String name);
}
