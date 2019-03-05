package logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import dao.PersonDAO;

public class Server 
{
	private ServerSocket server;
	private int port = 6969;

	public Server()
	{
		try 
		{
			server = new ServerSocket(port);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String argv[]) throws Exception
	{
		Server serv_main = new Server();
		System.out.println("Server started");
		serv_main.handleConnection();
	}

	public void handleConnection() 
	{
		while (true) 
		{
			try 
			{
				System.out.println("Waiting for client to connect");
				Socket socket = server.accept();
				System.out.println("Client connected");
				new ConnectionHandler(socket);
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

class ConnectionHandler implements Runnable 
{
    private Socket socket;

    public ConnectionHandler(Socket socket)
    {
        this.socket = socket;

        Thread t = new Thread(this);
        t.start();
    }

    public void run() 
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    		System.out.println("Waiting for object");
            Request req = (Request) ois.readObject();
            
            PersonDAO pd = new PersonDAO();
            ArrayList<Person> pp = new ArrayList<Person>();
            
            switch (req.cmd)
			{
			case('c'): pd.create(); break;
			case('r'): pp = pd.read(); break;
			case('u'): pd.update(req.p, req.col); break;
			case('d'): pd.delete(req.col); break;
			} 
            	
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    		System.out.println("Sending object");
            oos.writeObject(pp);

            ois.close();
            oos.close();
            socket.close();
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
}