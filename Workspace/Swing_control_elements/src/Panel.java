
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class Panel extends JPanel
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Panel()
	{
		setLayout(null);
		
		JLabel lbl = new JLabel("Label");
		lbl.setBounds(10, 10, 100, 20);
		add(lbl);
		
		JButton btn = new JButton("Button");
		btn.setBounds(10, 40, 100, 20);
		add(btn);
		
		JCheckBox cb = new JCheckBox("Check box");
		cb.setBounds(10, 70, 100, 20);
		add(cb);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("Radio 1");
		rb1.setBounds(10, 100, 100, 20);
		JRadioButton rb2 = new JRadioButton("Radio 2");
		rb2.setBounds(10, 130, 100, 20);
		rb1.setSelected(true);
		bg.add(rb1);	bg.add(rb2);
		add(rb1);		add(rb2);
		
		JComboBox cbox = new JComboBox();
		cbox.setBounds(10, 160, 100, 20);
		cbox.addItem("Combo box");
		cbox.addItem("Item 2");
		add(cbox);
		
		String s[] = {"List","2","3"};
		JList jl = new JList(s);
		JScrollPane sp = new JScrollPane(jl);
		sp.setBounds(10, 190, 100, 20);
		add(sp);
		
		JTextField tf = new JTextField("Text field");
		tf.setBounds(10, 220, 100, 20);
		add(tf);
		
		JTextArea ta = new JTextArea("Text area");
		JScrollPane sp1 = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setBounds(10, 250, 100, 100);
		add(sp1);
		
		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(120, 10, 200, 100);;
		tp.addTab("Panel 1", null);
		tp.addTab("Panel 2", null);
		add(tp);
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Tree");
		DefaultMutableTreeNode item1 = new DefaultMutableTreeNode("Item 1");
		top.add(item1);
		DefaultMutableTreeNode subitem1 = new DefaultMutableTreeNode("Subitem 1");
		item1.add(subitem1);
		DefaultMutableTreeNode subitem2 = new DefaultMutableTreeNode("Subitem 2");
		item1.add(subitem2);
		
		DefaultMutableTreeNode item2 = new DefaultMutableTreeNode("Item 2");
		top.add(item2);
		DefaultMutableTreeNode subitem21 = new DefaultMutableTreeNode("Subitem 1");
		item2.add(subitem21);
		DefaultMutableTreeNode subitem22 = new DefaultMutableTreeNode("Subitem 2");
		item2.add(subitem22);
		
		JTree tree = new JTree(top);
		JScrollPane sp2 = new JScrollPane(tree);
		sp2.setBounds(120, 120, 200, 120);
		add(sp2);
		
		// ??? - Без JScrollPane не показывает имена столбцов - ???
		String[] heads = {"Name", "Phone", "email"};
		String[][] data = {
				{"Random Name 1", "0671234567", "someemail@random.com"},
				{"Random Name 2", "0961234567", "anotheremail@gmail.com"}
		};
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
		JTable tbl = new JTable(data, heads);
		JScrollPane sp3 = new JScrollPane(tbl, v, h);
		sp3.setBounds(120, 250, 200, 100);
		add(sp3);
		
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 0);
		slider.setBounds(9, 350, 315, 50);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(5);
		slider.setLabelTable(slider.createStandardLabels(5));
		add(slider);
		
		JLabel lbl1 = new JLabel("Split");
		JLabel lbl2 = new JLabel("Pane");
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lbl1, lbl2);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		Dimension minimumSize = new Dimension(100, 50);
		splitPane.setMinimumSize(minimumSize);
		splitPane.setBounds(10, 400, 310, 50);
		add(splitPane);
	}
}