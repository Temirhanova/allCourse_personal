package ru.innopolis.stc13.service.interfaces;

import ru.innopolis.stc13.pojo.Role;

import java.util.Set;

public interface RoleService {
    int add(Role role);
    Role update(Role role);
    boolean delete(int id);
    Role getById(int id);
    Set<Role> getAll();
}
