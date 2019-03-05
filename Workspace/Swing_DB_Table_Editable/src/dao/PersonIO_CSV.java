package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

import logic.Person;

public class PersonIO_CSV implements PersonIO
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
			FileReader fileReader = new FileReader(fc.getSelectedFile().getAbsolutePath());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List<String> lines = new ArrayList<String>();
			String line = null;

			while ((line = bufferedReader.readLine()) != null) 
			{
				lines.add(line);
			}

			bufferedReader.close();

			lines.remove(0);
			for (String str : lines)
			{
				String[] temp = str.split(",");
				pp.add(new Person(
						Integer.parseInt(temp[0]),
						temp[1],
						temp[2],
						Integer.parseInt(temp[3]),
						Integer.parseInt(temp[4])));
			}
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
				File file = new File(fc.getSelectedFile().getPath() + ".csv");
				Writer writer = new FileWriter(file);

				writer.append("id,first_name,last_name,age,street_id").append('\n');
				for (Person p : pp) 
				{
					writer.append(p.id + "," + p.first_name + "," + p.last_name + "," 
							+ p.age + "," + p.street_id).append('\n');
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
