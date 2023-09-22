package Electricity;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JButton loginB, cancelB, signupB;
    JTextField username, password;
    Choice login;

    Login() {
        super("Login Page");
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(300, 20, 100, 20);
        add(lblUsername);

        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(300, 60, 100, 20);
        add(lblPassword);

        password = new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);

        JLabel lblLoginas = new JLabel("Login as");
        lblLoginas.setBounds(300, 100, 100, 20);
        add(lblLoginas);

        login = new Choice();
        login.add("Admin");
        login.add("Customer");
        login.setBounds(400, 100, 150, 20);
        add(login);

        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);

        loginB = new JButton("Login");
        loginB.setBounds(330, 160, 100, 20);
        loginB.addActionListener(this);
        add(loginB);

        cancelB = new JButton("Cancel");
        cancelB.setBounds(450, 160, 100, 20);
        cancelB.addActionListener(this);
        add(cancelB);

        signupB = new JButton("Sign Up");
        signupB.setBounds(390, 200, 100, 20);
        signupB.addActionListener(this);
        add(signupB);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginB) {
            String luname = username.getText();
            String lpass = password.getText();
            String luser = login.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + luname + "' and password = '" + lpass
                        + "' and usertype = '" + luser + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                     
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelB) {
            setVisible(false);
        } else if (ae.getSource() == signupB) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
