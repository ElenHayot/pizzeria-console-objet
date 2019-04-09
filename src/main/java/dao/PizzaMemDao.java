package dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	private List<Pizza> tableauPizza = new ArrayList<>();
	
	public PizzaMemDao(){
		tableauPizza.add(new Pizza("PEP", "Pépéroni", "Viande", 12.50));
		tableauPizza.add(new Pizza("MAR", "Margherita", "Sans Viande", 14.00));
		tableauPizza.add(new Pizza("REIN", "La Reine", "Viande", 11.50));
		tableauPizza.add(new Pizza("FRO", "La 4 fromages", "Sans Viande", 12.00));
		tableauPizza.add(new Pizza("CAN", "La Cannibale", "Viande", 12.50));
		tableauPizza.add(new Pizza("SAV", "La Savoyarde", "Poisson", 13.00));
		tableauPizza.add(new Pizza("ORI", "L'Orientale", "Poisson", 13.50));
		tableauPizza.add(new Pizza("IND", "L'Indienne", "Sans Viande", 14.00));
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public List<Pizza> findAllPizzas() {
		return tableauPizza;
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		
			//Rajout de la pizza à la prochaine ligne du tableau en tant que l-ième élément
		tableauPizza.add(new Pizza(pizza.getCode(), pizza.getLibelle(), pizza.getCategorie(), pizza.getPrix()));
		//l++;
		
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		Pizza p = findPizzaByCode(codePizza);
		int compteur = tableauPizza.indexOf(p); 
		tableauPizza.set(compteur, pizza);
		
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public void deletePizza(String codePizza) {
		
		Pizza p = findPizzaByCode(codePizza);
		tableauPizza.remove(p);

	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		
			//recherche de la pizza par son code
		Pizza pizzaCompt = new Pizza();
		for(Pizza p:tableauPizza){
			if(p.getCode().equals(codePizza))
				pizzaCompt = p;
		}
		
		return pizzaCompt; 
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public boolean pizzaExists(String codePizza) {
		
		for(Pizza p: tableauPizza){
			if(p.getCode().equals(codePizza))
				return true;
		}

		return false;
	}

	
	
}
