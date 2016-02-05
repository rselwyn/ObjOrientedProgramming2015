
public class Author {
	/**
	 * Instance variables 
	 */
	private String name;
	private String email;
	private char gender;
	
	/**
	 * Constructor 
	 * @param name: the author name
	 * @param email: the author's email
	 * @param gender: the author's gender 
	 */
	public Author(String name, String email, char gender){
		setName(name);
		setEmail(email);
		setGender(gender);
	}
	
	/**
	 * Returns the author's name
	 * @return name: the author name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Returns the author's email
	 * @return the email
	 */
	public String getEmail(){
		return this.email;
	}
	
	/**
	 * @return the author's gender
	 */
	public char getGender(){
		return this.gender;
	}
	
	/**
	 * Set the name
	 * @param name: the name to set 
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @param email: the email to set
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	 * Set the gender
	 * @param gender: the gender of the author
	 */
	public void setGender(char gender){
		this.gender = gender;
	}
	
	public String toString(){
		return getName() + " (" + getGender() + ") " + "at " + getEmail();
	}
	
}
