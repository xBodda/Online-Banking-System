
package Layouts;

/**
 *
 * @author abdel
 */


import BDA.OnlineBanking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PieChartLayout extends JFrame 
{
    private Font font;

    public static ModifyingLayout Modifying_Layout_Object;

    double Number_Of_Employees= OnlineBanking.Employee_Array_List.size();
    double Number_Of_Customers= OnlineBanking.Customer_Array_List.size();
    double total=Number_Of_Employees + Number_Of_Customers;
    int Angle_Of_Employees= (int)(Number_Of_Employees*360.0/total);
    int Angle_Of_Customers= (int)(Number_Of_Customers*360.0/total);
    int Percentage_Of_Employees= (int) (Number_Of_Employees*100.0/total);
    int Percentage_Of_Customers= (int) (Number_Of_Customers*100.0/total);
    JButton Back_Button = new JButton();
    JLabel Per1 ;
    JLabel Background = new JLabel();
    public PieChartLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Client");
        setSize(600, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
//        
//        
//        Per1 = new JLabel("Percentage of customers : "+Percentage_Of_Customers+"%");
//        Per1.setBounds(50, 100, 300, 30);
//        add(Per1);
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Modifying_Layout_Object = new ModifyingLayout();
                Modifying_Layout_Object.setVisible(true);
                Modifying_Layout_Object.setResizable(false);
                Modifying_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        addMouseListener(new MouseListener()
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
        add(Back_Button);
        
    }
    @Override
    public void paint( Graphics g )
    {
      font = new Font("Sanserif", Font.BOLD, 18);
      g.setColor( Color.black );
      g.fillArc( 110, 80, 300, 300, 0,Angle_Of_Employees );
      g.drawString("Percentage Of Employees : "+Percentage_Of_Employees+"%", 200, 410);
      g.setColor( Color.red );
      g.fillArc( 110, 80, 300, 300,Angle_Of_Employees,Angle_Of_Customers  );
      g.drawString("Percentage Of Customers : "+Percentage_Of_Customers+"%", 200, 450);
     
    }
    
}
