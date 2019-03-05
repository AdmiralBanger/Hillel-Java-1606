package view;

import java.awt.BorderLayout;

import javax.swing.*;

import ToolBoxPanels.*;
import presenter.PCommand;

@SuppressWarnings("serial")
public class PToolBox extends JPanel
{
	public PToolBox(PCommand cmd)
	{
		BorderLayout bl = new BorderLayout();
		bl.setVgap(30);
		setLayout(bl);
		
		add(new IOPanel(cmd), BorderLayout.NORTH);
		add(new FiguresPanel(cmd), BorderLayout.CENTER);
		add(new ColorStrokePanel(cmd), BorderLayout.SOUTH);
	}
}
