package fr.pizzeria.console;

public class Pizza {
	private int id;
	private String code;
	private String libelle;
	private double prix;
	
	private static int cpt = 0;
	
//constructeur de la classe Pizza sans id, celui-ci est incrémenté
	
	/**
	 * constructor
	 * @param code 
	 * 		code de la pizza
	 * @param libelle 
	 * 		nom de la pizza
	 * @param prix 
	 * 		prix de la pizza
	 */
	public Pizza(String code, String libelle, double prix) {
		this.id = cpt++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

//constructeur de la classe Pizza avec id à rentrer lors de l'appel
	
	/**
	 * constructor
	 * @param id 
	 * 		identifiant de la pizza (numéro)
	 * @param 
	 * 		code code de la pizza
	 * @param 
	 * 		libelle nom de la pizza (sans espace)
	 * @param 
	 * 		prix prix de la pizza
	 */
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
//méthode d'affichage de la liste des pizzas
	
	/**
	 * méthode d'affichage de la pizza
	 * @param a
	 * 		Pizza a
	 */
	public static void afficherPizza(Pizza a){
		System.out.println(a.code + " -> " + a.libelle + " (" + a.prix + " €)");
	}
	
//override (redéfinition) de la méthode toString()
	public String toString(){
		return code + " -> " + libelle + " (" + prix + " €)";
	}

//construction getter et setter
	/**
	 * getter
	 * @return	id de la pizza
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
}
