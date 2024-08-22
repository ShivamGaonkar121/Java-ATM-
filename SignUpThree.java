
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    public SignUpThree(String formno) {
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page: 3 Account Settings");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel l2 = new JLabel("Account Type");
        l2.setFont(new Font("Raleway", Font.BOLD,22));
        l2.setBounds(100,140,200,30);
        add(l2);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD,18));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,180,20);
        add(r1);
        
        r2 = new JRadioButton("FD Account");
        r2.setFont(new Font("Raleway", Font.BOLD,18));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,180,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,18));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,180,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway", Font.BOLD,18));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,200,20);
        add(r4);
        
        ButtonGroup grp = new ButtonGroup();
        grp.add(r1);
        grp.add(r2);
        grp.add(r3);
        grp.add(r4);
        
        JLabel l3 = new JLabel("Card Number");
        l3.setFont(new Font("Raleway", Font.BOLD,22));
        l3.setBounds(100,300,200,30);
        add(l3);
        
        JLabel l4 = new JLabel("XXXX-XXXX-XXXX-3196");
        l4.setFont(new Font("Raleway", Font.BOLD,22));
        l4.setBounds(330,300,300,30);
        add(l4);
        
        JLabel l7 = new JLabel("Your 16 Digit Card Number");
        l7.setFont(new Font("Raleway", Font.BOLD,12));
        l7.setBounds(100,330,300,30);
        add(l7);
        
        JLabel l5 = new JLabel("PIN: ");
        l5.setFont(new Font("Raleway", Font.BOLD,22));
        l5.setBounds(100,370,200,30);
        add(l5);
        
        JLabel l6 = new JLabel("XXXX");
        l6.setFont(new Font("Raleway", Font.BOLD,22));
        l6.setBounds(330,370,300,30);
        add(l6);
        
        JLabel l8 = new JLabel("Your 4 Digit Pin Number");
        l8.setFont(new Font("Raleway", Font.BOLD,12));
        l8.setBounds(100,400,300,30);
        add(l8);
        
        JLabel l9 = new JLabel("Services Required:");
        l9.setFont(new Font("Raleway", Font.BOLD,22));
        l9.setBounds(100,450,250,30);
        add(l9);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,230,30);
        add(c3);
        
        c4 = new JCheckBox("Email Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I Hereby Declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,680,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE);
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accType = null; 
            if (r1.isSelected()) {
                accType = "Savings Account";
            } else if (r2.isSelected()) {
                accType = "FD Account";
            } else if (r3.isSelected()) {
                accType = "Current Account";
            } else if (r4.isSelected()) {
                accType = "Recurring Account";
            }
            
            Random rand = new Random();
            String cardno = "" + Math.abs((rand.nextLong()% 90000000L) + 5040936000000000L);
            String pinno = "" + Math.abs((rand.nextLong()% 9000L) + 1000L);
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }
            
            try {
                if (accType == null) {
                    JOptionPane.showMessageDialog(null,"No Detail Entered");
                } else {
                    Conn conn = new Conn();
                    String query = "insert into signup3 values ('"+formno+"','"+accType+"','"+cardno+"','"+pinno+"','"+facility+"')";
                    String query1 = "insert into login values ('"+formno+"','"+cardno+"','"+pinno+"')";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"CardNumber: " + cardno + "\n PinNumber: " + pinno);
                    
                    setVisible(false);
                    new Deposit(pinno).setVisible(false);
                }
            } catch (Exception f) {
                System.out.println(f);
            }
            
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
            
        }
        
    }
    
    public static void main(String[] args) {
        new SignUpThree("");
    }
    
}
