package fr.pizzeria.exception;


public class StockageException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockageException(){
		//constructeur
	};
	
	public StockageException(String msg){
		//constructeur
		super(msg);
	};

}
