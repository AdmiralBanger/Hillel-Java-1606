package secondCalc;

import javax.swing.*;

@SuppressWarnings("serial")
public class CFrame extends JFrame
{
	public CFrame()
	{
		setTitle("Второй калькулятор");
		setBounds(100, 100, 520, 270);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new CPanel());
		
		setVisible(true);	
	}

}
