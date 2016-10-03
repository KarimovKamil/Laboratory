package ru.itis.inform;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class SimpleServlet extends HttpServlet {
    private HashMap<String, String> lp;

    @Override
    public void init() throws ServletException {
        lp = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            lp.put("admin" + i, "qwerty" + i);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        boolean flag = lp.containsKey(name) && lp.get(name).equals(password);
        req.setAttribute("message", "Hey, " + name);
        req.setAttribute("flag", flag);
        getServletConfig().getServletContext().getRequestDispatcher("/views/hello.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}