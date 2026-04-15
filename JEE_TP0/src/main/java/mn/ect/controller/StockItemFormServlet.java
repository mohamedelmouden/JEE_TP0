package mn.ect.controller;

import mn.ect.dao.StockItemDAO;
import mn.ect.entity.StockItem;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/item-form")
public class StockItemFormServlet extends HttpServlet {
    private StockItemDAO itemDAO;

    public void init() {
        itemDAO = new StockItemDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Optional<StockItem> item = itemDAO.findById(id);
            item.ifPresent(i -> request.setAttribute("item", i));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/item-form.jsp");
        dispatcher.forward(request, response);
    }
}