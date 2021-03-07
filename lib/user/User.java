package lib.user;

import lib.furniture.*;
import lib.*;

public class User {

	protected int id;
	protected String name;
	protected String surname;
	protected String mail;
	protected String password;
	protected Company company;

	public User(int id, String name, String surname, String mail, String password, Company company)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.company = company;
	}

	public User(String name, String surname, String mail, String password, Company company)
	{
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.company = company;
	}

	// getters
	public int getId(){return this.id;}
	public String getName(){return this.name;}
	public String getSurname(){return this.surname;}
	public String getMail(){return this.mail;}
	public String getPassword(){return this.password;}

	// setters
	public void setId(int id){this.id=id;}
	public void setName(String name){this.name=name;}
	public void setSurname(String surname){this.surname=surname;}
	public void setMail(String mail){this.mail=mail;}
	public void setPassword(String password){this.password=password;}

	@Override
	public String toString()
	{
		return String.valueOf(this.id) + "," + this.name + "," + this.surname + "," + this.mail + "," + this.password;
	}

}
