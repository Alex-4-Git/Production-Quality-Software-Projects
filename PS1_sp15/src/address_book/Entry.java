package address_book;

import java.io.Serializable;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Entry. Each entry is one contact record.
 */
public class Entry implements Serializable{
	
	/** The name. */
	private String name;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The email_list. */
	private EmailList email_list;
	
	/** The note. */
	private String note;
	
	/** The address_list. */
	private AddressList address_list;
	
	/**
	 * The Class Builder.
	 */
	public static class Builder{
		
		/** The name. */
		private String name;
		
		/** The phone number. */
		private String phoneNumber="";
		
		/** The email_list. */
		private EmailList email_list = new EmailList();
		
		/** The note. */
		private String note="";
		
		/** The address_list. */
		private AddressList address_list = new AddressList();
		
		
		/**
		 * Instantiates a new builder.
		 *
		 * @param n: the name. Name is a required field. If name only consist of white spaces, 
		 * exception will be thrown
		 */
		public Builder (String n){
			if(n==null){
				throw new IllegalArgumentException();
			}
			if(n.matches(".*\\S.*")){
				name = n;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		
		/**
		 * initialize the phone number.
		 *
		 * @param n: the phone number
		 * @return the builder
		 */
		public Builder phoneNumber(String n){
			if(n==null){
				throw new IllegalArgumentException();
			}
			if(n.matches(".*\\S.*")){
				phoneNumber = n;
			}
				
			return this;
		}
		
		/**
		 * initialize Email with type
		 *
		 * @param t: the type
		 * @param n: the email
		 * @return the builder
		 */
		public Builder email(Type t, String n){
			if(n==null){
				throw new IllegalArgumentException();
			}
			Email email = new Email(t,n);
			email_list.add(email);
			return this;
		}
		
		/**
		 * initialize Email with default type: Home
		 *
		 * @param n: the email
		 * @return the builder
		 */
		public Builder email(String n){
			if(n==null){
				throw new IllegalArgumentException();
			}
			Email email = new Email(n);
			email_list.add(email);
			return this;
		}
		
		/**
		 * initialize Address.
		 *
		 * @param t: the type
		 * @param z: the zip code
		 * @param s: the street
		 * @param c: the city
		 * @return the builder
		 */
		public Builder address(Type t, String z, String s, String c){
			if(z==null||s==null||c==null){
				throw new IllegalArgumentException();
			}
			Address address = new Address(t,z,s,c);
			if (address.isValid()) {
				address_list.add(address);
			}
			return this;
		}
		
		/**
		 * Note.
		 *
		 * @param n: the note
		 * @return the builder
		 */
		public Builder note(String n){
			note = n;
			return this;
		}
		
		/**
		 * Instantiates a new entry
		 *
		 * @return the entry
		 */
		public Entry build(){
			return new Entry(this);
		}
		
	}
	
	/**
	 * Instantiates a new entry
	 *
	 * @param b: builder
	 */
	private Entry(Builder b){
		name = b.name;
		phoneNumber=b.phoneNumber;
		email_list=b.email_list;
		note=b.note;
		address_list=b.address_list;
	}
	
	
	/**
	 * Sets the _name.
	 *
	 * @param n: the new _name
	 */
	public void set_name(String n){
		if(n.matches(".*\\S.*")){
			name = n.trim();
		}
	}
	
	/**
	 * Sets the _phone number.
	 *
	 * @param n: the new _phone number
	 */
	public void set_phoneNumber(String n){
		if(n.matches(".*\\S.*")){
			phoneNumber = n.trim();
		}
			
	}
	
	/**
	 * Sets the _note.
	 *
	 * @param n: the new _note
	 */
	public void set_note(String n){
		if(n.matches(".*\\S.*"))
			note = n.trim();
	}
	
	/**
	 * Edit_email. Index start from 1. If index fall out of boundary, nothing will happen.
	 *
	 * @param index: the index
	 * @param t: the type
	 * @param s: the email
	 */
	public void edit_email(int index, Type t, String s){
		if(email_list.get_length()==0) {
			email_list.add(new Email(t,s));
		}
		else {
			email_list.edit(index, t, s);
		}
	}
	
	/**
	 * Add_email.
	 *
	 * @param t: the type
	 * @param s: the email
	 */
	public void add_email(Type t, String s){
		email_list.add(new Email(t,s));
	}
	
	/**
	 * Delete_email. Index start from 1. If index fall out of boundary, nothing will happen.
	 *
	 * @param index: the index
	 */
	public void delete_email(int index){
		email_list.delete(index);
	}
	
	/**
	 * Edit_address. Index start from 1. If index fall out of boundary, nothing will happen.
	 *
	 * @param index: the index
	 * @param t: the type
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 */
	public void edit_address(int index, Type t, String z, String s, String c){
		if(address_list.get_length()==0) address_list.add(new Address(t,z,s,c));
		else address_list.edit(index, t, z, s, c);
	}
	
	/**
	 * Add_address.
	 *
	 * @param t: the type
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 */
	public void add_address(Type t, String z, String s, String c){
		address_list.add(new Address(t,z,s,c));
	}
	
	/**
	 * Delete_address. Index start from 1. If index fall out of boundary, nothing will happen.
	 *
	 * @param index: the index
	 */
	public void delete_address(int index){
		address_list.delete(index);
	}

	
	/**
	 * Match_name.
	 *
	 * @param n: the name
	 * @return true, if match is successful
	 */
	public boolean match_name(String n){
		return name.matches(".*"+n+".*");
	}
	
	/**
	 * Match_phone num.
	 *
	 * @param n: the phone number
	 * @return true, if match is successful
	 */
	public boolean match_phoneNum(String n){
		return phoneNumber.matches(".*"+n+".*");
	}
	
	/**
	 * Match_note.
	 *
	 * @param n: the note
	 * @return true, if match is successful
	 */
	public boolean match_note(String n){
		return note.matches(".*"+n+".*");
	}
	
	/**
	 * Match_email.
	 *
	 * @param e: the email
	 * @return true, if match is successful
	 */
	public boolean match_email(String e){
		return email_list.email_match(e);
	}
	
	/**
	 * Match_address.
	 *
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 * @return true, if match is successful
	 */
	public boolean match_address(String z, String s, String c){
		return address_list.match_address(z, s, c);
	}	
	
}
