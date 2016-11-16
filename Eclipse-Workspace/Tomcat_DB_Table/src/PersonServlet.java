import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO_MySQL;
import logic.Person;
import logic.convectors;

@SuppressWarnings("serial")
public class PersonServlet extends HttpServlet
{
	private PersonDAO_MySQL pd = new PersonDAO_MySQL();
	
	public static void registerDrivers()
    {
    	try 
    	{
    		Class.forName("com.mysql.jdbc.Driver");
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		}
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doGet( req, resp );
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setHeader("Content-Type", "text/text");
		resp.setContentType("text/text;charset=utf-8");
		char op = req.getParameter("oper").charAt(0);
		char type = req.getParameter("type").charAt(0);
		String res = "";
		
		switch (op)
		{
			case 'c': create(req); break;
			case 'r': res = read(req, type); break;
			case 'u': update(req); break;
			case 'd': delete(req); break;
		}
		
		PrintWriter pw = resp.getWriter();
		pw.println(res);
	}
	
	private void create(HttpServletRequest req)
	{
		int 	id 			= Integer.parseInt(req.getParameter("id"));
		String 	first_name 	= req.getParameter("first_name");
		String 	last_name 	= req.getParameter("last_name");
		int 	age 		= Integer.parseInt(req.getParameter("age"));
		int 	street_id 	= Integer.parseInt(req.getParameter("street_id"));
		
		Person p = new Person(id, first_name, last_name, age, street_id);

		pd.create(p);
	}

	private String read(HttpServletRequest req, char type)
	{
		String res = "";
		switch (type)
		{
			case 'H': res = convectors.returnHTML(pd.read()); break;
			case 'X': res = convectors.returnXML(pd.read());  break;
			case 'J': res = convectors.returnJson(pd.read()); break;
		}
		return res;
	}
	
	private void update(HttpServletRequest req)
	{
		int 	id 			= Integer.parseInt(req.getParameter("id"));
		String 	first_name 	= req.getParameter("first_name");
		String 	last_name 	= req.getParameter("last_name");
		int 	age 		= Integer.parseInt(req.getParameter("age"));
		int 	street_id 	= Integer.parseInt(req.getParameter("street_id"));

		Person p = new Person(id, first_name, last_name, age, street_id);
		pd.update(p);
	}

	private void delete(HttpServletRequest req)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		id = Integer.parseInt(req.getParameter("ID"));
		pd.delete(id);
	}
}
