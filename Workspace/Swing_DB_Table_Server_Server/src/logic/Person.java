package logic;

import java.io.Serializable;

public class Person implements Serializable
{
	private static final long serialVersionUID = 6969696969L;
	public int id;
	public String first_name;
	public String last_name;
	public int age;
	public int street_id;
	
	public Person(int id, String first_name, String last_name, int age, int street_id) 
	{
		init(id, first_name, last_name, age, street_id);
	}
	
	public void init(int id, String first_name, String last_name, int age, int street_id) 
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.street_id = street_id;
	}		
}
