package calculator;

import java.awt.event.*;
import javax.swing.*;

public class Control implements ActionListener{
	
	View v;
	Model m;
	
	public Control(View v) {
		m = new Model();
		this.v = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		JButton button = (JButton)ae.getSource();
		
		//Insert TextField
		switch(button.getText()) {
		//clear TextField
		case "CE":	m.clear();
					v.processField.setText("");
					v.tField.setText("0");	
					break;
		//delete TextField
		case "¡ç":	m.backSpace();
					v.tField.setText(m.answer);	
					break;
		//invert number	
		case "¡¾":	m.invert();
					v.tField.setText(m.answer);
					break;
		case "¡î":	m.squareRoot(button.getText());
					v.tField.setText(m.answer);
					v.processField.setText(m.process);
					break;
		case "sin":;
		case "cos":;
		case "tan":	m.trigonometric(button.getText());
					v.tField.setText(m.answer);
					v.processField.setText(m.process);
					break;
		//arithmetic operation
		case "¡À":
		case "¡¿":
		case "-":
		case "+":	m.calculate(button.getText());
					v.tField.setText("0");
					v.processField.setText(m.process);
					break;
		//circulate
		case "=":	m.finalCalculate();
					v.tField.setText(m.answer);
					v.processField.setText(m.process);
					break;
		//add point
		case ".":	if(m.point == false) {
					m.point = true;
					m.answer = m.answer + button.getText();
					v.tField.setText(m.answer);
					};
					break;
		//input number
		default: 	m.answer = m.answer + button.getText();
					v.tField.setText(m.answer);
		}
	}
}

