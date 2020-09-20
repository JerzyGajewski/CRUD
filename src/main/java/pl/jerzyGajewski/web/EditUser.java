package pl.jerzyGajewski.web;

import pl.jerzyGajewski.Dao.UserDao;
import pl.jerzyGajewski.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUser", urlPatterns = {"/edit"})
public class EditUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String idValue = request.getParameter("id");
        int id = Integer.parseInt(idValue);
        User user = UserDao.showUser(id);
        if (email.length() == 0) {
            user.getEmail();
        }else {
            user.setEmail(email);
        }
        if (password.length() == 0) {
            user.getPassword();
        }else {
            user.setUserName(name);
        }
        if (name.length() == 0) {
            user.getUserName();
        }else {
            user.setPassword(password);
        }
        UserDao.editUserData(user);
        response.sendRedirect("http://localhost:8080/userServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);

    }
}
