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
public void singleValueString() {
	assertEquals(1,cal.Add("1"));
}

@Test
public void twoNumberString() {
	assertEquals(14,cal.Add("5,9"));
}

@Test
public void multipleNumberString() {
	assertEquals(10,cal.Add("1,2,3,4"));
}

@Test
public void newLinesString() {
	assertEquals(10,cal.Add("1,\n,3,\n4,\n\n,2,\n"));
}

@Test
public void diffDelimiters() {
    assertEquals(17,cal.Add("//;\n1;2;3;5;6"));
}

@Test
public void diffDelimiters2() {
    assertEquals(12,cal.Add("//'\n1'2'3'6"));
}

}
