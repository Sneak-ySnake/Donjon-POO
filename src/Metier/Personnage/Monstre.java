package Metier.Personnage;

public class Monstre extends Personnage{

	private String nom = "Monstre";
	
	public Monstre(int pointDeVie, int force, int nbPieceOr, int coordonneeX, int coordonneeY) {
		super(pointDeVie, force, nbPieceOr, coordonneeX, coordonneeY);
	}

	public String getNom() {
		return nom;
	}
	
}
