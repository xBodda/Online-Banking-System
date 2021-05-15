/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author abdel
 */
public class DisplayCustomerDataLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 30;
    
    public static ViewAccountsDataLayout View_Accounts_Data_Layout_Object = new ViewAccountsDataLayout();
    
    String Rows_Names[] = {"Full Name", "Age", "Nationality", "Gender", "Mobile Phone", "Home Phone", "National ID", "User Type", "E-Mail Address",
                          "Password", "Educational State", "Social State", "Resident State", "Profession", "Salary", "Name Of Wordplace",
                          "City", "Street Name", "Postal Code", "Building Number", "Department Number"};
    
    String Row_Name[] = new String[1];
    
    Object Data[] =
    {
        LoginLayout.Temporary_Customer.getName(),
        LoginLayout.Temporary_Customer.getAge(),
        LoginLayout.Temporary_Customer.getNationality(),
        LoginLayout.Temporary_Customer.getGender(),
        LoginLayout.Temporary_Customer.getContact_Object().getMobile_Phone(),
        LoginLayout.Temporary_Customer.getContact_Object().getHome_Phone(),
        LoginLayout.Temporary_Customer.getNational_ID(),
        LoginLayout.Temporary_Customer.getUser_Type(),
        LoginLayout.Temporary_Customer.getContact_Object().getE_Mail_Address(),
        LoginLayout.Temporary_Customer.getPassword(),
        LoginLayout.Temporary_Customer.getEducational_State(),
        LoginLayout.Temporary_Customer.getSocial_State(),
        LoginLayout.Temporary_Customer.getResident_State(),
        LoginLayout.Temporary_Customer.getProfession(),
        LoginLayout.Temporary_Customer.getSalary(),
        LoginLayout.Temporary_Customer.getName_Of_Workplace(),
        LoginLayout.Temporary_Customer.getContact_Object().getCity(),
        LoginLayout.Temporary_Customer.getContact_Object().getStreet(),
        LoginLayout.Temporary_Customer.getContact_Object().getPostal_Code(),
        LoginLayout.Temporary_Customer.getContact_Object().getBuilding_Number(),
        LoginLayout.Temporary_Customer.getContact_Object().getDepartment_Number()
    };
    
    DefaultTableModel Data_Model = new DefaultTableModel();
    
    JTable Data_Table;
    
    JScrollPane Scroll_Pane;
    
    JButton View_Accounts_Data_Button = new JButton("View Accounts Data");
    JButton Back_Button = new JButton();
    
    DisplayCustomerDataLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Client");
        setSize(Frame, Frame);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        Data_Model.addColumn("");
        Data_Model.addColumn("Data");
        
        for(String R : Rows_Names)
        {
            Row_Name[0] = R;
            Data_Model.addRow(Row_Name);
        }
        
        for(int i = 0; i < Data.length; i++)
        {
            Data_Model.setValueAt(Data[i], i, 1);
        }
        
        Data_Table = new JTable(Data_Model);
        
        Data_Table.getColumnModel().getColumn(0).setMinWidth(150);
        Data_Table.getColumnModel().getColumn(0).setMaxWidth(150);
        
        Data_Table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable Table, Object Value, boolean Is_Selected, boolean Has_Focus, int Row, int Column)
            {
                setHorizontalAlignment(JLabel.LEFT);
                if(Table != null)
                {
                    JTableHeader Header = Table.getTableHeader();
                    if(Header != null)
                    {
                        setForeground(Header.getForeground());
                        setBackground(Header.getBackground());
                        setFont(Header.getFont());
                    }
                }
                if(Is_Selected)
                {
                    setFont(getFont().deriveFont(Font.BOLD));
                }
                setValue(Value);
                return this;
            }
        });
        
        Data_Table.getTableHeader().setReorderingAllowed(false);
        Data_Table.setEnabled(false);
        
        Scroll_Pane = new JScrollPane(Data_Table);
        Scroll_Pane.setBounds(0, 0, Frame, 360);
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        View_Accounts_Data_Button.setBounds((Frame - Width) - 200, ((Frame - Hight) - 200), Width, Hight);
        
        add(View_Accounts_Data_Button);
        add(Back_Button);
        add(Scroll_Pane);
        
        View_Accounts_Data_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                View_Accounts_Data_Layout_Object.setVisible(true);
                View_Accounts_Data_Layout_Object.setResizable(false);
                View_Accounts_Data_Layout_Object.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
        });
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                LoginLayout.Customer_Action_Layout_Object.setVisible(true);
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
    }
}
