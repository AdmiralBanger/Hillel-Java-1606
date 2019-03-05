import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

	@SuppressWarnings("unused")
	private Person decodeJSON(HttpServletRequest req)
	{
		Person p = null;
		JSONParser parser = new JSONParser();
		try 
		{
			Object obj = parser.parse(req.getParameter("obj"));
			JSONObject jsonObject = (JSONObject) obj;

			int 	id 			= (int) jsonObject.get("id");
			String 	first_name 	= (String) jsonObject.get("first_name");
			String 	last_name 	= (String) jsonObject.get("last_name");
			int 	age 		= (int) jsonObject.get("age");
			int 	street_id 	= (int) jsonObject.get("street_id");

			p = new Person(id, first_name, last_name, age, street_id);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

		return p;
	}

	private Person decodeXML(HttpServletRequest req)
	{
		Person p = null;
		
		try 
		{
			JAXBContext jc = JAXBContext.newInstance(Person.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource streamSource = new StreamSource(new StringReader(req.getParameter("obj")));
			JAXBElement<Person> je = unmarshaller.unmarshal(streamSource, Person.class);
			p = (Person)je.getValue();
		}
		catch (JAXBException e) 
		{
			e.printStackTrace();
		}

		return p;
	}

	private void create(HttpServletRequest req)
	{
		pd.create(decodeXML(req));
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
		pd.update(decodeXML(req));
	}

	private void delete(HttpServletRequest req)
	{
		pd.delete(decodeXML(req).id);
	}
}
