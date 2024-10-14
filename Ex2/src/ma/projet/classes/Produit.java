package ma.projet.classes;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Produit { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "prix")
    private float prix;
    private String reference;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;    
    @OneToMany(mappedBy = "produit")
    private Set<LigneCommandeProduit> ligneCommandeProduits;
    public Produit() {
    }
    public Produit(String reference, float prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public int getId() {
        return id;
    }
    public String getReference() {
        return reference;
    }
    public float getPrix() {
        return prix;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public Set<LigneCommandeProduit> getLigneCommandeProduits() {
        return ligneCommandeProduits;
    }
    public void setLigneCommandeProduits(Set<LigneCommandeProduit> ligneCommandeProduits) {
        this.ligneCommandeProduits = ligneCommandeProduits;
    }

    
    
    
    
    
    
}
