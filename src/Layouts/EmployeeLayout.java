/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author abdel
 */
public class EmployeeLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 50;
    
    public static AddNewEmployeeLayout Add_New_Employee_Layout_Object = new AddNewEmployeeLayout();
    public static SearchEmployeeLayout Search_Employee_Layout_Object = new SearchEmployeeLayout();
    public static DisplayAllEmployeesTableLayout Display_All_Employees_Table_Layout_Object;
    
    JButton Back_Button = new JButton();
    JButton Add_New_Employee_Button = new JButton("Add New Employee");
    JButton Search_Employee_Button = new JButton("Search Employee");
    JButton Display_All_Employees_Button = new JButton("Display All Employees");
    
    JLabel Background = new JLabel();

    public EmployeeLayout()
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
        
        Add_New_Employee_Button.setBounds((Frame - Width) / 2, 100, Width, Hight);
        Search_Employee_Button.setBounds((Frame - Width) / 2, 250, Width, Hight);
        Display_All_Employees_Button.setBounds((Frame - Width) / 2, 400, Width, Hight);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(Add_New_Employee_Button);
        add(Search_Employee_Button);
        add(Display_All_Employees_Button);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                LoginLayout.Modifying_Layout_Object.setVisible(true);
            }
        });
        
        Add_New_Employee_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Add_New_Employee_Layout_Object.setVisible(true);
                Add_New_Employee_Layout_Object.setResizable(false);
                Add_New_Employee_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Search_Employee_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Search_Employee_Layout_Object.setVisible(true);
                Search_Employee_Layout_Object.setResizable(false);
                Search_Employee_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Display_All_Employees_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Display_All_Employees_Table_Layout_Object = new DisplayAllEmployeesTableLayout();
                Display_All_Employees_Table_Layout_Object.setVisible(true);
                Display_All_Employees_Table_Layout_Object.setResizable(false);
                Display_All_Employees_Table_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Background.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent me)
            {
                requestFocusInWindow();
            }

            @Override
            public void mousePressed(MouseEvent me)
            {}

            @Override
            public void mouseReleased(MouseEvent me)
            {}

            @Override
            public void mouseEntered(MouseEvent me)
            {}

            @Override
            public void mouseExited(MouseEvent me)
            {}
        });
    }
}
