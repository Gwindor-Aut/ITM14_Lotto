package at.fhj.itm.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.model.Tipp;

public class TestTippDAO {
	
	private static TippDAO tippDAO;
	private static Tipp tipp;


	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tippDAO = new TippDAO();
		tipp = new Tipp(1000, "1,2,3,4,5,6", false, new Date(2016, 11, 04), 0, 0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		try {
			tippDAO.delete(tipp);
		} catch(Exception e) {
			
		}
	}

	@Test
	public void testCreate() {
		
		int id = tippDAO.create(tipp);
         
        Tipp tippout = tippDAO.read(id);
        assertEquals(tippout.hashCode(), tipp.hashCode()); 
	}
	
	@Test
	public void testRead() {
		
		int id = tippDAO.create(tipp);
         
        Tipp tippout = tippDAO.read(id);
        assertEquals(tippout.hashCode(), tipp.hashCode()); 
	}
	
	@Test
	public void testUpdate() {
		
		int id = tippDAO.create(tipp);
		Tipp tipp2 = tipp;
		tipp2.isQuicktipp = true;
		tippDAO.update(tipp2);
        Tipp accountingout = tippDAO.read(id);
        assertEquals(accountingout.hashCode(), tipp2.hashCode()); 
        assertNotEquals(accountingout, tipp);
	}
	
	@Test(expected=SQLException.class)
	public void testDelete() {
		
		tippDAO.create(tipp);
		@SuppressWarnings("deprecation")
		Tipp tippdel = new Tipp(1000, "1,2,3,4,5,6", false, new Date(2016, 11, 04), 0, 0); 
		int id2 = tippDAO.create(tippdel);
		tippDAO.delete(tippdel);
        
		/* should throw an exception */
        tippDAO.read(id2); 
	}

}
