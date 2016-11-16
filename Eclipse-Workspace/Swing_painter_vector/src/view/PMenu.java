package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import presenter.PCommand;

@SuppressWarnings("serial")
public class PMenu extends JMenuBar
{
	public PMenu(PCommand cmd)
	{		
		JMenu save = new JMenu("Save");
		
		JMenuItem saveXML = new JMenuItem("xml");
		JMenuItem saveCSV = new JMenuItem("csv");
		JMenuItem saveJson = new JMenuItem("json");
		JMenuItem saveYaml = new JMenuItem("yaml");
		save.add(saveXML);
		save.add(saveCSV);
		save.add(saveJson);
		save.add(saveYaml);

		JMenu open = new JMenu("Open");
		
		JMenuItem openXML = new JMenuItem("xml");
		JMenuItem openCSV = new JMenuItem("csv");
		JMenuItem openJson = new JMenuItem("json");
		JMenuItem openYaml = new JMenuItem("yaml");
		open.add(openXML);
		open.add(openCSV);
		open.add(openJson);
		open.add(openYaml);

		openXML.addActionListener(cmd.aOpen);
		openCSV.addActionListener(cmd.aOpen);
		openJson.addActionListener(cmd.aOpen);
		openYaml.addActionListener(cmd.aOpen);
		
		saveXML.addActionListener(cmd.aSave);
		saveCSV.addActionListener(cmd.aSave);
		saveJson.addActionListener(cmd.aSave);
		saveYaml.addActionListener(cmd.aSave);
		
		add(save);
		add(open);
		
		JMenu figs = new JMenu("Figures");
		JMenuItem oval = new JMenuItem("Oval");
		JMenuItem line = new JMenuItem("Line");
		JMenuItem rect = new JMenuItem("Rect");
		JMenuItem round = new JMenuItem("Round");

		line.setActionCommand("1");
		rect.setActionCommand("2");
		oval.setActionCommand("3");
		round.setActionCommand("4");
		oval.addActionListener(cmd.aType);
		line.addActionListener(cmd.aType);
		rect.addActionListener(cmd.aType);
		round.addActionListener(cmd.aType);

		figs.add(oval);
		figs.add(line);
		figs.add(rect);
		figs.add(round);
		
		add(figs);
		
		JMenu colorButn = new JMenu("Color");
		colorButn.addActionListener(cmd.aColor);
		add(colorButn);
		
		JMenu stroke = new JMenu("Stroke");
		for (int i = 1; i <= 10; i++)
		{
			JMenuItem item = new JMenuItem("" + i);
			item.addActionListener(cmd.aWidthMenu);
			stroke.add(item);
		}
		add(stroke);
	}
}
