
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener{
    
    
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    String pinNo;
    
    public FastCash(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img2 = img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel l1 = new JLabel("Select Withdrawal amount: ");
        l1.setBounds(200,300,700,35);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(l1);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(170,415,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(170,450,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(170,485,150,30);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Rs 10000");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);
        
        b7 = new JButton("Back");
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
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        } else {
            String amount = ((JButton) e.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNo+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                        
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (e.getSource() != b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinNo+"','"+date+"','Withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+ " debited successfully");
                setVisible(false);
                new Transactions(pinNo).setVisible(true);
            } catch (Exception f) {
                System.out.println(f);
            } 
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
    
}

