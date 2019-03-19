package fr.pizzeria.console;
import java.util.Scanner;
import dao.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int valeur = 0;

//La classe PizzaMemDao est une base de données et elle permet de modifier cette base de données
		PizzaMemDao pizza = new PizzaMemDao();

//*************************************************************************************//
//*************************************************************************************//
//*************************************************************************************//
		
		while(valeur != 99){
		System.out.println("\n***** Pizzeria Admninistration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
		
		valeur = sc.nextInt();
		
			switch(valeur){
			
			//*************************************************************************************//
			
			//Cas 1: afficher les pizza: appelle de la méthode afficherPizza()
			case 1: 
				System.out.println("\nListe des pizzas");

					//je récupère le tableau que me retourne la méthode findAllPizzas()
				Pizza[] tabPizzas = pizza.findAllPizzas();
	
					//affichage du tableau
				for (int i=0; i<tabPizzas.length; i++){
					if(tabPizzas[i] != null){	//afin d'empêcher d'afficher 100 lignes null...
						System.out.println(tabPizzas[i]);
					}else{break;}
				}
				
				break;
				
			//*************************************************************************************//
				
			//Cas 2: Ajouter une nouvelle pizza
			case 2:
				System.out.println("\nAjout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code: ");
				sc.nextLine();	//astuce pour que le code rentré ne passe pas à la trappe
				String codePizza = sc.nextLine();	
				System.out.println("Veuillez saisir le nom (sans espace): ");
				String nomPizza = sc.nextLine();
				System.out.println("Veuillez saisir le prix: ");
				String pP = sc.nextLine();
					//transformation String en double
				double prixPizza = Double.parseDouble(pP);
				Pizza newPizza = new Pizza(codePizza, nomPizza, prixPizza);
				
					//j'applique la méthode de rajout d'une nouvelle pizza				 
				pizza.saveNewPizza(newPizza); 
				break;
				
			//*************************************************************************************//
				
			//Cas 3: Mise à jour d'une pizza
			case 3:	
				System.out.println("\nMise à jour d'une pizza");
				System.out.println("Veuillez choisir le code de la pizza à modifier: ");
				sc.nextLine();
				String codePAM = sc.nextLine();
				System.out.println("Veuillez saisir le nouveau code: ");
				String nvCode = sc.nextLine();
				System.out.println("Veuillez saisir le nouveau nom (sans espace): ");
				String nvNom = sc.nextLine();
				System.out.println("Veuillez saisir le nouveau prix: ");
				String nvP = sc.nextLine();
				double nvPrix = Double.parseDouble(nvP);

					//correction des paramètres de la pizza
				newPizza = new Pizza(nvCode, nvNom, nvPrix);
				pizza.updatePizza(codePAM, newPizza);
				break;
				
			//*************************************************************************************//
				
			//Cas 4: Suppression d'une pizza
			case 4:
				System.out.println("\nSuppression d'une pizza");
				System.out.println("Veuillez choisir le code de la pizza à supprimer: ");
				sc.nextLine();
				String codePAS = sc.nextLine();
				
					//j'applique la méthode de suppression de pizza de la classe PizzaMemDao
				pizza.deletePizza(codePAS);
				break;
			}
		}
		
		if(valeur==99){
			System.out.println("\nA bientôt! \uf609");
		}
		sc.close();
	}
}
