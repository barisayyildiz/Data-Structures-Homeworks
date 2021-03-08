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
	
	public User(String name, String surname, String mail, String password)
	{
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;

	}

	public User(String name, String surname, String mail, String password, Company company)
	{
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.company = company;
	}

	public User(String mail, String password, Company company)
	{
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
