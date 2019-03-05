import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PPanel extends JPanel implements MouseListener
{

	public PPanel()
	{
		setLayout(null);
		setBackground(Color.white);
		addMouseListener(this);
	}

	public void mousePressed(MouseEvent e)
	{
		add(new Ball(e.getPoint()));
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}