package fr.pizzeria.console;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int valeur = 0;

//Définition de la liste des pizzas
		int l=8;
		Pizza[] tableauPizza = new Pizza[100];
		
		tableauPizza[0]= new Pizza("PEP", "Pépéroni", 12.50);
		tableauPizza[1] = new Pizza("MAR", "Margherita", 14.00);
		tableauPizza[2] = new Pizza("REIN", "La Reine", 11.50);
		tableauPizza[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		tableauPizza[4] = new Pizza("CAN", "La Cannibale", 12.50);
		tableauPizza[5] = new Pizza("SAV", "La Savoyarde", 13.00);
		tableauPizza[6] = new Pizza("ORI", "L'Orientale", 13.50);
		tableauPizza[7] = new Pizza("IND", "L'Indienne", 14.00);
		

	

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
			//Cas 1: aafficher les pizza: appelle de la méthode afficherPizza()
			case 1: 
				System.out.println("\nListe des pizzas");
				for(int i=0; i<l; i++){
					Pizza id = tableauPizza[i];
					Pizza.afficherPizza(id);
				}
				break;
			//*************************************************************************************//
			//Cas 2: Ajouter uen nouvelle pizza
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
				//Rajout de la pizza à la prochaine ligne du tableau en tant que l-ième élément
				tableauPizza[l] = new Pizza(codePizza, nomPizza, prixPizza);
				l++;
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
				//comparaison (String,String) avec equals et une réponse boolean
				boolean compare = false;
				//le compteur sert à retrouver le rang de la pizza dans le tableau
				int compteur = 0;
				for(int i=0; i<l; i++){
					compare = codePAM.equals(tableauPizza[i].code);
					if(compare==true){
						break;
					}
					compteur++;
				}
				//correction des paramètres de la pizza
				tableauPizza[compteur] = new Pizza(nvCode, nvNom, nvPrix);
				break;
			//*************************************************************************************//
			//Cas 4: Suppression d'une pizza
			case 4:
				System.out.println("\nSuppression d'une pizza");
				System.out.println("Veuillez choisir le code de la pizza à supprimer: ");
				sc.nextLine();
				String codePAS = sc.nextLine();
				compare = false;
				compteur = 0;
				for(int i=0; i<l; i++){
					compare = codePAS.equals(tableauPizza[i].code);
					if(compare==true){
						break;	//sortie de la boucle for dès que boolean=true pour que le compteur s'arrête
					}
					compteur++;
				}
				//décalage des derniers éléments du tableau vers le premier afin de ne pas avoir de trou dans le tableau
				for(int i=compteur; i<l-1; i++){
					tableauPizza[i] = tableauPizza[i+1];
				}
				//suppression du dernier élément du tableau (autrement doublon du dernier élément)
				tableauPizza[l-1] = null;
				//il y a un élément en moins donc l devient l-1
				l--;
				break;
			}
		}
		
		if(valeur==99){
			System.out.println("\nA bientôt! \uf609");
		}
		sc.close();
	}
}
