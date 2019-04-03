package dao;

import fr.pizzeria.exception.StockageException;

public abstract class MenuService {

	IPizzaDao dao;
	
	public abstract void executeUC() throws StockageException;


	public IPizzaDao getDao() {
		return dao;
	}


	public void setDao(IPizzaDao dao) {
		this.dao = dao;
	}
	
	
}
