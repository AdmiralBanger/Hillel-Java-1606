package logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import logic.Person;

public class Client 
{

	@SuppressWarnings("unchecked")
	public ArrayList<Person> sentRequest( char cmd, Person p, int col)
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		try
		{
			Socket socket = new Socket("localhost", 6969);

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(new Request(p, col, cmd));

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			pp = (ArrayList<Person>) ois.readObject();
			ois.close();
			oos.close();
			socket.close();
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

	public void create ()
	{
		sentRequest('c', null, 0);
	}

	public ArrayList<Person> read ()
	{
		ArrayList<Person> pp = sentRequest('r', null, 0);
		return pp;
	}

	public void update (Person p, int col)
	{
		sentRequest('u', p, col);	
	}

	public void delete (int id)
	{
		sentRequest('d', null, id);
	}
}