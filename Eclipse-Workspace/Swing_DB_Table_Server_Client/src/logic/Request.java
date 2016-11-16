package logic;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Request implements Serializable
{
	public Person p;
	public int col;
	public char cmd; 
	
	public Request(Person p, int col, char cmd) 
	{
		super();
		this.p = p;
		this.col = col;
		this.cmd = cmd;
	}
}
