package ru.innopolis.stc13.service.implement;

import ru.innopolis.stc13.pojo.Role;
import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.repository.dao.implementDao.RoleDaoImpl;
import ru.innopolis.stc13.repository.dao.interfaceDao.RoleDao;
import ru.innopolis.stc13.service.interfaces.RoleService;

import java.util.Set;

public class RoleServiceImpl implements RoleService {
    RoleDao roleDao = new RoleDaoImpl();
    @Override
    public int add(Role role) {
        if (role != null) {
            return roleDao.add(role);
        }
        return 0;
    }

    @Override
    public Role update(Role role) {
        if (role != null) {
            return  roleDao.update(role);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public Role getById(int id) {
        Role role;
        if (id != 0) {
            role = roleDao.getByLogin(id);
            if (role != null) {
                return roleDao.getByLogin(id);
            }
        }
        return null;
    }

    @Override
    public Set<Role> getAll() {
        return roleDao.getAll();
    }

}
