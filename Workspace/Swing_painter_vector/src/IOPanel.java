package ToolBoxPanels;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presenter.PCommand;




public class IOPanel
  extends JPanel
{
  public JComboBox saveBox = new JComboBox();
  
  public JComboBox openBox = new JComboBox();
  

  public IOPanel(PCommand cmd)
  {
    setLayout(new GridLayout(2, 2));
    
    JLabel saveLbl = new JLabel("Save");
    add(saveLbl);
    
    saveBox.addItem("xml");
    saveBox.addItem("csv");
    saveBox.addItem("json");
    saveBox.addItem("yaml");
    add(saveBox);
    saveBox.addActionListener(aSave);
    
    JLabel openLbl = new JLabel("Open");
    add(openLbl);
    
    openBox.addItem("xml");
    openBox.addItem("csv");
    openBox.addItem("json");
    openBox.addItem("yaml");
    add(openBox);
    openBox.addActionListener(aOpen);
  }
}
