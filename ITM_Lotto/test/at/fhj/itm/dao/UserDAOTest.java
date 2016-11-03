package at.fhj.itm.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.fhj.itm.model.User;

public class UserDAOTest {
	
	UserDAO udao;

	@Before
	public void setUp() throws Exception {
		udao = new UserDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		User u = new User(-1, "heli", "test");
		u.id = udao.create(u);
		
		User toCompare = udao.read(u.id);
		
		assertEquals(u.id, toCompare.id);
		assertEquals(u.username, toCompare.username);
		assertEquals(u.password, toCompare.password);
	}

}
