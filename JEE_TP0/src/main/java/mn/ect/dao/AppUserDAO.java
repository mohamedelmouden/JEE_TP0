package mn.ect.dao;

import mn.ect.entity.AppUser;
import mn.ect.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class AppUserDAO extends AbstractDAO<AppUser, Long> {

    public Optional<AppUser> findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            AppUser user = session.createQuery(
                    "FROM AppUser WHERE email = :email", AppUser.class)
                    .setParameter("email", email)
                    .uniqueResult();
            return Optional.ofNullable(user);
        }
    }
}
