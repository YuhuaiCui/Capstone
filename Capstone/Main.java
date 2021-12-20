import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Control Center of App :3
 *
 * @Yu Huai Cui
 * @1.0
 */
public class Main {
    public static void main (String[] args) {
        new Main();
        CalculatorTab calc = new CalculatorTab();
    }
    
    public Main() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFocusable(false);
        frame.add(tabbedPane);
        
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel("TEST");
        JLabel label3 = new JLabel("This is tab 3!!!");
        
        tabbedPane.add("Calculator", label1);
        tabbedPane.add("2", label2);
        tabbedPane.add("3", label3);
        
        frame.setVisible(true);
    }
}

