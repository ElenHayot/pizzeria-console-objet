package fr.pizzeria.console;

import fr.pizzeria.exception.*;
import java.util.Scanner;
import dao.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PizzaMemDao dao = new PizzaMemDao();
		int valeur = 0;

		// *************************************************************************************//
		// *************************************************************************************//
		// *************************************************************************************//

		while (valeur != 99) {
			System.out.println("\n***** Pizzeria Admninistration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			valeur = sc.nextInt();
			
				//je crée mes instances et partage le même dao entre elles
			ListerPizzaService listePizzas = new ListerPizzaService();
			listePizzas.setDao(dao);
			AjouterPizzaService ajoutPizza = new AjouterPizzaService();
			ajoutPizza.setDao(dao);
			ModifierPizzaService modifPizza = new ModifierPizzaService();
			modifPizza.setDao(dao);
			SupprimerPizzaService supprPizza = new SupprimerPizzaService();
			supprPizza.setDao(dao);

			switch (valeur) {

			// *************************************************************************************//

			// Cas 1: afficher les pizza: appelle de la méthode afficherPizza()
			case 1:
				System.out.println("\nListe des pizzas");
				listePizzas.executeUC();

				break;

			// *************************************************************************************//

			// Cas 2: Ajouter une nouvelle pizza
			case 2:
				System.out.println("\nAjout d'une nouvelle pizza");
				try{
					ajoutPizza.executeUC();
				}catch(SavePizzaException e){
					System.out.println(e.getMessage());
				}

				break;

			// *************************************************************************************//

			// Cas 3: Mise à jour d'une pizza
			case 3:
				System.out.println("\nMise à jour d'une pizza");
				try{
					modifPizza.executeUC();
				}catch(UpdatePizzaException e){
					System.out.println(e.getMessage());
				}

				break;

			// *************************************************************************************//

			// Cas 4: Suppression d'une pizza
			case 4:
				System.out.println("\nSuppression d'une pizza");
				try{supprPizza.executeUC();
				}catch(DeletePizzaException e){
					System.out.println(e.getMessage());
				}

				break;
			}
		}

		if (valeur == 99) {
			System.out.println("\nA bientôt! \uf609");
		}
		sc.close();
	}
}
