package at.fhj.itm14.MavenTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculatorTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(CalculatorTest.class );
    }


    public void testAdd(){
    	Calculator calc = new Calculator();
        assertEquals(42, calc.add(40, 2));
    }
    
    public void testSub(){
    	Calculator calc = new Calculator();
    	assertEquals(42, calc.sub(44, 2));
    }
	
	
}
