package model;

import java.awt.*;

public class Figure 
{
	Color color;
	int x1;
	int y1;
	int x2;
	int y2;
	int width = 1;
	int type = 1;
	
	public Figure() {}

	public Figure(PData pd, Point p1, Point p2) 
	{
		this.color = pd.col;
		this.type = pd.type;
		this.width = pd.width;
		this.x1 = p1.x;
		this.y1 = p1.y;
		this.x2 = p2.x;
		this.y2 = p2.y;
	}
	
	public Figure(Color col, int type, int width, Point p1, Point p2) 
	{
		this.color = col;
		this.type = type;
		this.width = width;
		this.x1 = p1.x;
		this.y1 = p1.y;
		this.x2 = p2.x;
		this.y2 = p2.y;
	}
	
	public void paint(Graphics g)
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setStroke(new BasicStroke(width));
		gg.setColor(color);
		switch (type) 
		{
			case 1: gg.drawLine(x1, y1, x2, y2); break;
			case 2: gg.drawRect(x1, y1, x2-x1, y2-y1); break;
			case 3: gg.drawOval(x1, y1, x2-x1, y2-y1); break;
			case 4: gg.drawRoundRect(x1, y1, x2-x1, y2-y1, 50,50); break;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
