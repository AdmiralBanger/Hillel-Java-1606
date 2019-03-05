package dao;

import java.util.ArrayList;

import logic.Person;
import logic.Phone;

public interface PersonInterface 
{
	void create(Person p);
	void update(Person p);
	void delete(Person p);
	ArrayList<Person> read();
	void createPhone(Phone p);
	void deletePhone(int phone_id);
}
