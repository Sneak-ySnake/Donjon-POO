package Metier.Objet;

import Metier.Personnage.Joueur;

public class PotionForce extends Objet {

	public PotionForce() {
		super("Potion de force", 1);
	}

	
	public void utilisation(Joueur joueur) {
		joueur.setForce(joueur.getForce()+getValeur());
		System.out.println("Vous avez gagné 1 point de force");
	}
}
