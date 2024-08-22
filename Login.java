
package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton clear,sign,sign_up;
    JTextField card;
    JPasswordField pin1;
    public Login() {
        setTitle("Automated Teller Machine - SG");
        setLayout(null);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/Initials.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label = new JLabel(icon3);
        label.setBounds(70, 30, 100, 100);
        add(label);
        
        JLabel welcome = new JLabel("Welcome to SG ATM");
        welcome.setBounds(200, 50, 400, 40);
        welcome.setFont(new Font("SANS-SERIF", Font.BOLD, 38));
        add(welcome);
        
        JLabel cardno = new JLabel("Enter Card No: ");
        cardno.setBounds(120, 150, 150, 30);
        cardno.setFont(new Font("SANS-SERIF", Font.BOLD, 20));
        add(cardno);
        
        card = new JTextField();
        card.setBounds(300, 150, 250, 30);
        card.setFont(new Font("Arial",Font.BOLD,14));
        add(card);
        
        JLabel pin = new JLabel("Enter Your PIN:");
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("SANS-SERIF", Font.BOLD, 20));
        add(pin);
        
        pin1 = new JPasswordField();
        pin1.setBounds(300, 220, 250, 30);
        pin1.setFont(new Font("Arial",Font.BOLD,14));
        add(pin1);
        
        sign = new JButton("Sign In");
        sign.addActionListener(this);
        sign.setBounds(200, 300, 100, 30);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        add(sign);
        
        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setBounds(350, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        
        sign_up = new JButton("Sign Up");
        sign_up.addActionListener(this);
        sign_up.setBounds(500, 300, 100, 30);
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.WHITE);
        add(sign_up);
     
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,400);
        setVisible(true);
        setLocation(350, 200);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==clear) {
            pin1.setText("");
            card.setText("");
        } else if (e.getSource()==sign) {
            Conn conn = new Conn();
            String cardno = card.getText();
            String pinNumber = pin1.getText();
            String query = "select * from login where cardnumber = '"+cardno+"'and pinnumber = '"+pinNumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            } catch (Exception g) {
                System.out.println(g);
            }
        } else if (e.getSource()==sign_up) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
            
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}
