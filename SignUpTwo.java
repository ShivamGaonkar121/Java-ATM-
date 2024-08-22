
package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField f1,f2,f5,f7,f8,f9,f10;
    JRadioButton gen1,gen2,gen3,gen4;
    JDateChooser dob;
    JButton next;
    JComboBox s1,s2,s3,s4,s5,s6;
    String formno;
    
    public SignUpTwo(String formno) {
        
        setLayout(null);
        this.formno = formno;
        JLabel personal = new JLabel("Personal Details Page 2");
        personal.setFont(new Font("Raleway", Font.BOLD, 22));
        personal.setBounds(290,80,280,40);
        add(personal);
        
        JLabel Name = new JLabel("Religion:");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(160,140,100,30);
        add(Name);
        
        String[] rel = {"Hindu","Muslim","Sikh","Christian"};
        s1 = new JComboBox(rel);
        s1.setBackground(Color.white);
        s1.setFont(new Font("Raleway", Font.BOLD, 14));
        s1.setBounds(400,140,300,30);
        add(s1);
        
        JLabel fName = new JLabel("Category: ");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(160,190,150,30);
        add(fName);
        
        String[] rel2 = {"General","OBC","SC/ST","Other"};
        s2 = new JComboBox(rel2);
        s2.setBackground(Color.white);
        s2.setFont(new Font("Raleway", Font.BOLD, 14));
        s2.setBounds(400,190,300,30);
        add(s2);
        
        JLabel DOB = new JLabel("Income");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(160,240,150,30);
        add(DOB);
        
        String[] rel3 = {"Under 1 lakh","Under 1,50,000","Under 3,00,000","Above 5,00,000"};
        s3 = new JComboBox(rel3);
        s3.setBackground(Color.white);
        s3.setFont(new Font("Raleway", Font.BOLD, 14));
        s3.setBounds(400,240,300,30);
        add(s3);
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(160,290,150,30);
        add(gender);

        JLabel em = new JLabel("Qualification");
        em.setFont(new Font("Raleway", Font.BOLD, 20));
        em.setBounds(160,320,150,30);
        add(em);
        
        String[] rel4 = {"Non-Graduate","Diploma","Bachelors","Post-Graduate"};
        s4 = new JComboBox(rel4);
        s4.setBackground(Color.white);
        s4.setFont(new Font("Raleway", Font.BOLD, 14));
        s4.setBounds(400,310,300,30);
        add(s4);
        
        JLabel ms = new JLabel("Occupation");
        ms.setFont(new Font("Raleway", Font.BOLD, 20));
        ms.setBounds(160,390,150,30);
        add(ms);
        
        String[] rel5 = {"Salaried","Un-Salaried","Business","Other"};
        s5 = new JComboBox(rel5);
        s5.setBackground(Color.white);
        s5.setFont(new Font("Raleway", Font.BOLD, 14));
        s5.setBounds(400,390,300,30);
        add(s5);
        
        JLabel addr = new JLabel("PAN");
        addr.setFont(new Font("Raleway", Font.BOLD, 20));
        addr.setBounds(160,440,150,30);
        add(addr);
        
        f7 = new JTextField();
        f7.setFont(new Font("Raleway", Font.BOLD, 14));
        f7.setBounds(400,440,300,30);
        add(f7);
        
        JLabel city = new JLabel("Aadhar Number: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(160,490,190,30);
        add(city);
        
        f8 = new JTextField();
        f8.setFont(new Font("Raleway", Font.BOLD, 14));
        f8.setBounds(400,490,300,30);
        add(f8);
        
        JLabel State = new JLabel("Senior Citizen: ");
        State.setFont(new Font("Raleway", Font.BOLD, 20));
        State.setBounds(160,540,150,30);
        add(State);
        
        gen1 = new JRadioButton("Yes");
        gen1.setBounds(400,540,60,30);
        gen1.setBackground(Color.WHITE);
        add(gen1);
        
        gen2 = new JRadioButton("No");
        gen2.setBounds(500,540,90,30);
        gen2.setBackground(Color.WHITE);
        add(gen2);
        
        ButtonGroup grp = new ButtonGroup();
        grp.add(gen1);
        grp.add(gen2);
        
        JLabel pinc = new JLabel("Existing Account: ");
        pinc.setFont(new Font("Raleway", Font.BOLD, 20));
        pinc.setBounds(160,590,180,30);
        add(pinc);
        
        gen3 = new JRadioButton("Yes");
        gen3.setBounds(400,590,60,30);
        gen3.setBackground(Color.WHITE);
        add(gen3);
        
        gen4 = new JRadioButton("No");
        gen4.setBounds(500,590,90,30);
        gen4.setBackground(Color.WHITE);
        add(gen4);
        
        ButtonGroup grp1 = new ButtonGroup();
        grp1.add(gen3);
        grp1.add(gen4);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        setTitle("Sign Up Page 2");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(350, 200);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        String religion = (String) s1.getSelectedItem();
        String category = (String) s2.getSelectedItem();
        String income = (String) s3.getSelectedItem();
        String education = (String) s4.getSelectedItem();
        String occupation = (String) s5.getSelectedItem();
        String pan = f7.getText();
        String aadharno = f8.getText();
        String formnumber = formno;
        
        String sc = null;
        if (gen1.isSelected()) {
            sc = "Yes";
        } else if (gen2.isSelected()) {
            sc = "No";
        }
        
        String sc1 = null;
        if (gen3.isSelected()) {
            sc1 = "Yes";
        } else if (gen4.isSelected()) {
            sc1 = "No";
        }

        
        try {
                Conn c = new Conn();
                String query2 = "insert into signup2 VALUES('"+formnumber+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"'"
                        + ",'"+pan+"','"+aadharno+"','"+sc+"','"+sc1+"')";
                c.s.executeUpdate(query2);
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
                
                
            
        } catch (Exception f) {
            System.out.println(f);
        }
    }
    
    public static void main(String[] args) {
        new SignUpTwo("");
    }
    
}
