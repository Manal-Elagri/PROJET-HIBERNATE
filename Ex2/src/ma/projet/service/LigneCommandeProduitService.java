package ma.projet.service;
import java.util.List;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class LigneCommandeProduitService implements IDao<LigneCommandeProduit> {
    @Override
    public boolean create(LigneCommandeProduit o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public LigneCommandeProduit findById(int id) {
        Session session = null;
        Transaction tx = null;
        LigneCommandeProduit lcp = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            lcp = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();}
        return lcp;}

    @Override
    public List<LigneCommandeProduit> findAll() {
         Session session = null;
        Transaction tx = null;
        List <LigneCommandeProduit> p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p =  session.createQuery("from LigneCommandeProduit").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return p;
    }
}
