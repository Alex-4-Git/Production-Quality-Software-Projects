package address_book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import sun.font.CreatedFontTracker;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressBook. This is the only class which can be used by users. 
 * Users can create empty address book, add entry, delete entry, edit entry, 
 * search contacts by name, email, phone number, note or address.
 * Users also can save address book into a file or read address book from a file.
 */
public class AddressBook implements Serializable{
	
	/** The contacts. */
	private ArrayList<Entry> contacts;
	
	/**
	 * Instantiates a new address book.
	 */
	public AddressBook(){
		contacts = new ArrayList<Entry>();
	}
	
	/**
	 * Creates the entry with all fields
	 *
	 * @param name: the name
	 * @param phoneNumber: the phone number
	 * @param note: the note
	 * @param email_type: the email_type
	 * @param email the: email
	 * @param address_type: the address_type
	 * @param zip_cod: the zip_cod
	 * @param street: the street
	 * @param city: the city
	 */
	public void createEntry(String name, String phoneNumber, String note, Type email_type, 
			String email,Type address_type, String zip_cod, String street, String city){
		Entry entry = new Entry.Builder(name).phoneNumber(phoneNumber).note(note).email
				(email_type,email).address(address_type, zip_cod, street, city).build();
		contacts.add(entry);
	}
	
	/**
	 * Quick create: create an entry with only name and phone number
	 *
	 * @param name: the name
	 * @param num: the phone number
	 */
	public void quickCreate(String name, String num){
		Entry entry = new Entry.Builder(name).phoneNumber(num).build();
		contacts.add(entry);
	}
	
	
	/**
	 * Removes the entry.
	 *
	 * @param index: the index. If index fall out of boundary, nothing will happen
	 */
	public void removeEntry(int index){
		index--;
		if(index>=0&&index<contacts.size()) {
			contacts.remove(index);
		}
	}
	
	/**
	 * Removes the entry.
	 *
	 * @param en: the entry
	 */
	public void removeEntry(Entry en){
		contacts.remove(en);
	}
	
	/**
	 * Search_by_name.
	 *
	 * @param n: the name
	 * @return the array list
	 */
	public ArrayList<Entry> search_by_name(String n){
		ArrayList<Entry> result = new ArrayList<Entry>();
		for(Entry en: contacts){
			if(en.match_name(n)) {
				result.add(en);
			}
		}
		return result;
	}
	
	/**
	 * Search_by_phonenumber.
	 *
	 * @param n: the phone number 
	 * @return the array list
	 */
	public ArrayList<Entry> search_by_phonenumber(String n){
		ArrayList<Entry> result = new ArrayList<Entry>();
		for(Entry en: contacts){
			if(en.match_phoneNum(n)) {
				result.add(en);
			}
		}
		return result;
	}
	
	/**
	 * Search_by_note.
	 *
	 * @param n: the note
	 * @return the array list
	 */
	public ArrayList<Entry> search_by_note(String n){
		ArrayList<Entry> result = new ArrayList<Entry>();
		for(Entry en: contacts){
			if(en.match_note(n)) {
				result.add(en);
			}
		}
		return result;
	}
	
	/**
	 * Search_by_email.
	 *
	 * @param n: the email
	 * @return the array list
	 */
	public ArrayList<Entry> search_by_email(String n){
		ArrayList<Entry> result = new ArrayList<Entry>();
		for(Entry en: contacts){
			if(en.match_email(n)) {
				result.add(en);
			}
		}
		return result;
	}
	
	/**
	 * Search_by_address.
	 *
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 * @return the array list
	 */
	public ArrayList<Entry> search_by_address(String z, String s, String c){
		ArrayList<Entry> result = new ArrayList<Entry>();
		for(Entry en: contacts){
			if(en.match_address(z, s, c)) {
				result.add(en);
			}
		}
		return result;
	}
	
	/**
	 * Gets all of the contacts.
	 *
	 * @return the an array list
	 */
	public ArrayList<Entry> get_Contacts(){
		return contacts;
	}
	
	/**
	 * Set_name.
	 *
	 * @param en: the entry
	 * @param name: the name
	 */
	public void set_name(Entry en, String name){
		en.set_name(name);
	}
	
	/**
	 * Set_phone number.
	 *
	 * @param en: the entry
	 * @param num: the phone number
	 */
	public void set_phoneNum(Entry en, String num){
		en.set_phoneNumber(num);
	}
	
	/**
	 * Set_note.
	 *
	 * @param en: the entry
	 * @param note: the note
	 */
	public void set_note(Entry en, String note){
		en.set_note(note);
	}
	
	/**
	 * Edit_email. index start from 1. If index fall out of boundary, nothing will happen.
	 *
	 * @param en: the entry
	 * @param index: the index
	 * @param t: the t
	 * @param s: the s
	 */
	public void edit_email(Entry en, int index, Type t, String s){
		en.edit_email(index, t, s);
	}
	
	/**
	 * Add_email.
	 *
	 * @param en the entry
	 * @param t: the type
	 * @param s: the email
	 */
	public void add_email(Entry en, Type t, String s){
		en.add_email(t, s);
	}
	
	/**
	 * Delete_email. index start from 1. If index fall out of boundary, nothing will happen
	 *
	 * @param en: the entry
	 * @param index: the index
	 */
	public void delete_email(Entry en, int index){
		en.delete_email(index);
	}
	
	/**
	 * Edit_address. index start from 1. If index fall out of boundary, nothing will happen
	 *
	 * @param en: the entry
	 * @param index: the index
	 * @param t: the type
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 */
	public void edit_address(Entry en, int index, Type t, String z, String s, String c){
		en.edit_address(index, t, z, s, c);
	}
	
	/**
	 * Add_address.
	 *
	 * @param en: the entry
	 * @param t: the type
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 */
	public void add_address(Entry en, Type t, String z, String s, String c){
		en.add_address(t, z, s, c);
	}
	
	/**
	 * Delete_address. index start from 1. If index fall out of boundary, nothing will happen
	 *
	 * @param en: the entry
	 * @param index: the index
	 */
	public void delete_address(Entry en, int index){
		en.delete_address(index);
	}
	

	
	/**
	 * Save address book to a file 
	 *
	 * @param file_name: the file_name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void save_to_file(String file_name) throws IOException{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file_name));
		objectOutputStream.writeObject(this);
		objectOutputStream.flush();
		objectOutputStream.close();
	}
	
	/**
	 * Read address book from a file
	 *
	 * @param file_name: the file_name
	 * @return the address book
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	public AddressBook read_from_file(String file_name) throws IOException, ClassNotFoundException{
		ObjectInputStream objectInputStream = new ObjectInputStream(
		        new FileInputStream(file_name));
		 
		return (AddressBook) objectInputStream.readObject();
	}
	
	public static void main(String[] args){
		AddressBook a=new AddressBook();
		a.quickCreate("dd", null);
	}

}
