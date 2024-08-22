
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinNo;
    JButton b1,b2;
    BalanceEnquiry(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);
        
        b2 = new JButton("Back");
        b2.setBounds(355,520,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNo+"'");
            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));

                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            } catch (Exception f) {
                    System.out.println(f);
                    }
            
        JLabel l1 = new JLabel("Your current balance is:  " + balance);
        l1.setBounds(170,300,400,30);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(l1);        
        
        
        setSize(900,900);
        setLocation(300,0);
        setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinNo).setVisible(true);
        
    }
        
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    
}
