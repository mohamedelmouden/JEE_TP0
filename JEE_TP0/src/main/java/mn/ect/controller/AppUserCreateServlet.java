package mn.ect.controller;

import mn.ect.dao.AppUserDAO;
import mn.ect.entity.AppUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-user")
public class AppUserCreateServlet extends HttpServlet {
    private AppUserDAO userDAO;

    public void init() {
        userDAO = new AppUserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (role == null || role.isEmpty()) {
            role = "USER";
        }

        AppUser newUser = new AppUser(firstName, lastName, email, password);
        newUser.setRole(role);
        userDAO.save(newUser);

        response.sendRedirect("users");
    }
}