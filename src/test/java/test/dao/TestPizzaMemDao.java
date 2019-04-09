package test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PizzaMemDao;
import fr.pizzeria.console.Pizza;

public class TestPizzaMemDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);
	
	PizzaMemDao dao;
	
	@Rule public TestName testName;
	Pizza pizza = new Pizza(8, "CHO", "Chocolate", "NATURE", 12.97);
	Pizza pizza2 = new Pizza(9, "MUG", "Muglion", "SANS_VIANDE", 18.50);
		
	
	@Before
	public void setUp(){
		
		LOG.info("Etant donnée une instance de PizzaMemDao");
		dao = new PizzaMemDao();
		
	}
	

	
	
	@Test
	public void testFindAllPizzas(){
		
		LOG.info("Lorsque l'on recherche la liste de pizzas");
		List<Pizza> list = dao.findAllPizzas();
		
		LOG.info("Alors la liste de pizzas contient au moins une pizza");
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void testSaveNewPizza(){
		
		List<Pizza> list = dao.findAllPizzas();
		dao.saveNewPizza(pizza);
		int valeurObtenue = list.size();
		
		Assert.assertEquals(9, valeurObtenue);
		Assert.assertTrue(dao.pizzaExists("CHO"));
		
	}
	
	@Test
	public void testUpdatePizza(){
		
		List<Pizza> list = dao.findAllPizzas();
		dao.updatePizza("PEP", pizza2);
		int valeurObtenue = list.size();
		
		Assert.assertEquals(8, valeurObtenue);
		Assert.assertTrue(dao.findPizzaByCode(pizza2.getCode()).equals(pizza2));
	}
	
	@Test
	public void testDeletePizza(){
		
		List<Pizza> list = dao.findAllPizzas();
		dao.deletePizza("MAR");
		int valeurObtenue = list.size();
		
		Assert.assertEquals(7, valeurObtenue);
		Assert.assertFalse(dao.pizzaExists("MAR"));
		
	}
	
	@Test
	public void testFindPizzaByCode(){
		
		List<Pizza> list = dao.findAllPizzas();
		Pizza p = dao.findPizzaByCode("REIN");
		int valeurObtenue = list.size();
		
		Assert.assertEquals(8, valeurObtenue);
		Assert.assertTrue(dao.pizzaExists(p.getCode()));
		
	}
	
	
}
