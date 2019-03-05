package view;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JFrame;

import presenter.PCommand;

@SuppressWarnings("serial")
public class PFrame extends JFrame 
{
	public PFrame()
	{
		setBounds(100, 100, 700, 600);
		setTitle("Painter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		
		PCommand cmd = new PCommand();
		PStatusBar sb = new PStatusBar();
		
		setJMenuBar(new PMenu(cmd));
		add(new PToolBar(cmd), BorderLayout.NORTH);
		add(new PToolBox(cmd), BorderLayout.WEST);
		add(new PPaintPanel(cmd, sb, new Point()), BorderLayout.CENTER);
		add(sb, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
