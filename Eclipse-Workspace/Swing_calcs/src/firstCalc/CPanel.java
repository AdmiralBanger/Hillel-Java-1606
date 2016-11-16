package firstCalc;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CPanel extends JPanel
{
	public CPanel()
	{
		setLayout(null);
		
		JTextField textX = new JTextField();
		textX.setBounds(10, 10, 100, 20);
		add(textX);
		
		JTextField textOP = new JTextField();
		textOP.setBounds(10, 40, 100, 20);
		add(textOP);
		
		JTextField textY = new JTextField();
		textY.setBounds(10, 70, 100, 20);
		add(textY);
		
		JTextField ans = new JTextField();
		ans.setBounds(10, 130, 100, 20);
		add(ans);
		
		JButton btn = new JButton("Calculate");
		btn.setBounds(10, 100, 100, 20);
		add(btn);
		btn.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String str1 = textX.getText();
				int num1 = Integer.parseInt(str1);
				String str2 = textY.getText();
				int num2 = Integer.parseInt(str2);
				char OP = textOP.getText().charAt(0);
				String res = "" + CalcAPI.FCalc(num1, num2, OP);
				ans.setText(res);
			}
		});				
	}
}