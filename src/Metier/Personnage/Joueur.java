package Metier.Personnage;

import java.util.Scanner;
import Metier.Donjon.*;
import Metier.Objet.BanditManchot;
import Metier.Objet.BourseOr;
import Metier.Objet.PotionForce;
import Metier.Objet.PotionSoin;

public class Joueur extends Personnage {
	
	private String nomJoueur;
	
	public Joueur(int pointDeVie, int force, int nbPieceOr, int coordonneeX, int coordonneeY) {
		super(pointDeVie, force, nbPieceOr, coordonneeX, coordonneeY);
	}

	public void regarder(Salle salle) {
		if(salle.getListeMonstre().size()>0) {
            System.out.println("Il y a " + salle.getListeMonstre().size() + " monstres");
        }
		if(salle.getListeObjet().size()!=0) {
            System.out.println("Présence de " + salle.getListeObjet().size() + " objet(s) :");
            for (int i = 0 ; i<salle.getListeObjet().size() ; i++) {
            	if (salle.getListeObjet().get(i) instanceof PotionForce) {
            		System.out.println(salle.getListeObjet().get(i).getNom()+" : "+salle.getListeObjet().get(i).getValeur()+" point de force");
            	}
            	if (salle.getListeObjet().get(i) instanceof PotionSoin) {
            		System.out.println(salle.getListeObjet().get(i).getNom()+" : "+salle.getListeObjet().get(i).getValeur()+" point de vie");
            	}
            	if (salle.getListeObjet().get(i) instanceof BourseOr) {
            		System.out.println(salle.getListeObjet().get(i).getNom()+" : "+salle.getListeObjet().get(i).getValeur()+" pièces d'or");
            	}
            	if (salle.getListeObjet().get(i) instanceof BanditManchot) {
            		System.out.println(salle.getListeObjet().get(i).getNom()+" : "+salle.getListeObjet().get(i).getValeur()+" pièces d'or pour obtenir un objet");
            	}
            }
		}
        if(salle.getListeMonstre().size()==0 && salle.getListeObjet().size()==0) {
            System.out.println("La salle est vide");
        }
       System.out.print("\nIssues vers : ");
        if (salle.isHaut()) {
        	System.out.print("le haut -");
        }
        if (salle.isBas()) {
        	System.out.print("le bas -");
        }
        if (salle.isGauche()) {
        	System.out.print("la gauche -");
        }
        if (salle.isDroite()) {
        	System.out.print("la droite");
        }
        System.out.println("\n");
    }
	
	public void deplacer(Salle carteDonjon[][]) {
		Scanner scan = new Scanner(System.in);
		int selection;
		int numeroHaut=0;
		int numeroBas=0;
		int numeroGauche=0;
		int numeroDroite=0;
		int i=1;
		System.out.println("Choisissez une direction :");
		if (carteDonjon[this.coordonneeX][this.coordonneeY].isHaut()) {
			System.out.println(i+"- Haut");
			numeroHaut = i;
			i++;
		}
		if (carteDonjon[this.coordonneeX][this.coordonneeY].isBas()) {
			System.out.println(i+"- Bas");
			numeroBas = i;
			i++;
		}
		if (carteDonjon[this.coordonneeX][this.coordonneeY].isGauche()) {
			System.out.println(i+"- Gauche");
			numeroGauche = i;
			i++;
		}
		if (carteDonjon[this.coordonneeX][this.coordonneeY].isDroite()) {
			System.out.println(i+"- Droite");
			numeroDroite = i;
			i++;
		}
		selection = scan.nextInt();
		if (selection==numeroHaut && numeroHaut!=0) {
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(false);
			super.coordonneeY = super.coordonneeY - 1;
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(true);
		}
		else if (selection==numeroBas && numeroBas!=0) {
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(false);
			super.coordonneeY = super.coordonneeY + 1;
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(true);
		}
		else if (selection==numeroGauche && numeroGauche!=0) {
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(false);
			super.coordonneeX = super.coordonneeX - 1;
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(true);
		}
		else if (selection==numeroDroite && numeroDroite!=0) {
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(false);
			super.coordonneeX = super.coordonneeX + 1;
			carteDonjon[super.coordonneeX][super.coordonneeY].setJoueur(true);
		}
	}
	
	public void utiliser(Salle salle, Joueur joueur) {
		Scanner scan = new Scanner(System.in);
		if(salle.getListeObjet().size()!=0) {
			for(int i=0; i<salle.getListeObjet().size(); i++) {
				System.out.println((i+1)+"- "+salle.getListeObjet().get(i).getNom());
			}
		}
		System.out.println("Choisissez un objet");
		int choix = scan.nextInt();
		for(int i=0; i<salle.getListeObjet().size(); i++) {
			if (choix==i+1) {
				System.out.println("Vous avez utilisé "+salle.getListeObjet().get(i).getNom());
				salle.getListeObjet().get(i).utilisation(joueur);
				salle.getListeObjet().remove(i);
			}
		}
	}

	public String getNomJoueur() {
		return nomJoueur;
	}
	
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur=nomJoueur;
	}
}
