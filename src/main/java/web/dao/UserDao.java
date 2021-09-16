package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> listAllUser();
    void addUser(User user);
    void removeUser(int id);
    void updateUser(int id, User user);
    User getUser(int id);

}
