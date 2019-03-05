package dao;

import java.util.ArrayList;

import logic.Person;
import logic.Phone;

public interface PersonInterface 
{
	ArrayList<Person> read();
	void update(Person p);
	void delete(int id);
	void create(Person p);
	void createPhone(Phone p);
	void deletePhone(int phone_id);
}
