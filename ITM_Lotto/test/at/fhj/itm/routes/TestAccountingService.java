package at.fhj.itm.routes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.dao.AccountingDAO;
import at.fhj.itm.model.Accounting;

public class TestAccountingService {
	
	private static AccountingService as;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		as = new AccountingService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTest() {
		assertEquals("<h1>TEST - /accounting</h1>", as.Test());
	}
	
	@Test
	public void TestGetAccoutingById() {
		AccountingDAO adao = new AccountingDAO();
		@SuppressWarnings("deprecation")
		Accounting ac = new Accounting(10000, 25.0, 5.0,"Test Account", new java.sql.Date(2016, 11, 04), 0);
		ac.id = adao.create(ac);
		assertEquals(ac.toString(), as.getAccoutingById((Integer) ac.id));
	}

}
