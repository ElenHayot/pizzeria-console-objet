package dao;

import fr.pizzeria.console.Pizza;

public interface IPizzaDao {

	Pizza[] findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
	
	
}
