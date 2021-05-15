/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class ViewAccountsDataLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 30;
    
    String Column_Names[] = {"Account Number", "Balance"};
    
    DefaultTableModel Data_Model = new DefaultTableModel();
    
    JTable Data_Table;
    
    JScrollPane Scroll_Pane;
    
    JButton Back_Button = new JButton();
    
    public ViewAccountsDataLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Frame, Frame);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        for(String C : Column_Names)
        {
            Data_Model.addColumn(C);
        }
        
        int i = 0;
        
        for(Person.Account A : LoginLayout.Temporary_Customer.getAccount_Object())
        {
            Data_Model.addRow(new Object[0][0]);
            Data_Model.setValueAt(A.getAccount_Number(), i, 0);
            Data_Model.setValueAt(A.getBalance(), i, 1);
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
        Scroll_Pane.setBounds(100, 0, 303, Frame - 30);
        
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
                CustomerActionLayout.Display_Customer_Data_Layout_Object.setVisible(true);
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
