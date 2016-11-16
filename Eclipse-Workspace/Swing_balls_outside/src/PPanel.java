import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PPanel extends JPanel implements MouseListener
{

	public PPanel()
	{
		setLayout(null);
		setBackground(Color.white);
		addMouseListener(this);
	}
	
	class ThreadAction extends Thread
	{
		Ball b;
		public void run() 
		{
			while (true)
			{
				try 
				{
					b.move();
					sleep(30);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	class TAction implements ActionListener
	{
		Ball b;
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			b.move();
		}
	}

	public void mousePressed(MouseEvent e)
	{
		Ball b = new Ball(e.getPoint());
		add(b);
		
		Timer timer = new Timer(30, new TAction());
		timer.start();
		
		//Thread thr = new ThreadAction();
		//thr.start();
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}