package Metier.Objet;

import Metier.Personnage.Joueur;

public class BanditManchot extends Objet {

	private Objet objetObtenu;
	
	public BanditManchot() {
		super("Bandit manchot", 10);
	}
	
	public void utilisation(Joueur joueur) {
		int aleatoire;
		if (joueur.getNbPieceOr()<10) {
			System.out.println("Vous n'avez pas assez de pièce d'or pour utiliser le bandit mancho");
		}
		if (joueur.getNbPieceOr()>=10) {
			System.out.println("Vous devez payer 10 pièces d'or");
			joueur.setNbPieceOr(joueur.getNbPieceOr()-getValeur());
			aleatoire = (int) ((Math.random() * (4 - 1)) + 1);
			switch (aleatoire) {
				case 1:
					System.out.println("Vous avez obtenu une potion de force");
					objetObtenu = new PotionForce();
					objetObtenu.utilisation(joueur);
					break;
				case 2:
					System.out.println("Vous avez obtenu une potion de soin");
					objetObtenu = new PotionSoin();
					objetObtenu.utilisation(joueur);
					break;
				case 3:
					System.out.println("Vous avez obtenu une bourse d'or");
					objetObtenu = new BourseOr();
					objetObtenu.utilisation(joueur);
					break;
			}
		}
	}
}
