package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import logic.Person;

public class PersonIO_XML implements PersonIO
{
	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			fc.showOpenDialog(null);
			File file = new File(fc.getSelectedFile().getAbsolutePath());
			Scanner in = new Scanner(file);
			List<String> list = new ArrayList<String>();
			
			while (in.hasNextLine())
			{
				list.add(in.nextLine());
			}

			int count = 0;
			int id = 0;
			String first_name = "";
			String last_name = "";
			int age = 0;
			int street_id = 0;

			for (int i = 3; i < list.size()-2; i++)
			{
				String[] sublist = list.get(i).split("</");
				
				if (sublist.length>1)
				{
					String[] sublist2 = sublist[0].split(">");
					
					switch (count)
					{
					case 0:	id = Integer.parseInt(sublist2[1]); 		count++; break;
					case 1:	first_name = (String)(sublist2[1]); 		count++; break;
					case 2:	last_name = (String)(sublist2[1]); 			count++; break;
					case 3: age = Integer.parseInt(sublist2[1]); 		count++; break;
					case 4: street_id = Integer.parseInt(sublist2[1]); 	count=0; pp.add(new Person(id, first_name, last_name, age, street_id)); i = i+2; break; 
					}
				}
			}
			
			in.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
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
				File file = new File(fc.getSelectedFile().getPath() + ".xml");
				
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
	
	private String startTag(String tagName)
	{
		return "<" + tagName + ">";
	}
	private String endTag(String tagName)
	{
		return "</" + tagName + ">\n";
	}
	
	private String param(String str, Object obj)
	{
		return "\t\t" + startTag(str) + " " + obj.toString() + " " + endTag(str);
	}
	private String elem(Person p)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t" + startTag("Person") + "\n");

		sb.append(param("id", p.id));
		sb.append(param("first_name", p.first_name));
		sb.append(param("last_name", p.last_name));
		sb.append(param("age", p.age));
		sb.append(param("street_id", p.street_id));
		
		sb.append("\t" + endTag("Person"));
		
		return sb.toString();
	}
	private String root(ArrayList<Person> pp, String rootName)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
		sb.append(startTag(rootName) + "\n");
		
		for (Person p : pp) 
		{
			sb.append(elem(p));
		}
		
		sb.append(endTag(rootName));
		
		return sb.toString();
	}
}
