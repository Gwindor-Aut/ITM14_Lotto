package at.fhj.itm.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.model.Accounting;

public class TestAccountingDAO {
	
	private static AccountingDAO accountingDAO;
	private static Accounting accounting;
	//private Accounting accounting;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		accountingDAO = new AccountingDAO();
		accounting = new Accounting(10000, 25.0, 5.0,"Test Account", (java.sql.Date) new Date(2016, 11, 03), 0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		accountingDAO.delete(accounting);
	}

	@Test
	public void testCreate() {
		
		int id = accountingDAO.create(accounting);
         
        Accounting accountingout = accountingDAO.read(id);
        assertEquals(accountingout.hashCode(), accounting.hashCode()); 
	}
	
	@Test
	public void testRead() {
		
		int id = accountingDAO.create(accounting);
         
        Accounting accountingout = accountingDAO.read(id);
        assertEquals(accountingout.hashCode(), accounting.hashCode()); 
	}
	
	@Test
	public void testUpdate() {
		
		int id = accountingDAO.create(accounting);
		Accounting accounting2 = accounting;
		accounting2.balance += 1; 
		accountingDAO.update(accounting2);
        Accounting accountingout = accountingDAO.read(id);
        assertEquals(accountingout.hashCode(), accounting2.hashCode()); 
        assertNotEquals(accountingout, accounting);
	}
	
	@Test(expected=SQLException.class)
	public void testDelete() {
		
		accountingDAO.create(accounting);
		@SuppressWarnings("deprecation")
		Accounting accounting2 = new Accounting(10002, 25.0, 5.0,"Test Account", (java.sql.Date) new Date(2016, 11, 03), 0);
		int id = accountingDAO.create(accounting2);
		accountingDAO.delete(accounting2);
        
		/* should throw an exception */
        accountingDAO.read(id); 
	}

}
