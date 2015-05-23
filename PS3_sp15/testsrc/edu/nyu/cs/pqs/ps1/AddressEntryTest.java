package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.NotEquals;

import edu.nyu.cs.pqs.ps1.*;


public class AddressEntryTest {
	private AddressEntry entry;

	@Before
	public void setUp() throws Exception {
		EntryName name= new EntryName("Alex","Simth");
		EntryPhoneNumber number = new EntryPhoneNumber("1", "347", "8913377");
		Email e = new Email("breakaway@nyu.edu");
		Address add = new Address("60", "Brooklyn", "NY", "11223", "US");
		EntryNote note = new EntryNote("He is cool");
		entry = new AddressEntry(name, number, e, add, note);
	}
	

	@Test(expected=NullPointerException.class)
	public void test_constructor_Null() {
		new AddressEntry(null, null, null, null, null);
	}
	
	@Test
	public void test_setEntryName(){
		EntryName name1= new EntryName("Ben","Simth");
		entry.setEntryName(name1);
		assertEquals(name1, entry.getEntryName());
	}
	
	@Test
	public void testSetPhoneNumber(){
		EntryPhoneNumber number1 = new EntryPhoneNumber("12", "344", "344577");
		entry.setEntryPhoneNumber(number1);
		assertEquals(number1, entry.getEntryPhoneNumber());
	}
	
	@Test
	public void testSetEmail(){
		Email em = new Email("pair@nyu.edu");
		entry.setEmail(em);
		assertEquals(em, entry.getEmail());
	}
	
	@Test
	public void testSetAddress(){
		Address add1 = new Address("70", "Brooklyn", "NY", "11223", "US");
		entry.setAddress(add1);
		assertEquals(add1, entry.getAddress());
	}
	
	@Test
	public void testSetNote(){
		EntryNote note1 = new EntryNote("He is very cool");
		entry.setEntryNote(note1);
		assertEquals(note1,entry.getNote());
	}
	
	@Test
	public void test_equals(){
		EntryName name= new EntryName("Alex","Simth");
		EntryPhoneNumber number = new EntryPhoneNumber("1", "347", "8913377");
		Email e = new Email("breakaway@nyu.edu");
		Address add = new Address("60", "Brooklyn", "NY", "11223", "US");
		EntryNote note = new EntryNote("He is cool");
		AddressEntry entry1 = new AddressEntry(name, number, e, add, note);
		
		EntryName name1= new EntryName("Ben");
		AddressEntry entry2 = new AddressEntry(name1, number, e, add, note);
		
		EntryPhoneNumber number1 = new EntryPhoneNumber("2", "347", "8913377");
		AddressEntry entry3 = new AddressEntry(name, number1, e, add, note);
		
		Email e1 = new Email("break@nyu.edu");
		AddressEntry entry4 = new AddressEntry(name, number, e1, add, note);
		
		Address add1 = new Address("600", "Brooklyn", "NY", "11223", "US");
		AddressEntry entry5 = new AddressEntry(name, number, e, add1, note);
		
		EntryNote note1 = new EntryNote("He is not cool");
		AddressEntry entry6 = new AddressEntry(name, number, e, add, note1);
		
		String entry7 = "Alex";
		
		assertTrue(entry.equals(entry1));
		assertFalse(entry.equals(entry2));
		assertFalse(entry.equals(entry3));
		assertFalse(entry.equals(entry4));
		assertFalse(entry.equals(entry5));
		assertFalse(entry.equals(entry6));
		assertFalse(entry.equals(entry7));
	}
	
	 
	@Test
	public void test_hashCode(){
	    int hash = 17;
	    hash = 31 * hash + entry.getEntryName().hashCode();
	    hash = 31 * hash + entry.getEntryPhoneNumber().hashCode();
	    hash = 31 * hash + entry.getEmail().hashCode();
	    hash = 31 * hash + entry.getAddress().hashCode();
	    hash = 31 * hash + entry.getNote().hashCode();
	    assertEquals(hash, entry.hashCode());
	    
	}
	
	@Test
	public void test_toString(){
		String s = "Name: " + entry.getEntryName().toString() + "\n" +
		        "Phone Number: " + entry.getEntryPhoneNumber().toString() + "\n" +
		        "Email: " + entry.getEmail().toString() + "\n" +
		        "Address: " + entry.getAddress().toString() + "\n" +
		        "Note:" + entry.getNote().toString() + "\n" ;
		
		assertEquals(s, entry.toString());
	}
	
}
