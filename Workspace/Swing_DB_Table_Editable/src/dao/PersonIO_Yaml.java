package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import logic.Person;

public class PersonIO_Yaml implements PersonIO
{
	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		List<String> list = new ArrayList<String>();
		Scanner in;
		try 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			fc.showOpenDialog(null);
			File file = new File(fc.getSelectedFile().getAbsolutePath());
			in = new Scanner(file);
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

			for (int i = 1; i < list.size(); i++)
			{
				String[] sublist = list.get(i).split(": ");
				
				if (sublist.length>1)
				{
					switch (count)
					{
					case 0:	id = Integer.parseInt(sublist[1]); 			count++; break;
					case 1:	first_name = (String)(sublist[1]); 			count++; break;
					case 2:	last_name = (String)(sublist[1]); 			count++; break;
					case 3: age = Integer.parseInt(sublist[1]); 		count++; break;
					case 4: street_id = Integer.parseInt(sublist[1]); 	count=0; pp.add(new Person(id, first_name, last_name, age, street_id)); i = i+2; break; 
					}
				}
			}
		} 
		catch (FileNotFoundException e) 
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
				File file = new File(fc.getSelectedFile().getPath() + ".yaml");

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
		return "\t" + str + ": " + obj.toString() + "\n";
	}
	private String elem(Person p)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("- Person " + p.id + ": \n");

		sb.append(param("id", p.id));
		sb.append(param("first_name", p.first_name));
		sb.append(param("last_name", p.last_name));
		sb.append(param("age", p.age));
		sb.append(param("street_id", p.street_id));

		return sb.toString();
	}
	private String root(ArrayList<Person> pp, String rootName)
	{
		StringBuilder sb = new StringBuilder();

		for (Person p : pp) 
		{
			sb.append(elem(p));
		}

		return sb.toString();
	}
}
