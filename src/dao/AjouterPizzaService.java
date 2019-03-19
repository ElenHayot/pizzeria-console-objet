package dao;

import fr.pizzeria.console.Pizza;
import java.util.Scanner;

public class AjouterPizzaService extends MenuService{
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void executeUC() {
		
		System.out.println("Veuillez saisir le code: ");
		String codePizza = sc.nextLine();	
		System.out.println("Veuillez saisir le nom (sans espace): ");
		String nomPizza = sc.nextLine();
		System.out.println("Veuillez saisir le prix: ");
		String pP = sc.nextLine();
			//transformation String en double
		double prixPizza = Double.parseDouble(pP);
		Pizza newPizza = new Pizza(codePizza, nomPizza, prixPizza);
		
			//j'applique la méthode de rajout d'une nouvelle pizza				 
		dao.saveNewPizza(newPizza); 
		
	}

}
