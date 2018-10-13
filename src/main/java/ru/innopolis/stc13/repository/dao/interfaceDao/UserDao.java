package ru.innopolis.stc13.repository.dao.interfaceDao;

import ru.innopolis.stc13.pojo.User;

import java.sql.SQLException;
import java.util.Set;

public interface UserDao {
     int add(User user);
     User update(User user);
     boolean delete(int id);
     User getByLogin(String login);
     Set<User> getAll();
}
