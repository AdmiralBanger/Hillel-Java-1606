package ToolBoxPanels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import presenter.PCommand;

@SuppressWarnings("serial")
public class FiguresPanel extends JPanel
{
	public FiguresPanel(PCommand cmd)
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JButton ovalButn = new JButton("Oval");
		JButton rectButn = new JButton("Rect");
		JButton lineButn = new JButton("Line");
		JButton roundRectButn = new JButton("Round");
		
		lineButn.setActionCommand("1");
		rectButn.setActionCommand("2");
		ovalButn.setActionCommand("3");
		roundRectButn.setActionCommand("4");
		
		lineButn.addActionListener(cmd.aType);
		rectButn.addActionListener(cmd.aType);
		ovalButn.addActionListener(cmd.aType);
		roundRectButn.addActionListener(cmd.aType);

		lineButn.setAlignmentX(CENTER_ALIGNMENT);
		rectButn.setAlignmentX(CENTER_ALIGNMENT);
		ovalButn.setAlignmentX(CENTER_ALIGNMENT);
		roundRectButn.setAlignmentX(CENTER_ALIGNMENT);
		
		add(ovalButn);
		add(rectButn);
		add(lineButn);
		add(roundRectButn);
	}
}
