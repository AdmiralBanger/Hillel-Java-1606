import javax.swing.SwingUtilities;

public class DNDMain 
{
	public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new DNDFrame();
            }
        });
    }
}
