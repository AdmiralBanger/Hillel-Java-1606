package model;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FigureIO_Json implements FigureIO 
{
	File name = null;
	public FigureIO_Json(File name) 
	{
		this.name = name;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void save(ArrayList<Figure> pp) 
	{
		try (FileWriter fw = new FileWriter(name))
		{
			JSONArray list = new JSONArray();
			for (Figure p : pp)
			{
				JSONObject obj = new JSONObject();
				obj.put("color", 	p.color.getRGB());
				obj.put("type", 	p.type);
				obj.put("width", 	p.width);
				obj.put("x1", 		p.x1);
				obj.put("y1", 		p.y1);
				obj.put("x2", 		p.x2);
				obj.put("y2", 		p.y2);
				list.add(obj);
			}
			fw.write(list.toJSONString());
			fw.flush();
			fw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Figure> load()
	{
		ArrayList<Figure> pp = new ArrayList<Figure>();
		JSONParser parser = new JSONParser();
		try
		{		
			Object object = parser.parse(new FileReader(name));

			JSONArray arr = (JSONArray) object;
			for (int i = 0; i < arr.size(); i++)
			{
				JSONObject obj = (JSONObject) arr.get(i);
				Point p1 = new Point(
						(int)(long) obj.get("x1"),
						(int)(long) obj.get("y1"));
				Point p2 = new Point(
						(int)(long) obj.get("x2"),
						(int)(long) obj.get("y2"));
				pp.add(new Figure(
						new Color((int)(long) obj.get("color")),
						(int)(long) obj.get("type"),
						(int)(long) obj.get("width"),
						p1,
						p2));
			}
		}
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

}
