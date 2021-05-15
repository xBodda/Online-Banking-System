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
public class SearchEmployeeTableLayout extends JFrame 
{
    int Frame = 600;
    int Width = 200;
    int Hight = 30;
    
    public static ViewAccountsDataLayout View_Accounts_Data_Layout_Object = new ViewAccountsDataLayout();
    public static ModifyEmployeeLayout Modify_Employee_Layout_Object = new ModifyEmployeeLayout();
 //   public static CardsLayout Cards_Layout_Object = new CardsLayout();
    public static CertifactsLayout Certifacts_Layout_Object = new CertifactsLayout();
    
    String Rows_Names[] = {"Full Name", "Age", "Nationality", "Gender", "Mobile Phone", "Home Phone", "National ID", "E-Mail Address",
                          "Password", "Educational State", "Social State", "Resident State", "Salary",
                          "City", "Street Name", "Postal Code", "Building Number", "Department Number"};
    
    String Row_Name[] = new String[1];
    
    Object Data[] =
    {
        SearchEmployeeLayout.Temporary_Employee.getName(),
        SearchEmployeeLayout.Temporary_Employee.getAge(),
        SearchEmployeeLayout.Temporary_Employee.getNationality(),
        SearchEmployeeLayout.Temporary_Employee.getGender(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getMobile_Phone(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getHome_Phone(),
        SearchEmployeeLayout.Temporary_Employee.getNational_ID(),
//        SearchEmployeeLayout.Temporary_Employee.getUser_Type(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getE_Mail_Address(),
        SearchEmployeeLayout.Temporary_Employee.getPassword(),
        SearchEmployeeLayout.Temporary_Employee.getEducational_State(),
        SearchEmployeeLayout.Temporary_Employee.getSocial_State(),
        SearchEmployeeLayout.Temporary_Employee.getResident_State(),
//        SearchEmployeeLayout.Temporary_Employee.getProfession(),
        SearchEmployeeLayout.Temporary_Employee.getSalary(),
//        SearchEmployeeLayout.Temporary_Employee.getName_Of_Workplace(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getCity(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getStreet(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getPostal_Code(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getBuilding_Number(),
        SearchEmployeeLayout.Temporary_Employee.getContact_Object().getDepartment_Number()
    };
    
    DefaultTableModel Data_Model = new DefaultTableModel();
    
    JTable Data_Table;
    
    JScrollPane Scroll_Pane;
    
    JButton Back_Button = new JButton();
    JButton View_Accounts_Data_Button = new JButton("View Accounts Data");
    JButton Delete_Employee_Button = new JButton("Delete Employee");
    JButton Modify_Employee_Button = new JButton("Modify Employee");
    JButton Add_New_Current_Account_Button = new JButton("Add New Current Account");
    JButton Add_New_Saving_Account_Button = new JButton("Add New Saving Account");
    JButton Cards_Button = new JButton("Cards");
    JButton Certifacts_Button = new JButton ("Add New Certifacts");
    
    SearchEmployeeTableLayout()
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
        Delete_Employee_Button.setBounds((Frame - Width) / 32, ((Frame - Hight) - 150), Width, Hight);
        Modify_Employee_Button.setBounds((Frame - Width) / 32, ((Frame - Hight) - 100), Width, Hight);
        Add_New_Current_Account_Button.setBounds((Frame - Width) - 200, ((Frame - Hight) - 150), Width, Hight);
        Add_New_Saving_Account_Button.setBounds((Frame - Width) - 200, ((Frame - Hight) - 100), Width, Hight);
        Cards_Button.setBounds((Frame - Width) - 20, ((Frame - Hight) - 150), Width, Hight);
        Certifacts_Button.setBounds((Frame - Width) - 20, ((Frame - Hight) - 100), Width, Hight);
        
        add(Back_Button);
        add(Scroll_Pane);
        add(View_Accounts_Data_Button);
        add(Delete_Employee_Button);
        add(Modify_Employee_Button);
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
                EmployeeLayout.Search_Employee_Layout_Object.setVisible(true);
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
        
        Delete_Employee_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                int Result;
                
                Result = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete This Employee ?", "Warning", JOptionPane.YES_NO_OPTION);
                
                if(Result == JOptionPane.YES_OPTION)
                {
                    BDA.OnlineBanking.Employee_Array_List.remove(SearchEmployeeLayout.Temporary_Employee);
                    
                    SearchEmployeeLayout.Temporary_Employee = null;
                    
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
                        ModifyingLayout.Employee_Layout_Object.setVisible(true);
                    }
                }
            }
        });
        
        Modify_Employee_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Modify_Employee_Layout_Object.setVisible(true);
                Modify_Employee_Layout_Object.setResizable(false);
                Modify_Employee_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
