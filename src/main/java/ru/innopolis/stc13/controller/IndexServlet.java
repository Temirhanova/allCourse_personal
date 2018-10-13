package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.service.implement.LoginServiceImpl;
import ru.innopolis.stc13.service.interfaces.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    private String testString = "";
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("logout".equals(req.getParameter("action"))) {
            req.getSession().invalidate();
        }
        if (req.getSession().getAttribute("login") != null) {
            int role = loginService.getRole(req.getSession().getAttribute("login").toString());
            switch (role) {
                case 1 : resp.sendRedirect("/inner/admin"); break;
                case 2 : resp.sendRedirect("/inner/manager"); break;
                case 3 : resp.sendRedirect("/inner/client"); break;
                case 4 : resp.sendRedirect("/inner/teacher"); break;
                default: resp.sendRedirect("/index?access=accesIsOpen"); break;
            }
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if ("Войти".equals(req.getParameter("signIn"))) {
            if (loginService.checkAuth(login, password)) {
                int role = loginService.getRole(login);
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("password", password);
                req.getSession().setAttribute("role", role);
                switch (role) {
                    case 1 : resp.sendRedirect("/inner/admin"); break;
                    case 2 : resp.sendRedirect("/inner/manager"); break;
                    case 3 : resp.sendRedirect("/inner/client"); break;
                    case 4 : resp.sendRedirect("/inner/teacher"); break;
                    default: resp.sendRedirect("/index?access=accesIsOpen"); break;
                }

            } else {
                resp.sendRedirect("/index?errorCode=wrongLogin");
            }

        }

        if ("Регитсрация".equals(req.getParameter("registration"))) {
            resp.sendRedirect("/registration?action=registration");
        }
    }
}
