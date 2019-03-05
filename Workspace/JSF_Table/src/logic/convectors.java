package logic;
import java.util.ArrayList;

public class convectors 
{
	public static String returnHTML(ArrayList<Person> pd)
	{
		String ret = "";
		for (Person p : pd)
		{
			ret += "<tr><td>" + p.id + "</td><td>" + p.first_name + "</td><td>" + p.last_name
				+ "</td><td>" + p.age + "</td><td>" + p.street_id + "</td></tr>";
		}
		return ret;
	}
	public static String returnXML(ArrayList<Person> pd)
	{
		String ret = "";
		
		ret += "<?xml version='1.0' encoding='UTF-8'?>";
		ret += "<Persons>";
		for (Person p : pd)
		{
				ret += "<person>";
				ret += "<id>" + p.id + "</id>";
				ret += "<first_name>" + p.first_name + "</first_name>";
				ret += "<last_name>" + p.last_name + "</last_name>";
				ret += "<age>" + p.age + "</age>";
				ret += "<street_id>" + p.street_id + "</street_id>";
				ret += "</person>";
		}
		ret += "</Persons>";
		
		return ret;
	}
	public static String returnJson(ArrayList<Person> pd)
	{
		String ret = "";
		
		ret += "[";
		boolean first = true;
		for (Person p : pd)
		{
				if (!first)
				{
					ret += ",";
				}
				first = false;
				ret += "{\"id\": \""   + p.id + "\", ";
				ret += "\"first_name\": \"" + p.first_name + "\", ";
				ret += "\"last_name\": \"" + p.last_name + "\", ";
				ret += "\"age\":\"" +  p.age +  "\", ";	
				ret += "\"street_id\":\"" +  p.street_id +  "\"}";
		}
		ret += "]";
		
		return ret;
	}
}
