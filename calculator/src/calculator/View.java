package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame {
	private JPanel panel;
	protected JTextField tField;
	protected JTextField processField;
	private JButton[] buttons;
	private String[] labels = {
			"√","sin","cos", "tan",
			"π", "CE", "←", "÷",
			"7", "8", "9", "×",
			"4", "5", "6", "-", 
			"1", "2", "3", "+", 
			"±", "0", ".", "="	};
	
	ActionListener ctr;
	
	public View() {
		
		//UIManager.put("TextField.disabledBackground", Color.GRAY);
		
		tField = new JTextField(20);
		tField.setText("0");
		tField.setEnabled(false);
		tField.setDisabledTextColor(Color.BLACK);
		tField.setFont(new Font("궁서체",Font.PLAIN, 36));
		
		processField = new JTextField(20);
		processField.setText("process of calculate");
		processField.setEnabled(false);
		processField.setDisabledTextColor(Color.BLACK);
		processField.setFont(new Font("명조", Font.PLAIN, 36));
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 4, 3, 3));
		
		buttons = new JButton[labels.length];
		int index = 0;
		ctr = new Control(this);
		for(index = 0; index < labels.length; index++) {
			buttons[index] = new JButton(labels[index]);
			buttons[index].addActionListener(ctr);
			buttons[index].setFont(new Font("명조", Font.BOLD, 36));
			//buttons[index].setBackground(Color.WHITE);
			panel.add(buttons[index]);
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(processField, BorderLayout.NORTH);
		this.add(tField, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		this.setTitle("Calculator _ 2muni");
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
	}
}
