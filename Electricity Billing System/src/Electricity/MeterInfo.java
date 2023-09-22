package Electricity;

import java.awt.BorderLayout;
import java.awt.Choice;
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

public class MeterInfo extends JFrame implements ActionListener {

    JTextField tfaddress, tfcity, tfstate, tfemail, tfphone;
    JButton submit, cancel;
    JLabel lblmeterno;
    Choice meterlocation, metertype, phasecode,billtype;
    String meter;
    MeterInfo(String meternumb) {
        this.meter=meternumb;
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(heading);
        // Meter Number
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 80, 100, 20);
        p.add(lblmeter);

        JLabel lblmeterno = new JLabel(meternumb);
        lblmeterno.setBounds(200, 80, 100, 20);
        p.add(lblmeterno);

        JLabel lblLocation = new JLabel("Meter Location");
        lblLocation.setBounds(100, 120, 100, 20);
        p.add(lblLocation);

        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(200, 120, 200, 20);
        p.add(meterlocation);

        JLabel lblmetertype = new JLabel("Meter Type");
        lblmetertype.setBounds(100, 160, 100, 20);
        p.add(lblmetertype);

        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(200, 160, 200, 20);
        p.add(metertype);

        JLabel lblphasecode = new JLabel("Meter Code");
        lblphasecode.setBounds(100, 200, 100, 20);
        p.add(lblphasecode);

        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(200,200,200,20);
        p.add(phasecode);

        // Bill Type
        JLabel lblbilltype = new JLabel("Bill Type");
        lblbilltype.setBounds(100, 240, 100, 20);
        p.add(lblbilltype);

        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(200, 240, 200, 20);
        p.add(billtype);
        
        JLabel lblday = new JLabel("Days");
        lblday.setBounds(100, 280, 100, 20);
        p.add(lblday);

        JLabel lbldays = new JLabel("30 Days");
        lbldays.setBounds(200, 280, 100, 20);
        p.add(lbldays);

        JLabel lblnote = new JLabel("Note");
        lblnote.setBounds(100, 320, 100, 20);
        p.add(lblnote);

        JLabel lblnote2 = new JLabel("By default bill is calculated for 30 days");
        lblnote2.setBounds(200, 320, 500, 20);
        p.add(lblnote2);
        
        submit = new JButton("Submit");
        submit.setBounds(120, 390, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String smeter = meter;
            String slocation=meterlocation.getSelectedItem();
            String stype = metertype.getSelectedItem();
            String scode=phasecode.getSelectedItem();
            String sbilltype=billtype.getSelectedItem();
            String days="30";
            
            String query = "insert into meter_info values('"+smeter+"','"+slocation+"','"+stype+"','"+scode+"','"+sbilltype+"','"+days+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Meter information added successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
    }

    public static void main(String[] args) {
        new MeterInfo("");
    }
}
