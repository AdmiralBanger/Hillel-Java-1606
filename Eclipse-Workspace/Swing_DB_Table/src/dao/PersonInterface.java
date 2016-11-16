package dao;

import java.util.ArrayList;

import logic.Person;

public interface PersonInterface 
{
	void create(Person p);
	void update(Person p);
	void delete(Person p);
	ArrayList<Person> read();
}
