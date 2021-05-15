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
public class TrainneLayout extends JFrame
{
    int Frame = 600;
    
    public static HR_DepartmentLayout HR_Department_layout_Object;
    
    JLabel Requirement_Label = new JLabel(" Requirement for trainning");
    JLabel Needs_Label = new JLabel(" A trainne MUST be familiar with: ");
    JLabel Requirements_needed_Label_1 = new JLabel("1-Accounting");
    JLabel Requirements_needed_Label_2 = new JLabel("2-Marketing");
    JLabel Requirements_needed_Label_3 = new JLabel("3-Human resources");
    JLabel Requirements_needed_Label_4 = new JLabel("4-Business mathematics");
    JLabel Mustbe_Label =new JLabel("MUST finish 1st year in collage or Gaduate");
    
    JLabel Background = new JLabel();
    JButton Back_Button = new JButton();
    
    public TrainneLayout()
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
        
        Requirement_Label.setBounds(0,0, 400, 100);
        Requirement_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Requirement_Label.setForeground(Color.BLACK);
        
        Needs_Label.setBounds(100, 50, 400, 100);
        Needs_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Needs_Label.setForeground(Color.BLACK);
        
        Requirements_needed_Label_1.setBounds(150, 100, 400, 100);
        Requirements_needed_Label_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Requirements_needed_Label_1.setForeground(Color.BLACK);
        
        Requirements_needed_Label_2.setBounds(150, 150, 400, 100);
        Requirements_needed_Label_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Requirements_needed_Label_2.setForeground(Color.BLACK);
        
        Requirements_needed_Label_3.setBounds(150, 200, 400, 100);
        Requirements_needed_Label_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Requirements_needed_Label_3.setForeground(Color.BLACK);
        
        Requirements_needed_Label_4.setBounds(150, 250, 400, 100);
        Requirements_needed_Label_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Requirements_needed_Label_4.setForeground(Color.BLACK);
        
        Mustbe_Label.setBounds(10,250, 500, 100);
        Mustbe_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD,20));
        Mustbe_Label.setForeground(Color.BLACK);
        
        add(Back_Button);
        add(Requirement_Label);
        add(Needs_Label);
        add(Requirements_needed_Label_1);
        add(Requirements_needed_Label_2);
        add(Requirements_needed_Label_3);
        add(Requirements_needed_Label_3);
        add(Mustbe_Label);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
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
