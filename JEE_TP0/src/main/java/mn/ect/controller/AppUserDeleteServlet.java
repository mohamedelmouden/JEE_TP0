package mn.ect.controller;

import mn.ect.dao.AppUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-user")
public class AppUserDeleteServlet extends HttpServlet {
    private AppUserDAO userDAO;

    public void init() {
        userDAO = new AppUserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        userDAO.deleteById(id);
        response.sendRedirect("users");
    }
}