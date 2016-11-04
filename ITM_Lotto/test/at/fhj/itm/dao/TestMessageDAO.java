package at.fhj.itm.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.model.Message;

public class TestMessageDAO {
	private static MessageDAO messageDAO;
	private static Message message;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		messageDAO = new MessageDAO();
		message = new Message(1000, "Test Text", false, new Date(2016, 11, 04), 0);
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
			messageDAO.delete(message);
		} catch(Exception e) {
			
		}
	}


	@Test
	public void testCreate() {
		
		int id = messageDAO.create(message);
         
        Message messageout = messageDAO.read(id);
        assertEquals(messageout.hashCode(), message.hashCode()); 
	}
	
	@Test
	public void testRead() {
		
		int id = messageDAO.create(message);
         
		Message messageout = messageDAO.read(id);
        assertEquals(messageout.hashCode(), message.hashCode());
	}
	
	@Test
	public void testUpdate() {
		
		int id = messageDAO.create(message);
		Message message2 = message;
		message2.isRead= true;
		messageDAO.update(message2);
        Message messageout = messageDAO.read(id);
        assertEquals(messageout.hashCode(), message2.hashCode()); 
        assertNotEquals(messageout, message);
	}
	
	@Test(expected=SQLException.class)
	public void testDelete() {
		
		messageDAO.create(message);
		@SuppressWarnings("deprecation")
		Message messagedel = new Message(1000, "Hallo :)", false, new Date(2016, 11, 04), 0);
		int id2 = messageDAO.create(messagedel);
		messageDAO.delete(messagedel);
        
		/* should throw an exception */
		messageDAO.read(id2); 
	}

}
