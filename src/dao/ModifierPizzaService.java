package dao;

import java.util.Scanner;
import fr.pizzeria.console.Pizza;

public class ModifierPizzaService extends MenuService {
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void executeUC() {
		System.out.println("Veuillez choisir le code de la pizza à modifier: ");
		String codePAM = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau code: ");
		String nvCode = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau nom (sans espace): ");
		String nvNom = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau prix: ");
		String nvP = sc.nextLine();
		double nvPrix = Double.parseDouble(nvP);

			//correction des paramètres de la pizza
		Pizza newPizza = new Pizza(nvCode, nvNom, nvPrix);
		dao.updatePizza(codePAM, newPizza);
		
	}
	
}
