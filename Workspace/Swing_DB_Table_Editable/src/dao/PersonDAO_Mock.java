package dao;

import java.util.ArrayList;

import logic.Person;

public class PersonDAO_Mock implements PersonInterface
{

ArrayList<Person> pp = null;
	
	public PersonDAO_Mock() 
	{
		pp = new ArrayList<Person>();
		
		pp.add(new Person(666, "Alya", "Gupkin", 40, 0));
		pp.add(new Person(112, "Valya", "Pushkin", 12, 0));
		pp.add(new Person(14, "Ilya", "Lutkin", 67, 0));
		pp.add(new Person(1, "Anya", "Murkin", 16, 0));
		pp.add(new Person(123, "Katya", "Durkin", 1, 0));
	}

	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}

	@Override
	public void update(Person p, int col) 
	{
		
	}

	@Override
	public void delete(int id) 
	{
		
	}

	@Override
	public void insert() 
	{
		
	}
}
