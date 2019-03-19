package dao;

import fr.pizzeria.console.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	int l=8;
	private Pizza[] tableauPizza = new Pizza[100];
	
	public PizzaMemDao(){
		tableauPizza[0]= new Pizza("PEP", "Pépéroni", 12.50);
		tableauPizza[1] = new Pizza("MAR", "Margherita", 14.00);
		tableauPizza[2] = new Pizza("REIN", "La Reine", 11.50);
		tableauPizza[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		tableauPizza[4] = new Pizza("CAN", "La Cannibale", 12.50);
		tableauPizza[5] = new Pizza("SAV", "La Savoyarde", 13.00);
		tableauPizza[6] = new Pizza("ORI", "L'Orientale", 13.50);
		tableauPizza[7] = new Pizza("IND", "L'Indienne", 14.00);
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public Pizza[] findAllPizzas() {
		return tableauPizza;
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		
			//Rajout de la pizza à la prochaine ligne du tableau en tant que l-ième élément
		tableauPizza[l] = new Pizza(pizza.getCode(), pizza.getLibelle(), pizza.getPrix());
		l++;
		
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
			//comparaison (String,String) avec equals et une réponse boolean
		Pizza p = findPizzaByCode(codePizza);
		int compteur = p.getId(); 
		
			//correction des paramètres de la pizza
		tableauPizza[compteur] = pizza;
		
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public void deletePizza(String codePizza) {
		
			//on retrouve la pizza correspondante e ton associe son Id à un compteur
		Pizza p = findPizzaByCode(codePizza);
		int compteur = p.getId();
		
			//décalage des derniers éléments du tableau vers le premier afin de ne pas avoir de trou dans le tableau
		for(int i=compteur; i<l-1; i++){
			tableauPizza[i] = tableauPizza[i+1];
		}
		
			//suppression du dernier élément du tableau (autrement doublon du dernier élément)
		tableauPizza[l-1] = null;
			//il y a un élément en moins donc l devient l-1
		l--;
		
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		
			//recherche de la pizza par son code
		boolean compare = false;
		int compteur = 0;
		for(int i=0; i<l; i++){
				//comparaison (String, String) avec equals
			compare = codePizza.equals(tableauPizza[i].getCode());
			if(compare==true){
				break;	//sortie de la boucle for dès que boolean=true pour que le compteur s'arrête
			}
			compteur++;
		}
		
			//retourne la pizza placée dans la case compteur du tableau
		Pizza pizzaCompt = tableauPizza[compteur];
		return pizzaCompt; 
	}

//*********************************************************************************************//
//*********************************************************************************************//
	
	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
