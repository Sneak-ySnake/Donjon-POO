package Main;

import java.util.Scanner;

import Metier.Donjon.Jeu;

public class Main {

	public static void main (String arg[]) {
		
		Jeu jeu = new Jeu();
		
		jeu.effacerEcran();
		jeu.menu();
		jeu.effacerEcran();
	}
}
