package Electricity;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcBill extends JFrame implements ActionListener {
    Choice meter, month;
    JLabel name;
    JTextField unitsconsumed;
    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    JButton submit, cancel;

    CalcBill() {

        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.add(heading);
        // meter number
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 80, 100, 20);
        p.add(lblmeter);

        meter = new Choice();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                meter.add(rs.getString("mere_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        meter.setBounds(200, 80, 200, 20);
        p.add(meter);
        // Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 120, 100, 20);
        p.add(lblname);

        name = new JLabel();
        name.setBounds(200, 120, 200, 20);
        p.add(name);
        // Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        JLabel address = new JLabel();
        address.setBounds(200, 160, 200, 20);
        p.add(address);

        meter.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where mere_no='" + meter.getSelectedItem() + "'");
                    while (rs.next()) {
                        name.setText(rs.getString("name"));
                        address.setText(rs.getString("address"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // Units Consumed
        JLabel lblunitsconsumed = new JLabel("Units Consumed");
        lblunitsconsumed.setBounds(100, 200, 100, 20);
        p.add(lblunitsconsumed);

        unitsconsumed = new JTextField();
        unitsconsumed.setBounds(200, 200, 200, 20);
        p.add(unitsconsumed);

        // Month
        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(100, 240, 100, 20);
        p.add(lblmonth);

        month = new Choice();
        month.setBounds(200, 240, 200, 20);
        for (int i = 0; i < months.length; i++) {
            month.add(months[i]);
        }
        p.add(month);

        submit = new JButton("Submit");
        submit.setBounds(120, 300, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 300, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String meterno = meter.getSelectedItem();
            String units = unitsconsumed.getText();
            String smonth = month.getSelectedItem();

            int totbill = 0;
            int units_consumed = Integer.parseInt(units);
            String query = "select * from tax";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    totbill += units_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totbill += Integer.parseInt(rs.getString("meter_rent"));
                    totbill += Integer.parseInt(rs.getString("service_charge"));
                    totbill += Integer.parseInt(rs.getString("service_tax"));
                    totbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totbill += Integer.parseInt(rs.getString("fixed_value"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Conn c = new Conn();
                String query2="insert into bill values('"+meterno+"','"+smonth+"','"+units+"','"+totbill+"','Not Paid')";
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalcBill();
    }
}
