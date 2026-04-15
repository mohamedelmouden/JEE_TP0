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
import java.util.List;

@WebServlet("/items")
public class StockItemListServlet extends HttpServlet {
    private StockItemDAO itemDAO;

    public void init() {
        itemDAO = new StockItemDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<StockItem> items = itemDAO.findAll();
        request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/item-list.jsp");
        dispatcher.forward(request, response);
    }
}
