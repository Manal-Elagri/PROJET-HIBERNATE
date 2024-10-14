# PROJET-HIBERNATE
# Projets Hibernate - Gestion des produits, stock et projets

Ce dépôt contient plusieurs projets implémentés en utilisant le framework Hibernate pour la persistance des données dans des applications Java. Chaque projet vise à résoudre un problème particulier, de la gestion des produits à la gestion des projets et des stocks.

## Structure des projets

### 1. **H1 : Gestion des produits**
Ce projet permet de gérer une liste de produits en ajoutant, supprimant, modifiant et consultant les produits dans une base de données MySQL.

#### Fonctionnalités :
- Ajouter un produit
- Afficher tous les produits
- Modifier et supprimer un produit
- Rechercher des produits selon des critères spécifiques

#### Instructions :
1. Créer une base de données MySQL nommée `H1`.
2. Ajouter les dépendances Hibernate-JPA et MySQL dans le projet.
3. Configurer Hibernate avec un fichier `hibernate.cfg.xml` et créer l'entité `Produit` dans le package `ma.projet.entity`.
4. Utiliser `ProduitService` pour les opérations CRUD sur les produits.

#### Tables Base de Données :

![image](https://github.com/user-attachments/assets/c2713e34-0f77-4cb3-bcde-cd083063db6a)

### 2. **Ex2 : Gestion de stock d'un magasin**
Ce projet gère le stock de produits d'un magasin. Il permet de suivre les produits en stock, les commandes, et les catégories de produits.

#### Fonctionnalités :
- Afficher les produits par catégorie
- Gérer les commandes et les lignes de commande
- Filtrer les produits par date de commande ou prix

#### Instructions :
1. Créer les entités dans `ma.projet.classes`.
2. Configurer Hibernate avec `hibernate.cfg.xml` dans `ma.projet.config`.
3. Utiliser les services `ProduitService`, `CommandeService`, etc., pour gérer les données du stock.

#### Tables Base de Données :

![image](https://github.com/user-attachments/assets/3251e83a-c5f0-419c-b956-9d242dfe32c4)


### 3. **Ex3 : Gestion de projets**
Ce projet est une application de gestion de projets dans un environnement de bureau d'études. Il suit l'avancement des tâches dans les projets, les employés impliqués et les coûts associés.

#### Fonctionnalités :
- Suivre les tâches réalisées par un employé
- Afficher les projets et leurs tâches
- Calculer le coût global d'un projet

#### Instructions :
1. Développer les entités dans `ma.projet.classes`.
2. Configurer Hibernate avec `hibernate.cfg.xml`.
3. Utiliser les services `ProjetService`, `TacheService`, et `EmployeService` pour interagir avec les données des projets.

#### Tables Base de Données :

![image](https://github.com/user-attachments/assets/1d321c70-aa20-40ab-a6e3-9bb6d1f64232)

### 4. **Travail à Rendre : Gestion de l'état civil**

Ce projet permet de gérer l'état civil des citoyens d'une province en utilisant Hibernate pour la persistance des données. L'application inclut des fonctionnalités pour gérer les hommes, les femmes et les mariages.

#### Fonctionnalités

- **Enregistrement des citoyens** : Gestion des informations sur les hommes et les femmes.
- **Gestion des mariages** : Suivi des mariages réussis et échoués.
- **Gestion des enfants** : Suivi des enfants d'un couple.

#### Structure du projet

##### Couche de persistance
- **Entités** : `Homme`, `Femme`, et `Mariage` dans le package `ma.projet.beans`.
- **Configuration** : `hibernate.cfg.xml` pour la connexion à la base de données MySQL.
- **Classe utilitaire** : `HibernateUtil` pour gérer la session Hibernate.

##### Couche service
- **Services** : `HommeService`, `FemmeService`, et `MariageService`.
  - Affichage des épouses d'un homme.
  - Calcul du nombre d'enfants d'une femme.
  - Lister les femmes mariées plusieurs fois.

##### Programme de test
- Créer des données pour tester les fonctionnalités (10 femmes et 5 hommes).
- Afficher les résultats des différentes requêtes.

###### Tables Base de Données :

![image](https://github.com/user-attachments/assets/49117714-b252-4f45-8940-7580efe013f1)

## Configuration de Hibernate

Chaque projet inclut un fichier de configuration `hibernate.cfg.xml` pour définir les paramètres de la base de données et la gestion des entités :
```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/H1</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="show_sql">true</property>
    </session-factory>
</hibernate-configuration>
``````
## Prérequis

Avant de pouvoir exécuter les projets, assurez-vous d'avoir les éléments suivants installés et configurés :

1. **JDK 8 ou plus**  
   Hibernate nécessite Java pour fonctionner. Assurez-vous d'avoir installé une version appropriée du JDK.

2. **MySQL**  
   Une base de données MySQL doit être installée pour stocker les données des projets.  
   - Créer les bases de données mentionnées dans chaque projet (`H1`, etc.).

3. **Hibernate-JPA et MySQL JDBC Driver**  
   Les bibliothèques Hibernate et le pilote JDBC de MySQL sont essentiels pour permettre la communication entre Java et la base de données MySQL.  
   - Hibernate peut être installé via Maven ou en ajoutant les fichiers JAR nécessaires dans le classpath du projet.

4. **NetBeans ou un IDE supportant Java**  
   Utilisez un environnement de développement intégré (IDE) comme NetBeans, Eclipse ou IntelliJ IDEA pour gérer et exécuter les projets.

