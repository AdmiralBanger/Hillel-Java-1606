package gui;


import javax.swing.*;

@SuppressWarnings("serial")
public class TFrame extends JFrame
{
	public TFrame()
	{
		setTitle("Database Table");
		setBounds(600, 300, 550, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new TPanel());
		
		setVisible(true);	
	}

}
