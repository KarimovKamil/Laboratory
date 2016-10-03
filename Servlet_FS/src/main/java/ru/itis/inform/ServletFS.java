package ru.itis.inform;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletFS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String directory = req.getParameter("directory");
        String mask = req.getParameter("mask");
        FilesSeeker fs = new FilesSeeker();
        List<String> list = fs.findFile(directory, mask, new ArrayList<String>());
        req.setAttribute("list", list);

        getServletConfig().getServletContext().getRequestDispatcher("/views/find.jsp").forward(req, resp);
    }
}
