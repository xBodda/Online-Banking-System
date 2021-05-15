/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import static Layouts.AddNewCustomerLayout.Educational_State_Combo_Box;
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
public class TransportationLayout extends JFrame
{
    int Frame = 600;
    int Button_Width = 130;
    int Button_Hight = 50;
    int X = 10;
    int Y = 10;
    int Width = 200;
    int Hight = 30;
    
    public HR_DepartmentLayout HR_Department_layout_Object;
    
    JLabel Destination_Label = new JLabel("Distinations: ");
    JLabel Line_1_Label = new JLabel("Line 1:");     JLabel Line_1_dist_Label = new JLabel("Maser El Gededa"); 
    JLabel Line_2_Label = new JLabel("Line 2:");     JLabel Line_2_dist_Label = new JLabel("Nasr City"); 
    JLabel Line_3_Label = new JLabel("Line 3:");     JLabel Line_3_dist_Label = new JLabel("Obour"); 
    JLabel Line_4_Label = new JLabel("Line 4:");     JLabel Line_4_dist_Label = new JLabel("Maadi"); 
    JLabel Line_5_Label = new JLabel("Line 5:");     JLabel Line_5_dist_Label = new JLabel("Haram"); 
    JLabel Line_6_Label = new JLabel("Line 6:");     JLabel Line_6_dist_Label = new JLabel("Shobra"); 
     
    JLabel Background = new JLabel();
    JButton Back_Button = new JButton();
    
    public TransportationLayout()
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
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        Destination_Label.setBounds(0, 0,200, 150);
        Destination_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
        Destination_Label.setForeground(Color.BLACK);
        
        Line_1_Label.setBounds((Frame-Width)/5,10, 100, 300);
        Line_1_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_1_Label.setForeground(Color.BLACK);
        
        Line_2_Label.setBounds((Frame-Width)/5,60, 100, 300);
        Line_2_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_2_Label.setForeground(Color.BLACK);
        
        Line_3_Label.setBounds((Frame-Width)/5,110, 100, 300);
        Line_3_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_3_Label.setForeground(Color.BLACK);
        
        Line_4_Label.setBounds((Frame-Width)/5,160, 100, 300);
        Line_4_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_4_Label.setForeground(Color.BLACK);
        
        Line_5_Label.setBounds((Frame-Width)/5,210, 100, 300);
        Line_5_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_5_Label.setForeground(Color.BLACK);
        
        Line_6_Label.setBounds((Frame-Width)/5,260, 100, 300);
        Line_6_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_6_Label.setForeground(Color.BLACK);
        
        Line_1_dist_Label.setBounds((Frame-Width)/2, 10, 200, 300);
        Line_1_dist_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_1_dist_Label.setForeground(Color.BLACK);
        
        Line_2_dist_Label.setBounds((Frame-Width)/2,60, 100, 300);
        Line_2_dist_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_2_dist_Label.setForeground(Color.BLACK);
        
        Line_3_dist_Label.setBounds((Frame-Width)/2,110, 100, 300);
        Line_3_dist_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_3_dist_Label.setForeground(Color.BLACK);
        
        Line_4_dist_Label.setBounds((Frame-Width)/2,170, 100, 300);
        Line_4_dist_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_4_dist_Label.setForeground(Color.BLACK);
        
        Line_5_dist_Label.setBounds((Frame-Width)/2,220, 100, 300);
        Line_5_dist_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_5_dist_Label.setForeground(Color.BLACK);
        
        Line_6_dist_Label.setBounds((Frame-Width)/2,270, 100, 300);
        Line_6_dist_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Line_6_dist_Label.setForeground(Color.BLACK);
        
        
        add(Back_Button);
        add(Destination_Label);
        add(Line_1_Label);
        add(Line_2_Label);
        add(Line_3_Label);
        add(Line_4_Label);
        add(Line_5_Label);
        add(Line_6_Label);
        add(Line_1_dist_Label);
        add(Line_2_dist_Label);
        add(Line_3_dist_Label);
        add(Line_4_dist_Label);
        add(Line_5_dist_Label);
        add(Line_6_dist_Label);
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
