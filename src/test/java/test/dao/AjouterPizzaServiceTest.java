package test.dao;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import dao.AjouterPizzaService;
import dao.IPizzaDao;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public class AjouterPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Rule public ExpectedException exceptionLevee = ExpectedException.none();

	@Test
	public void executeUC() throws StockageException {
		
		//test si l'exception est correctement levée lorsqu'un prix négatif est entré
		exceptionLevee.expect(SavePizzaException.class);
		exceptionLevee.expectMessage("Merci d'entrer un prix positif (autrement vous perdez de l'argent)");
		
		// création du mock
		IPizzaDao mock = Mockito.mock(IPizzaDao.class);
		Pizza pizza = new Pizza("CRO", "Cromanion", "SANS_OS", 0.02);	
		
		//alimentation du mock
		systemInMock.provideLines("CRO", "Cromanion", "SANS_OS", "-0.02");
	
		AjouterPizzaService ajouterPizzasService = new AjouterPizzaService();
		ajouterPizzasService.setDao(mock);
		ajouterPizzasService.executeUC();
		
		// vérifier que la méthode saveNewPizza du mock a été invoquée
		Mockito.verify(mock).saveNewPizza(pizza);
		
	}
	
}
