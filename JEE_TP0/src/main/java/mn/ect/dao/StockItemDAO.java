package mn.ect.dao;

import mn.ect.entity.StockItem;
import mn.ect.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class StockItemDAO extends AbstractDAO<StockItem, Long> {

    public Optional<StockItem> findBySkuCode(String skuCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StockItem item = session.createQuery(
                    "FROM StockItem WHERE skuCode = :skuCode", StockItem.class)
                    .setParameter("skuCode", skuCode)
                    .uniqueResult();
            return Optional.ofNullable(item);
        }
    }

    public List<StockItem> findByCategory(String category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM StockItem WHERE category = :category", StockItem.class)
                    .setParameter("category", category)
                    .list();
        }
    }

    public List<StockItem> findLowStock() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM StockItem WHERE quantityInStock <= reorderThreshold", StockItem.class)
                    .list();
        }
    }
}
