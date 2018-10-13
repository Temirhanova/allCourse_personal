package ru.innopolis.stc13.service.implement;

import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.repository.dao.interfaceDao.UserDao;
import ru.innopolis.stc13.repository.dao.implementDao.UserDaoImpl;
import ru.innopolis.stc13.service.interfaces.LoginService;
import ru.innopolis.stc13.utils.UtilMD5;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public int getRole(String login) {
        User user;
        if (login != null) {
            user = userDao.getByLogin(login);
            if (user == null){
                return -1;
            }
            return user.getRole();
        }
        return -1;
    }

    @Override
    public boolean checkAuth(String login, String password) {
        User user;

        if (login != null) {
            user = userDao.getByLogin(login);
            if (user != null){
//                    if (user.getPassword().equals(UtilMD5.md5Custom(password)))
                if (user.getPassword().equals(password))
                    return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
