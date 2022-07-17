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
        functionButtons[0] = subButton;
        functionButtons[1] = multiplyButton;
        functionButtons[2] = divideButton;
        functionButtons[3] = decimalButton;
        functionButtons[4] = equalButton;
        functionButtons[5] = deleteButton;
        functionButtons[6] = clearButton;

        for (int i = 0; i < functionButtons.length ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }



        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
