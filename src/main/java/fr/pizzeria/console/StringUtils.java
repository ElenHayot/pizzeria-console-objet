package fr.pizzeria.console;

import java.lang.reflect.Field;
import fr.pizzeria.utils.ToString;


//Cette classe permet de redéfinir la méthode toString() de la classe Pizza

public class StringUtils {

	public String stringUtils(Object object){
		
		String chaine = "";
		//retourne la classe StringUtils même
		@SuppressWarnings("rawtypes")
		Class classe = object.getClass(); 
		//récupération de la liste des attributs de la classe
		Field[] fields = classe.getDeclaredFields();	
		
		//parcours de la liste des attributs de la classe (id, code, libelle et prix)
		for(Field attribut : fields){
			//vérifie si l'attribut contient l'annotation @ToString
			if(attribut.isAnnotationPresent(ToString.class)){
				
				//je rends les attributs de la classe Pizza accessibles (ils sont en private)
				attribut.setAccessible(true);
				//création de l'objet ToString pour récupérer la valeur de l'attribut
				ToString annotation = attribut.getAnnotation(ToString.class);
				
				//attribution des arguments définis à ceux de l'annotation
				boolean uppercase = annotation.uppercase();
				String before = annotation.before();
				String after = annotation.after();
				
				try{
					chaine += before + after;
					if(uppercase){
						//mise en majuscule de la valeur de l'attribut
						chaine += attribut.get(object).toString().toUpperCase();
					}else{
						chaine += attribut.get(object).toString();
					}
				}catch(IllegalArgumentException | IllegalAccessException e){
					e.printStackTrace();
				}	
			}
		}
		return chaine;
	}
	
}
