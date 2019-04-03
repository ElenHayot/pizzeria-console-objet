package fr.pizzeria.console;

import java.lang.reflect.Field;
import fr.pizzeria.utils.Rule;

public class Validator {

	public void validator(Object object){
		
		@SuppressWarnings("rawtypes")
		Class classe = object.getClass();
		Field[] field = classe.getDeclaredFields();
		
		for(Field attribut:field){
			if(attribut.isAnnotationPresent(Rule.class)){
				attribut.setAccessible(true);
				Rule annotation = attribut.getAnnotation(Rule.class);
				int min = annotation.min();
				int max = annotation.max();
				
				try{
					continue;
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
}
