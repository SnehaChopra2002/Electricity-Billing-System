package Electricity;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable {
    Thread t;
    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        JLabel image = new JLabel(i1);
        add(image);

        setVisible(true);
        
        for (int i = 1,j=1; i <= 576&&j<=451; i++,j++) {
            setSize(i, j);
            setLocation(700, 100);
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public void run(){
        try {
            Thread.sleep(2000);
            setVisible(false);

            // LoginFrame
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
