package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;
import edu.nyu.cs.pqs.ps1.*;

import org.junit.Before;
import org.junit.Test;

import sun.org.mozilla.javascript.internal.ast.NewExpression;

public class EntryPhoneNumberTest {
	EntryPhoneNumber number;

	@Before
	public void setUp() throws Exception {
		number = new EntryPhoneNumber("11220","1","345678943");
	}

	@Test
	public void test_constructor_String() {
		new EntryPhoneNumber("11220","1","345678943");
	}
	
	// this test failed because constructor did not handle NullPointerException
	@Test(expected=NullPointerException.class)
	public void test_constructor_null(){
		new EntryPhoneNumber(null, null, null);
	}
	
	
	@Test
	public void test_setAreaCode(){
		number.setAreaCode("33441");
		assertEquals("33441", number.getAreaCode());
	}
	
	@Test
	public void test_setPrefix(){
		number.setPrefix("33441");
		assertEquals("33441", number.getPrefix());
	}
	
	@Test
	public void test_setNumber(){
		number.setNumber("33441");
		assertEquals("33441", number.getNumber());
	}
	
	
	@Test
	public void test_equals(){
		EntryPhoneNumber number1=new EntryPhoneNumber("11220","1","345678943");
		EntryPhoneNumber number2=new EntryPhoneNumber("15566","1","345678943");
		EntryPhoneNumber number3=new EntryPhoneNumber("11220","1","345611111");
		EntryPhoneNumber number4=new EntryPhoneNumber("11220","2","345611111");
		String number5 = "234677777";
		assertTrue(number.equals(number1));
		assertFalse(number1.equals(number2));
		assertFalse(number1.equals(number3));
		assertFalse(number1.equals(number4));
		assertFalse(number1.equals(number5));
	}
	
	@Test
	public void test_hashCode(){
		 int hash = 17;
		 hash = 31 * hash + number.getAreaCode().hashCode();
		 hash = 31 * hash + number.getPrefix().hashCode();
		 hash = 31 * hash + number.getNumber().hashCode();
		 assertEquals(hash, number.hashCode());
	}
	
	@Test
	public void test_toString(){
		String string = number.getAreaCode() + "-" + number.getPrefix() + "-" + number.getNumber();
		assertEquals(string, number.toString());
	}

}
