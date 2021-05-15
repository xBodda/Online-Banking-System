/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author abdel
 */
public class DisplayAllCustomersTableLayout extends JFrame
{
    GraphicsEnvironment Graphics_Environment_Object = GraphicsEnvironment.getLocalGraphicsEnvironment();
    
    String Column_Names[] = {"Full Name", "Age", "Nationality", "Gender", "Mobile Phone", "Home Phone", "National ID", "User Type", "E-Mail Address",
                          "Password", "Educational State", "Social State", "Resident State", "Profession", "Salary", "Name Of Wordplace",
                          "City", "Street Name", "Postal Code", "Building Number", "Department Number"};
    
    DefaultTableModel Data_Model = new DefaultTableModel();
    
    JTable Data_Table;
    
    JScrollPane Scroll_Pane;
    
    JButton Back_Button = new JButton();

    public DisplayAllCustomersTableLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Graphics_Environment_Object.getMaximumWindowBounds().width, Graphics_Environment_Object.getMaximumWindowBounds().height);
        setLayout(null);
        
        for(String C : Column_Names)
        {
            Data_Model.addColumn(C);
        }
        
        int i = 0;
        
        for(Person.Customer C : BDA.OnlineBanking.Customer_Array_List)
        {
            Data_Model.addRow(new Object[0][0]);
            Data_Model.setValueAt(C.getName(), i, 0);
            Data_Model.setValueAt(C.getAge(), i, 1);
            Data_Model.setValueAt(C.getNationality(), i, 2);
            Data_Model.setValueAt(C.getGender(), i, 3);
            Data_Model.setValueAt(C.getContact_Object().getMobile_Phone(), i, 4);
            Data_Model.setValueAt(C.getContact_Object().getHome_Phone(), i, 5);
            Data_Model.setValueAt(C.getNational_ID(), i, 6);
            Data_Model.setValueAt(C.getUser_Type(), i, 7);
            Data_Model.setValueAt(C.getContact_Object().getE_Mail_Address(), i, 8);
            Data_Model.setValueAt(C.getPassword(), i, 9);
            Data_Model.setValueAt(C.getEducational_State(), i, 10);
            Data_Model.setValueAt(C.getSocial_State(), i, 11);
            Data_Model.setValueAt(C.getResident_State(), i, 12);
            Data_Model.setValueAt(C.getProfession(), i, 13);
            Data_Model.setValueAt(C.getSalary(), i, 14);
            Data_Model.setValueAt(C.getName_Of_Workplace(), i, 15);
            Data_Model.setValueAt(C.getContact_Object().getCity(), i, 16);
            Data_Model.setValueAt(C.getContact_Object().getStreet(), i, 17);
            Data_Model.setValueAt(C.getContact_Object().getPostal_Code(), i, 18);
            Data_Model.setValueAt(C.getContact_Object().getBuilding_Number(), i, 19);
            Data_Model.setValueAt(C.getContact_Object().getDepartment_Number(), i, 20);
            i++;
        }
        
        Data_Table = new JTable(Data_Model);
        
        for(int j = 0; j < Column_Names.length; j++)
        {
            Data_Table.getColumnModel().getColumn(j).setMinWidth(150);
            Data_Table.getColumnModel().getColumn(j).setPreferredWidth(150);
        }
        
        Data_Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        Data_Table.getTableHeader().setReorderingAllowed(false);
        Data_Table.setEnabled(false);
        
        Scroll_Pane = new JScrollPane(Data_Table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Scroll_Pane.setBounds(0, 0, Graphics_Environment_Object.getMaximumWindowBounds().width - 10, Graphics_Environment_Object.getMaximumWindowBounds().height - 30);
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        add(Back_Button);
        add(Scroll_Pane);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ModifyingLayout.Customer_Layout_Object.setVisible(true);
            }
        });
    }
}
