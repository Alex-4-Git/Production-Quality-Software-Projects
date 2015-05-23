package edu.nyu.cs.pqs.ps1;

import junit.framework.AssertionFailedError;
import edu.nyu.cs.pqs.ps1.EntryName;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntryNameTest {
	private EntryName  name;

	@Before
	public void setUp() throws Exception {
		name = new EntryName("Michael","Jordan");
	}

	@Test
	public void test_constructor_String() {
		new EntryName("Michael");
		new EntryName("Michael","Jordan");
	}
	//	test failed because constructor did not handle  NullPointerException
	@Test(expected=NullPointerException.class)
	public void test_constructor_null(){
		new EntryName(null);
	}
	
	@Test
	public void test_getFirstName(){
		assertEquals("Michael", name.getFirstName());
	}
	
	@Test
	public void test_getLastName(){
		assertEquals("Jordan", name.getLastName());
	}
	
	
	@Test
	public void test_setFirstName(){
		name.setFirstName("Lee");
		assertEquals("Lee", name.getFirstName());
	}
	
	@Test
	public void test_setLastName(){
		name.setLastName("James");
		assertEquals("James", name.getLastName());
	}
	
	//	test failed because constructor did not handle  NullPointerException
	@Test(expected=NullPointerException.class)
	public void test_equals_null(){
		EntryName name1 = new EntryName(null,null);
		assertFalse(name.equals(name1));
		EntryName name2 = new EntryName(null,"Jordan");
		assertTrue(name.equals(name2));
		EntryName name3 = new EntryName("Michael",null);
		assertTrue(name.equals(name3));
		EntryName name4 = new EntryName(null,"Jordann");
		assertFalse(name.equals(name4));
		EntryName name5 = new EntryName("Michaell",null);
		assertFalse(name.equals(name5));
	}
	
	@Test
	public void test_equals_NotNull(){
		EntryName name1 = new EntryName("Michael","Jordan");
		String name2 = "alex";
		EntryName name3 = new EntryName("Michaell","Jordan");
		EntryName name4 = new EntryName("Michael","Jordann");
		assertTrue(name.equals(name1));
		assertFalse(name.equals(name2));
		assertFalse(name.equals(name3));
		assertFalse(name.equals(name4));
	}
	
	@Test
	public void test_hashCode(){
		int hash = 17;
		hash = 31 * hash + name.getFirstName().hashCode(); 
		hash = 31 * hash + name.getLastName().hashCode();
		assertEquals(hash, name.hashCode());
	}
	
	@Test
	public void test_toString(){
		assertEquals(name.getFirstName() + " " + name.getLastName(), name.toString());
	}
	

}
