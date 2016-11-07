package at.fhj.itm.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import at.fhj.itm.dao.UserDAO;

public class TestUser {
	
	private static User u1;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		u1 = new User(1,"Username", "Password");
		userDAO = new UserDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		userDAO.delete(u1);
	}

	@Test
	public void TestAddUser() {
		u1.id = userDAO.create(u1);
		assertEquals(userDAO.read(u1.id).toString(), u1.toString());
	}
	
	@Test(expected=SQLException.class)
	public void TestAddSameUserTwice() {
		u1.id = userDAO.create(u1);
		//Add the same user a second time. Should throw an error
		u1.id = userDAO.create(u1);
		
	}
}
