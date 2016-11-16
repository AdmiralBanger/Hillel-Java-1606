package savers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import logic.Person;

public class saveJson 
{
	@SuppressWarnings("unchecked")
	public static void save(ArrayList<Person> pp)
	{
		try 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = new File(fc.getSelectedFile().getPath() + ".json");
				FileWriter writer = new FileWriter(file);
				JSONArray res = new JSONArray();
				
				for (Person p : pp) 
				{
					JSONObject temp = new JSONObject();
					temp.put("id", p.id);
					temp.put("first_name", p.first_name);
					temp.put("last_name", p.last_name);
					temp.put("age", p.age);
					temp.put("street_id", p.street_id);
					res.add(temp);
				}
				
				writer.write(res.toJSONString());
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
