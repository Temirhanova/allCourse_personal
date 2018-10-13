package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.pojo.Role;
import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.service.implement.RoleServiceImpl;
import ru.innopolis.stc13.service.interfaces.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

public class RoleServlet extends HttpServlet {
    RoleService roleService;


    @Override
    public void init() throws ServletException {
        super.init();
        roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Role> users = roleService.getAll();
        System.out.println("in get - from url parametr - " + request.getParameter("update"));
        System.out.println("in get - idInPost - " + request.getAttribute("idd"));
        request.setAttribute("roles", users);
        request.getRequestDispatcher("/role.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("in post - from url parametr - " + request.getParameter("update"));
        System.out.println("in post - id - " + request.getParameter("id"));
        System.out.println("in post - create - " + request.getParameter("create"));
        request.setAttribute("idd", request.getParameter("id"));
        if ("Создать роль".equals(request.getParameter("create"))) {
            Role role = new Role(("".equals(request.getParameter("name"))) ? "" : request.getParameter("name"));
            roleService.add(role);
        }
//        request.getRequestDispatcher("/inner/role").forward(request, response);
        response.sendRedirect("/inner/role");

    }


}
