package ru.innopolis.stc13.service.implement;

import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.repository.dao.implementDao.UserDaoImpl;
import ru.innopolis.stc13.repository.dao.interfaceDao.UserDao;
import ru.innopolis.stc13.service.interfaces.UserService;

import java.util.Set;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public int add(User user) {
        if (user != null) {
            return userDao.add(user);
        }
        return 0;
    }

    @Override
    public User update(User user) {
        if (user != null) {
            return userDao.update(user);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public User getByLogin(String login) {
        User user;
        if (login != null) {
            user = userDao.getByLogin(login);
            if (user != null) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Set<User> getAll() {
        return userDao.getAll();
    }
}
