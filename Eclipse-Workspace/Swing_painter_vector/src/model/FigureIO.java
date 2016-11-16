package model;

import java.io.File;
import java.util.ArrayList;

public interface FigureIO 
{
	void save(ArrayList<Figure> pp);
	ArrayList<Figure> load();
	
	public static FigureIO getInstance(File file, String getActionCommand)
	{
		FigureIO ret = null;
		switch (getActionCommand) 
		{
			case "xml":  ret = new FigureIO_XML(file); break;
			case "csv":  ret = new FigureIO_CSV(file); break;
			case "json": ret = new FigureIO_Json(file); break;
			case "yaml": ret = new FigureIO_Yaml(file); break;
		}
		
		return ret;
	}
}
