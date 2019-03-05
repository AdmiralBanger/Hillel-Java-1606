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
		
		JMenuItem savebmp = new JMenuItem("bmp");
		JMenuItem savepng = new JMenuItem("png");
		JMenuItem savegif = new JMenuItem("gif");
		save.add(savebmp);
		save.add(savepng);
		save.add(savegif);

		JMenu open = new JMenu("Open");
		
		JMenuItem openbmp = new JMenuItem("bmp");
		JMenuItem openpng = new JMenuItem("png");
		JMenuItem opengif = new JMenuItem("gif");
		open.add(openbmp);
		open.add(openpng);
		open.add(opengif);

		openbmp.addActionListener(cmd.aOpen);
		openpng.addActionListener(cmd.aOpen);
		opengif.addActionListener(cmd.aOpen);
		
		savebmp.addActionListener(cmd.aSave);
		savepng.addActionListener(cmd.aSave);
		savegif.addActionListener(cmd.aSave);
		
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
		
		JMenuItem colorButn = new JMenuItem("Color");
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
