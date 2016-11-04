package at.fhj.itm.msg;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFakeMsg {
	
	private static FakeMsg fakeMsg;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fakeMsg = new FakeMsg();
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
	public void testGetMsg() {
		String name = "Testname";
		assertEquals("Hello "+name, fakeMsg.getMsg(name));
	}

}
