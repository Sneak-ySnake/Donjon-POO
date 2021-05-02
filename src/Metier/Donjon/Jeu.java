package Metier.Donjon;

import Metier.Personnage.Joueur;
import Metier.Personnage.MonstreAleatoire;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Path;
import Metier.Personnage.*;
import java.util.ArrayList;

public class Jeu {

	Donjon donjon = new Donjon();
	Joueur joueur = new Joueur(20, 10, 10, 1, 0);
	String path = System.getenv("Score");
	File score = new File(path, "Score.txt");
	Scanner passage = new Scanner(System.in);
	String passer;

	public void initiliserDonjon() {
		donjon.ajouterSalle();
	}

	public void lancerJeu() {
		try {
			while (donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY].isSortie() == false
					&& joueur.getPointDeVie() > 0) {
				donjon.afficherCarte();
				System.out.println("\n" + joueur.getNomJoueur() + ": \n" + "Points de vie : " + joueur.getPointDeVie()
						+ " || Points de force : " + joueur.getForce() + " || Nombre de pièces : "
						+ joueur.getNbPieceOr() + "\n");
				actionJoueur();
				deplacerMonstre();
				if (donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY].isSortie()) {
					effacerEcran();
					donjon.afficherCarte();
					ecrireScore();
					System.out.println("Bravo. Vous avez gagnez !");
					System.out.println("\nAppuyez sur entrée pour revenir au menu");
					passer = passage.nextLine();
				}
				if (joueur.getPointDeVie() == 0) {
					effacerEcran();
					donjon.afficherCarte();
					ecrireScore();
					System.out.println("Vous êtes mort");
					System.out.println("\nAppuyez sur entrée pour revenir au menu");
					passer = passage.nextLine();
				}
				effacerEcran();
				lancerJeu();
			}
		} catch (InputMismatchException e) {
			effacerEcran();
			lancerJeu();
		}
	}

	public void choisirNom() {
		System.out.println("Entrez votre nom");
		Scanner scan = new Scanner(System.in);
		String nom = scan.nextLine();
		joueur.setNomJoueur(nom);
	}

	public void menu() {
		Scanner scan = new Scanner(System.in);
		int selection;

		System.out.println("Menu\n\n1- Nouvelle partie\n2- Meilleurs scores\n3- Quitter");
		selection = scan.nextInt();
		switch (selection) {
		case 1:
			effacerEcran();
			choisirNom();
			initiliserDonjon();
			effacerEcran();
			lancerJeu();
			donjon=new Donjon();
			joueur=new Joueur(1000, 10, 10, 1, 0);;
			menu();
			break;
		case 2:
			if (!score.exists()) {
				effacerEcran();
				System.out.println("Pas de score enregistré pour le moment\n\nAppuyez sur entrée pour revenir au menu");
				passer = passage.nextLine();
			}
			else {
				lireScore();
			}
			effacerEcran();
			menu();
			break;
		case 3:
			break;
		}
	}

	public void actionJoueur() {
		int i = 1;
		int selection;
		Scanner scan = new Scanner(System.in);
		int actionAttaquer = 0;
		int actionUtiliser = 0;
		int actionDeplacer = 0;
		int actionRegarder = 0;

		if (donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY].getListeMonstre().size() != 0) {
			System.out.println(i + "- Attaquer");
			actionAttaquer = i;
			i++;
		}
		if (donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY].getListeObjet().size() != 0) {
			System.out.println(i + "- Utiliser un objet");
			actionUtiliser = i;
			i++;
		}
		if (donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY].getListeMonstre().size() == 0) {
			System.out.println(i + "- Se déplacer");
			actionDeplacer = i;
			i++;
		}
		System.out.println(i + "- Regarder");
		actionRegarder = i;

		selection = scan.nextInt();
		if (selection == actionAttaquer && actionAttaquer != 0) {
			joueur.attaquer(joueur, donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY]);
			System.out.println("\nAppuyez sur entrée pour continuer");
			passer = passage.nextLine();
		} else if (selection == actionUtiliser && actionUtiliser != 0) {
			joueur.utiliser(donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY], joueur);
			System.out.println("\nAppuyez sur entrée pour continuer");
			passer = passage.nextLine();
		} else if (selection == actionDeplacer && actionDeplacer != 0) {
			joueur.deplacer(donjon.mapDonjon);
		} else if (selection == actionRegarder && actionRegarder != 0) {
			joueur.regarder(donjon.mapDonjon[joueur.coordonneeX][joueur.coordonneeY]);
			System.out.println("\nAppuyez sur entrée pour continuer");
			passer = passage.nextLine();
		}
	}

	public void ecrireScore() {
		try {

			if (!score.exists()) {
				score.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(score));
				bw.write("0 Joueur *0000-00-00*00:00:00.000* ");
				bw.write(joueur.getNbPieceOr() + " " + joueur.getNomJoueur() + " *" + LocalDate.now() + "*"
						+ LocalTime.now() + "* ");
				bw.close();
			} else {
				FileWriter fw = new FileWriter(score.getAbsoluteFile(), true);
				fw.write(joueur.getNbPieceOr() + " " + joueur.getNomJoueur() + " *" + LocalDate.now() + "*"
						+ LocalTime.now() + "* ");
				fw.close();
			}
		} catch (IOException e) {

		}
	}

	public void lireScore() {
		if (score.exists()) {
			Scanner scanSelection = new Scanner(System.in);
			try {
				// AJOUT DES SCORES A LA LISTE
				int tabScore[] = new int[100];
				String tabJoueur[] = new String[100];
				Scanner scan = new Scanner(score);
				Scanner scanTexte = new Scanner(score);
				int scoreJoueur;
				String scoreString = null;
				String joueur = null;
				int indice = 0;

				while (scan.hasNext()) {
					scan.useDelimiter("[ ][a-zA-Z_0-9]*[ ][*][0-9]{4}[-][0-9]{2}[-][0-9]{2}[*][0-9]{2}[:][0-9]{2}[:][0-9]{2}[.][0-9]{3}[*][ ]");
					scanTexte.useDelimiter("[[ ]|[\\s]][0-9]*[ ]");

					scoreString = scan.next();
					scoreJoueur = Integer.parseInt(scoreString);

					joueur = scanTexte.next();
					if (scoreJoueur == 0 && joueur.equals("0 Joueur *0000-00-00*00:00:00.000*")) {
					} else {
						tabScore[indice] = scoreJoueur;
						tabJoueur[indice] = joueur;
						indice++;
					}
				}
				// GARDE QUE LES 10 MEILLEURS ET AFFICHE
				int temp;
				String tempString;
				for (int i = 0; i < tabScore.length; i++) {
					for (int j = 0; j < tabScore.length; j++) {
						if (tabScore[i] > tabScore[j]) {
							temp = tabScore[i];
							tabScore[i] = tabScore[j];
							tabScore[j] = temp;

							tempString = tabJoueur[i];
							tabJoueur[i] = tabJoueur[j];
							tabJoueur[j] = tempString;
						}
					}
				}
				System.out.println("Héros du donjon :\n");

				for (int i = 0; i < 10; i++) {
					if (tabJoueur[i] == null) {
					} else if (tabJoueur[0] == null) {
						System.out.println("Pas de score enregistré");
					} else {
						System.out.println((i + 1) + " : " + tabJoueur[i]);
						System.out.println("    " + tabScore[i] + " points");
					}
				}
				System.out.println("\nAppuyer sur entrée pour continuer");
				passer = passage.nextLine();
			} catch (IOException e) {

			}
		}

	}

	public void deplacerMonstre() {
		MonstreAleatoire monstre;
		ArrayList<Monstre> listeMonstreAleatoire = new ArrayList<Monstre>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < donjon.mapDonjon[i][j].getListeMonstre().size(); k++) {
					if (donjon.mapDonjon[i][j].getListeMonstre().get(k) instanceof MonstreAleatoire) {
						listeMonstreAleatoire.add(donjon.mapDonjon[i][j].getListeMonstre().get(k));
					}
				}
			}
		}
		for (int i = 0; i < listeMonstreAleatoire.size(); i++) {
			monstre = (MonstreAleatoire) listeMonstreAleatoire.get(i);
			if (listeMonstreAleatoire.get(i).getCoordonneeX() == joueur.coordonneeX
					&& listeMonstreAleatoire.get(i).getCoordonneeY() == joueur.coordonneeY) {
			} else {
				donjon.mapDonjon[monstre.coordonneeX][monstre.coordonneeY].getListeMonstre().remove(monstre);
				monstre.deplacerAleatoire(donjon.mapDonjon);
			}
		}
	}

	public void effacerEcran() {
		try {

			if (System.getProperty("os.name").contains("Windows"))

				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			else

				Runtime.getRuntime().exec("clear");

		} catch (IOException | InterruptedException ex) {
		}
	}
}
