package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FigureIO_XML implements FigureIO 
{
	File name = null;
	public FigureIO_XML(File name) 
	{
		this.name = name;
	}
	@Override
	public void save(ArrayList<Figure> pp) 
	{
		try (XMLEncoder xe = new XMLEncoder( new FileOutputStream(name)))
		{
			xe.writeObject(pp);
			xe.flush();
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
		ArrayList<Figure> pp = null;
		try(XMLDecoder de = new XMLDecoder(new FileInputStream(name))) 
		{			
			pp = (ArrayList<Figure>) de.readObject();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

}
