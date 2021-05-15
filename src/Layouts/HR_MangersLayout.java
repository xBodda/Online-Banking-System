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
public class HR_MangersLayout extends JFrame
{
    int Frame = 600;
    int Hight = 30;
    
    public static HR_DepartmentLayout HR_Department_layout_Object;
    
    JLabel Owner_1 = new JLabel("Abdelrahman Sayed");
    JLabel Background = new JLabel();
    
    JButton Back_Button = new JButton();
    
    public HR_MangersLayout()
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
        
        Owner_1.setBounds(120,100, 400, Hight);
        Owner_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
        Owner_1.setForeground(Color.BLACK);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(Owner_1);
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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       }
           });
    }
}
