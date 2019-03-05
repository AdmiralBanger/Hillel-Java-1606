package dal;

import java.util.ArrayList;

import logic.Person;

public class PersonDAO_Mock implements PersonDAO
{

	public ArrayList<Person> pp = null;

	public PersonDAO_Mock() 
	{
		pp = new ArrayList<Person>();

		Person p = new Person(666, "Alya", "Gupkin", 40);

		/*p.addContact(new Contact("066 997 73 15", "home", p));
		p.addContact(new Contact("060 997 73 15", "office", p));*/
		pp.add(p);

	}

	@Override
	public void create(Person p) 
	{
		pp.add(p);
	}

	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		for (int i = 0; i< pp.size(); i++)
		{
			Person tmp = pp.get(i);
			if (tmp.id == p.id)
			{	
				tmp.init(p.id, p.fname, p.lname, p.age);
			}
		}
	}

	@Override
	public void delete(Person p) 
	{
		for (int i = 0; i< pp.size(); i++)
		{
			Person tmp = pp.get(i);
			if (tmp.id == p.id)
			{	
				pp.remove(i);
			}
		}
	}
}
