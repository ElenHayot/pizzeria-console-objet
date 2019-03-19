package dao;

import fr.pizzeria.console.Pizza;

public class ListerPizzaService extends MenuService {

	
	@Override
	public void executeUC() {

			
			Pizza[] tabPizzas = dao.findAllPizzas();
			
			//affichage du tableau
		for (int i=0; i<tabPizzas.length; i++){
			if(tabPizzas[i] != null){	//afin d'empêcher d'afficher 100 lignes null...
				System.out.println(tabPizzas[i]);
			}else{break;}
		}
		
		
	}

}
