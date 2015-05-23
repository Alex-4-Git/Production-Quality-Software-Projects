package edu.nyu.cs.pqs.ps1;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import edu.nyu.cs.pqs.ps1.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private AddressBook book;
	private AddressEntry entry;
	private AddressEntry entry1;

	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
		EntryName name= new EntryName("Alex","Simth");
		EntryPhoneNumber number = new EntryPhoneNumber("1", "347", "8913377");
		Email e = new Email("breakaway@nyu.edu");
		Address add = new Address("60", "Brooklyn", "NY", "11223", "US");
		EntryNote note = new EntryNote("He is cool");
		entry = new AddressEntry(name, number, e, add, note);
		
		EntryName name1= new EntryName("Ben","Simth");
		EntryPhoneNumber number1 = new EntryPhoneNumber("2", "347", "8913377");
		Email e1 = new Email("break@nyu.edu");
		Address add1 = new Address("70", "Brooklyn", "NY", "11223", "US");
		EntryNote note1 = new EntryNote("He is not cool");
		entry1 = new AddressEntry(name1, number1, e1, add1, note1);
	}

	@Test
	public void testConstructor() {
		new AddressBook();
	}
	
	@Test
	public void testAddEntryAndRemove(){
	
		assertTrue(book.addNewEntry(entry));
		assertTrue(book.removeOldEntry(entry));
		
	}
	
	@Test
	public void testSearchByIllegalObject(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		Address add = new Address("60", "Brooklyn", "NY", "11223", "US");
		List<AddressEntry> result = book.search(add);
		List<AddressEntry> target = new LinkedList<AddressEntry>();
		target.add(entry);
		assertEquals(result, target);
	}
	
	@Test
	public void testSearchByEntry(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		
		EntryName name= new EntryName("Alex","Simth");
		EntryPhoneNumber number = new EntryPhoneNumber("1", "347", "8913377");
		Email e = new Email("breakaway@nyu.edu");
		Address add = new Address("60", "Brooklyn", "NY", "11223", "US");
		EntryNote note = new EntryNote("He is cool");
		AddressEntry entry2 = new AddressEntry(name, number, e, add, note);
		
		List<AddressEntry> result = book.search(entry2);
		List<AddressEntry> target = new LinkedList<AddressEntry>();
		target.add(entry2);
		assertEquals(result, target);
	}
	
	
	@Test
	public void testSearchByAddress(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		EntryName name= new EntryName("Alex","Simth");
		List<AddressEntry> result = book.search(name);
		List<AddressEntry> target = new LinkedList<AddressEntry>();
		target.add(entry);
		assertEquals(result, target);
	}
	
	@Test
	public void testSearchByName(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		EntryName name= new EntryName("Alex","Simth");
		List<AddressEntry> result = book.search(name);
		List<AddressEntry> target = new LinkedList<AddressEntry>();
		target.add(entry);
		assertEquals(result, target);
		
	}
	
	@Test
	public void testSearchByPhoneNumber(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		EntryPhoneNumber number = new EntryPhoneNumber("1", "347", "8913377");
		List<AddressEntry> result = book.search(number);
		List<AddressEntry> target = new LinkedList<AddressEntry>();
		target.add(entry);
		assertEquals(result, target);	
	}
	
	@Test
	public void testSearchByEmail(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		Email e = new Email("breakaway@nyu.edu");
		List<AddressEntry> result = book.search(e);
		List<AddressEntry> target = new LinkedList<AddressEntry>();
		target.add(entry);
		assertEquals(result, target);	
	}
	
	@Test
	public void testSearchByNote(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		EntryNote note = new EntryNote("He is cool");
		List<AddressEntry> result = book.search(note);
		List<AddressEntry> target = new LinkedList<AddressEntry>();
		target.add(entry);
		assertEquals(result, target);	
	}
	
	@Test
	public void testToString(){
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		String s=" ";
		s+=entry.toString();
		s+=entry1.toString();
		assertEquals(s, book.toString());
	}
	
	
	// test failed because there is a bug in method readAddressBookFromFile in
	// AddressBook. Even if this bug did not exist we still can not make sure if
	// we read the right information from file.
	// In AddressBook the List<AddressEntry> book is private and there is no getter,
	// so we can not see what is inside. And there is no equals exist so we can not 
	// compare if 2 addressBook contains same contents.
	@Test
	public void testSaveToFileAndReadFromFile() throws IOException{
		book.addNewEntry(entry);
		book.addNewEntry(entry1);
		File file = book.saveAddressBookToFile();
		AddressBook book1 = new AddressBook();
		book1 = book1.readAddressBookFromFile(file);
		
		
	}
	
	
	

}
