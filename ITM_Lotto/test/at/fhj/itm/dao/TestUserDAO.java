package at.fhj.itm.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.model.User;

public class TestUserDAO {

	private static UserDAO userDAO;
	private static User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDAO = new UserDAO();
		user = new User(1000, "Test", "Test");
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
			userDAO.delete(user);
		} catch(Exception e) {
			
		}
	}

	@Test
	public void testCreate() {
		
		user.id = userDAO.create(user);
         
        User userout = userDAO.read(user.id);
        assertEquals(userout.hashCode(), user.hashCode()); 
	}
	
	@Test
	public void testRead() {
		
		user.id = userDAO.create(user);
         
        User userout = userDAO.read(user.id);
        assertEquals(userout.hashCode(), user.hashCode()); 
	}
	
	@Test
	public void testReadByUsername() {
		user.id = userDAO.create(user);
		
		assertEquals(user.hashCode(), userDAO.readByUsername(user.username).hashCode());
		
	}
	
	@Test
	public void testUpdate() {
		
		user.id = userDAO.create(user);
		User user2 = user;
		user2.password = "alligator";
		userDAO.update(user2);
        User accountingout = userDAO.read(user.id);
        assertEquals(accountingout.hashCode(), user2.hashCode()); 
        assertNotEquals(accountingout, user);
	}
	
	@Test(expected=SQLException.class)
	public void testDelete() {
		
		User userdel = new User(1000, "XYZ", "Tschau"); 
		userdel.id = userDAO.create(userdel);
		userDAO.delete(userdel);
        
		/* should throw an exception */
        userDAO.read(userdel.id); 
	}

}
