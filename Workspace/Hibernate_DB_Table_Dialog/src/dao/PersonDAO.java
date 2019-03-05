package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import logic.*;

public class PersonDAO implements PersonInterface
{
	Configuration cfg;
	SessionFactory factory;
	
	public PersonDAO() 
	{
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}

	@Override
	public void create(Person p) 
	{
		Session session = factory.openSession();  
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}

	@Override
	public ArrayList<Person> read() 
	{
		Session session = factory.openSession();
		List<Person> persons = new ArrayList<Person>();
		session.beginTransaction();
		persons = session.createQuery("from Person").getResultList();
		session.flush();
		session.close();
		return (ArrayList<Person>) persons;
	}

	@Override
	public void update(Person p)
	{
		Session session = factory.openSession();  
		session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
		session.flush();
		session.close();
	}

	@Override
	public void delete(int id) 
	{
		Session session = factory.openSession();  
		session.beginTransaction();
        Person p = (Person) session.load(Person.class, id);
        session.delete(p);
        session.getTransaction().commit();
		session.flush();
		session.close();
	}
}
