package Dialogs;

import javax.swing.*;

@SuppressWarnings("serial")
public class CFrame extends JFrame
{
	public CFrame()
	{
		setTitle("Диалоговые окна");
		setBounds(100,100,200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new CPanel());
		
		setVisible(true);
	}
	

}
