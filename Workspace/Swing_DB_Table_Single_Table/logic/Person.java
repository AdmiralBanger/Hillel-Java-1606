package logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Person")
public class Person implements Serializable
{
	@Id
	@Column(name = "ID")
	public int id;

	@Column(name = "Fname")
	public String fname;

	@Column(name = "Lname")
	public String lname;

	@Column(name = "Age")
	public int age;

	@Column(name = "Contacts")
	public String contacts;

	public Person()
	{
		//
	}

	public Person(int id, String fname, String lname, int age)
	{
		this.id    = id;
		this.fname = fname;
		this.lname = lname;
		this.age   = age;
	}
	
	public Person(int id, String fname, String lname, int age, String contacts)
	{
		init(id, fname, lname, age, contacts);
	}

	public void init(int id, String fname, String lname, int age, String contacts)
	{
		this.id    = id;
		this.fname = fname;
		this.lname = lname;
		this.age   = age;
		this.contacts = contacts;
	}

	public String toString()
	{
		String str = "Person [ id=" + id + "; lname=" + lname + "; fname="+ fname + "; age=" + age + "]";
		return str;
	}
}