/*
 * 
 */
package address_book;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Address.
 */
public class Address implements Serializable{
	
	/** The type. */
	private Type type=Type.Home;
	
	/** The zip_code. */
	private String zip_code="";
	
	/** The street. */
	private String street="";
	
	/** The city. */
	private String city="";
	
	/**
	 * Instantiates a new address with all fields empty.
	 */
	public Address(){}
	
	/**
	 * Instantiates a new address.
	 *
	 * @param t: the type
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 */
	public Address(Type t, String z, String s, String c){
		if(t!=null) type=t;
		if(z.matches(".*\\S.*")){
			set_zip_code(z.trim());
		}
		if(s.matches(".*\\S.*")){
			set_street(s.trim());
		}
		if(c.matches(".*\\S.*")){
			set_city(c.trim());
		}
			
	}
	
	/**
	 * Checks if the address is valid.
	 *
	 * @return true, if at least one field is not empty.
	 */
	public boolean isValid(){
		return zip_code!=""||street!=""||city!="";
	}
	
	
	/**
	 * Address_match.
	 *
	 * @param z: the zip code
	 * @param s: the street
	 * @param c: the city
	 * @return true, if match is successful
	 */
	public boolean address_match(String z, String s, String c){
		if(z==""&&s==""&&c=="") {
			return false;
		}
		return zip_code_match(z)&&street_match(s)&&city_match(c);
	}
	
	/**
	 * Zip_code_match.
	 *
	 * @param e: the zip code
	 * @return true, if successful
	 */
	public boolean zip_code_match(String e){
		return zip_code.matches(".*"+e+".*");
	}
	
	/**
	 * Street_match.
	 *
	 * @param e: the street
	 * @return true, if successful
	 */
	public boolean street_match(String e){
		return street.matches(".*"+e+".*");
	}
	
	/**
	 * City_match.
	 *
	 * @param e: the city
	 * @return true, if successful
	 */
	public boolean city_match(String e){
		return city.matches(".*"+e+".*");
	}
	
	/**
	 * Sets the _zip_code.
	 *
	 * @param x: the new _zip_code
	 */
	public  void set_zip_code(String x){
		if(x.matches(".*\\S.*")){
			zip_code = x.trim();
		}
	}
	
	/**
	 * Sets the _street.
	 *
	 * @param x: the new _street
	 */
	public  void set_street(String x){
		if(x.matches(".*\\S.*")){
			street = x.trim();
		}
			
	}
	
	/**
	 * Sets the _city.
	 *
	 * @param s: the new _city
	 */
	public void set_city(String s){
		if(s.matches(".*\\S.*")){
			city = s.trim();
		}
			
	}
	
	/**
	 * Sets the _type.
	 *
	 * @param t: the new _type
	 */
	public void set_type(Type t){
		if(t!=null)
			type=t;
	}
	
	/**
	 * Gets the _zip_code.
	 *
	 * @return the _zip_code
	 */
	public String get_zip_code(){
		return zip_code;
	}
	
	/**
	 * Gets the _street.
	 *
	 * @return the _street
	 */
	public String get_street(){
		return street;
	}
	
	/**
	 * Gets the _city.
	 *
	 * @return the _city
	 */
	public String get_city(){
		return city;
	}
	
}
