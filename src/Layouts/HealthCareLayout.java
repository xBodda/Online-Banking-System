/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author abdel
 */
public class HealthCareLayout extends JFrame
{
    int Frame =600;
    int Width = 200;
    int Hight = 50;
    
    public HR_DepartmentLayout HR_Department_layout_Object;
     
    JLabel Doctors_name_label = new  JLabel("Doctor's Names:");       JLabel DR_1 = new JLabel("DR Abdelrahman Sayed");               JLabel DR_2 = new JLabel("DR Kareem Yasser");
    JLabel Near_Hospitals_Label = new JLabel ("Nearby Hospiatls:");    JLabel hospital_1 = new JLabel("EL Nozha Hospital");   JLabel hospital_2 = new JLabel("EL Galaa Hospital");
    
    JLabel Background = new JLabel();
    JButton Back_Button = new JButton();
     public HealthCareLayout()
     {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Frame, Frame);
        setLayout(null);
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        Doctors_name_label.setBounds(0, 50, Width, Hight);
        Doctors_name_label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Doctors_name_label.setForeground(Color.BLACK);
        
        DR_1.setBounds(100,100, Width, Hight);
        DR_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        DR_1.setForeground(Color.BLACK);
        
        DR_2.setBounds(300,100, Width, Hight);
        DR_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        DR_2.setForeground(Color.BLACK);
        
        Near_Hospitals_Label.setBounds(10,200, Width, Hight);
        Near_Hospitals_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Near_Hospitals_Label.setForeground(Color.BLACK);
        
        hospital_1.setBounds(50, 250, Width, Hight);
        hospital_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        hospital_1.setForeground(Color.BLACK);
        
        hospital_2.setBounds(300,250, Width, Hight);
        hospital_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        hospital_2.setForeground(Color.BLACK);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(Doctors_name_label);
        add(DR_1);
        add(DR_2);
        add(Near_Hospitals_Label);
        add(hospital_1);
        add(hospital_2);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                setVisible(false);
                HR_Department_layout_Object = new HR_DepartmentLayout();
                HR_Department_layout_Object.setVisible(true);
                HR_Department_layout_Object.setResizable(false);
                HR_Department_layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                
            }
        });
     }
    
}
