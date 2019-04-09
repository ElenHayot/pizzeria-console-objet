package dao;

import java.util.List;
import fr.pizzeria.console.Pizza;

public class ListerPizzaService extends MenuService {

	
	@Override
	public void executeUC() {

			List<Pizza> tabPizza = dao.findAllPizzas();
			
			for(Pizza p:tabPizza)
				System.out.println(p);
		
		
	}

}
