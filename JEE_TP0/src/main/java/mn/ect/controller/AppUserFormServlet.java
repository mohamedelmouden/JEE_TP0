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
import java.util.Optional;

@WebServlet("/user-form")
public class AppUserFormServlet extends HttpServlet {
    private AppUserDAO userDAO;

    public void init() {
        userDAO = new AppUserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Optional<AppUser> user = userDAO.findById(id);
            user.ifPresent(u -> request.setAttribute("user", u));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-form.jsp");
        dispatcher.forward(request, response);
    }
}