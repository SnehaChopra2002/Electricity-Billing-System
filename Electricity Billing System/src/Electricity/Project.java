package Electricity;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    JMenuItem calcbill,newcustomer ;
    Project() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        mb.add(master);
        // New Customer
        newcustomer = new JMenuItem("New Customer");

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));

        newcustomer.setMnemonic('D');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

        newcustomer.addActionListener(this);
        master.add(newcustomer);
        
        // Customer details
        JMenuItem customerdetails =new JMenuItem("Customer Details");
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));

        customerdetails.setMnemonic('E');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        master.add(customerdetails);

        // Deposit Details
        JMenuItem depositdetails = new JMenuItem("Deposit Details");

        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));

        depositdetails.setMnemonic('F');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        master.add(depositdetails);

        // Calculate Bill
        calcbill = new JMenuItem("Calculate Bill");

        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4 =icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calcbill.setIcon(new ImageIcon(image4));

        calcbill.setMnemonic('G');
        calcbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));

        calcbill.addActionListener(this);
        master.add(calcbill);

        setLayout(new FlowLayout());

        setVisible(true);

        // Menu 2
        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        mb.add(info);

        JMenuItem updateinfo = new JMenuItem("Update Information");

        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 =icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(image5));

        updateinfo.setMnemonic('H');
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        info.add(updateinfo);

        // View Information
        JMenuItem viewinfo = new JMenuItem("View Information");

        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 =icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image6));

        viewinfo.setMnemonic('I');
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        info.add(viewinfo);

        //  Menu 3
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        mb.add(user);

        // Pay Bill
        JMenuItem paybill = new JMenuItem("Pay Bill");

        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 =icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));

        paybill.setMnemonic('J');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");

        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8 =icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));

        billdetails.setMnemonic('K');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        user.add(billdetails);

        //  Menu 4
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        mb.add(report);
        
        // generate bill
        JMenuItem generatebill = new JMenuItem("Generate Bill");

        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 =icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));

        generatebill.setMnemonic('L');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        report.add(generatebill);

        //  Menu 5
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);
        
        // notepad
        JMenuItem notepad = new JMenuItem("NotePad");

        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image12 =icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image12));

        notepad.setMnemonic('M');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        // notepad
        JMenuItem calculator = new JMenuItem("Calculator");

        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image10 =icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image10));

        calculator.setMnemonic('N');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        user.add(calculator);

        // notepad
        JMenuItem exit = new JMenuItem("Exit");

        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image11 =icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image11));

        exit.setMnemonic('W');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        utility.add(exit);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==calcbill){
            new CalcBill();
        }
        else if(ae.getSource()==newcustomer){
            new NewCustomer();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
