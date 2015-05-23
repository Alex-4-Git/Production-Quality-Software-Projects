package edu.nyu.cs.pqs.ps1;

import edu.nyu.cs.pqs.ps1.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
	private Address add;

	@Before
	public void setUp() throws Exception {
		add=new Address("60", "Brooklyn", "NY", "11223", "US");
	}

	// this test failed because constructor did not handle NullPointerException
	@Test(expected=NullPointerException.class)
	public void test_constructor_null(){
		new Address(null, null, null,null,null);
	}
		
	@Test
	public void test_constructor_String(){
		new Address("60", "Brooklyn", "NY", "11223", "US");
	}
	
	@Test
	public void test_setStreet(){
		add.setStreet("90");
		assertEquals("90", add.getStreet());
	}
	
	@Test
	public void test_setCity(){
		add.setString("90");
		assertEquals("90", add.getCity());
	}
	
	@Test
	public void test_setState(){
		add.setState("90");
		assertEquals("90", add.getState());
	}
	
	@Test
	public void test_setZip(){
		add.setZip("90");
		assertEquals("90", add.getZip());
	}
	
	@Test
	public void test_setCountry(){
		add.setCountry("90");
		assertEquals("90", add.getCountry());
	}
	
	@Test
	public void test_equals(){
		Address add1 = new Address("60", "Brooklyn", "NY", "11223", "US");
		Address add2 = new Address("61", "Brooklyn", "NY", "11223", "US");
		Address add3 = new Address("60", "Brooklyn", "NY", "11223", "UA");
		Address add4 = new Address("60", "Brooklyn", "NY", "11343", "US");
		Address add5 = new Address("60", "Brookl2n", "NY", "11223", "US");
		Address add6 = new Address("60", "Brooklyn", "NN", "11223", "US");
		String add7 = "Brooklyn";
		assertTrue(add.equals(add1));
		assertFalse(add.equals(add2));
		assertFalse(add.equals(add3));
		assertFalse(add.equals(add4));
		assertFalse(add.equals(add5));
		assertFalse(add.equals(add6));
		assertFalse(add.equals(add7));
	}
	
	@Test
	public void test_hashCode(){
	    int hash = 17;
	    hash = 31 * hash + add.getStreet().hashCode();
	    hash = 31 * hash + add.getCity().hashCode();
	    hash = 31 * hash + add.getState().hashCode();
	    hash = 31 * hash + add.getZip().hashCode();
	    hash = 31 * hash + add.getCountry().hashCode();
	    assertEquals(hash, add.hashCode());
	}
	
	@Test
	public void test_toString(){
		String s= add.getStreet() + "\n" +
				add.getCity() + ", " + add.getState() + " " + add.getZip() + "\n" +
				add.getCountry();
		assertEquals(s, add.toString());
	}
	

}
