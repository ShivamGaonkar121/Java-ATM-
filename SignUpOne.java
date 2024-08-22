
package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
    

public class SignUpOne extends JFrame implements ActionListener{

    long number;
    JTextField f1,f2,f5,f7,f8,f9,f10;
    JRadioButton gen1,gen2,ms1,ms2,ms3;
    JDateChooser dob;
    JButton next;
    
    SignUpOne() {
        Random random = new Random();
        number = Math.abs((random.nextLong() % 9000L) + 1000L);
        
        JLabel appno = new JLabel("Application Form No: " + number);
        appno.setFont(new Font("Arial", Font.BOLD, 38));
        appno.setForeground(Color.RED);
        appno.setBounds(160,40,600,40);
        add(appno);
        
        
        JLabel personal = new JLabel("Personal Details Page 1");
        personal.setFont(new Font("Raleway", Font.BOLD, 22));
        personal.setBounds(290,80,290,40);
        add(personal);
        
        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(160,140,100,30);
        add(Name);
        
        f1 = new JTextField();
        f1.setFont(new Font("Raleway", Font.BOLD, 14));
        f1.setBounds(400,140,300,30);
        add(f1);
        
        JLabel fName = new JLabel("Father's Name: ");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(160,190,150,30);
        add(fName);
        
        f2 = new JTextField();
        f2.setFont(new Font("Raleway", Font.BOLD, 14));
        f2.setBounds(400,190,300,30);
        add(f2);
        
        JLabel DOB = new JLabel("Date of Birth: ");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(160,240,150,30);
        add(DOB);
        
        dob = new JDateChooser();
        dob.setBounds(400,240,300,30);
        add(dob);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(160,290,150,30);
        add(gender);
        
        gen1 = new JRadioButton("Male");
        gen1.setBounds(400,290,60,30);
        gen1.setBackground(Color.WHITE);
        add(gen1);
        
        gen2 = new JRadioButton("Female");
        gen2.setBounds(500,290,90,30);
        gen2.setBackground(Color.WHITE);
        add(gen2);
        
        ButtonGroup grp = new ButtonGroup();
        grp.add(gen1);
        grp.add(gen2);
        
        JLabel em = new JLabel("Email Address: ");
        em.setFont(new Font("Raleway", Font.BOLD, 20));
        em.setBounds(160,340,150,30);
        add(em);
        
        f5 = new JTextField();
        f5.setFont(new Font("Raleway", Font.BOLD, 14));
        f5.setBounds(400,340,300,30);
        add(f5);
        
        JLabel ms = new JLabel("Marital Status: ");
        ms.setFont(new Font("Raleway", Font.BOLD, 20));
        ms.setBounds(160,390,150,30);
        add(ms);
        
        ms1 = new JRadioButton("Married");
        ms1.setBounds(400,390,70,30);
        ms1.setBackground(Color.WHITE);
        add(ms1);
        
        ms2 = new JRadioButton("Single");
        ms2.setBounds(500,390,90,30);
        ms2.setBackground(Color.WHITE);
        add(ms2);
        
        ms3 = new JRadioButton("Other");
        ms3.setBounds(600,390,90,30);
        ms3.setBackground(Color.WHITE);
        add(ms3);
        
        ButtonGroup grp1 = new ButtonGroup();
        grp1.add(ms1);
        grp1.add(ms2);
        grp1.add(ms3);
        
        JLabel addr = new JLabel("Adddress: ");
        addr.setFont(new Font("Raleway", Font.BOLD, 20));
        addr.setBounds(160,440,150,30);
        add(addr);
        
        f7 = new JTextField();
        f7.setFont(new Font("Raleway", Font.BOLD, 14));
        f7.setBounds(400,440,300,30);
        add(f7);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(160,490,150,30);
        add(city);
        
        f8 = new JTextField();
        f8.setFont(new Font("Raleway", Font.BOLD, 14));
        f8.setBounds(400,490,300,30);
        add(f8);
        
        JLabel State = new JLabel("State: ");
        State.setFont(new Font("Raleway", Font.BOLD, 20));
        State.setBounds(160,540,150,30);
        add(State);
        
        f9 = new JTextField();
        f9.setFont(new Font("Raleway", Font.BOLD, 14));
        f9.setBounds(400,540,300,30);
        add(f9);
        
        JLabel pinc = new JLabel("Pin Code: ");
        pinc.setFont(new Font("Raleway", Font.BOLD, 20));
        pinc.setBounds(160,590,150,30);
        add(pinc);
        
        f10 = new JTextField();
        f10.setFont(new Font("Raleway", Font.BOLD, 14));
        f10.setBounds(400,590,300,30);
        add(f10);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        setLayout(null);
        setTitle("Sign Up Page 1");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent e) {
        String formnumber = "" + number;
        String name = f1.getText();
        String fname = f2.getText();
        String dob1 = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (gen1.isSelected()) {
            gender = "Male";
            
        } else if (gen2.isSelected()) {
            gender = "Female";
        } else {
            gender = "Other";
        }
        String email = f5.getText();
        String ms = null;
        if (ms1.isSelected()) {
            ms = "Married";
        } else if (ms2.isSelected()) {
            ms = "Single";
        } else {
            ms = "other";
        }
        String address = f7.getText();
        String city = f8.getText();
        String state = f9.getText();
        String pin = f10.getText();
        
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null,"Please enter your Name");
            } else {
                Conn c = new Conn();
                String query = "insert into signup VALUES('"+formnumber+"','"+name+"','"+fname+"','"+dob1+"','"+gender+"','"+email+"'"
                        + ",'"+ms+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formnumber).setVisible(true);
            }
        } catch (Exception f) {
            System.out.println(f);
        }
        
        
    }
    
    public static void main(String[] args) {
        new SignUpOne();
    }
    
}
