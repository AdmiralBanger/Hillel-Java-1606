package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.ho.yaml.Yaml;

public class FigureIO_Yaml implements FigureIO 
{
	File name = null;
	public FigureIO_Yaml(File name) 
	{
		this.name = name;
	}
	@Override
	public void save(ArrayList<Figure> pp) 
	{
		try
		{
			Yaml.dump(pp, name);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Figure> load()
	{
		ArrayList<Figure> pp = new ArrayList<Figure>();
		try
		{		
			pp = (ArrayList<Figure>) Yaml.load(name);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

}
