package mn.ect.controller;

import mn.ect.dao.AppUserDAO;
import mn.ect.entity.AppUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/update-user")
public class AppUserUpdateServlet extends HttpServlet {
    private AppUserDAO userDAO;

    public void init() {
        userDAO = new AppUserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String active = request.getParameter("active");

        Optional<AppUser> optionalUser = userDAO.findById(id);
        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);

            if (password != null && !password.isEmpty()) {
                user.setPasswordHash(password);
            }

            if (role != null && !role.isEmpty()) {
                user.setRole(role);
            }

            if (active != null) {
                user.setActive(Boolean.parseBoolean(active));
            }

            userDAO.update(user);
        }

        response.sendRedirect("users");
    }
}