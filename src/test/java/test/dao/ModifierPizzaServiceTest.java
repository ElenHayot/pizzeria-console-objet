package test.dao;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import dao.IPizzaDao;
import dao.ModifierPizzaService;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public class ModifierPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Rule public ExpectedException exceptionLevee = ExpectedException.none();

	@Test
	public void executeUC() throws StockageException {
		
		//test si l'exception est levée lorsque le code de la pizza est trop petit
		exceptionLevee.expect(UpdatePizzaException.class);
		exceptionLevee.expectMessage("Veuillez saisir un code avec au moins deux caractères");
		
		IPizzaDao mock = Mockito.mock(IPizzaDao.class);
		Pizza pizza = new Pizza("CRO", "Cromanion", "SANS_OS", 0.02);
		
		//ordonne au mock de retourner true lorsque l'on teste pizzaExist("PEP");
		Mockito.when(mock.pizzaExists("PEP")).thenReturn(true);
		systemInMock.provideLines("PEP", "O", "Cromanion", "SANS_OS", "0.02");
		
		ModifierPizzaService modif = new ModifierPizzaService();
		modif.setDao(mock);
		modif.executeUC();
		
		Mockito.verify(mock).updatePizza("PEP", pizza);
		
		
	}
	
}
