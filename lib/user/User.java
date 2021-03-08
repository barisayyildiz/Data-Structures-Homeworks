package lib.user;

import lib.furniture.*;
import lib.*;

/**
 * User class
 */
public class User {

	protected int id;
	protected String name;
	protected String surname;
	protected String mail;
	protected String password;
	protected Company company;
	
	/**
	 * User constructor
	 * @param name name
	 * @param surname surname
	 * @param mail mail
	 * @param password password
	 */
	public User(String name, String surname, String mail, String password)
	{
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;

	}

	/**
	 * User constructor
	 * @param name name
	 * @param surname surname
	 * @param mail mail
	 * @param password password
	 * @param company company
	 */
	public User(String name, String surname, String mail, String password, Company company)
	{
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.company = company;
	}

	/**
	 * User constructor
	 * @param mail mail
	 * @param password password
	 * @param company company
	 */
	public User(String mail, String password, Company company)
	{
		this.mail = mail;
		this.password = password;
		this.company = company;
	}

	// getters
	/**
	 * Returns id
	 * @return id
	 */
	public int getId(){return this.id;}
	/**
	 * Return name
	 * @return name
	 */
	public String getName(){return this.name;}
	/**
	 * Returns surname
	 * @return surname
	 */
	public String getSurname(){return this.surname;}
	/**
	 * Returns mail
	 * @return mail
	 */
	public String getMail(){return this.mail;}
	/**
	 * Returns password
	 * @return password
	 */
	public String getPassword(){return this.password;}

	// setters
	/**
	 * Sets id
	 * @param id
	 */
	public void setId(int id){this.id=id;}
	/**
	 * Sets name
	 * @param name
	 */
	public void setName(String name){this.name=name;}
	/**
	 * Sets surname
	 * @param surname
	 */
	public void setSurname(String surname){this.surname=surname;}
	/**
	 * Sets mail
	 * @param mail
	 */
	public void setMail(String mail){this.mail=mail;}
	/**
	 * Sets password
	 * @param password
	 */
	public void setPassword(String password){this.password=password;}
	/**
	 * Sets company
	 * @param company
	 */
	public void setCompany(Company company){this.company = company;}

	@Override
	public String toString()
	{
		String str = "\n";
		str += "Id : \t" + this.id + "\n";
		str += "Name : \t" + this.name + "\n";
		str += "Surname : \t" + this.surname + "\n";
		str += "Mail : \t" + this.mail + "\n";
		str += "Password : \t" + this.password + "\n";
		
		return str;
	}

}
