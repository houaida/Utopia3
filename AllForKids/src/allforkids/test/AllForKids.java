/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.test;

import allforkids.entite.Admin;
import allforkids.entite.Commande;
import allforkids.entite.Commentaire;
import allforkids.entite.LigneCommande;
import allforkids.entite.Livraison;
import allforkids.entite.Livreur;
import allforkids.entite.MoyenDetransport;
import allforkids.entite.Note;
import allforkids.entite.Produit;
import allforkids.entite.Promotion;
import allforkids.service.CommandeService;
import allforkids.service.LivraisonService;
import allforkids.service.LivreurService;
import allforkids.service.MoyendeTransportService;
import allforkids.service.NoteService;
import allforkids.service.ProduitService;
import allforkids.service.PromotionService;
import allforkids.technique.util.DataSource;
import java.sql.Date;

import allforkids.entite.Babysitter;
import allforkids.entite.Club;
import allforkids.entite.Demande;
import allforkids.entite.Enfant;
import allforkids.entite.Enseignant;
import allforkids.entite.Evenement;
import allforkids.entite.Forum;
import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.entite.Membre;
import allforkids.entite.Offre;
import allforkids.entite.Parent;
import allforkids.entite.Pub;
import allforkids.entite.Question;
import allforkids.entite.Reclamation;
import allforkids.entite.Reponse;
import allforkids.entite.Ticket;
import allforkids.service.AdminService;
import allforkids.service.BabysitterService;
import allforkids.service.ClubService;
import allforkids.service.DemandeService;
import allforkids.service.EnfantService;
import allforkids.service.EnseignantService;
import allforkids.service.EvenementService;
import allforkids.service.ForumService;
import allforkids.service.GarderieService;
import allforkids.service.JardinEnfantService;
import allforkids.service.MembreService;
import allforkids.service.OffreService;
import allforkids.service.ParentService;
import allforkids.service.PubService;
import allforkids.service.QuestionService;
import allforkids.service.ReclamationService;
import allforkids.service.ReponseService;
import allforkids.service.TicketService;

/**
 *
 * @author MacBook
 */
public class AllForKids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource ds=DataSource.getInstance();
         System.out.println("DS:"+ds);
       // System.out.println("**************Houaida************");
         //GARDERIE:
         /*Garderie G=new Garderie(7,"hoda", "ariana",1234455);
           GarderieService Gservice= GarderieService.getInstance();
           //Gservice.insert(G);
          Gservice.getAllMap().entrySet().stream().forEach(e->System.out.println(e));
           Garderie p4=new Garderie(8,8,"hou","meek",233);
           Gservice.update(p4);
           //System.out.println(p4);
           Garderie p3=Gservice.search(8);
           //System.out.println(p3);*/
         
           //JARDIN D'ENFANT:
         /*JardinEnfant J=new JardinEnfant(9,"hoda", "ariana",1234455);
           JardinEnfantService Jservice=JardinEnfantService.getInstance();
           //Jservice.insert(J);
           //Jservice.getAll().forEach(e->System.out.println(e));
           Jservice.getAllMap().entrySet().stream().forEach(e->System.out.println(e));
           JardinEnfant J1=new JardinEnfant(5,8,"houaida","meek",23);
           Jservice.update(J1);
           JardinEnfant J2=Jservice.search(5);
           System.out.println(J2);*/
          
          //ENSEIGNANT:
         
         /*Enseignant E=new Enseignant(123,"houaida", "meknassi","hoda","mdp1","houaida.meknassi@esprit.tn",12,"theatre");
         //  EnseignantService Eservice=new EnseignantService();
           EnseignantService Eservice=EnseignantService.getInstance();
           EnseignantService Es=EnseignantService.getInstance();
            System.out.println("Eservice:"+Eservice);
          System.out.println("Es:"+Es);
           Es.getAll().forEach(e->System.out.println(e));
           //Eservice.insert(E);
           Eservice.getAll().forEach(e->System.out.println(e));
           Enseignant E1=new Enseignant(9,123,"houaida", "meknassi","hoda2","mdp2","houaida.meknassi@esprit.tn",12,"theatre");
           Eservice.update(E1);
           
           Enseignant J2=Eservice.search(9);
           Eservice.delete(12);
           System.out.println(J2);
         */
         //ENFANT:
       /* Enfant EN=new Enfant(4,"hoda", "ariana",12);
           EnfantService ENservice= EnfantService.getInstance();
          // ENservice.insert(EN);
           ENservice.getAll().forEach(e->System.out.println(e));
           Enfant E2=new Enfant(7,4,"houaida","meek",23);
           ENservice.update(E2);
           Enfant E3=ENservice.search(7);
           System.out.println(E3);*/
         
         //ADMIN:
    /*    Admin A=new Admin("pseudo1","mdp1","email1");
           AdminService Aservice=AdminService.getInstance();
          //Aservice.insert(A);
           Aservice.getAll().forEach(e->System.out.println(e));
           Admin A2=new Admin(1,"pseudo2","mdp2","email2");
           Aservice.update(A2);
           Admin A3=Aservice.search(4);
           //System.out.println(A3);*/
        
        //PARENT:
     /*Parent P=new Parent(12345678,"houaida", "meknassi","hoda","mdp1","houaida.meknassi@esprit.tn","ariana",100);
           ParentService Pservice=ParentService.getInstance();
           //Pservice.insert(P);
           Pservice.getAll().forEach(e->System.out.println(e));
           Parent P1=new Parent(10,12345777,"houa", "mek","hoda","mdp2","houaida.meknassi@esprit.tn","ariana",999);
           Pservice.update(P1);
           
           Parent P2=Pservice.search(10);
           System.out.println(P2);*/
         
    
         /*****************imen*******************/
        MoyenDetransport t=new MoyenDetransport("II", "181 tu 8982",2);
        MoyenDetransport t2=new MoyenDetransport("Porche", "170 tu 12365",2);
        //MoyendeTransportService tService =  MoyendeTransportService.getInstance() ;
       // tService.insert(t);  
       // tService.insert(t2);
        //tService.getAll().forEach(e->System.out.println(e));
        
      //  MoyenDetransport t1 =new MoyenDetransport(4,"chouf trahh","179 tu 8982",5);
       // tService.update(t1);
        
      //  MoyenDetransport p3= tService.getMoyenById(1) ; 
        // System.out.println(p3.toString());
        
       /*   tService.delete(p3); 
           MoyenDetransport p3= tService.search(1) ; 
        System.out.println(p3.toString());*/
       
       System.out.println("++++++++++++++++++++++++++////MODULE BOUTIQUE////+++++++++++++++++++++++++++++");
       System.out.println("*****************GESTION DES PRODUITS******************");
        /*Produit p1=new Produit("poupée Vaiana", "jouets", (float)26.99, "Embarquez pour des aventures extraordinaires avec la belle Vaiana ! ") ; 
        Produit p2=new Produit("Trottinette", "jouets", (float)72.00, "Déplacez-vous avec style aux commandes de cette trottinette solide, évolutive et ultra-confortable !"); 
        ProduitService gestionP =  ProduitService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        //gestionP.insert(p1);
        //gestionP.insert(p2) ;
        gestionP.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Produit p3=gestionP.search(1) ; 
        System.out.println(p3);
       
        
        
        System.out.println("*****************GESTION DES PROMOTIONS******************");
     //   Promotion pr1 = new Promotion( 1,50, new Date(0) ,new Date(0) );
      //  Promotion pr2 = new Promotion( 1,50, new Date(0) ,new Date(0) );
        PromotionService gestionPr = PromotionService.getInstance() ; 
        System.out.println("<<<<< Insertion et affichage >>>>>");
        //gestionPr.insertTotal(pr1);
        gestionPr.insertTotal(pr2);
        //gestionPr.insert(pr1);
        //gestionPr.insert(pr2);
        gestionPr.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Promotion pr3=gestionPr.search(1) ; 
        System.out.println(pr3);
       
        
                
        
        System.out.println("*****************GESTION DES COMMENTAIRES******************");
        /*Commentaire c1 = new Commentaire(3, 1, "agréable produit, trés bonne qualité.. Merci") ; 
        Commentaire c2 = new Commentaire(3, 1, "inutile!") ; 
        CommentaireService gestionC = CommentaireService.getInstance() ; 
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionC.insert(c1);
        gestionC.insert(c2);
        gestionC.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Commentaire c3=gestionC.search(3) ; 
        System.out.println(c3);*/
        
        System.out.println("*****************GESTION DES NOTES******************");
        /*Note n1 = new Note(3, 1, 2) ; 
        Note n2 = new Note(3, 2, 4) ;  
        NoteService gestionN = NoteService.getInstance() ; 
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionN.insert(n1);
        gestionN.insert(n2);
        gestionN.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Note n3=gestionN.search(1) ; 
        System.out.println(n3);*/
        
        System.out.println("*****************GESTION DES LIVREURS******************");
        /*Livreur l1 = new Livreur("toto", "toto", "toto@esprit.tn", 1) ; 
        Livreur l2 = new Livreur("toto2", "toto2", "toto2@esprit.tn", 0) ; 
        LivreurService gestionL = LivreurService.getInstance() ;
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionL.insert(l1);
        gestionL.insert(l2);
        gestionL.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Livreur l3 = gestionL.search(1) ; 
        System.out.println(l3);*/
        
        System.out.println("*****************GESTION DES LIVRAISONS******************");
        /*Livraison lv1 = new Livraison(1, 3, 2, 520, "nasr2") ; 
        LivraisonService gestionLv = LivraisonService.getInstance() ;
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionLv.insert(lv1);
        gestionLv.getAll().forEach(e->System.out.println(e)) ; 
        System.out.println("<<<<< Recherche >>>>>");
        Livraison lv3 = gestionLv.search(15) ; 
        System.out.println(lv3);*/
        
        
        System.out.println("*****************GESTION DES LIGNE COMMANDES******************");
        /*LigneCommande lc1 = new LigneCommande(5, 4) ;  
        LigneCommande lc2 = new LigneCommande(3, 1) ; 
        LigneCommande lc3 = new LigneCommande(2, 5) ; 
        Produit prod3 = new Produit(2,72) ; 
        LigneCommandeService gestionLc = LigneCommandeService.getInstance() ;
        ProduitService gestionP =  ProduitService.getInstance();
        //gestionLc.insert(lc1);
        //gestionLc.insert(lc2);
        //gestionLc.insert(lc3);
        gestionLc.insertPrix(gestionP.search(5));
        gestionLc.insertPrix(gestionP.search(3));
        gestionLc.getAll().forEach(e->System.out.println(e)) ;*/
        
        System.out.println("*****************GESTION DES COMMANDES******************");
        /*Commande cm1 = new Commande(6, 1, 0) ; 
        CommandeService gestionCm = CommandeService.getInstance() ;
        gestionCm.insert(cm1);
        gestionCm.insertTotal(cm1);
        gestionCm.getAll().forEach(e->System.out.println(e));*/
        
           System.out.println("++++++++++++++++++++++++++////MODULE Babysitter////+++++++++++++++++++++++++++++");
        /*
        System.out.println("*****************GESTION Babysitter******************");
        /*Babysitter b1=new Babysitter(15003930,"Aicha","Ferchichi","151JFT1766","123456789/","aicha.ferchichi@esprit.tn","Sidi bou said",25768582); 
        Babysitter b2=new Babysitter(15773930,"Houwaida","Meknassi","155JFT1466","hoda123","houaida.meknassi@esprit.tn","El Ghazela",22508741);
        Babysitter b4=new Babysitter(2,15773931,"Houwaida","Meknassi","155JFT1466","apresUpdate","houaida.meknassi@esprit.tn","El Ghazela",22508741); 
        BabysitterService gestionB=  BabysitterService.getInstance() ;
        System.out.println("<<<<< Insertion et affichage >>>>>");
        //gestionB.insert(b1);
        //gestionB.insert(b2) ;
        gestionB.getAll().forEach(e->System.out.println(e));
        
        System.out.println("<<<<< Recherche >>>>>");
        Babysitter b3=gestionB.search(2) ; 
        System.out.println(b3);
        System.out.println("<<<<< Modifier >>>>>");
        gestionB.update(b4);
        System.out.println("<<<<< Supprimer >>>>>");
<<<<<<< HEAD
        gestionB.delete(6);
        gestionB.getAll().forEach(e->System.out.println(e));*/
       /*
=======
        gestionB.delete(1);
        gestionB.getAll().forEach(e->System.out.println(e));
       
>>>>>>> 676447e17ddd27c1d1bf92e9d40259c80ef2c4a8
        System.out.println("*****************GESTION Demande******************");
        Demande d1=new Demande(1,new Date(0),"Je veux avoir babysitter pour le vendredi soir"); 
        Demande d2=new Demande(2,new Date(0),"Je veux avoir babysitter pour le lundi soir");
        Demande d4=new Demande(13,4,new Date(0),"");
        DemandeService gestionD=  DemandeService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionD.insert(d1);
        gestionD.insert(d2) ;
        gestionD.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Demande d5=gestionD.search(13); 
        System.out.println(d5);
        System.out.println("<<<<< Modifier >>>>>");
        gestionD.update(d4);
        gestionD.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Supprimer >>>>>");
        gestionD.delete(14);
        gestionD.getAll().forEach(e->System.out.println(e));
      
      System.out.println("*****************GESTION Forum******************");
        Forum f1=new Forum(1,2,"premier forum");
        Forum f2=new Forum(2,3,"second forum");
        Forum f4=new Forum(3,2,2,"3éme forum");
        ForumService gestionF=  ForumService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionF.insert(f1);
        gestionF.insert(f2) ;
        gestionF.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Forum f5=gestionF.search(3); 
        System.out.println(f5);
        System.out.println("<<<<< Modifier >>>>>");
        gestionF.update(f4);
        gestionF.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Supprimer >>>>>");
        gestionF.delete(3);
        gestionF.getAll().forEach(e->System.out.println(e)); 
       System.out.println("*****************GESTION Offres******************");
        Offre o1=new Offre(1,new Date(0),"Je veux travailler le weekend");
        Offre o2=new Offre(2,new Date(0),"Je veux travailler du lundi au vendredi");
        Offre o4=new Offre(8,3,new Date(0),"Je veux travailler juste deux jours");
        OffreService gestionO=  OffreService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        //gestionO.insert(o1);
        //gestionO.insert(o2) ;
        gestionO.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Offre o5=gestionO.search(9); 
        System.out.println(o5);
        System.out.println("<<<<< Modifier >>>>>");
        gestionO.update(o4);
        gestionO.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Supprimer >>>>>");
        gestionO.delete(8);
        gestionO.getAll().forEach(e->System.out.println(e));
      
       System.out.println("*****************GESTION Questions******************");
        Question q1=new Question(1,new Date(0),"Comment je peux regler cette erreur:null pointer?");
        Question q2=new Question(2,new Date(0),"Comment je peux intégrer mon projet?");
        Question q4=new Question(2,5,new Date(0),"");
       
        QuestionService gestionQ=  QuestionService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        //gestionQ.insert(q1);
        //gestionQ.insert(q2) ;
        gestionQ.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Question q5=gestionQ.search(3); 
        System.out.println(q5);
        System.out.println("<<<<< Modifier >>>>>");
        gestionQ.update(q4);
        gestionQ.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Supprimer >>>>>");
        gestionQ.delete(3);
        gestionQ.getAll().forEach(e->System.out.println(e)); 
        
       System.out.println("*****************GESTION Reclamations******************");
        Reclamation r1=new Reclamation(1,1,"Un retard de deux heures cest pas normal",new Date(0));
        Reclamation r2=new Reclamation(2,2,"Je ne peux pas supporter elle est maladroite",new Date(0));
        Reclamation r4=new Reclamation(7,2,3,"Je veux rembourser mon argent",new Date(0));
       
        ReclamationService gestionR=  ReclamationService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        //gestionR.insert(r1);
        //gestionR.insert(r2) ;
         gestionR.getAllMap().entrySet().stream().forEach(e->System.out.println(e));
        //gestionR.getAll().forEach(e->System.out.println(e));
        /*
        System.out.println("<<<<< Recherche >>>>>");
        Reclamation r5=gestionR.search(7); 
        System.out.println(r5);
        System.out.println("<<<<< Modifier >>>>>");
        gestionR.update(r4);
        gestionR.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Supprimer >>>>>");
        gestionR.delete(8);
        gestionR.getAll().forEach(e->System.out.println(e)); 
        
         System.out.println("*****************GESTION Reponses******************");
        Reponse rep1=new Reponse(1,1,new Date(0),"Je vous conseille de faire des recherches");
        Reponse rep2=new Reponse(4,2,new Date(0),"C est super,merci");
        Reponse rep4=new Reponse(3,5,3,new Date(0),"Je vais essayer votre soluion merci!!");
       
        ReponseService gestionRep=  ReponseService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        //gestionRep.insert(rep1);
        //gestionRep.insert(rep2) ;
        gestionRep.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Reponse rep5=gestionRep.search(3); 
        System.out.println(rep5);
        System.out.println("<<<<< Modifier >>>>>");
        gestionRep.update(rep4);
        gestionRep.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Supprimer >>>>>");
        gestionRep.delete(4);
        gestionRep.getAll().forEach(e->System.out.println(e));*/
 System.out.println("++++++++++++++++++++++++++////Clubs et événements////+++++++++++++++++++++++++++++");
       /* System.out.println("*****************GESTION Clubs******************");
        Club c1=new Club("l'artiste","dessin","hammamet",3,12,10,30);
        Club c2=new Club("musicien","musique","tunis",3,18,8,22);
        Club c3=new Club("theatre","theatre","nabeul",6,20,10,18);
        ClubService cl= ClubService.getInstance();
        cl.insert(c1);
        cl.insert(c2);
        cl.insert(c3);
        cl.getAll().forEach(e->System.out.println(e));
        cl.delete(3);
        cl.getAll().forEach(e->System.out.println(e));
        Club c4=null;
        c4=cl.search(1);
        System.out.println(c4);
        cl.update(c4);*/
        /*System.out.println("*****************GESTION événements******************");
        Evenement e1=new Evenement("yuma",new Date(0),"hammamet",20,2,10);
        Evenement e2=new Evenement("labes",new Date(0),"sfax",20,3,30);
        Evenement e3=new Evenement("mashrouu leila",new Date(0),"gabes",21,2,35);
        EvenementService ev= EvenementService.getInstance();
        ev.insert(e1);
        ev.insert(e2);
        ev.insert(e3);
        ev.getAll().forEach(e->System.out.println(e));
        ev.delete(3);
        ev.getAll().forEach(e->System.out.println(e));
        Evenement e4=null;
        e4=ev.search(1);
        System.out.println(e4);
        ev.update(e4);*/
        /*System.out.println("*****************GESTION membres******************");
        Membre m1=new Membre("khedira","ghada",new Date(0),22,20362589,"ghada.khedira@esprit.tn");
        Membre m2=new Membre("Ferchichi","aicha",new Date(0),10,97458523,"aicha.ferchichi@esprit.tn");
        Membre m3=new Membre("ouaja","molka",new Date(0),12,25648859,"molka.ouaja@esprit.tn");
        MembreService me= MembreService.getInstance();
        me.insert(m1);
        me.insert(m2);
        me.insert(m3);
        me.getAll().forEach(e->System.out.println(e));
        me.delete(3);
        me.getAll().forEach(e->System.out.println(e));
        Membre m4=null;
        m4=me.search(1);
        System.out.println(m4);
        me.update(m4);*/
       /* System.out.println("*****************GESTION Pubs******************");
        Pub p1=new Pub("samsung","portable",new Date(0),new Date(0),2,"expire");
        Pub p2=new Pub("Zara","vetement",new Date(0),new Date(0),2,"en cours");
        Pub p3=new Pub("monoprix","promo aid",new Date(0),new Date(0),3,"expire");
        PubService pu= PubService.getInstance();
        pu.insert(p1);
        pu.insert(p2);
        pu.insert(p3);
        pu.getAll().forEach(e->System.out.println(e));
        pu.delete(3);
        pu.getAll().forEach(e->System.out.println(e));
        Pub p4=null;
        p4=pu.search(1);
        System.out.println(p4);
        pu.update(p4);*/
       /*System.out.println("*****************GESTION Tickets******************");
        Ticket t1=new Ticket(1,"***",20,"dispo");
        Ticket t2=new Ticket(1,"***",20,"vendu");
        Ticket t3=new Ticket(2,"***",25,"dispo");
        TicketService ti= TicketService.getInstance();
        ti.insert(t1);
        ti.insert(t2);
        ti.insert(t3);
        ti.getAll().forEach(e->System.out.println(e));
        */
    }
    
}
