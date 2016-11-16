package dao;

import java.util.ArrayList;

import logic.Person;
import logic.Phone;

public class PersonDAO_Mock implements PersonInterface
{

ArrayList<Person> pp = null;
	
	public PersonDAO_Mock() 
	{
		pp = new ArrayList<Person>();
		
		pp.add(new Person(666, "Alya", "Gupkin", 40, 0));
			pp.get(0).addPhone(new Phone(1, 666, "personal", "+380993974009"));
			pp.get(0).addPhone(new Phone(2, 666, "dead", "0969979566"));
			pp.get(0).addPhone(new Phone(3, 666, "home", "69-69-69"));
		pp.add(new Person(112, "Valya", "Pushkin", 12, 0));
		pp.add(new Person(14, "Ilya", "Lutkin", 67, 0));
			pp.get(2).addPhone(new Phone(4, 14, "personal", "1112223344"));
		pp.add(new Person(1, "Anya", "Murkin", 16, 0));
		pp.add(new Person(123, "Katya", "Durkin", 1, 0));
			pp.get(4).addPhone(new Phone(5, 123, "personal", "+380993974009"));
			pp.get(4).addPhone(new Phone(6, 123, "personal", "+380996969696"));
	}

	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}

	@Override
	public void create(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPhone(Phone p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePhone(int phone_id) {
		// TODO Auto-generated method stub
		
	}
}
