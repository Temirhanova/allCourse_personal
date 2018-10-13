package ru.innopolis.stc13.service.interfaces;

public interface LoginService {
    int getRole(String login);
    boolean checkAuth(String login, String password);
}
