package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class PStatusBar extends JPanel
{
	public JLabel xlbl;
	public JLabel ylbl;
	
	public PStatusBar()
	{
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		xlbl = new JLabel("X: ");
		ylbl = new JLabel("Y: ");
		add(xlbl);
		add(ylbl);
	}
}
