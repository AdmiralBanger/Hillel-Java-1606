package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logic.TableModel;

@SuppressWarnings("serial")
public class TPanel extends JPanel
{

	public TPanel()
	{
		setLayout(null);
		
		TableModel tm = new TableModel();
		JTable tbl = new JTable(tm);
		tbl.getColumnModel().getColumn(0).setPreferredWidth(10);
		tbl.getColumnModel().getColumn(3).setPreferredWidth(10);
		tbl.getColumnModel().getColumn(4).setPreferredWidth(30);
		JScrollPane scr = new JScrollPane(tbl);
		scr.setBounds(10, 10, 430, 271);
		add(scr);
		tbl.addMouseListener(tm.aUpd);
		
		JButton create = new JButton("Create");
		create.setBounds(470, 10, 100, 20);
		add(create);
		create.addActionListener(tm.aCreate);
		
		JButton read = new JButton("Read");
		read.setBounds(470, 40, 100, 20);
		add(read);
		read.addActionListener(tm.aRead);

		JButton update = new JButton("Update");
		update.setBounds(470, 70, 100, 20);
		add(update);
		update.addActionListener(tm.aUpdate);
		
		JButton delete = new JButton("Delete");
		delete.setBounds(470, 100, 100, 20);
		add(delete);
		delete.addActionListener(tm.aDelete);
	}
}
