package at.fhj.itm.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.model.WinningLevel;

public class TestWinningLevelDAO {

	private static WinningLevelDAO winningLevelDAO;
	private static WinningLevel winningLevel;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		winningLevelDAO = new WinningLevelDAO();
		winningLevel = new WinningLevel(1000, new Date(2016, 11, 04),1,10,25,300);
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
			winningLevelDAO.delete(winningLevel);
		} catch(Exception e) {
			
		}
	}

	@Test
	public void testCreate() {
		
		int id = winningLevelDAO.create(winningLevel);
         
        WinningLevel winningLevelout = winningLevelDAO.read(id);
        assertEquals(winningLevelout.hashCode(), winningLevel.hashCode()); 
	}
	
	@Test
	public void testRead() {
		
		int id = winningLevelDAO.create(winningLevel);
         
        WinningLevel winningLevelout = winningLevelDAO.read(id);
        assertEquals(winningLevelout.hashCode(), winningLevel.hashCode()); 
	}
	
	@Test
	public void testUpdate() {
		
		int id = winningLevelDAO.create(winningLevel);
		WinningLevel winningLevel2 = winningLevel;
		winningLevel2.five = 5;
		winningLevelDAO.update(winningLevel2);
        WinningLevel accountingout = winningLevelDAO.read(id);
        assertEquals(accountingout.hashCode(), winningLevel2.hashCode()); 
        assertNotEquals(accountingout, winningLevel);
	}
	
	@Test(expected=SQLException.class)
	public void testDelete() {
		
		winningLevelDAO.create(winningLevel);
		@SuppressWarnings("deprecation")
		WinningLevel winningLeveldeldel = new WinningLevel(1000, new Date(2016, 11, 04),1,10,25,300);
		int id2 = winningLevelDAO.create(winningLeveldeldel);
		winningLevelDAO.delete(winningLeveldeldel);
        
		/* should throw an exception */
        winningLevelDAO.read(id2); 
	}
}
