
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
public class ModifyingLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 50;
    
    public static CustomerLayout Customer_Layout_Object = new CustomerLayout();
    public static EmployeeLayout Employee_Layout_Object = new EmployeeLayout();
    public static PieChartLayout Pie_Chart_Layout_Object;
    
    JButton Back_Button = new JButton();
    JButton Customer_Button = new JButton("Customer");
    JButton Employee_Button = new JButton("Empolyee");
    JButton Statistics_Button = new JButton("Statistics");
    
    JLabel Background = new JLabel();
    
    public ModifyingLayout()
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
        
        Customer_Button.setBounds((Frame - Width) / 2, (Frame - Hight) / 6, Width, Hight);
        Employee_Button.setBounds((Frame - Width) / 2, (Frame - Hight) / 3, Width, Hight);
        Statistics_Button.setBounds((Frame - Width) / 2, (Frame - Hight) / 2 , Width, Hight);
        
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(Customer_Button);
        add(Employee_Button);
        add(Statistics_Button);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                BDA.OnlineBanking.Login_Layout_Object.setVisible(true);
            }
        });
        Statistics_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                Pie_Chart_Layout_Object = new PieChartLayout();
                Pie_Chart_Layout_Object.setVisible(true);
                Pie_Chart_Layout_Object.setResizable(false);
                Pie_Chart_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Customer_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Customer_Layout_Object.setVisible(true);
                Customer_Layout_Object.setResizable(false);
                Customer_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Employee_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Employee_Layout_Object.setVisible(true);
                Employee_Layout_Object.setResizable(false);
                Employee_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
