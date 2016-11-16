
import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame
{
	public Frame()
	{
		setTitle("Ёлементы управлени€");
		setBounds(700, 300, 345, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new Panel());
		
		setVisible(true);
	}
	

}
