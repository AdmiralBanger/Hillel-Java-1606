package gui;

import javax.swing.*;

@SuppressWarnings("serial")
public class TFrame extends JFrame
{
	public TFrame()
	{
		setTitle("Person");
		setBounds(100,100,700,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new TPanel());
		
		setVisible(true);
	}
	

}