
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
public class CustomerLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 50;
    
    public static AddNewCustomerLayout Add_New_Customer_Layout_Object = new AddNewCustomerLayout();
    public static SearchCustomerLayout Search_Customer_Layout_Object = new SearchCustomerLayout();
    public static DisplayAllCustomersTableLayout Display_All_Customers_Table_Layout_Object;
    public static HR_DepartmentLayout HR_Department_Layout_Object = new HR_DepartmentLayout();
    
    JButton Back_Button = new JButton();
    JButton Add_New_Customer_Button = new JButton("Add New Customer");
    JButton Search_Customer_Button = new JButton("Search Customer");
    JButton Display_All_Customers_Button = new JButton("Display All Customers");
    JButton HR_Department_Button = new JButton("HR Department"); 
    
    JLabel Background = new JLabel();

    public CustomerLayout()
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
        
        Add_New_Customer_Button.setBounds((Frame - Width) / 2, 50, Width, Hight);
        Search_Customer_Button.setBounds((Frame - Width) / 2, 200, Width, Hight);
        Display_All_Customers_Button.setBounds((Frame - Width) / 2, 350, Width, Hight);
        HR_Department_Button.setBounds((Frame - Width) / 2, 500, Width, Hight);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(Add_New_Customer_Button);
        add(Search_Customer_Button);
        add(Display_All_Customers_Button);
        add(HR_Department_Button);
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
        
        Add_New_Customer_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Add_New_Customer_Layout_Object.setVisible(true);
                Add_New_Customer_Layout_Object.setResizable(false);
                Add_New_Customer_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Search_Customer_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Search_Customer_Layout_Object.setVisible(true);
                Search_Customer_Layout_Object.setResizable(false);
                Search_Customer_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Display_All_Customers_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Display_All_Customers_Table_Layout_Object = new DisplayAllCustomersTableLayout();
                Display_All_Customers_Table_Layout_Object.setVisible(true);
                Display_All_Customers_Table_Layout_Object.setResizable(false);
                Display_All_Customers_Table_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        HR_Department_Button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               dispose();
               HR_Department_Layout_Object.setVisible(true);
               HR_Department_Layout_Object.setResizable(false);
               HR_Department_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
