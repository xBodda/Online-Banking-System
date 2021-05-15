/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author abdel
 */
public class HR_DepartmentLayout extends JFrame
{
    int Frame =600;
     int Width = 200;
     int Hight = 50;
     
     public static CustomerLayout Customer_Layout_Object= new CustomerLayout();
     public static TransportationLayout Transportation_Layout_Object;
     public static HealthCareLayout Health_Care_Layout_Object;
     public static HR_MangersLayout HR_Mangers_Layout_Object;
     public static TrainneLayout Trainne_Layout_Object;
     
     JButton Back_Button = new JButton();
     JButton Transportation_Button = new JButton("Transportation"); 
     JButton Trainne_Button = new JButton("Trainne");
     JButton Health_Care_Button = new JButton("Health Care");
     JButton HR_Managers_Button = new JButton("HR Mangers");
     JButton Recruiter_Button = new JButton("Recruiter");
     
     JLabel Background = new JLabel();
     
    public HR_DepartmentLayout()
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
        
        Transportation_Button.setBounds((Frame-Width)/2, 100, Width,Hight);
        Trainne_Button.setBounds((Frame-Width)/2, 200, Width,Hight);
        Health_Care_Button.setBounds((Frame-Width)/2, 300, Width, Hight);
        HR_Managers_Button.setBounds((Frame-Width)/2, 400, Width,Hight);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(Transportation_Button);
        add(Health_Care_Button);
        add(HR_Managers_Button);
        add(Trainne_Button);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Customer_Layout_Object.setVisible(true);
            }
        });
     
        Transportation_Button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                setVisible(false);
                Transportation_Layout_Object= new TransportationLayout();
                Transportation_Layout_Object.setVisible(true);
                Transportation_Layout_Object.setResizable(false);
                Transportation_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Health_Care_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {  
                setVisible(false);
               Health_Care_Layout_Object= new HealthCareLayout();
               Health_Care_Layout_Object.setVisible(true);
               Health_Care_Layout_Object.setResizable(false);
               Health_Care_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        HR_Managers_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                setVisible(false);
                HR_Mangers_Layout_Object = new HR_MangersLayout();
                HR_Mangers_Layout_Object.setVisible(true);
                HR_Mangers_Layout_Object.setResizable(false);
                HR_Mangers_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Trainne_Button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                Trainne_Layout_Object = new TrainneLayout();
                Trainne_Layout_Object.setVisible(true);
                Trainne_Layout_Object.setResizable(false);
                Trainne_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
           }
        });
     }
}
