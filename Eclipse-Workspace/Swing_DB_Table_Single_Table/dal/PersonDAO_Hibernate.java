package dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import logic.Person;

public class PersonDAO_Hibernate implements PersonDAO
{	

	@Override
	public void create(Person p) 
	{
		Session session = createSession();
		Transaction t=session.beginTransaction();  
		session.persist(p);//persisting the object  
		t.commit();//transaction is committed  
		session.close();
		System.out.println("successfully saved");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Person> read() 
	{
		Session session = createSession();
		ArrayList<Person> pp = new ArrayList<Person>();

		List<Person> products  = (List<Person>) session.createQuery("from Person").list();
		for ( Person p : (List<Person>) products ) 
		{
			pp.add(p);
		}

		return pp;
	}

	@Override
	public void update(Person p) 
	{
		Session session = createSession();
		Transaction t=session.beginTransaction();  
		session.update(p);//persisting the object  
		t.commit();//transaction is committed 
		session.close();
		System.out.println("successfully saved");
	}

	@Override
	public void delete(Person p) 
	{
		Session session = createSession();
		Transaction t=session.beginTransaction();  
		session.delete(p);//persisting the object  
		t.commit();//transaction is committed 
		session.close();
		System.out.println("successfully saved");
	}

	public Session createSession ()
	{
		Session session;
		Configuration cfg = new Configuration();  
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		session=factory.openSession();  
		return session;
	}
}
