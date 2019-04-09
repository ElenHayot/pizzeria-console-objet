package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import fr.pizzeria.console.Pizza;

public class PizzaJpaDao implements IPizzaDao {

	public PizzaJpaDao() {
		
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		EntityManager em1 = emf.createEntityManager();
		
		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> pizzaList = requete.getResultList();
		
		em1.close();
		emf.close();
		return pizzaList;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		EntityManager em1 = emf.createEntityManager();
		//transaction nécessaire pour rajouter une ligne dans la table
		EntityTransaction et = em1.getTransaction();
		et.begin();
		
		em1.persist(pizza);
		pizza.setCode(pizza.getCode());
		pizza.setLibelle(pizza.getLibelle());
		pizza.setCategorie(pizza.getCategorie());
		pizza.setPrix(pizza.getPrix());
		
		et.commit();
		//fin de la transaction
		em1.close();
		emf.close();
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		EntityManager em1 = emf.createEntityManager();
		//transaction nécessaire pour modifier une ligne dans la table
		EntityTransaction et = em1.getTransaction();
		et.begin();
		
		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p where code=:reference", Pizza.class);
		
		requete.setParameter("reference", codePizza);
		Pizza result = requete.getSingleResult();
		result.setCode(pizza.getCode());
		result.setLibelle(pizza.getLibelle());
		result.setCategorie(pizza.getCategorie());
		result.setPrix(pizza.getPrix());
		em1.merge(result);
		
		et.commit();		
		//fin de la transaction
		em1.close();
		emf.close();
		
	}

	@Override
	public void deletePizza(String codePizza) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		EntityManager em1 = emf.createEntityManager();
		//transaction nécessaire pour modifier une ligne dans la table
		EntityTransaction et = em1.getTransaction();
		et.begin();
		
		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p where code=:reference", Pizza.class);
		requete.setParameter("reference", codePizza);
		Pizza result = requete.getSingleResult();
		em1.remove(result);
		
		et.commit();		
		//fin de la transaction
		em1.close();
		emf.close();
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		EntityManager em1 = emf.createEntityManager();

		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p where code=:reference", Pizza.class);
		requete.setParameter("reference", codePizza);
		Pizza result = requete.getSingleResult();

		em1.close();
		emf.close();
		return result;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean answer = false;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		EntityManager em1 = emf.createEntityManager();

		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p where code=:reference", Pizza.class);
		
		requete.setParameter("reference", codePizza);
		Pizza result = requete.getSingleResult();
		if(result != null)
			answer = true;
				
		em1.close();
		emf.close();
		return answer;
	}

}
