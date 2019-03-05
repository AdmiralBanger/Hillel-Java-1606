package dao;

import java.util.ArrayList;

import logic.Person;

public interface PersonInterface 
{
	ArrayList<Person> read();
	void update(Person p);
	void delete(int id);
	void create(Person p);
}
