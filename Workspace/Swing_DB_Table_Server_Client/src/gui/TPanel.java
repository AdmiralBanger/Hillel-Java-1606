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
