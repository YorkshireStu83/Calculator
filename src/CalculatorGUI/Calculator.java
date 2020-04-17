package CalculatorGUI;

import java.awt.Color;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Calculator implements ActionListener {
	
	private static JTextArea display;
	private static JButton bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine;
	private static JButton bZero, bAdd, bSubtract, bMultiply, bDivide, bEquals, bDecimal; 
	private static JButton bPercent, bSquared, bRoot, bClear, bBack, bPlusMinus, bQuit;
	private static String displayValue;
	private static char function = '.';
	private static boolean calculated = false;
	private static float value = 0.0f;
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(435, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.add(panel);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		
		display = new JTextArea();
		display.setBounds(0, 0, 435, 100);
		Font font = new Font("Verdana", Font.PLAIN, 42);
		display.setFont(font);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setText("0");
		panel.add(display);
		
		panel.setLayout(null);
		
		// Bottom row
		bZero = new JButton("0");
		bZero.setBounds(15, 325, 55, 55);
		bZero.addActionListener(new Calculator());
		panel.add(bZero);
		
		bDecimal = new JButton(".");
		bDecimal.setBounds(85, 325, 55, 55);
		bDecimal.addActionListener(new Calculator());
		panel.add(bDecimal);
		
		bPercent = new JButton("%");
		bPercent.setBounds(155, 325, 55, 55);
		bPercent.addActionListener(new Calculator());
		panel.add(bPercent);
		
		bAdd = new JButton("+");
		bAdd.setBounds(225, 325, 55, 55);
		bAdd.addActionListener(new Calculator());
		panel.add(bAdd);
		
		bEquals = new JButton("=");
		bEquals.setBounds(295, 325, 125, 55);
		bEquals.addActionListener(new Calculator());
		panel.add(bEquals);
	
		// Row three
		bOne = new JButton("1");
		bOne.setBounds(15, 255, 55, 55);
		bOne.addActionListener(new Calculator());
		panel.add(bOne);
		
		bTwo = new JButton("2");
		bTwo.setBounds(85, 255, 55, 55);
		bTwo.addActionListener(new Calculator());
		panel.add(bTwo);
		
		bThree = new JButton("3");
		bThree.setBounds(155, 255, 55, 55);
		bThree.addActionListener(new Calculator());
		panel.add(bThree);
		
		bSubtract = new JButton("-");
		bSubtract.setBounds(225, 255, 55, 55);
		bSubtract.addActionListener(new Calculator());
		panel.add(bSubtract);
		
		bSquared = new JButton("Sq");
		bSquared.setBounds(295, 255, 55, 55);
		bSquared.addActionListener(new Calculator());
		panel.add(bSquared);
		
		bRoot = new JButton("√");
		bRoot.setBounds(365, 255, 55, 55);
		bRoot.addActionListener(new Calculator());
		panel.add(bRoot);
		
		// Row two
		bFour = new JButton("4");
		bFour.setBounds(15, 185, 55, 55);
		bFour.addActionListener(new Calculator());
		panel.add(bFour);
		
		bFive = new JButton("5");
		bFive.setBounds(85, 185, 55, 55);
		bFive.addActionListener(new Calculator());
		panel.add(bFive);
		
		bSix = new JButton("6");
		bSix.setBounds(155, 185, 55, 55);
		bSix.addActionListener(new Calculator());
		panel.add(bSix);
		
		bMultiply = new JButton("*");
		bMultiply.setBounds(225, 185, 55, 55);
		bMultiply.addActionListener(new Calculator());
		panel.add(bMultiply);
		
		bPlusMinus = new JButton("+/-");
		bPlusMinus.setBounds(295, 185, 55, 55);
		bPlusMinus.addActionListener(new Calculator());
		panel.add(bPlusMinus);
		
		bQuit = new JButton("Q");
		bQuit.setBounds(365, 185, 55, 55);
		bQuit.addActionListener(new Calculator());
		panel.add(bQuit);
		
		// Top Row
		bSeven = new JButton("7");
		bSeven.setBounds(15, 115, 55, 55);
		bSeven.addActionListener(new Calculator());
		panel.add(bSeven);
		
		bEight = new JButton("8");
		bEight.setBounds(85, 115, 55, 55);
		bEight.addActionListener(new Calculator());
		panel.add(bEight);
		
		bNine = new JButton("9");
		bNine.setBounds(155, 115, 55, 55);
		bNine.addActionListener(new Calculator());
		panel.add(bNine);
		
		bDivide = new JButton("/");
		bDivide.setBounds(225, 115, 55, 55);
		bDivide.addActionListener(new Calculator());
		panel.add(bDivide);
		
		bBack = new JButton("<");
		bBack.setBounds(295, 115, 55, 55);
		bBack.addActionListener(new Calculator());
		panel.add(bBack);
		
		bClear = new JButton("C");
		bClear.setBounds(365, 115, 55, 55);
		bClear.addActionListener(new Calculator());
		panel.add(bClear);
		
	
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent button) {
		displayValue = display.getText();
		String buttonName = String.valueOf(button.getActionCommand());	
		
		switch(buttonName) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				// Add next character
				if (displayValue.charAt(0) == '0')
					displayValue = buttonName;		
				else
					displayValue += buttonName;
				break;
			case "0":
				if (displayValue != "0") 
					displayValue += buttonName;
				break;
			case ".":
				if (displayValue.indexOf('.') == -1) {
					displayValue += buttonName;
				}
				break;
			case "C":
				displayValue = "0";
				value = 0.0f;
				function = '.';
				calculated = false;
				break;
			case "<":
				if (displayValue.length() == 1) {				
					displayValue = "0";
				} else {
					int length = displayValue.length();
					displayValue = displayValue.substring(0, length-1);
				}
				break;
			case "+":
				if (!calculated) {
					// Addition
					value += Float.parseFloat(displayValue);
				}
				function = '+';		
				displayValue = "0";
				calculated = false;
				break;
			case "-":
				if (!calculated) {
					// Subtraction				
					value -= Float.parseFloat(displayValue);
				}
				function = '-';
				displayValue = "0";
				calculated = false;
				break;
			case "*":
				if (!calculated) {
					// Multiplication
					value *= Float.parseFloat(displayValue);
				}
				// Set initial value for multiplication
				if (value == 0)
					value += Float.parseFloat(displayValue);
				function = '*';
				displayValue = "0";
				calculated = false;
				break;
			case "/":
				if (!calculated) {
					// Division
					value /= Float.parseFloat(displayValue);
				}	
				// Set initial value for division
				if (value == 0)
					value += Float.parseFloat(displayValue);
				function = '/';
				displayValue = "0";
				calculated = false;
				break;
			case "=":
				if (function == '+') 
					value += Float.parseFloat(displayValue);					
				else if (function == '-')
					value -= Float.parseFloat(displayValue);	
				else if (function == '*')
					value *= Float.parseFloat(displayValue);	
				else if (function == '/')
					value /= Float.parseFloat(displayValue);	
				displayValue = Float.toString(value);
				function = '.';
				calculated = true;
				break;
			case "+/-":
				float currentValue = Float.parseFloat(displayValue);
				currentValue = currentValue - (2*currentValue);
				displayValue = Float.toString(currentValue);
				break;
			case "Q":
				System.exit(0);
				break;
			case "%":
				if (function == '+') 
					value += Float.parseFloat(displayValue) / 100;					
				else if (function == '-')
					value -= Float.parseFloat(displayValue) / 100;	
				else if (function == '*') {
					value *= Float.parseFloat(displayValue);
					value /= 100;
				}
				else if (function == '/') {
					value /= Float.parseFloat(displayValue);
					value *= 100;
				}					
				displayValue = Float.toString(value);
				function = '.';
				calculated = true;
				break;
			case "Sq":
				float squareValue = Float.parseFloat(displayValue);
				squareValue *= squareValue;
				displayValue = Float.toString(squareValue);
				break;
			case "√":
				double rootValue = Float.parseFloat(displayValue);
				rootValue = Math.sqrt(rootValue);
				displayValue = Double.toString(rootValue);
				break;		
		}

		
		//Check if need to display decimals
		if (displayValue.length() > 2) {
			if (Float.parseFloat(displayValue) % 1 == 0 && displayValue.contains(".")) {
				displayValue = displayValue.substring(0, displayValue.length()-2);
			}
		}
		
		// Cut display to 15 figures if too long
		if (displayValue.length() > 15) {
			displayValue = displayValue.substring(0, 15);
		}
		
		
		// Update display
		display.setText(displayValue);
		
	}
}
