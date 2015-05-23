package address_book;

import java.io.Serializable;



// TODO: Auto-generated Javadoc
/**
 * The Class Email.
 */
public class Email implements Serializable{
	
	/** The type. */
	private Type type;
	
	/** The email. */
	private String email="";
	
	/**
	 * Instantiates a new email.
	 *
	 * @param t: the type
	 * @param e: the email
	 */
	public Email(Type t, String e){
		if(t!=null) type =t;
		else type = Type.Home;
		if(e.matches(".*\\S.*")){
			email = e.trim();
		}
			
	}
	
	/**
	 * Instantiates a new email with default type: Home
	 *
	 * @param e: the email
	 */
	public Email(String e){
		if(e.matches(".*\\S.*")){
			email = e.trim();
		}
			
		type=Type.Home;
	}
	
	
	/**
	 * Email_match.
	 *
	 * @param e: the email
	 * @return true, if match is successful
	 */
	public boolean email_match(String e){
		return email.matches(".*"+e+".*");
	}
	
	/**
	 * Gets the _type.
	 *
	 * @return the _type
	 */
	public Type get_type(){
		return type;
	}
	
	/**
	 * Gets the _email.
	 *
	 * @return the _email
	 */
	public String get_email(){
		return email;
	}
	
	/**
	 * Sets the _type.
	 *
	 * @param t: the new _type
	 */
	public void set_type(Type t){
		if(type!=null){
			type = t;
		}
			
	}
	
	/**
	 * Sets the _email.
	 *
	 * @param e: the new _email
	 */
	public void set_email(String e){
		if(e.matches(".*\\S.*")){
			email = e.trim();
		}
			
	}
	
}
