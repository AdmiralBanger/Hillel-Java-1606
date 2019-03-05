package savers;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import logic.Person;

public class saveCSV 
{
	public static void save(ArrayList<Person> pp)
	{
		try 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = new File(fc.getSelectedFile().getPath() + ".csv");
				FileWriter writer = new FileWriter(file);
				
				writer.append("id,first_name,last_name,age,street_id\n");
				for (Person p : pp) 
				{
					writer.append(p.id + "," + p.first_name + "," + p.last_name + "," 
									+ p.age + "," + p.street_id + "\n");	
				}
				writer.flush();
			    writer.close();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
