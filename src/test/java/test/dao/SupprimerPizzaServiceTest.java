package test.dao;


import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import dao.IPizzaDao;
import dao.SupprimerPizzaService;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Rule
	public ExpectedException exceptionLevee = ExpectedException.none();
	
	@Test
	public void executeUC() throws DeletePizzaException {
		
		exceptionLevee.expect(DeletePizzaException.class);
		exceptionLevee.expectMessage("La pizza choisie n'existe pas");
		
		IPizzaDao mock = Mockito.mock(IPizzaDao.class);
		
		Mockito.when(mock.pizzaExists("PEP")).thenReturn(false);
		systemInMock.provideLines("PEP");
		
		SupprimerPizzaService suppress = new SupprimerPizzaService();
		suppress.setDao(mock);
		suppress.executeUC();
		
		Mockito.verify(mock).deletePizza("PEP");
		
	}
	
}
