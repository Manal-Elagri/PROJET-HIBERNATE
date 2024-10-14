package ma.projet.service;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
public class ProduitService implements IDao<Produit> {
    @Override
    public boolean create(Produit o) {
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
        return etat;}

    @Override
    public Produit findById(int id) {
        Session session = null;
        Transaction tx = null;
        Produit p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p = (Produit) session.get(Produit.class, id);
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

    @Override
    public List<Produit> findAll() {
        Session session = null;
        Transaction tx = null;
        List <Produit> p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            p =  session.createQuery("from Produit").list();
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
    
    
    
     // 1. Méthode pour afficher la liste des produits par catégorie
    public List<Produit> findByCategorieId(int categorieId) {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            produits = session.createQuery("FROM Produit WHERE categorie.id = :categorieId")
                              .setParameter("categorieId", categorieId)
                              .list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return produits;
    }
    /************** findCommandesBetweenDates ************************/
    public List<Produit> findCommandesBetweenDates(Date startDate, Date endDate) {
    Session session = null;
    List<Produit> produits = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        produits = session.createQuery("SELECT p FROM Produit p " +
                                        "JOIN p.ligneCommandeProduits lcp " +"JOIN lcp.commande c " +
                                        "WHERE c.date BETWEEN :startDate AND :endDate")
                          .setParameter("startDate", startDate)
                          .setParameter("endDate", endDate)
                          .list();
    } catch (HibernateException e) {
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    return produits;}


    
  

  public List<Produit> findProduitsSelonPrix(float price) {
    Session session = null;
    List<Produit> produits = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Produit p WHERE p.prix > :price");
        query.setParameter("price", price);
        produits = query.list(); 
    } catch (HibernateException e) {
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    return produits;
}
public List<Produit> findProduitsByCommandeId(int commandeId) {
    Session session = null;
    List<Produit> produits = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        produits = session.createQuery("SELECT p FROM Produit p " + "JOIN p.ligneCommandeProduits lcp "  +
                                        "WHERE lcp.commande.id = :commandeId")
                          .setParameter("commandeId", commandeId)
                          .list();
    } catch (HibernateException e) {
        e.printStackTrace();
    } finally {
        if (session != null) session.close();
    }
    return produits;}

    
    
    
    
}
