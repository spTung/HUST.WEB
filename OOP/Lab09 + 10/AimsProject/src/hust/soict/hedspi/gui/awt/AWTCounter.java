package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;

public class AWTCounter extends Frame implements ActionListener {
	private Label lblCount;
	private TextField tfCount;
	private Button btnCount;
	private int count = 0;
	
	public AWTCounter ( ) {
		setLayout(new FlowLayout());
		lblCount = new Label("Counter"); this.add(lblCount);
		tfCount = new TextField(count + "", 10);
		tfCount.setEditable(false);
		add(tfCount); 
		
		btnCount = new Button("Count"); // construct the Button component
		add(btnCount);
		
		btnCount.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setTitle("AWT Counter"); // "super" Frame sets its title
		setSize(250, 100); 
//		setLocation(600,500);
		setVisible(true); 
	}
	
	public static void main(String[] args) {
		
		 AWTCounter app = new AWTCounter();
		 
		 }

		 public void actionPerformed(ActionEvent evt) {
			 
		 ++count;
		 tfCount.setText(count + "");
		 
		 }

}
