package ma.projet.classes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class LigneCommandeProduit {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;
@ManyToOne
@JoinColumn(name = "commande_id")
private Commande commande;
@ManyToOne
@JoinColumn(name = "produit_id")
private Produit produit;
    public LigneCommandeProduit() {
    }
    public LigneCommandeProduit(int quantite, Produit produit, Commande commande) {
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }
    public int getId() {
        return id;
    }
    public int getQuantite() {
        return quantite;
    }
    public Produit getProduit() {
        return produit;
    }
    public Commande getCommande() {
        return commande;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
