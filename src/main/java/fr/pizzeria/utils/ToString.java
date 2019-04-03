package fr.pizzeria.utils;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface ToString {
	
	String before() default "";
	String after() default "";
	boolean uppercase() default true;
	
}
