package ru.itis.kpfu.servlets;

import ru.itis.kpfu.dao.CredentialsDao;
import ru.itis.kpfu.dao.CredentialsDaoJdbcTemplateImpl;
import ru.itis.kpfu.model.Credentials;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change")
public class ProfileChangeServlet extends HttpServlet {

    CredentialsDao credentialsDao = new CredentialsDaoJdbcTemplateImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("uname", req.getSession().getAttribute("session_uname"));
        getServletConfig().getServletContext().getRequestDispatcher("/profileChange.ftl")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Credentials credential = new Credentials();
        credential.setLogin(username);
        credential.setPassword(password);
        credential.setId(credentialsDao.findByName((String) req.getSession()
                .getAttribute("session_uname")).getId());
        credentialsDao.update(credential);
        req.getSession().setAttribute("session_uname", credentialsDao.findByPrimaryKey(credential.getId()).getLogin());
        req.setAttribute("session_uname", req.getSession().getAttribute("session_uname"));
        resp.sendRedirect("/profile");
    }
}
