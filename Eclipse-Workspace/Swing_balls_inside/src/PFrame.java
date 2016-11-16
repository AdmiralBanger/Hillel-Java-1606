import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PFrame extends JFrame 
{
	public PFrame()
	{
		setBounds(100, 100, 500, 500);
		setTitle("Balls");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new PPanel());
		setVisible(true);
	}
}
