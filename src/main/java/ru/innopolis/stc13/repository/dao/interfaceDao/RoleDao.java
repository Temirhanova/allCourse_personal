package ru.innopolis.stc13.repository.dao.interfaceDao;

import ru.innopolis.stc13.pojo.Role;

import java.util.Set;

public interface RoleDao {
    int add(Role role);
    Role update(Role role);
    boolean delete(int id);
    Role getByLogin(int id);
    Set<Role> getAll();
}
