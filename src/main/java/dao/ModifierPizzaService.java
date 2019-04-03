package dao;

import fr.pizzeria.exception.*;
import java.util.Scanner;
import fr.pizzeria.console.Pizza;

public class ModifierPizzaService extends MenuService {
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void executeUC() throws UpdatePizzaException{
		System.out.println("Veuillez choisir le code de la pizza à modifier: ");
		String codePAM = sc.nextLine().toUpperCase();
		
		Boolean retour = dao.pizzaExists(codePAM);
		
		if(retour == false ){
			throw new UpdatePizzaException("La pizza choisie n'existe pas");
		}
		
		System.out.println("Veuillez saisir le nouveau code: ");
		String nvCode = sc.nextLine().toUpperCase();
		
		if(nvCode.length() <= 1){
			throw new UpdatePizzaException("Veuillez saisir un code avec au moins deux caractères");
		}
		
		System.out.println("Veuillez saisir le nouveau nom (sans espace): ");
		String nvNom = sc.nextLine();
		System.out.println("Veuillez saisir la catégorie: ");
		String nvCategorie = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau prix: ");
		String nvP = sc.nextLine();

		double nvPrix = Double.parseDouble(nvP);
		if(nvPrix <= 0){
			throw new UpdatePizzaException("Merci d'entrer un prix un peu plus correct");
		}
		
			//correction des paramètres de la pizza
		Pizza newPizza = new Pizza(nvCode, nvNom, nvCategorie, nvPrix);
		dao.updatePizza(codePAM, newPizza);
		
	}
	
}
