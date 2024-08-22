
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Transactions extends JFrame implements ActionListener{
    
    
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    String pinNo;
    
    public Transactions(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel l1 = new JLabel("Please select your transaction: ");
        l1.setBounds(200,300,700,35);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(l1);
        
        b1 = new JButton("Deposit");
        b1.setBounds(170,415,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Cash Withdrawal");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Fast Cash");
        b3.setBounds(170,450,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Mini Statement");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Pin Change");
        b5.setBounds(170,485,150,30);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Balance Enquiry");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);
        
        b7 = new JButton("Exit");
        b7.setBounds(355,520,150,30);
        b7.addActionListener(this);
        image.add(b7);
        
        setSize(900,900);
        setLocation(300,0);
        setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            System.exit(0);
        } else if (e.getSource() == b1) {
            setVisible(false);
            new Deposit(pinNo).setVisible(true);
        } else if (e.getSource() == b2) {
            setVisible(false);
            new Withdraw(pinNo).setVisible(true);
        } else if (e.getSource() == b3) {
            setVisible(false);
            new FastCash(pinNo).setVisible(true);
        }  else if (e.getSource() == b5) {
            setVisible(false);
            new PinChange(pinNo).setVisible(true);
        }  else if (e.getSource() == b6) {
            setVisible(false);
            new BalanceEnquiry(pinNo).setVisible(true);
        }  else if (e.getSource() == b4) {
            setVisible(false);
            new MiniStatement(pinNo).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
    
}
