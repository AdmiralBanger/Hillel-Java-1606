package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
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
		
		InputMap inputMap = tbl.getInputMap(WHEN_FOCUSED);
		ActionMap actionMap = tbl.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "insert");
		actionMap.put("backspace", new AbstractAction()
		{
		    public void actionPerformed(ActionEvent evt) 
		    {
		    	int row = tbl.getSelectedRow();
		       	int col = tbl.getSelectedColumn();
		       	if (col >= 0 && row >= 0)
		       	{
		       		try
		       		{
		       			row = tbl.convertRowIndexToModel(row);
		       			col = tbl.convertColumnIndexToModel(col);
		       			tm.setValueAt("", row, col);
		       		}
		       		catch (NumberFormatException e)
		       		{
		       			JOptionPane.showMessageDialog(null, "Cannot clear primary key or number!", 
		       					"Error", JOptionPane.ERROR_MESSAGE);
		       		}
		       	}
		    }
		});
		actionMap.put("delete", new AbstractAction()
		{
		    public void actionPerformed(ActionEvent evt) 
		    {
		    	int row = tbl.getSelectedRow();
		    	if (row >= 0)
		       	{
		    		row = tbl.convertRowIndexToModel(row);
		    		int id = (int) tm.getValueAt(row, 0);
		    		tm.delete(id);
		       	}
		    }
		});
		actionMap.put("insert", new AbstractAction()
		{
		    public void actionPerformed(ActionEvent evt) 
		    {
		    	tm.insert();
		    }
		});

		JLabel lbl = new JLabel("Export:");
		lbl.setBounds(420, 160, 100, 20);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		add(lbl);
		
		JButton xmlBut = new JButton("XML");
		xmlBut.setBounds(420, 190, 100, 20);
		add(xmlBut);
		xmlBut.addActionListener(tm.save);
		
		JButton csvBut = new JButton("CSV");
		csvBut.setBounds(420, 220, 100, 20);
		add(csvBut);
		csvBut.addActionListener(tm.save);
		
		JButton jsonBut = new JButton("Json");
		jsonBut.setBounds(420, 250, 100, 20);
		add(jsonBut);
		jsonBut.addActionListener(tm.save);
		
		JButton yamlBut = new JButton("Yaml");
		yamlBut.setBounds(420, 280, 100, 20);
		add(yamlBut);
		yamlBut.addActionListener(tm.save);
		
		JLabel importLbl = new JLabel("Import:");
		importLbl.setBounds(420, 10, 100, 20);
		importLbl.setHorizontalAlignment(JLabel.CENTER);
		add(importLbl);
		
		JButton inputXMLBut = new JButton("XML");
		inputXMLBut.setBounds(420, 40, 100, 20);
		add(inputXMLBut);
		inputXMLBut.addActionListener(tm.read);
		
		JButton inputCSVBut = new JButton("CSV");
		inputCSVBut.setBounds(420, 70, 100, 20);
		add(inputCSVBut);
		inputCSVBut.addActionListener(tm.read);
		
		JButton inputJsonBut = new JButton("Json");
		inputJsonBut.setBounds(420, 100, 100, 20);
		add(inputJsonBut);
		inputJsonBut.addActionListener(tm.read);
		
		JButton inputYamlBut = new JButton("Yaml");
		inputYamlBut.setBounds(420, 130, 100, 20);
		add(inputYamlBut);
		inputYamlBut.addActionListener(tm.read);

		JLabel backspaceLbl = new JLabel("Backspace - clear selected cell");
		backspaceLbl.setBounds(10, 280, 200, 20);
		add(backspaceLbl);
		
		JLabel deleteLbl2 = new JLabel("Delete - delete selected row");
		deleteLbl2.setBounds(250, 280, 200, 20);
		add(deleteLbl2);
		
		JLabel insertLbl2 = new JLabel("Insert - add new row");
		insertLbl2.setBounds(10, 300, 250, 20);
		add(insertLbl2);
	}
}
