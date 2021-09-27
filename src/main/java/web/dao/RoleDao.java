package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import java.util.List;
import java.util.Set;


public interface RoleDao {
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String rolename);
    List<Role> getAllRoles();
}
