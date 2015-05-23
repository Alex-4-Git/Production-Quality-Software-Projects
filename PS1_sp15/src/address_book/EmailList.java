package address_book;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailList.
 */
public class EmailList implements Serializable{
	
	/** The list. */
	private ArrayList<Email> list = new ArrayList<>();
	
	/**
	 * Adds an email into list
	 *
	 * @param e the e
	 */
	public void add(Email e){
		if(e.get_email()!="") {
			list.add(e);
		}
	}
	
	/**
	 * Delete an email from list
	 *
	 * @param e: the email
	 */
	public void delete(Email e){
		if(list.contains(e)) {
			list.remove(e);
		}
	}
	
	/**
	 * Delete email by index. Index starts from 1. If index is out of boundary, nothing will happen.
	 *
	 * @param index: the index
	 */
	public void delete(int index){
		if(index>0&&index-1<list.size()){
			list.remove(index-1);
		}
	}
	
	/**
	 * Match_email.
	 *
	 * @param s: the email
	 * @return true, if successful
	 */
	public boolean match_email(String s){
		for(Email e: list){
			if(e.email_match(s)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Edits email by index
	 *
	 * @param index: the index
	 * @param t: the type
	 * @param s: the email address
	 */
	public void edit(int index, Type t, String s){
		if(index>0&&index-1<list.size()){
			Email email = list.get(index-1);
			edit(email, t, s);
		}
	}
	
	/**
	 * Edits email
	 *
	 * @param e: the email
	 * @param t: the type
	 * @param s: the email address
	 */
	private void edit(Email e, Type t, String s){
		if(list.contains(e)){
			e.set_type(t);
			e.set_email(s);
		}
	}
	
	/**
	 * Gets the _length.
	 *
	 * @return the _length
	 */
	public int get_length(){
		return list.size();
	}
	
	/**
	 * Email_match.
	 *
	 * @param e: the email
	 * @return true, if successful
	 */
	public boolean email_match(String e){
		for(Email i: list){
			if(i.email_match(e)) {
				return true;
			}
		}
		return false;
	}

}
