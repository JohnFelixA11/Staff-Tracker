package Employee;
import java.awt.Image;

import javax.swing.*;
public class Splash extends JFrame {
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/STAFFTRACKER.gif"));
        Image i2 = i1.getImage().getScaledInstance(700,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        setSize(700,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
