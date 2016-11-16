import java.awt.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class Ball extends JPanel
{
	int dx;
	int dy;
	int size;
	Color color;

	public Ball(Point p)
	{
		Random rand = new Random();

		setSize(30, 30);
		color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

		dx = rand.nextInt(10) - 5; 
		dy = rand.nextInt(10) - 5;
		while (dx == 0)
		{
			dx = rand.nextInt(10) - 5;
		}
		while (dy == 0)
		{
			dy = rand.nextInt(10) - 5;
		}

		p.translate(-15, -15);
		setLocation(p);
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(color);
		gg.fillOval(1, 1, 30, 30);
	}

	public void move()
	{
		JPanel pp = (JPanel) getParent();
		Point p = getLocation();
		if (p.x <= 0 || p.x+30 >= pp.getWidth())
		{
			dx = -dx;
		}
		if (p.y <= 0 || p.y+30 >= pp.getHeight())
		{
			dy = -dy;
		}
		p.translate(dx, dy);
		setLocation(p);
	}

}