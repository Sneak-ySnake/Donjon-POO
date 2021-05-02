package Metier.Personnage;

import Metier.Donjon.Salle;
import Metier.Objet.BourseOr;
import java.util.Scanner;

public abstract class Personnage {

	private int pointDeVie;
	private int force;
	private int nbPieceOr = 0;
	public int coordonneeX;
	public int coordonneeY;
	
	public Personnage(int pointDeVie, int force, int nbPieceOr, int coordonneeX, int coordonneeY) {
		this.pointDeVie=pointDeVie;
		this.force=force;
		this.nbPieceOr=nbPieceOr;
		this.coordonneeX=coordonneeX;
		this.coordonneeY=coordonneeY;
	}
	
	public Personnage(int pointDeVie, int force, int coordonneeX, int coordonneeY) {
		this.pointDeVie=pointDeVie;
		this.force=force;
		this.coordonneeX=coordonneeX;
		this.coordonneeY=coordonneeY;
	}
	
	public void attaquer(Personnage joueur, Salle salle){
		Scanner scan = new Scanner(System.in);
		int selection;
		
		if (salle.getListeMonstre().size()>1) {
			for (int i=0 ; i<salle.getListeMonstre().size() ; i++) {
				System.out.println((i+1)+"- "+salle.getListeMonstre().get(i).getNom()+" "+(i+1)+" : "+salle.getListeMonstre().get(i).getPointDeVie()+" points de vie");
			}
			System.out.println("\nChoisissez un monstre à attaquer");
			selection = scan.nextInt();
			for (int i=0 ; i<salle.getListeMonstre().size() ; i++) {
				if (selection==i+1) {
					System.out.println("Vous attaquez le monstre "+(selection)+" avec "+joueur.getForce() + " forces");
					salle.getListeMonstre().get(selection-1).setPointDeVie(salle.getListeMonstre().get(selection-1).getPointDeVie() - joueur.getForce());
					System.out.println("Le monstre "+(selection)+" a encore "+salle.getListeMonstre().get(selection-1).getPointDeVie()+" points de vie");
					if (salle.getListeMonstre().get(selection-1).getPointDeVie()>0) {
						joueur.setPointDeVie(joueur.getPointDeVie() - salle.getListeMonstre().get(selection-1).getForce());
						System.out.println("Le monstre "+(selection)+" vous attaque avec "+salle.getListeMonstre().get(selection-1).getForce()+" forces");
						System.out.println("Il vous reste "+joueur.getPointDeVie()+" points de vie");
					}
					else {
						System.out.println("Le monstre "+(selection)+" est mort");
						salle.getListeObjet().add(new BourseOr(salle.getListeMonstre().get(selection-1).getNbPieceOr()));
						salle.getListeMonstre().remove(salle.getListeMonstre().get(selection-1));
					}
				}
			}
		}
		
		else if (salle.getListeMonstre().size()==1) {
			System.out.println("Vous attaquez le monstre avec "+joueur.getForce() + " forces");
			salle.getListeMonstre().get(0).setPointDeVie(salle.getListeMonstre().get(0).getPointDeVie() - joueur.getForce());
			System.out.println("Le monstre a encore "+salle.getListeMonstre().get(0).getPointDeVie()+" points de vie");
				if (salle.getListeMonstre().get(0).getPointDeVie()>0) {
					joueur.setPointDeVie(joueur.getPointDeVie() - salle.getListeMonstre().get(0).getForce());
					System.out.println("Le monstre vous attaque avec "+salle.getListeMonstre().get(0).getForce()+" forces");
					System.out.println("Il vous reste "+joueur.getPointDeVie()+" points de vie");
				}
				else {
					System.out.println("Le monstre est mort");
					salle.getListeObjet().add(new BourseOr(salle.getListeMonstre().get(0).getNbPieceOr()));
					salle.getListeMonstre().remove(salle.getListeMonstre().get(0));
				}
		}
		
	}
	
	public int getForce() {
		return force;
	}

	public int getNbPieceOr() {
		return nbPieceOr;
	}

	public void setNbPieceOr(int nbPieceOr) {
		this.nbPieceOr = nbPieceOr;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public void setForce(int force) {
		this.force = force;
	}

	@Override
	public String toString() {
		return "Personnage [pointDeVie=" + pointDeVie + ", force=" + force + ", nbPieceOr=" + nbPieceOr	+ "]";
	}
	
	public int getCoordonneeX() {
		return coordonneeX;
	}

	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
	}

	public int getCoordonneeY() {
		return coordonneeY;
	}

	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
	}
	
}
