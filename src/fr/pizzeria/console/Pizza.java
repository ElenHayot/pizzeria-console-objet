package fr.pizzeria.console;

public class Pizza {
	int id;
	String code;
	String libelle;
	double prix;
	
	
	public Pizza(String code, String libelle, double prix) {
		this.id++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
//méthode d'affichage de la liste des pizzas
	public static void afficherPizza(Pizza a){
		System.out.println(a.code + " -> " + a.libelle + " (" + a.prix + " €)");
	}
	
	
}
