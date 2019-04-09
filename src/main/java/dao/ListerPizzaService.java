package dao;

import java.util.List;
import fr.pizzeria.console.Pizza;

public class ListerPizzaService extends MenuService {

	
	@Override
	public void executeUC() {

			List<Pizza> tabPizza = dao.findAllPizzas();
			
			System.out.println("\nVoici la liste des pizzas enregistrées dans la base de données:");
			for(Pizza p:tabPizza)
				System.out.println(p);
		
		
	}

}
