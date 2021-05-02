package Metier.Objet;
import Metier.Personnage.*;

public abstract class Objet {

	private String nom;
	private int valeur;
	
	public Objet(String nom, int valeur) {
		this.nom=nom;
		this.valeur=valeur;
	}
	
	public abstract void utilisation(Joueur joueur);

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
