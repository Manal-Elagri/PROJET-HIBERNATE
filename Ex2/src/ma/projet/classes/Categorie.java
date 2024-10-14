package ma.projet.classes;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Categorie {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private int id;
       @Column(name = "code")
    private String code;
         @Column(name = "libelle")
    private String libelle;   
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produit> produits;
    public Categorie() {
    }
    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
    public int getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getLibelle() {
        return libelle;
    }
    public List<Produit> getProduits() {
        return produits;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }        
}
