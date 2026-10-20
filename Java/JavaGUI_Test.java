import javax.swing.*;
import java.awt.*;

public class JavaGUI_Test {
    public static void main(String[] args) {
         JFrame frame = new JFrame("My first GUI");

         frame.setSize(1000,500);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLocationRelativeTo(null);

         JLabel label = new JLabel("Welcome to Java GUI", SwingConstants.CENTER);

         JButton button = new JButton("Click Me");

         button.addActionListener(e -> label.setText("It Works!!"));

         frame.setLayout(new BorderLayout());
         frame.add(label,BorderLayout.CENTER);
         frame.add(button,BorderLayout.NORTH);

         frame.setVisible(true);
    }
}