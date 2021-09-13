package one.microstream.domain;

import java.util.ArrayList;
import java.util.List;


public class Author
{
	private String			id;
	private String			firstname;
	private String			lastname;
	private String			email;
	private String			gender;
	private List<Address>	addresses	= new ArrayList<Address>();
	
	public Author()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Author(String id, String firstname, String lastname, String email, String gender)
	{
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
	}
	
	public List<Address> getAddresses()
	{
		return addresses;
	}
	
	public void setAddresses(List<Address> addresses)
	{
		this.addresses = addresses;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
}
