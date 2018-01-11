package calculator;

import java.lang.Math;

public class Model {
	protected double numA, numB;
	protected String process;
	protected String operator;
	protected String answer;
	protected boolean point;
	
	public Model() {
		numA = 0;
		numB = 0;
		process = "";
		operator = "";
		answer = "";
		point = false;
	}
	
	
	//click "CE" button
	public void clear() {
		numA = 0;
		numB = 0;
		process = "";
		operator = "";
		answer = "";
		point = false;
	}
	//click "¡ç" button
	public void backSpace() {
		if(answer.length() >= 1 && answer.charAt(answer.length()-1) == '.')
			point = false;
		try {
			answer = answer.substring(0, answer.length()-1);
		}catch(StringIndexOutOfBoundsException sie) {}
	}
	//click "¡¾" button
	public void invert() {
		try {
			if(answer.charAt(0) == '-') 
				answer = answer.substring(1, answer.length());
			else 
				answer = "-" + answer;
		}catch(StringIndexOutOfBoundsException sie) {}
	}
	//click "¡î" button
	public void squareRoot(String function) {
		if(numA==0) {
			try {
				numA = Double.parseDouble(answer);
			}catch(NumberFormatException nfe) {
				answer = "0";
				numA = 0;
			};
			numA = Math.sqrt(numA);
		}else {
			try {
				numB = Double.parseDouble(answer);
			}catch(NumberFormatException nfe) {
				answer = "0";
				numB = 0;
			};
			numB = Math.sqrt(numB);
		}
		process = process+function+answer;
		answer ="";
	}
	//click TRIGONOMETRIC buttons
	public void trigonometric (String function) {
		if(numA==0) {
			try {
				numA = Double.parseDouble(answer);
			}catch(NumberFormatException nfe) {
				answer = "0";
				numA = 0;
			};
			switch(function) {
			case "sin": numA = Math.sin(numA); break;
			case "cos": numA = Math.cos(numA); break;
			case "tan": numA = Math.tan(numA); break;
			}
		}else {
			try {
				numB = Double.parseDouble(answer);
			}catch(NumberFormatException nfe) {
				answer = "0";
				numB = 0;
			};
			switch(function) {
			case "sin": numB = Math.sin(numB); break;
			case "cos": numB = Math.cos(numB); break;
			case "tan": numB = Math.tan(numB); break;
			}
		}
		process = process+function+"("+answer+")";
		answer ="";
	}
	//click OPERATOR buttons
	public void calculate(String operator)  {
		if(this.operator.equals("")) {
			this.operator = operator;
			if(numA == 0) {
				try {
					numA = Double.parseDouble(answer);
				}catch(NumberFormatException nfe) {
					operator = "";
				}
			}
			process = process + answer + this.operator;
			answer = "";
		}else{
			if(numB == 0) {
				try {
					numB = Double.parseDouble(answer);
				}catch(NumberFormatException nfe) {
					answer = "";
					numB = 0;
				}
			}
			switch(this.operator) {
			case "¡À": numA = numA / numB; break;
			case "¡¿": numA = numA * numB; break;
			case "-": numA = numA - numB; break;
			case "+": numA = numA + numB; break;
			}
			if(numB!=0)
				process = process + answer + this.operator;
			answer = "";
		}
	}
	//click "=" button
	public void finalCalculate() {
		if(this.operator.length()==1) {
			if(process.charAt(process.length()-1) == operator.charAt(0)) {
				try {
					numB = Double.parseDouble(answer);
				}catch(NumberFormatException nfe) {
					answer = "0";
					numB = 0;
				}
				process = process + answer;
			}
			switch(this.operator) {
			case "¡À": numA = numA / numB; break;
			case "¡¿": numA = numA * numB; break;
			case "-": numA = numA - numB; break;
			case "+": numA = numA + numB; break;
			}
			answer = Double.toString(numA);
			//delete ".0" (fake like parse.toInteger)
			if(answer.substring(answer.length()-2, answer.length()).equals(".0")) {
				answer = answer.substring(0, answer.length()-2);
			}
			this.operator = "";
		}else {
			process = process + answer;
			answer = Double.toString(numA);
			if(answer.substring(answer.length()-2, answer.length()).equals(".0")) {
				answer = answer.substring(0, answer.length()-2);
			}
			this.operator = "";
		}
	}
}
