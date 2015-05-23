package edu.nyu.cs.pqs.ps1;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import edu.nyu.cs.pqs.ps1.EntryNote;

public class EntryNoteTest {
	private EntryNote en;
	
	@Before
	public void setUp(){
		en = new EntryNote("good");
	}
	
	@Test
	public void test_constructor_String(){
		EntryNote note=new EntryNote("something");
	}
	
	// the test failed because it did not handle NullPointerException
	@Test(expected=NullPointerException.class)
	public void test_constructor_null(){
		EntryNote note = new EntryNote(null);
	}
	
	@Test
	public void test_getText(){
		assertEquals("good", en.getText());
	}
	
	// the test failed because it did not handle NullPointerException
	@Test(expected=NullPointerException.class)
	public void test_setText_null(){
		en.setText(null);
	}
	
	@Test
	public void test_setText_String(){
		en.setText("bad");
		assertEquals("bad", en.getText());
	}
	
	@Test
	public void test_equals(){
		EntryNote en1= new EntryNote("good");
		EntryNote en2= new EntryNote("bad");
		String en3 = "good";
		assertTrue(en.equals(en1));
		assertFalse(en.equals(en2));
		assertFalse(en.equals(en3));
	}
	
	@Test
	public void test_hashCode(){
		int hash = 31 * 17 + en.getText().hashCode();
		assertEquals(hash, en.hashCode());
	}
	
	@Test
	public void test_toString(){
		assertEquals("good", en.toString());
	}
	
}
