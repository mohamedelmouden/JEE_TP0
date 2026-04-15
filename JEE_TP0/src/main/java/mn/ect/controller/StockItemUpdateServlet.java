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
import java.util.Optional;

@WebServlet("/update-item")
public class StockItemUpdateServlet extends HttpServlet {
    private StockItemDAO itemDAO;

    public void init() {
        itemDAO = new StockItemDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String details = request.getParameter("details");
        BigDecimal unitPrice = new BigDecimal(request.getParameter("unitPrice"));
        Integer quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
        String skuCode = request.getParameter("skuCode");
        String category = request.getParameter("category");
        String reorderThreshold = request.getParameter("reorderThreshold");

        Optional<StockItem> optionalItem = itemDAO.findById(id);
        if (optionalItem.isPresent()) {
            StockItem item = optionalItem.get();
            item.setTitle(title);
            item.setDetails(details);
            item.setUnitPrice(unitPrice);
            item.setQuantityInStock(quantityInStock);
            item.setSkuCode(skuCode);
            item.setCategory(category);
            if (reorderThreshold != null && !reorderThreshold.isEmpty()) {
                item.setReorderThreshold(Integer.parseInt(reorderThreshold));
            }
            itemDAO.update(item);
        }

        response.sendRedirect("items");
    }
}
