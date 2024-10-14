package ma.projet.classes;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Commande {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(mappedBy = "commande")
    private Set<LigneCommandeProduit> ligneCommandeProduits;
    public Commande() {
    }
    public Commande(Date date) {
        this.date = date;
    }
    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Set<LigneCommandeProduit> getLigneCommandeProduits() {
        return ligneCommandeProduits;
    }
    public void setLigneCommandeProduits(Set<LigneCommandeProduit> ligneCommandeProduits) {
        this.ligneCommandeProduits = ligneCommandeProduits;
    }  
}
