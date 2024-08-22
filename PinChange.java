
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField f1,f2;
    JButton b1,b2;
    String pinNo;
    PinChange(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);
       
        JLabel l1 = new JLabel("Change your PIN:  ");
        l1.setBounds(250,280,500,35);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(l1);
        
        JLabel l2 = new JLabel("New PIN:  ");
        l2.setBounds(165,320,180,25);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(l2);
        
        f1 = new JPasswordField();
        f1.setBounds(330,320,180,25);
        f1.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(f1);
        
        JLabel l3 = new JLabel("Re-Enter New PIN:  ");
        l3.setBounds(165,360,180,25);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(l3);
        
        f2 = new JPasswordField();
        f2.setBounds(330,360,180,25);
        f2.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(f2);
        
        b1 = new JButton("Change");
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
        if (e.getSource() == b1) {
            try {
                String npin = f1.getText();
                String rpin = f2.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enetered pin does not match");
                    return;
                }
                
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter PIN");
                    return;
                }
                
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNo+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinNo+"'";
                String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pinNo+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }  
            catch (Exception f) {
                System.out.println(f);
        }
    } else {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
}
    
    
    
    
    
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
