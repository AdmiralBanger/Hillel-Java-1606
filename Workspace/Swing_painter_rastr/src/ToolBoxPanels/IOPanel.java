package ToolBoxPanels;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presenter.PCommand;

@SuppressWarnings("serial")
public class IOPanel extends JPanel
{
	@SuppressWarnings("rawtypes")
	public JComboBox saveBox = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox openBox = new JComboBox();
	
	@SuppressWarnings("unchecked")
	public IOPanel(PCommand cmd)
	{
		setLayout(new GridLayout(2, 2));
		
		JLabel saveLbl = new JLabel("Save");
		add(saveLbl);
				
		saveBox.addItem("bmp");
		saveBox.addItem("png");
		saveBox.addItem("gif");
		add(saveBox);
		saveBox.addActionListener(cmd.aSave);
		
		JLabel openLbl = new JLabel("Open");
		add(openLbl);
		
		openBox.addItem("bmp");
		openBox.addItem("png");
		openBox.addItem("gif");
		add(openBox);
		openBox.addActionListener(cmd.aOpen);
	}
}
