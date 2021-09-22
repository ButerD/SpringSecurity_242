package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;


public interface RoleDao {
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String rolename);
}
