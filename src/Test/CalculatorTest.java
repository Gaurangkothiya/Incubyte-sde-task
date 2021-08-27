package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;
import main.Calculator;
import main.NegativeNumException;

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
public void testEmptyString() throws Exception {
	assertEquals(0,cal.Add(""));
}

@Test
public void singleValueString() throws Exception{
	assertEquals(1,cal.Add("1"));
}

@Test
public void twoNumberString() throws Exception{
	assertEquals(14,cal.Add("5,9"));
}

@Test
public void multipleNumberString() throws Exception {
	assertEquals(10,cal.Add("1,2,3,4"));
}

@Test
public void newLinesString() throws Exception {
	assertEquals(10,cal.Add("1,\n,3,\n4,\n\n,2,\n"));
}

@Test
public void diffDelimiters() throws Exception{
    assertEquals(17,cal.Add("//;\n1;2;3;5;6"));
}

@Test
public void diffDelimiters2() throws Exception{
    assertEquals(12,cal.Add("//'\n1'2'3'6"));
}

@Test 
public void checkNegativeNumber() throws Exception {
	try {
		cal.Add("5,-10,15,-20,30");
	}
	catch (NegativeNumException ng) {
	assertEquals("Negatives not allowed:- -10,-20",ng.getMessage());
	}
}

@Test
public void checkNegativeNumber2() throws Exception {
	try {
		cal.Add("\n,-110,-15,200,-3");
	}
	catch (NegativeNumException ng) {
	assertEquals("Negatives not allowed:- -110,-15,-3",ng.getMessage());
	}
}

@Test
public void numBiggerThan1000Ignored() throws Exception {
	assertEquals(12,cal.Add("1001,2,3,6"));
}


}
