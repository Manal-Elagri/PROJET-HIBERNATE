package ma.projet.services;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class ProjetService  implements IDao<Projet> {
    @Override
    public boolean create(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    

    @Override
    public Projet getById(int id) {
        Projet projet = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return projet;
    }

    @Override
    public List<Projet> getAll() {
        List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return projets;
    }
       public void getTachesByProjets(Projet projet) {
         List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        Employe emp = null ;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("getTachesByProjets");
            query.setParameter("employeId", emp.getId());
            
            taches = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        if (taches.isEmpty()) {
            System.out.println("Aucune tâche réalisé(e) par " + emp.getNom());
        } else {
            System.out.println("Les tâches réalisés par " + emp.getNom() + ":");
            for (Tache t : taches) {
                System.out.println(t.getNom());
            }
        }
    }
public void getCompletedTasksInProject(Projet projet) {
        List<Tache> completedTasks = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT t FROM Tache t WHERE t.projet.id = :projet AND t.dateFin IS NOT NULL");
            query.setParameter("projet", projet.getId());
            completedTasks = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (completedTasks.isEmpty()) {
            System.out.println("Aucune tâche terminée dans le projet: " + projet.getNom());
        } else {
            System.out.println("Projet : " + projet.getId() + " Nom : " + projet.getNom() +
                    " Date début : " + projet.getDateDebut());
            System.out.println("La Liste des tâches:");
            for (Tache task : completedTasks) {
                System.out.println("Id de la tache :"+
                    task.getId() + "\t" +
                    "Le nom de la tache :" +
                    task.getNom() + "\t" +
                    "La date début de la tache :"+
                    task.getDateDebut() + "\t" +
                    "La date fin de la tache :"+
                    task.getDateFin()
                );
            }
        }
    }
}