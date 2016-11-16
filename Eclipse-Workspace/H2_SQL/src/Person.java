
public class Person 
{
	int id;
	String first_name;
	String last_name;
	int age;
	int street_id;
	
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

	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", street_id=" + street_id + "]";
	}
	
	
}
