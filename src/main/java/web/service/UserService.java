package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService {
    List<User> listUser();
    void addUser(User user);
    void removeUser(int id);
    public User getUser(int id);
    public void updateUser(User user);

}
