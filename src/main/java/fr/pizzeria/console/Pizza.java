package fr.pizzeria.console;

import fr.pizzeria.utils.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA")
public class Pizza {
	
	@Id
	@Column(name="ID")
	private int id;
	//rajout des paramètres before et after pour demander une certaine mise en page
	
	@Column(name="CODE")
	@ToString(before="* ", after="  ")	
	private String code;
	
	@Column(name="NAME")
	@ToString(before=" -> ", uppercase=false)
	private String libelle;
	
	@Column(name="CATEGORY")
	@ToString(before=", Cat ")
	private String categorie;
	
	@Column(name="PRICE")
	@ToString(before=" : ", after=" €")
	@Rule(min=0)
	private double prix;
	
	private static int cpt = 0;
	
	public Pizza(){}
	
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
	public Pizza(String code, String libelle, String categorie, double prix) {
		this.id = cpt++;
		this.code = code;
		this.libelle = libelle;
		this.categorie = categorie;
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
	public Pizza(int id, String code, String libelle, String categorie, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.categorie = categorie;
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
		//Appel de la méthode stringUtils de la classe StringUtil
		StringUtils stringUtils = new StringUtils();
		return stringUtils.stringUtils(this);
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

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getCategorie() {
		return categorie;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
}
