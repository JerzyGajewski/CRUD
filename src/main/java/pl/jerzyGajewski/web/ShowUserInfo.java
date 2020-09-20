package pl.jerzyGajewski.web;

import pl.jerzyGajewski.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowUserInfo", urlPatterns = {"/showInfo"})
public class ShowUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String idValue = request.getParameter("id");
        int id = Integer.parseInt(idValue);
        request.setAttribute("showInfo", UserDao.showUser(id));
        getServletContext().getRequestDispatcher("/WEB-INF/views/showInfo.jsp").forward(request, response);

    }
}
