package Metier.Personnage;

import java.util.Random;

import Metier.Donjon.Salle;

public class MonstreAleatoire extends Monstre {

	private String nom = "Monstre aléatoire";

	public MonstreAleatoire(int pointDeVie, int force, int nbPieceOr, int coordonneeX, int coordonneeY) {
		super(pointDeVie, force, nbPieceOr, coordonneeX, coordonneeY);
	}

	public void deplacerAleatoire(Salle carteDonjon[][]) {
		Random random = new Random();
		boolean deplacement = false;
		while (deplacement == false) {
			int aleatoire = 1 + random.nextInt(5 - 1);

			switch (aleatoire) {
			case 1:
				if (carteDonjon[this.coordonneeX][this.coordonneeY].isHaut()) {
					this.coordonneeY = this.coordonneeY - 1;
					carteDonjon[this.coordonneeX][this.coordonneeY].getListeMonstre().add(this);
					deplacement = true;
				}
				break;
			case 2:
				if (carteDonjon[this.coordonneeX][this.coordonneeY].isBas()) {
					this.coordonneeY = this.coordonneeY + 1;
					carteDonjon[this.coordonneeX][this.coordonneeY].getListeMonstre().add(this);
					deplacement = true;
				}

				break;
			case 3:
				if (carteDonjon[this.coordonneeX][this.coordonneeY].isGauche()) {
					this.coordonneeX = this.coordonneeX - 1;
					carteDonjon[this.coordonneeX][this.coordonneeY].getListeMonstre().add(this);
					deplacement = true;
				}
				break;
			case 4:
				if (carteDonjon[this.coordonneeX][this.coordonneeY].isDroite()) {
					this.coordonneeX = this.coordonneeX + 1;
					carteDonjon[this.coordonneeX][this.coordonneeY].getListeMonstre().add(this);
					deplacement = true;
				}
				break;
			}
		}

	}

	public String getNom() {
		return nom;
	}

}
