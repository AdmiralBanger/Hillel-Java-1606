package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Figure;
import presenter.PCommand;

@SuppressWarnings("serial")
public class PPaintPanel extends JPanel implements MouseListener, MouseMotionListener
{
	Point p1 = null;
	PCommand cmd = null;
	PStatusBar sb = null;

	public ArrayList<Figure> pp = new ArrayList<Figure>(); 

	public PPaintPanel(PCommand cmd, PStatusBar sb)
	{
		this.cmd = cmd;
		this.sb = sb;
		cmd.ppanel = this;
		
		setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		setBackground(Color.white);
		setComponentPopupMenu(new PPopupMenu(cmd));
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		for (Figure f : pp) 
		{
			f.paint(g);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		p1 = e.getPoint();
	}
	public void mouseReleased(MouseEvent e)
	{
		pp.add(new Figure(cmd.pd, p1, e.getPoint()));
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