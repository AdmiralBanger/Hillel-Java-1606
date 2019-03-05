package logic;

public class Person 
{
	public int id;
	public String first_name;
	public String last_name;
	public int age;
	public int street_id;
	
	public Person() {};
	
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

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFirst_name() 
	{
		return first_name;
	}

	public void setFirst_name(String first_name) 
	{
		this.first_name = first_name;
	}

	public String getLast_name() 
	{
		return last_name;
	}

	public void setLast_name(String last_name) 
	{
		this.last_name = last_name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public int getStreet_id() 
	{
		return street_id;
	}

	public void setStreet_id(int street_id) 
	{
		this.street_id = street_id;
	}
}
