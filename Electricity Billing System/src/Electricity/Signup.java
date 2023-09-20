package Electricity;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField username,name,meter,password;
    Choice accountType;
    Signup() {
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(new Color(102, 0, 51));
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        // panel.setBackground(new Color(160, 160, 160));
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 102)), "Create Acount"));
        add(panel);

        JLabel heading = new JLabel("Create Account as");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.DARK_GRAY);
        // heading.setFont(new Font("Autumn",Font.BOLD,14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.DARK_GRAY);
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        panel.add(meter);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.DARK_GRAY);
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.DARK_GRAY);
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.DARK_GRAY);
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);

        create = new JButton("Create");
        create.setBackground(new Color(0, 0, 102));
        create.setForeground(Color.WHITE);
        create.setBounds(140,250,120,30);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 102));
        back.setForeground(Color.WHITE);
        back.setBounds(340,250,120,30);
        back.addActionListener(this);
        panel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String atype=accountType.getSelectedItem();
            String uname=username.getText();
            String sname=name.getText();
            String pass=password.getText();
            String met=meter.getText();

            try {
                Conn c = new Conn();
                String query = "insert into login values('"+met+"','"+uname+"','"+sname+"','"+pass+"','"+atype+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account created successfully");
                setVisible(false);
                new Login();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
