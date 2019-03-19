package dao;

public abstract class MenuService {

	PizzaMemDao dao;
	
	
	
	abstract void executeUC();



	public PizzaMemDao getDao() {
		return dao;
	}



	public void setDao(PizzaMemDao dao) {
		this.dao = dao;
	}
	
}
