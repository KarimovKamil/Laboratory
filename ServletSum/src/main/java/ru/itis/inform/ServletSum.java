package ru.itis.inform;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.valueOf;

public class ServletSum extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numberA = valueOf(req.getParameter("a"));
        int numberB = valueOf(req.getParameter("b"));
        req.setAttribute("sum", numberA + numberB);
        getServletConfig().getServletContext().getRequestDispatcher("/views/answer.jsp").forward(req, resp);
    }
}
