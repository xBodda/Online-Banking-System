/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import Person.Customer;
import Exceptions.Exception_Message;
import Person.Account;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
 *
 * @author abdel
 */
public class AddNewCustomerLayout2 extends JFrame
{
    //Random rand = new Random();
    int Frame = 600;
    int Button_Width = 130;
    int Button_Hight = 50;
    int X = 10,
        Y = 0,
        X1 = 170,
        Y1 = 10;
    
    Person.Customer Temporarily_Customer = new Person.Customer();
    
    
    JLabel Social_State_Label = new JLabel("Social State");           JLabel Resident_State_Label = new JLabel("Resident State");
    JLabel Profession_Label = new JLabel("Profession");               JLabel Salary_Label = new JLabel("Salary");
    JLabel Name_Of_Workplace_Label = new JLabel("Name Of Workplace"); JLabel Building_Number_Label = new JLabel("Building Number");
    JLabel Department_Number_Label = new JLabel("Department Number"); JLabel Postal_Code_Label = new JLabel("Postal Code");
    JLabel Street_Label = new JLabel("Street");                       JLabel City_Label = new JLabel("City");
    
    JTextField Profession_Text = new JTextField();            JTextField Salary_Text = new JTextField();
    JTextField Name_Of_Workplace_Text = new JTextField();     JTextField Building_Number_Text = new JTextField();
    JTextField Department_Number_Text = new JTextField();     JTextField Postal_Code_Text = new JTextField();
    JTextField Street_Text = new JTextField();                JTextField City_Text = new JTextField();
    
    JComboBox Social_State_Combo_Box = new JComboBox();               JComboBox Resident_State_Combo_Box = new JComboBox();
    
    JButton Back_Button = new JButton();
    JButton Add_Button = new JButton("Add");
    
    JLabel Background = new JLabel();

    public AddNewCustomerLayout2()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setSize(Frame, Frame);
        setTitle("BDA Bank Server");
        setLayout(null);
        
        
        Social_State_Label.setBounds(10, 0, 160, 50);            Social_State_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));       Social_State_Label.setForeground(Color.BLACK);
        Resident_State_Label.setBounds(X, Y + 40, 160, 50);      Resident_State_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));     Resident_State_Label.setForeground(Color.BLACK);
        Profession_Label.setBounds(X, Y + 80, 160, 50);          Profession_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));         Profession_Label.setForeground(Color.BLACK);
        Salary_Label.setBounds(X, Y + 120, 160, 50);             Salary_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));             Salary_Label.setForeground(Color.BLACK);
        Name_Of_Workplace_Label.setBounds(X, Y + 160, 160, 50);  Name_Of_Workplace_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));  Name_Of_Workplace_Label.setForeground(Color.BLACK);
        Building_Number_Label.setBounds(X, Y + 240, 160, 50);    Building_Number_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));    Building_Number_Label.setForeground(Color.BLACK);
        Department_Number_Label.setBounds(X, Y + 200, 160, 50);  Department_Number_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));  Department_Number_Label.setForeground(Color.BLACK);
        Postal_Code_Label.setBounds(X, Y + 280, 160, 50);        Postal_Code_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));        Postal_Code_Label.setForeground(Color.BLACK);
        Street_Label.setBounds(X, Y + 320, 160, 50);             Street_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));             Street_Label.setForeground(Color.BLACK);
        City_Label.setBounds(X, Y + 360, 160, 50);               City_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));               City_Label.setForeground(Color.BLACK);
        
        Profession_Text.setBounds(X1, Y1 + 80, 200, 30);
        Salary_Text.setBounds(X1, Y1 + 120, 200, 30);
        Name_Of_Workplace_Text.setBounds(X1, Y1 + 160, 200, 30);
        Building_Number_Text.setBounds(X1, Y1 + 200, 200, 30);
        Department_Number_Text.setBounds(X1, Y1 + 240, 200, 30);
        Postal_Code_Text.setBounds(X1, Y1 + 280, 200, 30);
        Street_Text.setBounds(X1, Y1 + 320, 200, 30);
        City_Text.setBounds(X1, Y1 + 360, 200, 30);
        
        Social_State_Combo_Box.setBounds(X1, Y1, 200, 30);
        Resident_State_Combo_Box.setBounds(X1, Y1 + 40, 200, 30);
        
        Social_State_Combo_Box.addItem("Choose");
        Social_State_Combo_Box.addItem("Single");
        Social_State_Combo_Box.addItem("Married");
        Social_State_Combo_Box.addItem("Widowed");
        Social_State_Combo_Box.addItem("Divorced");

        Resident_State_Combo_Box.addItem("Choose");
        Resident_State_Combo_Box.addItem("Resident");
        Resident_State_Combo_Box.addItem("Non-Resident");
        Resident_State_Combo_Box.addItem("Statutory Resident");
        Resident_State_Combo_Box.addItem("Part-Year Residents");
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        Add_Button.setBounds(400, 450, Button_Width, Button_Hight);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        
        add(Social_State_Label);        add(Resident_State_Label);       add(Profession_Label);
        add(Salary_Label);              add(Name_Of_Workplace_Label);    add(Building_Number_Label);
        add(Department_Number_Label);   add(Postal_Code_Label);          add(Street_Label);
        add(City_Label);
        
        add(Profession_Text);         add(Salary_Text);       add(Name_Of_Workplace_Text);    add(Building_Number_Text);
        add(Department_Number_Text);  add(Postal_Code_Text);  add(Street_Text);               add(City_Text);
        
        add(Social_State_Combo_Box);     add(Resident_State_Combo_Box);
        
        add(Add_Button);
        
        add(Background);
        
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                CustomerLayout.Add_New_Customer_Layout_Object.setVisible(true);
            }
        });
        
        Add_Button.addActionListener(new Add_Handler());
        
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
        
        SwingUtilities.getRootPane(Add_Button).setDefaultButton(Add_Button);
    }
    private class Add_Handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if(Social_State_Combo_Box.getSelectedItem().equals("Choose"))
            {
                JOptionPane.showMessageDialog(null, "The Social State Field Is Empty, Please Input A Valid Social State.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Resident_State_Combo_Box.getSelectedItem().equals("Choose"))
            {
                JOptionPane.showMessageDialog(null, "The Resident State Field Is Empty, Please Input A Valid Resident State.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Profession_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Profession Field Is Empty, Please Input A Valid Profession.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Salary_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Salary Field Is Empty, Please Input A Valid Salary.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Name_Of_Workplace_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Name Of Workplace Field Is Empty, Please Input A Valid Name Of Workplace.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Building_Number_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Building Number Field Is Empty, Please Input A Valid Building Number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Department_Number_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Department Number Field Is Empty, Please Input A Valid Department Number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Postal_Code_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Postal Code Field Is Empty, Please Input A Valid Postal Code.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Street_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Street Field Is Empty, Please Input A Valid Street.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(City_Text.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The City Field Is Empty, Please Input A Valid City.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                int Result;
                try
                {
                    Temporarily_Customer.setName(AddNewCustomerLayout.Full_Name_Text_Field.getText());
                    if(AddNewCustomerLayout.Male_Radio_Button.isSelected())
                    {
                        Temporarily_Customer.setGender(AddNewCustomerLayout.Male_Radio_Button.getText());
                    }
                    else if(AddNewCustomerLayout.Female_Radio_Button.isSelected())
                    {
                        Temporarily_Customer.setGender(AddNewCustomerLayout.Female_Radio_Button.getText());
                    }
                    Temporarily_Customer.setNationality((String) AddNewCustomerLayout.Nationality_Combo_Box.getSelectedItem());
                    Temporarily_Customer.setEducational_State((String) AddNewCustomerLayout.Educational_State_Combo_Box.getSelectedItem());
                    Temporarily_Customer.setSocial_State((String) Social_State_Combo_Box.getSelectedItem());
                    Temporarily_Customer.setResident_State((String) Resident_State_Combo_Box.getSelectedItem());
                    Temporarily_Customer.setPassword(AddNewCustomerLayout.Password_Password_Field.getText());
                    Temporarily_Customer.setNational_ID(AddNewCustomerLayout.National_ID_Text_Field.getText());
                    Temporarily_Customer.setAge(Integer.parseInt(AddNewCustomerLayout.Age_Text_Field.getText()));
                    Temporarily_Customer.setSalary(Integer.parseInt(Salary_Text.getText()));
                    Temporarily_Customer.setUser_Type((String) AddNewCustomerLayout.User_Type_Combo_Box.getSelectedItem());
                    Temporarily_Customer.setName_Of_Workplace(Name_Of_Workplace_Text.getText());
                    Temporarily_Customer.setProfession(Profession_Text.getText());
                    Temporarily_Customer.E_Mail_Address_Aggregation(AddNewCustomerLayout.E_Mail_Address_Text_Field.getText());
                    Temporarily_Customer.Mobile_Phone_Aggregation(AddNewCustomerLayout.Mobile_Phone_Text_Field.getText());
                    Temporarily_Customer.Home_Phone_Aggregation(AddNewCustomerLayout.Home_Phone_Text_Field.getText());
                    Temporarily_Customer.City_Aggregation(City_Text.getText());
                    Temporarily_Customer.Street_Aggregation(Street_Text.getText());
                    Temporarily_Customer.Postal_Code_Aggregation(Postal_Code_Text.getText());
                    Temporarily_Customer.Building_Number_Aggregation(Integer.parseInt(Building_Number_Text.getText()));
                    Temporarily_Customer.Department_Number_Aggregation(Integer.parseInt(Department_Number_Text.getText()));
                    Temporarily_Customer.setBalance(100);
//                    Temporarily_Customer.setAccount_Object();
//                    Temporarily_Customer.setAccount_Number("5262910787876565");
//                    Temporarily_Customer.setAccount_Number("5262910765439876");
                    BDA.OnlineBanking.Customer_Array_List.add(Temporarily_Customer);
                    
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch(IOException ex)
                    {}
                    
                    BDA.OnlineBanking.Accounts.put(Temporarily_Customer.getNational_ID(), BDA.OnlineBanking.Caesar_Cipher_Encryption(Temporarily_Customer.getPassword(), BDA.OnlineBanking.Encryption_Key));
                    
                    Result = JOptionPane.showConfirmDialog(null, "Your Data Has Been Added.", "Done", JOptionPane.DEFAULT_OPTION);
                    
                    if(Result == JOptionPane.OK_OPTION)
                    {
                        dispose();
                        ModifyingLayout.Customer_Layout_Object.setVisible(true);
                    }
                }
                catch (Exception_Message ex)
                {}
            }
        }
    }
}
