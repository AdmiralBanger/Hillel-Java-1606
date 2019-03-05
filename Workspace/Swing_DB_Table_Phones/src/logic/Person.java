package logic;

import java.util.ArrayList;

public class Person 
{
	public int id;
	public String first_name;
	public String last_name;
	public int age;
	public int street_id;
	public ArrayList<Phone> phones = new ArrayList<Phone>();
	
	public Person(int id, String first_name, String last_name, int age, int street_id) 
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.street_id = street_id;
	}
	
	public void addPhone(Phone p)
	{
		phones.add(p);
	}
}
