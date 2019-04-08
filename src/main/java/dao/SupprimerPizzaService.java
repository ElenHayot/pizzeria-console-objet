package dao;

import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaService extends MenuService {
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void executeUC() throws DeletePizzaException{
		
		System.out.println("Veuillez choisir le code de la pizza à supprimer: ");
		String codePAS = sc.nextLine().toUpperCase();
		
		Boolean retour = dao.pizzaExists(codePAS);
		
		if(retour == false){
			throw new DeletePizzaException("La pizza choisie n'existe pas");
		}
		
		
			//j'applique la méthode de suppression de pizza de la classe PizzaMemDao
		dao.deletePizza(codePAS);
		
		
	}

}
