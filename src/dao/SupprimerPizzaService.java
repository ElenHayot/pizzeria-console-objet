package dao;

import java.util.Scanner;

public class SupprimerPizzaService extends MenuService {
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void executeUC() {
		
		System.out.println("Veuillez choisir le code de la pizza à supprimer: ");
		String codePAS = sc.nextLine();
		
			//j'applique la méthode de suppression de pizza de la classe PizzaMemDao
		dao.deletePizza(codePAS);
		
		
	}

}
