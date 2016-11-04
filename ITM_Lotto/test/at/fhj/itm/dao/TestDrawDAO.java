package at.fhj.itm.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.model.Draw;

public class TestDrawDAO {

	private static DrawDAO drawDAO;
	private static Draw draw;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		drawDAO = new DrawDAO();
		draw = new Draw(10000, 25000, "1,2,3,4,5,6", new java.sql.Date(2016, 11, 14), 0, 350, 30, 15, 0);
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
			drawDAO.delete(draw);
		} catch(Exception e) {
			
		}
	}

	@Test
	public void testCreate() {
		
		drawDAO.create(draw);
         
        Draw drawout = drawDAO.read(10000);
        assertEquals(drawout.hashCode(), draw.hashCode()); 
	}
	
	@Test
	public void testRead() {
		
		drawDAO.create(draw);
         
		Draw drawout = drawDAO.read(10000);
        assertEquals(drawout.hashCode(), draw.hashCode()); 
	}
	
	@Test
	public void testUpdate() {
		
		drawDAO.create(draw);
		Draw draw2 = draw;
		draw2.jackpotLevel += 1; 
		drawDAO.update(draw2);
        Draw accountingout = drawDAO.read(10000);
        assertEquals(accountingout.hashCode(), draw2.hashCode()); 
        assertNotEquals(accountingout, draw);
	}
	
	@Test(expected=SQLException.class)
	public void testDelete() {
		
		drawDAO.create(draw);
		@SuppressWarnings("deprecation")
		Draw drawdel = new Draw(10002, 25000, "1,2,3,4,5,6", new java.sql.Date(2016, 11, 14), 0, 350, 30, 15, 0); 
		drawDAO.create(drawdel);
		drawDAO.delete(drawdel);
        
		/* should throw an exception */
        drawDAO.read(10002); 
	}


}
