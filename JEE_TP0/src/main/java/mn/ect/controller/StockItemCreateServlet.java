package mn.ect.controller;

import mn.ect.dao.StockItemDAO;
import mn.ect.entity.StockItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/create-item")
public class StockItemCreateServlet extends HttpServlet {
    private StockItemDAO itemDAO;

    public void init() {
        itemDAO = new StockItemDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String details = request.getParameter("details");
        BigDecimal unitPrice = new BigDecimal(request.getParameter("unitPrice"));
        Integer quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
        String skuCode = request.getParameter("skuCode");
        String category = request.getParameter("category");
        String reorderThreshold = request.getParameter("reorderThreshold");

        StockItem newItem = new StockItem(title, details, unitPrice, quantityInStock, skuCode, category);

        if (reorderThreshold != null && !reorderThreshold.isEmpty()) {
            newItem.setReorderThreshold(Integer.parseInt(reorderThreshold));
        }

        itemDAO.save(newItem);

        response.sendRedirect("items");
    }
}