package address_book;

import java.io.Serializable;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class AddressList.
 */
public class AddressList implements Serializable{
	
	/** The list. */
	private ArrayList<Address> list = new ArrayList<Address>();
	
	/**
	 * Match_address.
	 *
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 * @return true, if successful
	 */
	public boolean match_address(String z, String s, String c){
		for(Address a: list){
			if(a.address_match(z, s, c)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Adds the address into list
	 *
	 * @param a: the address
	 */
	public void add(Address a){
		if(a.isValid()) {
			list.add(a);
		}
	}
	
	/**
	 * Delete.
	 *
	 * @param a: the address
	 */
	public void delete(Address a){
		if(list.contains(a)) {
			list.remove(a);
		}
	}
	
	/**
	 * Delete by index. Index starts from 1. If index is out of boundary, nothing will happen.
	 *
	 * @param index the index
	 */
	public void delete(int index){
		if(index>0&&index-1<list.size()){
			list.remove(index-1);
		}
	}
	
	/**
	 * Edits the address by index. Index starts from 1. 
	 * If index is out of boundary, nothing will happen.
	 *
	 * @param index: the index
	 * @param t: the type
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 */
	public void edit(int index, Type t, String z, String s, String c){
		if(index>0&&index-1<list.size()){
			Address a = list.get(index-1);
			edit(a, t, z, s, c);
		}
	}
	
	/**
	 * Edits the address
	 *
	 * @param a: the address
	 * @param t: the type
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 */
	private void edit(Address a, Type t, String z, String s, String c){
		if(list.contains(a)){
			a.set_type(t);
			a.set_zip_code(z);
			a.set_street(s);
			a.set_city(c);
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
	
}
