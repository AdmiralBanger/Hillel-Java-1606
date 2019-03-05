import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class firstCalcServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		doGet( req, resp );
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{		
		int res = 0;
		int a   = Integer.parseInt( req.getParameter("aNum") );
		int b   = Integer.parseInt( req.getParameter("bNum") );
		char op = req.getParameter("op").charAt(0);
		
		switch( op )
		{
			case '+': res = a + b; break;
			case '-': res = a - b; break;
			case '/': res = a / b; break;
			case '*': res = a * b; break;
		}
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println(res);
	}
}
