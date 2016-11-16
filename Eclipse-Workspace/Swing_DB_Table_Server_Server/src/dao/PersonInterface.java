package dao;

import java.util.ArrayList;

import logic.Person;

public interface PersonInterface 
{
	ArrayList<Person> read();
	void update(Person p, int col);
	void delete(int id);
	void create();
}
