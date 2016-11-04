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
		
		int id = userDAO.create(user);
         
        User Userout = userDAO.read(id);
        assertEquals(Userout.hashCode(), user.hashCode()); 
	}
	
	@Test
	public void testRead() {
		
		int id = userDAO.create(user);
         
        User Userout = userDAO.read(id);
        assertEquals(Userout.hashCode(), user.hashCode()); 
	}
	
	@Test
	public void testUpdate() {
		
		int id = userDAO.create(user);
		User User2 = user;
		User2.password = "alligator";
		userDAO.update(User2);
        User accountingout = userDAO.read(id);
        assertEquals(accountingout.hashCode(), User2.hashCode()); 
        assertNotEquals(accountingout, user);
	}
	
	@Test(expected=SQLException.class)
	public void testDelete() {
		
		userDAO.create(user);
		User Userdel = new User(1000, "XYZ", "Tschau"); 
		int id2 = userDAO.create(Userdel);
		userDAO.delete(Userdel);
        
		/* should throw an exception */
        userDAO.read(id2); 
	}


}
