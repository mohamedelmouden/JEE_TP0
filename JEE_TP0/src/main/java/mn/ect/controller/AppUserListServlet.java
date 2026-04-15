package mn.ect.controller;

import mn.ect.dao.AppUserDAO;
import mn.ect.entity.AppUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class AppUserListServlet extends HttpServlet {
    private AppUserDAO userDAO;

    public void init() {
        userDAO = new AppUserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AppUser> users = userDAO.findAll();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-list.jsp");
        dispatcher.forward(request, response);
    }
}