package Metier.Objet;
import Metier.Personnage.*;

public class PotionSoin extends Objet{

	public PotionSoin() {
		super("Potion de soin", (int) ((Math.random() * (11 - 1)) + 1));
	}

	@Override
	public void utilisation(Joueur joueur) {
		joueur.setPointDeVie(joueur.getPointDeVie() + getValeur());
		System.out.println("Vous gagnez "+getValeur()+" point de vie");
	}


}
