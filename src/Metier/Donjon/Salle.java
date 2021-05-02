package Metier.Donjon;
import java.util.ArrayList;
import Metier.Personnage.Monstre;
import Metier.Objet.Objet;

public class Salle {

	private boolean haut;
	private boolean bas;
	private boolean gauche;
	private boolean droite;
	private boolean joueur;
	private boolean sortie;
	private ArrayList<Monstre> listeMonstre = new ArrayList<Monstre>();
	private ArrayList<Objet> listeObjet = new ArrayList<Objet>();
	
	public Salle(boolean haut, boolean bas, boolean gauche, boolean droite, boolean joueur, boolean sortie, ArrayList<Monstre> listeMonstre, ArrayList<Objet> listeObjet) {
		this.haut=haut;
		this.bas=bas;
		this.gauche=gauche;
		this.droite=droite;
		this.joueur=joueur;
		this.sortie=sortie;
		this.listeMonstre=listeMonstre;
		this.listeObjet=listeObjet;
		
	}
	
	public void affichageSalle() {
        ///// SALLE VIDE
        if (gauche==false && droite==false && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0 && sortie==false) {
            System.out.print("|        |");
        }
        else if (gauche==true && droite==false && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0 && sortie==false) {
            System.out.print("         |");
        }
        else if (gauche==false && droite==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0 && sortie==false) {
            System.out.print("|         ");
        }
        else if (gauche==true && droite==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0 && sortie==false) {
            System.out.print("          ");
        }
        
        ///// SALLE AVEC OBJET
        else if (gauche==false && droite==false && joueur==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("|   "+listeObjet.size()+"O   |");
        }
        else if (gauche==true && droite==false && joueur==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("    "+listeObjet.size()+"O   |");
        }
        else if (gauche==false && droite==true && joueur==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("|   "+listeObjet.size()+"O    ");
        }
        else if (gauche==true && droite==true && joueur==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("    "+listeObjet.size()+"O    ");
        }
        
        
        ////// SALLE AVEC MONSTRE
        else if (gauche==false && droite==false && joueur==false && listeObjet.size()==0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("|   "+listeMonstre.size()+"M   |");
        }
        else if (gauche==true && droite==false && joueur==false && listeObjet.size()==0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("    "+listeMonstre.size()+"M   |");
        }
        else if (gauche==false && droite==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("|    "+listeMonstre.size()+"M   ");
        }
        else if (gauche==true && droite==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("     "+listeMonstre.size()+"M   ");
        }
        
        
        ////// SALLE AVEC MONSTRE ET OBJET
        else if (gauche==false && droite==false && joueur==false && listeObjet.size()>0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("|  "+ listeObjet.size() + "O "+ listeMonstre.size() +"M  |");
        }
        else if (gauche==true && droite==false && joueur==false && listeObjet.size()>0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("  "+listeObjet.size() + "O "+ listeMonstre.size() +"M  |");
        }
        else if (gauche==false && droite==true && joueur==false && listeObjet.size()>0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("|  "+ listeObjet.size() + "O "+ listeMonstre.size() +"M  ");
        }
        else if (gauche==true && droite==true && joueur==false && listeObjet.size()>0 && listeMonstre.size()>0 && sortie==false) {
            System.out.print("  "+listeObjet.size() + "O "+ listeMonstre.size() +"M  ");
        }
        
        ////// SORTIE
        else if (gauche==false && droite==false && sortie==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("|  -><-  |");
        }
        else if (gauche==true && droite==false && sortie==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("   -><-  |");
        }
        else if (gauche==false && droite==true && sortie==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("|  -><-   ");
        }
        else if (gauche==true && droite==true && sortie==true && joueur==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("   -><-   ");
        }
            
        ///// JOUEUR
        else if (gauche==false && droite==false && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("|    P   |");
        }
        else if (gauche==true && droite==false && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("     P   |");
        }
        else if (gauche==false && droite==true && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("|    P    ");
        }
        else if (gauche==true && droite==true && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("     P    ");
        }

 

        
        ///// JOUEUR ET MONSTRE
        else if (gauche==false && droite==false && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()>0) {
            System.out.print("|  P " + listeMonstre.size() + "M" +"  |");
        }
        else if (gauche==true && droite==false && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()>0) {
            System.out.print("   P " + listeMonstre.size() + "M"+"   |");
        }
        else if (gauche==false && droite==true && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()>0) {
            System.out.print("|  P " + listeMonstre.size() + "M"+"    ");
        }
        else if (gauche==true && droite==true && joueur==true && sortie==false && listeObjet.size()==0 && listeMonstre.size()>0) {
            System.out.print("   P " + listeMonstre.size() + "M"+"    ");
        }
        
        ///// JOUEUR ET OBJET
        else if (gauche==false && droite==false && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("|  P "+ listeObjet.size() + "O" +"  |");
        }
        else if (gauche==true && droite==false && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("   P "+ listeObjet.size() + "O" +"  |");
        }
        else if (gauche==false && droite==true && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("|  P "+ listeObjet.size() + "O" +"   ");
        }
        else if (gauche==true && droite==true && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()==0) {
            System.out.print("   P "+ listeObjet.size() + "O" +"  |");
        }
        
        
        ///// JOUEUR ET MONSTRE ET OBJET 
        else if (gauche==false && droite==false && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()>0) {
            System.out.print("|P "+ listeObjet.size() + "O "+ listeMonstre.size() + "M |");
        }
        else if (gauche==true && droite==false && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()>0) {
        System.out.print(" P "+ listeObjet.size() + "O "+ listeMonstre.size() + "M |");
        }
        else if (gauche==false && droite==true && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()>0) {
            System.out.print("|P "+ listeObjet.size() + "O "+ listeMonstre.size() + "M  ");
        }
        else if (gauche==true && droite==true && joueur==true && sortie==false && listeObjet.size()>0 && listeMonstre.size()>0) {
            System.out.print(" P "+ listeObjet.size() + "O "+ listeMonstre.size() + "M  ");
        }
        
        ///// JOUEUR ET SORTIE
        if (gauche==false && droite==false && joueur==true && sortie==true && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("| :-)    |");
        }
        else if (gauche==true && droite==false && joueur==true && sortie==true && listeObjet.size()==0 && listeMonstre.size()==0) {                    
            System.out.print("  :-)    |");
        }
        else if (gauche==false && droite==true && joueur==true && sortie==true && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("| :-)     ");
        }    
        else if (gauche==true && droite==true && joueur==true && sortie==true && listeObjet.size()==0 && listeMonstre.size()==0) {
            System.out.print("  :-)     ");
        }
    }
	

	public boolean isJoueur() {
		return joueur;
	}

	public void setJoueur(boolean joueur) {
		this.joueur = joueur;
	}

	public boolean isHaut() {
		return haut;
	}

	public boolean isBas() {
		return bas;
	}

	public boolean isGauche() {
		return gauche;
	}

	public boolean isDroite() {
		return droite;
	}

	public boolean isSortie() {
		return sortie;
	}

	public ArrayList<Monstre> getListeMonstre() {
		return listeMonstre;
	}

	public ArrayList<Objet> getListeObjet() {
		return listeObjet;
	}
}
