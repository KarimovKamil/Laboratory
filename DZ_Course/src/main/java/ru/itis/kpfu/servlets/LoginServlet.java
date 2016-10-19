package ru.itis.kpfu.servlets;

import ru.itis.kpfu.dao.CredentialsDao;
import ru.itis.kpfu.dao.CredentialsDaoImpl;
import ru.itis.kpfu.dao.CredentialsDaoJdbcTemplateImpl;
import ru.itis.kpfu.model.Credentials;
import ru.itis.kpfu.servlets.utils.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    CredentialsDao credentialsDao = new CredentialsDaoJdbcTemplateImpl();
    MD5 md5 = new MD5();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String salt = md5.encode(req.getParameter("password"));

        Credentials credentials;
        try {
            credentials = credentialsDao.findByName(username);
        } catch (Exception e) {
            req.setAttribute("error", true);
            getServletConfig().getServletContext().getRequestDispatcher("/login.ftl")
                    .forward(req, resp);
            return;
        }

        if (credentials.getSalt().equals(salt)) {
            req.getSession().setAttribute("session_uname", username);
            resp.sendRedirect("/profile");
        } else {
            req.setAttribute("error", true);
            getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(req, resp);
        }
    }
}
