package model;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class FigureIO_CSV implements FigureIO 
{
	File name = null;
	public FigureIO_CSV(File name) 
	{
		this.name = name;
	}
	@Override
	public void save(ArrayList<Figure> pp) 
	{
		try (CSVWriter writer = new CSVWriter(new FileWriter(name), '\t'))
		{
			String[] str = {"type", "color", "width", "x1", "x2", "y1", "y2"};
			writer.writeNext(str);
			for (Figure p : pp)
			{
				String[] line = {Integer.toString(p.type), String.valueOf(p.color.getRGB()), Integer.toString(p.width), Integer.toString(p.x1),
						Integer.toString(p.x2), Integer.toString(p.y1), Integer.toString(p.y2)};
				writer.writeNext(line);
			}
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
		try(CSVReader reader = new CSVReader(new FileReader(name), '\t'))
		{			
			String [] nextLine = reader.readNext();
			while ((nextLine = reader.readNext()) != null) 
			{
				Point p1 = new Point(Integer.parseInt(nextLine[3]), Integer.parseInt(nextLine[5]));
				Point p2 = new Point(Integer.parseInt(nextLine[4]), Integer.parseInt(nextLine[6]));
				pp.add(new Figure(
						new Color(Integer.parseInt(nextLine[1])),
						Integer.parseInt(nextLine[0]),
						Integer.parseInt(nextLine[2]),
						p1,
						p2));
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

}
