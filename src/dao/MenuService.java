package dao;

import fr.pizzeria.exception.StockageException;

public abstract class MenuService {

	PizzaMemDao dao;
	
	public abstract void executeUC() throws StockageException;


	public PizzaMemDao getDao() {
		return dao;
	}


	public void setDao(PizzaMemDao dao) {
		this.dao = dao;
	}
	
	
}
