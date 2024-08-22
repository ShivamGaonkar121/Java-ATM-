package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Deposit extends JFrame implements ActionListener{
    
    
    JTextField t1;
    JButton b1,b2;
    String pinNo;
    
    Deposit(String pinNo) {
        
        this.pinNo = pinNo;
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel l1 = new JLabel("Enter the amount you want to deposit:");
        l1.setFont(new Font("Raleway", Font.BOLD, 16));
        l1.setForeground(Color.white);
        l1.setBounds(170,300,400,20);
        image.add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(170,350,320,30);
        image.add(t1);
        
        b1 = new JButton("Deposit");
        b1.setBounds(355,485,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(355,520,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        setSize(900,900);
        setLocation(300,0);
        setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
            
        } else if (e.getSource() == b1) {
            String number = t1.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount to deposit");
            } try {
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinNo+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" deposited Sucessfully.");
                setVisible(false);
                new Transactions(pinNo).setVisible(true);
            } catch (Exception f) {
                System.out.println(f);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        new Deposit("");
    }
    
}
