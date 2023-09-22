package Electricity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewCustomer extends JFrame implements ActionListener {

    JTextField tfname, tfaddress, tfcity, tfstate, tfemail, tfphone;
    JButton next, cancel;
    JLabel lblmeterno;
    NewCustomer() {
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(heading);
        // Name
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 80, 200, 20);
        p.add(tfname);
        // Meter
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 120, 100, 20);
        p.add(lblmeter);

        lblmeterno = new JLabel("");
        lblmeterno.setBounds(200, 120, 100, 20);
        p.add(lblmeterno);

        Random rand = new Random();
        long number = Math.abs(rand.nextLong() % 1000000);
        lblmeterno.setText(Long.toString(number));
        // Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 160, 200, 20);
        p.add(tfaddress);
        // City
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(200, 200, 200, 20);
        p.add(tfcity);
        // State
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(200, 240, 200, 20);
        p.add(tfstate);
        // Email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 280, 200, 20);
        p.add(tfemail);
        // Phone Number
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(100, 320, 100, 20);
        p.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 320, 200, 20);
        p.add(tfphone);

        next = new JButton("Next");
        next.setBounds(120, 390, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String name = tfname.getText();
            String meter = lblmeterno.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phoneno = tfphone.getText();

            String query1="insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phoneno+"')";
            String query2="insert into login values('"+meter+"','','"+name+"','','')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Details added successfully");
                setVisible(false);

                // new Frame
                new MeterInfo(meter);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Project();
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
