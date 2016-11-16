package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import presenter.PCommand;

@SuppressWarnings("serial")
public class PPaintPanel extends JPanel implements MouseListener, MouseMotionListener
{
	Point p1 = null;
	PCommand cmd = null;
	PStatusBar sb = null;

	public BufferedImage pp = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);

	public PPaintPanel(PCommand cmd, PStatusBar sb, Point size)
	{
		this.cmd = cmd;
		this.sb = sb;
		cmd.ppanel = this;

		setLayout(null);
		setSize(800, 800);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		setBackground(Color.white);
		setComponentPopupMenu(new PPopupMenu(cmd));

		pp.getGraphics().setColor(Color.white);
		pp.getGraphics().fillRect(0, 0, 800, 800);
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.drawImage(pp, 0, 0, null);
	}

	public void mousePressed(MouseEvent e)
	{
		p1 = e.getPoint();
	}
	public void mouseReleased(MouseEvent e)
	{
		Graphics2D gg = pp.createGraphics();
		gg.setStroke(new BasicStroke(cmd.pd.width));
		gg.setColor(cmd.pd.col);
		switch (cmd.pd.type)
		{
			case 1: gg.drawLine(p1.x, p1.y, e.getX(), e.getY()); break;
			case 2: gg.drawRect(p1.x, p1.y, e.getX()-p1.x, e.getY()-p1.y); break;
			case 3: gg.drawOval(p1.x, p1.y, e.getX()-p1.x, e.getY()-p1.y); break;
			case 4: gg.drawRoundRect(p1.x, p1.y, e.getX()-p1.x, e.getY()-p1.y, 50,50); break;
		}
		gg.dispose();
		repaint();
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	@Override
	public void mouseDragged(MouseEvent e){}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		sb.xlbl.setText("X: " + e.getX());
		sb.ylbl.setText("Y: " + e.getY());
		sb.repaint();
	}
}