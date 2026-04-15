package mn.ect.controller;

import mn.ect.dao.StockItemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-item")
public class StockItemDeleteServlet extends HttpServlet {
    private StockItemDAO itemDAO;

    public void init() {
        itemDAO = new StockItemDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        itemDAO.deleteById(id);
        response.sendRedirect("items");
    }
}