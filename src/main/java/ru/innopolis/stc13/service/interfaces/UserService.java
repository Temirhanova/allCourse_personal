package ru.innopolis.stc13.service.interfaces;

import ru.innopolis.stc13.pojo.User;

import java.util.Set;

public interface UserService {
    int add(User user);
    User update(User user);
    boolean delete(int id);
    User getByLogin(String login);
    Set<User> getAll();
}
