package fr.pizzeria.console;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int valeur = 0;
		
		while(valeur != 99){
		System.out.println("***** Pizzeria Admninistration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
		
		valeur = sc.nextInt();
		
			switch(valeur){
			case 1: 
				System.out.println("\nListe des pizzas");
				break;
			case 2:
				System.out.println("\nAjout d'une nouvelle pizza");
				break;
			case 3:	
				System.out.println("\nMise à jour d'une pizza");
				break;
			case 4:
				System.out.println("\nSuppression d'une pizza");
				break;
			}
		}
		
		if(valeur==9){
			System.out.println("\nA bientôt! \uf609");
		}
		sc.close();
	}

}
