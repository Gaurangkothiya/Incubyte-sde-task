package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import main.Calculator;

public class CalculatorTest {
	
	Calculator cal;

@Before
public void setUp() {
    cal = new Calculator();
}	
	
	
@Test
 public  void testCreate()
 {
 }

@Test
public void testEmptyString() {
	assertEquals(0,cal.Add(""));
}

@Test
public void simpleValueString() {
	assertEquals(1,cal.Add("1"));
}

}
