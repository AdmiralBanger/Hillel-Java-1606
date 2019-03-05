package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ToolBoxPanels.*;
import presenter.PCommand;

@SuppressWarnings("serial")
public class PToolBar extends JPanel
{
	public PToolBar(PCommand cmd) 
	{
		JToolBar toolBar = new JToolBar("Tool Bar");
		toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.LINE_AXIS));
		toolBar.setFloatable(false);
		setBackground(Color.red);

		IOPanel io = new IOPanel(cmd);
		io.setLayout(new FlowLayout());
		toolBar.add(io);
		
		FiguresPanel fp = new FiguresPanel(cmd);
		fp.setLayout(new FlowLayout());
		toolBar.add(fp);
		
		ColorStrokePanel csp = new ColorStrokePanel(cmd);
		csp.setLayout(new FlowLayout());
		toolBar.add(csp);
		
		add(toolBar);
	}
}
