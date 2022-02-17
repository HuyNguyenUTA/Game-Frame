//Huy Nguyen
//1001744707
package code6_1001744707;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class GameFrame extends JFrame
{
    private final JLabel label1;
    private final JButton OKButton;
    private final JButton CancelButton;
    private final JTextField textField1;
    String CCName = "";
    
    public GameFrame()
    {
        super("What is this ?");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Random rand = new Random();
        switch(rand.nextInt(4)+1)
        {
            case 1:
                CCName = "texas";
                break;
            case 2:
                CCName = "dog";
                break;
            case 3:
                CCName = "cat";
                break;
            case 4:
                CCName = "uta";
                break;
        }
        Icon CC = new ImageIcon(getClass().getResource(CCName + ".png"));
        label1 = new JLabel("Label with text and icon", CC, SwingConstants.CENTER);
        label1.setToolTipText("This is label1");
        add(label1);
        
        EventHandler handler = new EventHandler();
        textField1 = new JTextField(10);
        textField1.selectAll();
        textField1.addActionListener(handler);
        add(textField1);
        
        OKButton = new JButton("OK");
        OKButton.addActionListener(handler);
        add(OKButton);
        
        CancelButton = new JButton("Cancel");
        CancelButton.addActionListener(handler);
        add(CancelButton);
    }
    
    private class EventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String string ="";
            boolean b = false;
            if(CCName.equalsIgnoreCase(textField1.getText()))
            {
                string = String.format("correctly phrase");
                b=true;
            }
            else
            {
                string = String.format("incorrectly phrase"); 
            }
            if(event.getSource() == OKButton || event.getSource() == textField1)
            {
                JOptionPane.showMessageDialog(null, string);
                if(b==true)
                {
                    System.exit(0);
                }
            }
            else if(event.getSource() == CancelButton)
            {
                System.exit(0);
            }
        }
    }
}
