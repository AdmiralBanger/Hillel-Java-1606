package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import logic.Person;

public class PersonIO_Json implements PersonIO
{
	@Override
	public ArrayList<Person> read() 
	{
		StringBuilder txtjson = new StringBuilder();
		try 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			fc.showOpenDialog(null);
			File file = new File(fc.getSelectedFile().getAbsolutePath());
			Scanner inputScanner = new Scanner(file);
			while(inputScanner.hasNext())
			{
				txtjson.append(inputScanner.next());
			}
			inputScanner.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		String str = txtjson.toString();
		String[] list = str.split(",");
		ArrayList<Person> pp = new ArrayList<Person>();
		
		int count = 0;
		int id = 0;
		String first_name = "";
		String last_name = "";
		int age = 0;
		int street_id = 0;
		
		for (int i = 0; i < list.length; i++)
		{
			
			String[] sublist = list[i].split(":");
			
			switch (count)
			{
			case 0:	id = Integer.parseInt(sublist[1]); count++; break;
			case 1:	first_name = (String)(sublist[1]); count++; break;
			case 2:	last_name = (String)(sublist[1]); count++; break;
			case 3: age = Integer.parseInt(sublist[1]); count++; break;
			case 4:
			{
				String[] subsublist = sublist[1].split("}");
				street_id = Integer.parseInt(subsublist[0]); 
				count=0;
				pp.add(new Person(id, first_name, last_name, age, street_id)); 
				break;
			}
			}					
		}
		return pp;
	}

	@Override
	public void write(ArrayList<Person> pp) 
	{
		try 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = new File(fc.getSelectedFile().getPath() + ".json");
				
				StringBuilder sb = new StringBuilder();
				sb.append(root(pp, "Table"));
				
				Writer writer = new FileWriter(file);
				writer.write(sb.toString());
				writer.flush();
				writer.close();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
		
	private String param(String str, Object obj)
	{
		return "\t\t\"" + str + "\":\"" + obj.toString() + "\",\n";
	}
	private String elem(Person p)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t{\n");

		sb.append(param("id", p.id));
		sb.append(param("first_name", p.first_name));
		sb.append(param("last_name", p.last_name));
		sb.append(param("age", p.age));
		sb.append(param("street_id", p.street_id));
		
		sb.setLength(sb.length() - 2);
		sb.append("\n\t},\n");
		
		return sb.toString();
	}
	private String root(ArrayList<Person> pp, String rootName)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[\n");
		
		for (Person p : pp) 
		{
			sb.append(elem(p));
		}
		
		sb.setLength(sb.length() - 2);
		sb.append("\n]");
		
		return sb.toString();
	}
}
