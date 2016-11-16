package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import model.FigureIO;
import model.PData;
import view.PPaintPanel;

@SuppressWarnings("rawtypes")
public class PCommand 
{
	public PData pd = new PData();
	public PPaintPanel ppanel = null;
	
	public OpenFileAction aOpen = new OpenFileAction();
	public SaveFileAction aSave = new SaveFileAction();
	public ColorAction aColor = new ColorAction();
	public WidthAction aWidth = new WidthAction();
	public WidthMenuAction aWidthMenu = new WidthMenuAction();
	public TypeAction aType = new TypeAction();
	
	class TypeAction implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pd.type = Integer.parseInt(e.getActionCommand());
		}
	}
	
	class ColorAction implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			pd.col = JColorChooser.showDialog(null, "JColorChooser Sample", pd.col);
		}
	}
	
	class WidthAction implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JComboBox cbox = (JComboBox) e.getSource();
			pd.width = cbox.getSelectedIndex() + 1;
		}
	}
	
	class WidthMenuAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pd.width = Integer.parseInt(e.getActionCommand());
		}
		
	}
	
	class SaveFileAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				JComboBox cbox = (JComboBox) e.getSource();
				String str = cbox.getSelectedItem().toString();
				FigureIO.getInstance(file, str).save(ppanel.pp);
			}
		}
	}
	class OpenFileAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String userDir = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(userDir + "/Desktop");
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				JComboBox cbox = (JComboBox) e.getSource();
				String str = cbox.getSelectedItem().toString();
				ppanel.pp = FigureIO.getInstance(file, str).load();
				ppanel.repaint();
			}
		}
	}
}
