import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Calculator.
 *
 * @Yu Huai Cui (Daniel)
 * @1.0
 */

public class CalculatorTab implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, multiButton, divButton;
    JButton deciButton, equalsButton, delButton, clearButton, negativeButton;
    JPanel panel;
    
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    
    
    CalculatorTab() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("/");
        deciButton = new JButton(".");
        equalsButton = new JButton("=");
        delButton = new JButton("DEL");
        clearButton = new JButton("CE");
        negativeButton = new JButton("(-)");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = deciButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;
        
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        
        //Setting location of delete, clear, and negative buttons
        negativeButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);
        
        //Creating the grid
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        
        //Adding buttons to the grid
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
        panel.add(multiButton);
        panel.add(deciButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divButton);
        
        //adding the grid buttons and the clear and delete buttons to the frame
        frame.add(panel);
        frame.add(negativeButton);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(Integer.toString(i)));
            }
        }
        
        if(e.getSource() == deciButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        
        if(e.getSource() == multiButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        
        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator) {
                case'+':
                    result = num1+num2;
                    break;
                case'-':
                    result = num1-num2;
                    break;
                case'*':
                    result = num1*num2;
                    break;
                case'/':
                    result = num1/num2;
                    break;
            }
            textfield.setText(Double.toString(result));
            num1 = result;
        }
        
        if(e.getSource() == clearButton) {
            textfield.setText("");
        }
        
        if(e.getSource() == delButton) {
            String str = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < str.length()-1; i++) {
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }
        
        if(e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(Double.toString(temp));
        }
    }
} // End of Calculator class

