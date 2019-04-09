package test.dao;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import dao.IPizzaDao;
import dao.ListerPizzaService;
import fr.pizzeria.exception.StockageException;

public class ListerPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void executeUC() throws StockageException {
		
		IPizzaDao mock = Mockito.mock(IPizzaDao.class);
		ListerPizzaService lister = new ListerPizzaService();
		lister.setDao(mock);
		lister.executeUC();
		
		Mockito.verify(mock);
		
	}
	
}
