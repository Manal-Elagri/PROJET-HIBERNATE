package h1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
public class H1 {
    public static void main(String[] args) {
        
        ProduitService pp = new ProduitService();
        
       pp.create(new Produit("ZARA", "QZ125", new Date(), 125.36, "CASCETTE"));
        
        pp.create(new Produit("PUMA", "ZAE214", new Date(), 3210.5, "T.SHIRT"));
            
        pp.create(new Produit("NIKE", "HGF654", new Date(), 7542.32, "CHAUSSURE"));
                
        pp.create(new Produit("ADIDAS", "UI3254", new Date(), 6985.00, "PONTALON"));
                    
        pp.create(new Produit("JORDAN", "GF654", new Date(), 4521.30, "ESPADRILLE"));
         // Affichez la liste des produits
            System.out.println(" ***** L ' affichage de la liste des produits selon la marque ***** ");
         for(Produit p : pp.findAll())
         
            System.out.println(p.getMarque());
         
            System.out.println(" ***** -------------  ***** ");
      
        //Affichage des informations du produit dont id = 2  
        System.out.println(" ***** L ' affichage du produit numéro 2 ***** ");
        // ID du produit à rechercher
        int idProduit = 2;
        Produit produit = pp.findById(idProduit);
        // Vérification si le produit existe avant d'afficher ses informations
        if (produit != null) {
            System.out.println("Produit trouvé !");
            System.out.println("ID: " + produit.getId());
            System.out.println("Reference: " + produit.getReference());
            System.out.println("Marque: " + produit.getMarque());
            System.out.println("Prix: " + produit.getPrix());
              System.out.println("Date Achat: " + produit.getDateAchat());
                System.out.println("Designation: " + produit.getDesignation());
        } else {
            System.out.println("Aucun produit trouvé avec l'ID: " + idProduit);
        }
        // Supprimer le produit dont id = 3
        pp.delete(pp.findById(3));
        // Modification des informations du produit dont id = 1,
        // ID du produit à mettre à jour
        int idProduitModif = 1;
        Produit produitMod = pp.findById(idProduitModif);
        if (produitMod != null) {
            System.out.println("Produit trouvé ! Mise à jour en cours..."); 
            // Modification des informations du produit
            produitMod.setMarque("Louis Vuitton");
            produitMod.setReference("DE-1234");
            produitMod.setDateAchat(new Date()); // Date actuelle
            produitMod.setPrix(1000.23);
            produitMod.setDesignation("Sac-Femme");
            // Application la mise à jour
            boolean updated = pp.update(produitMod);
            // Vérification si la mise à jour a réussi
            if (updated) {
                System.out.println("Mise à jour réussie !");
                System.out.println("Nouvelles informations du produit :");
                System.out.println("ID: " + produitMod.getId());
                System.out.println("Marque: " + produitMod.getMarque());
                System.out.println("Référence: " + produitMod.getReference());
                System.out.println("Date d'achat: " + produitMod.getDateAchat());
                System.out.println("Prix: " + produitMod.getPrix());
                System.out.println("Désignation: " + produitMod.getDesignation());
            } else {
                System.out.println("Échec de la mise à jour.");
            }
        } else {
            System.out.println("Aucun produit trouvé avec l'ID: " + idProduitModif);
        }
         // Récupération la liste de tous les produits
        List<Produit> produits = pp.findAll();
        // Vérification et affichage des produits dont le prix est supérieur à 100 DH
        System.out.println("Produits avec un prix supérieur à 100 DH :");
        boolean produitTrouve = false;
        for (Produit p : produits) {
            if (p.getPrix() > 100) {
                produitTrouve = true;
                System.out.println("ID: " + p.getId());
                System.out.println("Marque: " + p.getMarque());
                System.out.println("Référence: " + p.getReference());
                System.out.println("Date d'achat: " + p.getDateAchat());
                System.out.println("Prix: " + p.getPrix());
                System.out.println("Désignation: " + p.getDesignation());
                System.out.println("-------------------------------");
            }
        }
        if (!produitTrouve) {
            System.out.println("Aucun produit trouvé avec un prix supérieur à 100 DH.");
        }
        System.out.println("*****************************");
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Lecture de la première date au clavier
            System.out.print("Entrez la date de début (yyyy-MM-dd) : ");
            String dateDebutStr = scanner.nextLine();
            Date dateDebut = sdf.parse(dateDebutStr);

            // Lecture de la deuxième date au clavier
            System.out.print("Entrez la date de fin (yyyy-MM-dd) : ");
            String dateFinStr = scanner.nextLine();
            Date dateFin = sdf.parse(dateFinStr);

            // Récupération la liste de tous les produits
            List<Produit> produitss = pp.findAll();
            // Filtrage et affichage des produits commandés entre les deux dates
            System.out.println("Produits commandés entre " + dateDebutStr + " et " + dateFinStr + " :");
            boolean produitTrouver = false;
            for (Produit p : produits) {
                if (p.getDateAchat().after(dateDebut) && p.getDateAchat().before(dateFin)) {
                    produitTrouver = true;
                    System.out.println("ID: " + p.getId());
                    System.out.println("Marque: " + p.getMarque());
                    System.out.println("Référence: " + p.getReference());
                    System.out.println("Date d'achat: " + sdf.format(p.getDateAchat()));
                    System.out.println("Prix: " + p.getPrix());
                    System.out.println("Désignation: " + p.getDesignation());
                    System.out.println("-------------------------------");
                }
            }
            if (!produitTrouver) {
                System.out.println("Aucun produit trouvé entre ces dates.");
            }
        } catch (ParseException e) {
            System.out.println("Erreur : format de date invalide. Veuillez entrer la date au format yyyy-MM-dd.");
        } finally {
            scanner.close();
        }
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    

