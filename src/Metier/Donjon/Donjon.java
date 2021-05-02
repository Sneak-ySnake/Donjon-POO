package Metier.Donjon;

import java.util.ArrayList;
import Metier.Personnage.*;
import Metier.Objet.BanditManchot;
import Metier.Objet.BourseOr;
import Metier.Objet.Objet;
import Metier.Objet.PotionForce;
import Metier.Objet.PotionSoin;

public class Donjon {

	Salle mapDonjon[][] = new Salle[5][4];
    //////                   HAUT   BAS    GAUCHE DROITE JOUEUR SORTIE
	Salle salle1 = new Salle(false, false, false, false, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle2 = new Salle(false, true, false, false, true, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle3 = new Salle(false, true, false, false, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle4 = new Salle(false, false, false, false, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle5 = new Salle(false, false, false, false, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle6 = new Salle(false, false, false, false, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle7 = new Salle(true, true, false, false, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle8 = new Salle(true, true, false, true, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle9 = new Salle(false, false, true, true, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle10 = new Salle(false, true, true, false, false, false, new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle11 = new Salle(false, false, false, true, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle12 = new Salle(true, true, true, false, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle13 = new Salle(true, true, false, false, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle14 = new Salle(false, false, false, false, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle15 = new Salle(true, true, false, false, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle16 = new Salle(false, false, false, false, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle17 = new Salle(true, false, false, true, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle18 = new Salle(true, false, true, false, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle19 = new Salle(false, false, false, true, false, true,	new ArrayList<Monstre>(), new ArrayList<Objet>());
	Salle salle20 = new Salle(true, false, true, false, false, false,	new ArrayList<Monstre>(), new ArrayList<Objet>());

	public void ajouterSalle() {
		salle3.getListeObjet().add(new PotionForce());
		salle3.getListeObjet().add(new PotionSoin());
		salle3.getListeObjet().add(new BourseOr());
		salle17.getListeObjet().add(new BanditManchot());
		salle12.getListeMonstre().add(new MonstreAleatoire(15, 5, 10, 1, 2));
		salle8.getListeMonstre().add(new MonstreAleatoire(15, 5, 10, 2, 1));
		salle17.getListeObjet().add(new PotionSoin());
		mapDonjon[0][0] = salle1;
		mapDonjon[1][0] = salle2;
		mapDonjon[2][0] = salle3;
		mapDonjon[3][0] = salle4;
		mapDonjon[4][0] = salle5;
		mapDonjon[0][1] = salle6;
		mapDonjon[1][1] = salle7;
		mapDonjon[2][1] = salle8;
		mapDonjon[3][1] = salle9;
		mapDonjon[4][1] = salle10;
		mapDonjon[0][2] = salle11;
		mapDonjon[1][2] = salle12;
		mapDonjon[2][2] = salle13;
		mapDonjon[3][2] = salle14;
		mapDonjon[4][2] = salle15;
		mapDonjon[0][3] = salle16;
		mapDonjon[1][3] = salle17;
		mapDonjon[2][3] = salle18;
		mapDonjon[3][3] = salle19;
		mapDonjon[4][3] = salle20;
	}

public void afficherCarte() {
		
		for (int i=0 ; i<5 ; i++) {
			if (!mapDonjon[i][0].isHaut()) {
				System.out.print("**********");
			}
			else if (mapDonjon[i][0].isHaut()) {
				System.out.print("*        *");
			}
		}
		System.out.print("\n");
		
		for (int i=0 ; i<5 ; i++) {
			mapDonjon[i][0].affichageSalle();
		}

		System.out.print("\n");
		for (int i=0 ; i<5 ; i++) {
			if (!mapDonjon[i][1].isHaut()) {
				System.out.print("**********");
			}
			else if (mapDonjon[i][1].isHaut()) {
				System.out.print("*        *");
			}
		}
		System.out.print("\n");
		
		for (int i=0 ; i<5 ; i++) {
			mapDonjon[i][1].affichageSalle();
		}
		
		System.out.print("\n");
		for (int i=0 ; i<5 ; i++) {
			if (!mapDonjon[i][2].isHaut()) {
				System.out.print("**********");
			}
			else if (mapDonjon[i][2].isHaut()) {
				System.out.print("*        *");
			}
		}
		System.out.print("\n");
		
		for (int i=0 ; i<5 ; i++) {
			mapDonjon[i][2].affichageSalle();
		}
		
		System.out.print("\n");
		for (int i=0 ; i<5 ; i++) {
			if (!mapDonjon[i][3].isHaut()) {
				System.out.print("**********");
			}
			else if (mapDonjon[i][3].isHaut()) {
				System.out.print("*        *");
			}
		}
		System.out.print("\n");
		
		for (int i=0 ; i<5 ; i++) {
			mapDonjon[i][3].affichageSalle();
		}
		
		System.out.print("\n");
		for (int i=0 ; i<5 ; i++) {
			if (!mapDonjon[i][3].isBas()) {
				System.out.print("**********");
			}
			else if (mapDonjon[i][3].isBas()) {
				System.out.print("*        *");
			}
		}
		System.out.print("\n");
	}
}
