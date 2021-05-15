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
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author abdel
 */
public class SearchCustomerTableLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 30;
    
    public static ViewAccountsDataLayout View_Accounts_Data_Layout_Object = new ViewAccountsDataLayout();
    public static ModifyCustomerLayout Modify_Customer_Layout_Object = new ModifyCustomerLayout();
    public static CardsLayout Cards_Layout_Object = new CardsLayout();
    public static CertifactsLayout Certifacts_Layout_Object = new CertifactsLayout();
    
    String Rows_Names[] = {"Full Name", "Age", "Nationality", "Gender", "Mobile Phone", "Home Phone", "National ID", "User Type", "E-Mail Address",
                          "Password", "Educational State", "Social State", "Resident State", "Profession", "Salary", "Name Of Wordplace",
                          "City", "Street Name", "Postal Code", "Building Number", "Department Number"};
    
    String Row_Name[] = new String[1];
    
    Object Data[] =
    {
        SearchCustomerLayout.Temporary_Customer.getName(),
        SearchCustomerLayout.Temporary_Customer.getAge(),
        SearchCustomerLayout.Temporary_Customer.getNationality(),
        SearchCustomerLayout.Temporary_Customer.getGender(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getMobile_Phone(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getHome_Phone(),
        SearchCustomerLayout.Temporary_Customer.getNational_ID(),
        SearchCustomerLayout.Temporary_Customer.getUser_Type(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getE_Mail_Address(),
        SearchCustomerLayout.Temporary_Customer.getPassword(),
        SearchCustomerLayout.Temporary_Customer.getEducational_State(),
        SearchCustomerLayout.Temporary_Customer.getSocial_State(),
        SearchCustomerLayout.Temporary_Customer.getResident_State(),
        SearchCustomerLayout.Temporary_Customer.getProfession(),
        SearchCustomerLayout.Temporary_Customer.getSalary(),
        SearchCustomerLayout.Temporary_Customer.getName_Of_Workplace(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getCity(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getStreet(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getPostal_Code(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getBuilding_Number(),
        SearchCustomerLayout.Temporary_Customer.getContact_Object().getDepartment_Number()
    };
    
    DefaultTableModel Data_Model = new DefaultTableModel();
    
    JTable Data_Table;
    
    JScrollPane Scroll_Pane;
    
    JButton Back_Button = new JButton();
    JButton View_Accounts_Data_Button = new JButton("View Accounts Data");
    JButton Delete_Customer_Button = new JButton("Delete Customer");
    JButton Modify_Customer_Button = new JButton("Modify Customer");
    JButton Add_New_Current_Account_Button = new JButton("Add New Current Account");
    JButton Add_New_Saving_Account_Button = new JButton("Add New Saving Account");
    JButton Cards_Button = new JButton("Cards");
    JButton Certifacts_Button = new JButton ("Add New Certifacts");
    
    SearchCustomerTableLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
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
        Delete_Customer_Button.setBounds((Frame - Width) / 32, ((Frame - Hight) - 150), Width, Hight);
        Modify_Customer_Button.setBounds((Frame - Width) / 32, ((Frame - Hight) - 100), Width, Hight);
        Add_New_Current_Account_Button.setBounds((Frame - Width) - 200, ((Frame - Hight) - 150), Width, Hight);
        Add_New_Saving_Account_Button.setBounds((Frame - Width) - 200, ((Frame - Hight) - 100), Width, Hight);
        Cards_Button.setBounds((Frame - Width) - 20, ((Frame - Hight) - 150), Width, Hight);
        Certifacts_Button.setBounds((Frame - Width) - 20, ((Frame - Hight) - 100), Width, Hight);
        
        add(Back_Button);
        add(Scroll_Pane);
        add(View_Accounts_Data_Button);
        add(Delete_Customer_Button);
        add(Modify_Customer_Button);
        add(Add_New_Current_Account_Button);
        add(Add_New_Saving_Account_Button);
        add(Cards_Button);
        add(Certifacts_Button);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                CustomerLayout.Search_Customer_Layout_Object.setVisible(true);
            }
        });
        
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
        
        Delete_Customer_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                int Result;
                
                Result = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete This Customer ?", "Warning", JOptionPane.YES_NO_OPTION);
                
                if(Result == JOptionPane.YES_OPTION)
                {
                    BDA.OnlineBanking.Customer_Array_List.remove(SearchCustomerLayout.Temporary_Customer);
                    
                    SearchCustomerLayout.Temporary_Customer = null;
                    
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch(IOException ex)
                    {}
                
                    Result = JOptionPane.showConfirmDialog(null, "Customer Deleted Successfully.", "Done", JOptionPane.DEFAULT_OPTION);
                    
                    if(Result == JOptionPane.OK_OPTION)
                    {
                        dispose();
                        ModifyingLayout.Customer_Layout_Object.setVisible(true);
                    }
                }
            }
        });
        
        Modify_Customer_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Modify_Customer_Layout_Object.setVisible(true);
                Modify_Customer_Layout_Object.setResizable(false);
                Modify_Customer_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            } 
        });
        
        Add_New_Current_Account_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                int Result;
                
                Result = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add New Current Account ?", "Warning", JOptionPane.YES_NO_OPTION);
                
                if(Result == JOptionPane.YES_OPTION)
                {
                    try
                    {
                        Person.Current_Account Current_Account_Object = new Person.Current_Account();
                        SearchCustomerLayout.Temporary_Customer.getAccount_Object().add(Current_Account_Object);
                        BDA.OnlineBanking.Save();
                    }
                    catch(IOException ex)
                    {}
                }
            }
        });
        
        Add_New_Saving_Account_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                int Result;
                
                Result = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add New Saving Account ?", "Warning", JOptionPane.YES_NO_OPTION);
                
                if(Result == JOptionPane.YES_OPTION)
                {
                    try
                    {
                        Person.Saving_Account Saving_Account_Object = new Person.Saving_Account();
                        SearchCustomerLayout.Temporary_Customer.getAccount_Object().add(Saving_Account_Object);
                        BDA.OnlineBanking.Save();
                    }
                    catch(IOException ex)
                    {}
                }
            }
        });
        
        Cards_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Cards_Layout_Object.setVisible(true);
                Cards_Layout_Object.setResizable(false);
                Cards_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Certifacts_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                Certifacts_Layout_Object.setVisible(true);
                Certifacts_Layout_Object.setResizable(false);
                Certifacts_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
