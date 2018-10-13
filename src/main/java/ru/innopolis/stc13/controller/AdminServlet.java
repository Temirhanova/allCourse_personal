package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.service.implement.UserServiceImpl;
import ru.innopolis.stc13.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class AdminServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("" + request.getParameter("updateId"));
        System.out.println("" + request.getParameter("deleteId"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
}
