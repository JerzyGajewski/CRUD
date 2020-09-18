package pl.jerzyGajewski.web;

import pl.jerzyGajewski.Dao.UserDao;
import pl.jerzyGajewski.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/userServlet"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", UserDao.showAllUsers());
     getServletContext().getRequestDispatcher(request.getContextPath() + "/WEB-INF/views/login.jsp").forward(request,response);
    }
}
