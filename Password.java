//Huy Nguyen
//1001744707
package code6_1001744707;

import javax.swing.JOptionPane;  
import javax.swing.JFrame;
//import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password extends JFrame
{
    private final JPasswordField passwordField;
    String user_input_password ="";
    final String actual_password = "123";
    
    public Password()
    {
        super("Enter the password to continue");
        setLayout(new FlowLayout());
        passwordField = new JPasswordField(10);
        passwordField.setEchoChar('X');
        add(passwordField);
        
        EventHandler handler = new EventHandler();
        passwordField.addActionListener(handler);
    } 
    
    private class EventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == passwordField)
            {
                user_input_password = event.getActionCommand();
            }
            if(user_input_password.equals(actual_password))
            {
                setVisible(false);
                GameFrame gameframe = new GameFrame();
                gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameframe.setSize(400,400);
                gameframe.setVisible(true);
            }
            else//(user_input_password != actual_password)
            {
                JOptionPane.showMessageDialog(null,"invalid password");
            }
        }              
    }
}
