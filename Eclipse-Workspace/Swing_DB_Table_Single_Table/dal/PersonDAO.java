package dal;

import java.util.ArrayList;

import logic.Person;

public interface PersonDAO 
{
	void create(Person p);
	ArrayList<Person> read();
	void update(Person p);
	void delete(Person p);
}
