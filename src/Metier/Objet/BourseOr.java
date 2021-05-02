package Metier.Objet;
import Metier.Personnage.*;

public class BourseOr extends Objet{

	public BourseOr() {
		super("Bourse d'or", (int) ((Math.random() * (4 - 1)) + 1));
	}
	
	public BourseOr(int valeur) {
		super("Bourse d'or", valeur);
	}

	@Override
	public void utilisation(Joueur joueur) {
		joueur.setNbPieceOr(joueur.getNbPieceOr() + getValeur());
		System.out.println("Vous gagnez "+getValeur()+" pièces d'or");
	}

}
