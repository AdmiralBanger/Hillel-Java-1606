package Dialogs;
import java.awt.event.*;
import java.awt.print.PrinterJob;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CPanel extends JPanel
{
	public CPanel()
	{
		setLayout(null);
		
		JFileChooser file = new JFileChooser();
		
		JButton btn = new JButton("FileOpen");
		btn.setBounds(10, 10, 100, 20);
		add(btn);
		btn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{          
				file.showDialog(null, "Открыть файл");
			}
		});		
		
		JButton btn1 = new JButton("FileClose");
		btn1.setBounds(10, 40, 100, 20);
		add(btn1);
		btn1.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				file.showSaveDialog(null);
			}
		});		
		
		JButton btn2 = new JButton("Color");
		btn2.setBounds(10, 70, 100, 20);
		add(btn2);
		btn2.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color initialBackground = btn2.getBackground();
				new JColorChooser();
				JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
			}
		});		
		
		JButton btn3 = new JButton("Input");
		btn3.setBounds(10, 100, 100, 20);
		add(btn3);
		btn3.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showInputDialog(null, "Some text");
			}
		});		
		
		JButton btn4 = new JButton("Printer");
		btn4.setBounds(10, 130, 100, 20);
		add(btn4);
		btn4.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.printDialog();
			}
		});		
	}
}