package dao;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.SavePizzaException;

import java.util.Scanner;

public class AjouterPizzaService extends MenuService{
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void executeUC() throws SavePizzaException {
		
		System.out.println("Veuillez saisir le code: ");
		String codePizza = sc.nextLine().toUpperCase();	
		
		if(codePizza.length() <= 1){
			throw new SavePizzaException("Veuillez saisir un code avec au moins deux caractères");
		}
		System.out.println("Veuillez saisir le nom (sans espace): ");
		String nomPizza = sc.nextLine();
		System.out.println("Veuillez saisir la catégorie: ");
		String catPizza = sc.nextLine();
		System.out.println("Veuillez saisir le prix: ");
		String pP = sc.nextLine();
			//transformation String en double
		double prixPizza = Double.parseDouble(pP);
		
		if(prixPizza <= 0){
			throw new SavePizzaException("Merci d'entrer un prix un peu plus correct");
		}
		
		Pizza newPizza = new Pizza(codePizza, nomPizza, catPizza, prixPizza);
		
			//j'applique la méthode de rajout d'une nouvelle pizza				 
		dao.saveNewPizza(newPizza); 
		
		
	}

}
