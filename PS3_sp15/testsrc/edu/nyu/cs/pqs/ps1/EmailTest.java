package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;
import edu.nyu.cs.pqs.ps1.Email;


import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	private Email email;
	
	@Before
	public void setUp(){
		email = new Email("breakaway@nyu.edu");
	}

	// test failed because it did not handle NullPointerException
	@Test(expected=NullPointerException.class)
	public void test_constructor_null_parameter() {
		new Email(null);
	}
	
	@Test
	public void test_constructor_String(){
		Email email = new Email("hello");
	}
	
	@Test
	public void test_getEmail(){
		assertEquals("breakaway@nyu.edu", email.getEmail());
	}
	
	@Test
	public void test_setEmail_String(){
		email.setEmail("pqs");
		assertEquals("pqs", email.getEmail());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_setEmail_null(){
		email.setEmail(null);
	}
	
	@Test
	public void test_equal(){
		Email e1=new Email("pqs");
		String e2 = "pqs";
		Email e3=new Email("breakaway@nyu.edu");
		assertFalse(email.equals(e1));
		assertFalse(email.equals(e2));
		assertTrue(email.equals(e3));
	}
	
	@Test
	public void test_hashCode(){
		int hash = 31 * 17 + email.getEmail().hashCode();
		assertEquals(hash, email.hashCode());
	}
	
	@Test
	public void test_toString(){
		assertEquals("breakaway@nyu.edu", email.toString()); 
	}
}
