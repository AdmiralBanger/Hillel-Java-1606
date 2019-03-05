package dao;

import java.util.ArrayList;
import logic.Person;

public interface PersonIO 
{
	ArrayList<Person> read();
	void write(ArrayList<Person> pp);
}
