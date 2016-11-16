package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
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
		JScrollPane scr = new JScrollPane(tbl);
		scr.setBounds(10, 10, 400, 271);
		add(scr);
		
		JButton create = new JButton("Create");
		create.setBounds(420, 10, 100, 20);
		add(create);
		create.addActionListener(tm.aCreate);
		
		JButton read = new JButton("Read");
		read.setBounds(420, 40, 100, 20);
		add(read);
		read.addActionListener(tm.aRead);
		
		JButton update = new JButton("Update");
		update.setBounds(420, 70, 100, 20);
		add(update);
		update.addActionListener(tm.aUpdate);
		
		JButton delete = new JButton("Delete");
		delete.setBounds(420, 100, 100, 20);
		add(delete);
		delete.addActionListener(tm.aDelete);
		
		JLabel lbl = new JLabel("Export:");
		lbl.setBounds(420, 170, 100, 20);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		add(lbl);
		
		JButton xmlBut = new JButton("XML");
		xmlBut.setBounds(420, 200, 100, 20);
		add(xmlBut);
		xmlBut.addActionListener(tm.save);
		
		JButton csvBut = new JButton("CSV");
		csvBut.setBounds(420, 230, 100, 20);
		add(csvBut);
		csvBut.addActionListener(tm.save);
		
		JButton jsonBut = new JButton("Json");
		jsonBut.setBounds(420, 260, 100, 20);
		add(jsonBut);
		jsonBut.addActionListener(tm.save);
	}
}
