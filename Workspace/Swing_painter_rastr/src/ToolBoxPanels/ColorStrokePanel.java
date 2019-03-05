package ToolBoxPanels;


import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import presenter.PCommand;

@SuppressWarnings("serial")
public class ColorStrokePanel extends JPanel
{
	@SuppressWarnings("unchecked")
	public ColorStrokePanel(PCommand cmd)
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton bColor = new JButton("Color");
		add(bColor);
		bColor.addActionListener(cmd.aColor);
		
		@SuppressWarnings("rawtypes")
		JComboBox cbox = new JComboBox();
		for (int i = 1; i <= 10; i++) 
		{
			cbox.addItem(i);
		}
		cbox.addActionListener(cmd.aWidth);
		add(cbox);
		
	}
}
