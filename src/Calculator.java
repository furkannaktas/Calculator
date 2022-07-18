import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];  // All numbers
    JButton[] functionButtons = new JButton[8]; //All function buttons +, - etc
    JButton addButton, subButton, multiplyButton, divideButton;
    JButton decimalButton, equalButton, deleteButton, clearButton;
    JPanel panel;


    Font myFont = new Font("Ink Free",Font.BOLD,30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;


    Calculator(){
        frame = new JFrame("Calculator");               // Name of the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);                       // Not to enter any char instead on the calculator

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;

        for (int i = 0; i < functionButtons.length ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }

        deleteButton.setBounds(50,430,145,50);
        clearButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.lightGray);

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
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divideButton);




        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < numberButtons.length ; i++) {

            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='+';
            textField.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        }

        if(e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }

        if(e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }

        if(e.getSource() == equalButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));          // Assign the result into the result box
            num1=result;                                        // Now the num1 is the result
        }

        if(e.getSource() == clearButton){                       // Clear button functionality
           textField.setText("");
        }
    }
}
