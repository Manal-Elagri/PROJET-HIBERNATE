package ex2;
import java.util.Date;
import java.util.List;
import ma.projet.classes.*;
import ma.projet.service.*;
import ma.projet.util.HibernateUtil;
public class Ex2 {
  public static void main(String[] args) { 
        // Création du service pour les produits
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        CommandeService cos = new CommandeService();
        LigneCommandeProduitService lcps = new LigneCommandeProduitService();
        // 1. Création des catégories
        Categorie categorie1 = new Categorie("C01", "Électronique");
        Categorie categorie2 = new Categorie("C02", "Alimentation");
        cs.create(categorie1);
        cs.create(categorie2);
        // 2. Création des produits associés aux catégories
        Produit produit1 = new Produit("ES12", 120, cs.findById(1));
        Produit produit2 = new Produit("ZR85", 100, cs.findById(2));
         ps.create(produit1);
         ps.create(produit2);
        // 3. Création d'une commande
        Commande commande = new Commande(new Date());
         cos.create(commande);
          Commande commande1 = new Commande(new Date()); 
         cos.create(commande1);
        // 4. Création des lignes de commande 
        LigneCommandeProduit ligne1 = new LigneCommandeProduit(7, ps.findById(1), cos.findById(1)); 
        LigneCommandeProduit ligne2 = new LigneCommandeProduit(14, ps.findById(2), cos.findById(2)); 
        lcps.create(ligne1);
         lcps.create(ligne2);
          // 1. Test de la méthode findByCategorieId
        System.out.println("----- Produits par catégorie -----");
        List<Produit> produitsParCategorie = ps.findByCategorieId(1); 
        for (Produit p : produitsParCategorie) {
            System.out.println(p.getReference() + " - " + p.getPrix() + " DH");
        }  
        // 2. Test de la méthode findCommandesBetweenDates (trouver les produits commandés entre deux dates)
        System.out.println("\n----- Produits commandés entre deux dates -----");
        Date startDate = new Date(2024-10-12);  
        Date endDate = new Date(2024-10-15);   
        List<Produit> produitsEntreDates = ps.findCommandesBetweenDates(startDate, endDate);
        for (Produit pp : produitsEntreDates) {
            System.out.println("La reference du produit est : " +pp.getReference() + "Le prix du produit" + pp.getPrix() + " DH");
        }
        // 3. Test de la méthode findProductsAbovePrice 
        System.out.println("\n----- Produits au-dessus d'un certain prix -----");
        List<Produit> produitsAbovePrice = ps.findProduitsSelonPrix(100);
        for (Produit p : produitsAbovePrice) {
            System.out.println(p.getReference() + " - " + p.getPrix() + " DH");
        }
        // 4. Test de la méthode findProduitsByCommandeId 
        System.out.println("\n----- Produits par commande -----");
      List<Produit> produitsCommande = ps.findProduitsByCommandeId(2);

    for (Produit produit : produitsCommande) {
    System.out.println("Référence: " + produit.getReference() + 
                       ", Prix: " + produit.getPrix() +"Catégorie " + produit.getCategorie().getLibelle() );
    }  
    }
    
}
