package lib.user;

public class User {

	protected int id;
	protected String name;
	protected String surname;
	protected String mail;
	protected String password;

	public User(int id, String name, String surname, String mail, String password)
	{
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
	}

	// getters
	public int getId(){return this.id;}
	public String getName(){return this.name;}
	public String getSurname(){return this.surname;}
	public String getMail(){return this.mail;}
	public String getPassword(){return this.password;}

	@Override
	public String toString()
	{
		return String.valueOf(this.id) + "," + this.name + "," + this.surname + "," + this.mail + "," + this.password;
	}

}
