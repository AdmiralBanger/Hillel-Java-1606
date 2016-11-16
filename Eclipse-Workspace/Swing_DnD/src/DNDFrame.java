import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DNDFrame 
{

    public DNDFrame() 
    {
        createAndShowUI();
    }

    private void createAndShowUI() 
    {
        final JFrame frame = new JFrame();
        
        frame.setBounds(100, 100, 800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        @SuppressWarnings("serial")
		JPanel draggableLabel = new JPanel() 
        {
            @Override
            public Dimension getPreferredSize() 
            {
                return new Dimension(100, 100);
            }
        };
        
        
       
        draggableLabel.setSize(50, 50);
        draggableLabel.setBackground(Color.blue);

        @SuppressWarnings("serial")
		JPanel panel1 = new JPanel() 
        {
            @Override
            public Dimension getPreferredSize() 
            {
                return new Dimension(400, 400);
            }
        };
        panel1.setBackground(Color.cyan);
        panel1.setName("Droppable");

        
        @SuppressWarnings("serial")
		JPanel panel2 = new JPanel() 
        {
            @Override
            public Dimension getPreferredSize() 
            {
                return new Dimension(400, 400);
            }
        };
        panel2.add(draggableLabel);
        panel2.setName("Droppable");


        DragableComp cd = new DragableComp(frame);

        cd.registerComponent(draggableLabel);

        frame.add(panel1, BorderLayout.WEST);

        frame.add(panel2, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}