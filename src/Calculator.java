import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Calculator class implementing ActionListener for handling button clicks
public class Calculator implements ActionListener {
    // Declare all the components and variables
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("JetBrains Mono", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor for Calculator
    Calculator() {
        // Initialize the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setVisible(true);

        // Initialize the text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Initialize the buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("-");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Add action listeners and set font for function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Set font for function buttons
        Font functionButtonFont = new Font("JetBrains Mono", Font.BOLD, 20);
        for (JButton button : functionButtons) {
            button.setFont(functionButtonFont);
        }

        // Set bounds for delete, clear and negative buttons
        delButton.setBounds(50, 450, 110, 50);
        clrButton.setBounds(160, 450, 110, 50);
        negButton.setBounds(270, 450, 80, 50);

        // Initialize number buttons and add action listeners
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Initialize panel and set its properties
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        // Set background and foreground colors for frame, text field, number and function buttons
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        for (JButton button : numberButtons) {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
        }
        for (JButton button : functionButtons) {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
        }

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle number button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // Handle function button clicks
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String temp = textField.getText();
            textField.setText("");
            for (int i = 0; i < temp.length() - 1; i++) {
                textField.setText(textField.getText() + temp.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            if (textField.getText().isEmpty()) {
                textField.setText("-");
            } else {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        new Calculator();
    }
}