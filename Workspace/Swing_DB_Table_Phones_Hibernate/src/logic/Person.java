package logic;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	public int id;
	
	@Column(name="first_name")
	public String first_name;
	
	@Column(name="last_name")
	public String last_name;
	
	@Column(name="age")
	public int age;
	
	@Column(name="street_id")
	public int street_id;

	public ArrayList<Phone> phones = new ArrayList<Phone>();
	
	public Person()
	{
		
	}
	
	public Person(int id, String first_name, String last_name, int age, int street_id) 
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.street_id = street_id;
	}
	
	public void addPhone(Phone p)
	{
		phones.add(p);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStreet_id() {
		return street_id;
	}

	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}

	public ArrayList<Phone> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<Phone> phones) {
		this.phones = phones;
	}
}
