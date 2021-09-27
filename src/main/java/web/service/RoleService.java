package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String rolename);
    List<Role> getAllRoles();
}
