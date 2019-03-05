package secondCalc;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CPanel extends JPanel
{
	int firstNum = 0;
	char op;

	public CPanel()
	{
		setLayout(null);

		JTextField output = new JTextField();
		output.setBounds(10, 10 , 480, 40 );
		add(output);

		JButton btn1 = new JButton("1");
		btn1.setSize(120, 40);
		btn1.setLocation(10, 60);
		add(btn1);
		btn1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 1;
				output.setText(num);
			}
		});

		JButton btn2 = new JButton("2");
		btn2.setSize(120, 40);
		btn2.setLocation(130, 60);
		add(btn2);
		btn2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 2;
				output.setText(num);
			}
		});

		JButton btn3 = new JButton("3");
		btn3.setSize(120, 40);
		btn3.setLocation(250, 60);
		add(btn3);
		btn3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 3;
				output.setText(num);
			}
		});

		JButton plus = new JButton("+");
		plus.setSize(120, 40);
		plus.setLocation(370, 60);
		add(plus);
		plus.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				firstNum = Integer.parseInt(output.getText());
				output.setText("");
				op = '+' ;				
			}
		});

		JButton btn4 = new JButton("4");
		btn4.setSize(120, 40);
		btn4.setLocation(10, 100);
		add(btn4);
		btn4.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 4;
				output.setText(num);
			}
		});

		JButton btn5 = new JButton("5");
		btn5.setSize(120, 40);
		btn5.setLocation(130, 100);
		add(btn5);
		btn5.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 5;
				output.setText(num);
			}
		});

		JButton btn6 = new JButton("6");
		btn6.setSize(120, 40);
		btn6.setLocation(250, 100);
		add(btn6);
		btn6.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 6;
				output.setText(num);
			}
		});

		JButton minus = new JButton("-");
		minus.setSize(120, 40);
		minus.setLocation(370, 100);
		add(minus);
		minus.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				firstNum = Integer.parseInt(output.getText());
				output.setText("");
				op = '-' ;				
			}
		});

		JButton btn7 = new JButton("7");
		btn7.setSize(120, 40);
		btn7.setLocation(10, 140);
		add(btn7);
		btn7.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 7;
				output.setText(num);
			}
		});

		JButton btn8 = new JButton("8");
		btn8.setSize(120, 40);
		btn8.setLocation(130, 140);
		add(btn8);
		btn8.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 8;
				output.setText(num);
			}
		});


		JButton btn9 = new JButton("9");
		btn9.setSize(120, 40);
		btn9.setLocation(250, 140);
		add(btn9);
		btn9.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText() + 9;
				output.setText(num);
			}
		});

		JButton multi = new JButton("*");
		multi.setSize(120, 40);
		multi.setLocation(370, 140);
		add(multi);
		multi.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				firstNum = Integer.parseInt(output.getText());
				output.setText("");
				op = '*' ;				
			}
		});

		JButton res = new JButton("=");
		res.setSize(240, 40);
		res.setLocation(10, 180);
		add(res);
		res.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int secondNum = Integer.parseInt(output.getText());
				output.setText(Integer.toString(CalcAPI.FCalc(firstNum, secondNum, op)));
			}
		});

		JButton btn0 = new JButton("0");
		btn0.setSize(120, 40);
		btn0.setLocation(250, 180);
		add(btn0);
		btn0.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String num = "" + output.getText()+0;
				output.setText(num);
			}
		});

		JButton div = new JButton("/");
		div.setSize(120, 40);
		div.setLocation(370, 180);
		add(div);
		div.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				firstNum = Integer.parseInt(output.getText());
				output.setText("");
				op = '/';				
			}
		});
	}
}
