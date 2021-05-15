/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import Exceptions.Exception_Message;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author abdel
 */
public class ModifyEmployeeLayout extends JFrame
{
    int Frame = 600;
    int Width = 250;
    int Hight = 30;
    
    public static SearchCustomerTableLayout Search_Customer_Table_Layout_Object;
    
    Person.Employee Temporarily_Employee = new Person.Employee();
     
    String Data_1[] = {"Choose", "Full Name", "Date Of Birth", "Mobile Phone", "Home Phone", "E-Mail Address",
                       "Password",  "Profession", "Educational State",
                       "Social State", "Resident State", "Home Address"};
    
    JLabel Modify_Label = new JLabel("Please Choose");
    JLabel Modified_Label;
    JComboBox Modified_ComboBox;
    
    JTextField Modified_Text_Field;
    
    JComboBox Modify_Combo_Box = new JComboBox();
    
    static  JComboBox Educational_State_ComboBox = new JComboBox ();
    JComboBox Social_State_Combo_Box_Modify = new JComboBox ();
    JComboBox Resident_State_Combo_Box_Modify = new JComboBox();
//    static JComboBox User_Type_Combo_Box = new JComboBox();
    
    JButton Save_Button = new JButton("Save");
    JButton Back_Button = new JButton();
    
    
    JLabel Background = new JLabel();
    
    public ModifyEmployeeLayout()
    {
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Frame, Frame);
        setLayout(null);
            
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        
        JTextField Modified_Department_No_TextField = new JTextField ();
        JTextField Modified_Street_TextField = new JTextField();
        JTextField Modified_Building_No_TextField = new JTextField();
        JTextField Modified_City_TextField = new JTextField ();
        
        JLabel Modified_Department_Number_Label = new JLabel ("Please Enter The New Department No.");
        JLabel Modified_Street_Label = new JLabel ("Please Enter The New Street Name ");
        JLabel Modified_Building_Number_Label= new JLabel ("PLease Enter The New Building No.");
        JLabel Modified_City_Label = new JLabel ("Please Enter The New City ");
        
        Modified_Department_No_TextField.setBounds(250, 250 , 150, 30);
        Modified_Street_TextField.setBounds(250, 310 , 150, 30);
        Modified_Building_No_TextField.setBounds(250, 370 , 150, 30);
        Modified_City_TextField.setBounds(250, 430 ,150, 30);
      
        Modified_Department_Number_Label.setBounds(200 , 200 , 230, 75);
        Modified_Street_Label.setBounds(200 , 260 , 230, 75);
        Modified_Building_Number_Label.setBounds(200 ,320 , 230, 75);
        Modified_City_Label.setBounds(200 , 380 , 200, 75);
        
        Modify_Label.setBounds((Frame - Width) / 2, (Frame - Hight) / 4, Width, Hight);
        Modify_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, Hight));
        Modify_Label.setForeground(Color.BLACK);
        
        Modify_Combo_Box.setBounds((Frame - Width)/2 , (Frame - Hight) / 3, Width, Hight);
        
        Educational_State_ComboBox.setBounds((Frame - Width) / 2, (Frame - Hight) / 2, Width, Hight);
        Social_State_Combo_Box_Modify.setBounds((Frame - Width) / 2, (Frame - Hight) / 2, Width, Hight);
        Resident_State_Combo_Box_Modify.setBounds((Frame - Width) / 2, (Frame - Hight) / 2, Width, Hight);
//        User_Type_Combo_Box.setBounds((Frame - Width) / 2, (Frame - Hight) / 2, Width, Hight);
        
        Social_State_Combo_Box_Modify.addItem("Choose");
        Social_State_Combo_Box_Modify.addItem("Single");
        Social_State_Combo_Box_Modify.addItem("Married");
        Social_State_Combo_Box_Modify.addItem("Widowed");
        Social_State_Combo_Box_Modify.addItem("Divorced");
        Social_State_Combo_Box_Modify.setVisible(false);
        
        Educational_State_ComboBox.addItem("Choose");
        Educational_State_ComboBox.addItem("Illiterate");
        Educational_State_ComboBox.addItem("High School");
        Educational_State_ComboBox.addItem("Diploma");
        Educational_State_ComboBox.addItem("College");
        Educational_State_ComboBox.addItem("Associate's Degree");
        Educational_State_ComboBox.addItem("Bachelor's Degree");
        Educational_State_ComboBox.addItem("Master's Degree");
        Educational_State_ComboBox.addItem("Doctorate Degree");
        Educational_State_ComboBox.setVisible(false);
        
        Resident_State_Combo_Box_Modify.addItem("Choose");
        Resident_State_Combo_Box_Modify.addItem("Resident");
        Resident_State_Combo_Box_Modify.addItem("Non-Resident");
        Resident_State_Combo_Box_Modify.addItem("Statutory Resident");
        Resident_State_Combo_Box_Modify.addItem("Part-Year Residents");
        Resident_State_Combo_Box_Modify.setVisible(false);
        
//        User_Type_Combo_Box.addItem("Choose");
//        User_Type_Combo_Box.addItem("Normal");
//        User_Type_Combo_Box.addItem("Vip");
//        User_Type_Combo_Box.setVisible(false);
        
        add(Educational_State_ComboBox);
        add(Social_State_Combo_Box_Modify);
        add(Resident_State_Combo_Box_Modify);
//        add(User_Type_Combo_Box);
        add(Back_Button);
       
        add(Modified_Department_No_TextField);
        add(Modified_Street_TextField);
        add(Modified_Building_No_TextField);
        add(Modified_City_TextField);
        add(Modified_Department_Number_Label);
        add(Modified_Street_Label);
        add(Modified_Building_Number_Label);
        add(Modified_City_Label);
        Modified_Department_No_TextField.setVisible(false);
        Modified_Street_TextField.setVisible(false);
        Modified_Building_No_TextField.setVisible(false);
        Modified_City_TextField.setVisible(false);  
        Modified_Department_Number_Label.setVisible(false);
        Modified_Street_Label.setVisible(false);
        Modified_Building_Number_Label.setVisible(false);
        Modified_City_Label.setVisible(false);
        
        for(String D : Data_1)
        {
           Modify_Combo_Box.addItem(D);
        }
        
        Save_Button.setBounds(450, 450, 100, 50);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Modify_Label);
        add(Modify_Combo_Box);
        add(Save_Button);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                Search_Customer_Table_Layout_Object = new SearchCustomerTableLayout();
                Search_Customer_Table_Layout_Object.setVisible(true);
                Search_Customer_Table_Layout_Object.setResizable(false);
                Search_Customer_Table_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
        
        Modify_Combo_Box.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent Event_Object)
            {
                try
                {
                    remove(Modified_Label);
                    remove(Modified_Text_Field);
                }
                catch(NullPointerException e)
                {}
                
                remove(Background);
                
                for(int i = 1 ; i <= 9; i++)
                {
                    if(Modify_Combo_Box.getSelectedItem().equals(Data_1[i]))
                    {
                        Modified_Label = new JLabel(" New " + Data_1[i]);
                        Modified_Text_Field = new JTextField();
                        Modified_Label.setBounds((Frame - Width) / 2, (Frame - Hight) / 2, Width, Hight);
                        Modified_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
                        Modified_Label.setForeground(Color.BLACK);
                        Modified_Text_Field.setBounds((Frame - Width) / 2, 330, Width, Hight);
                        
                        remove(Educational_State_ComboBox);
                        remove(Social_State_Combo_Box_Modify);
                        remove(Resident_State_Combo_Box_Modify);
//                        remove(User_Type_Combo_Box);
                        add(Modified_Label);
                        add(Modified_Text_Field);
                    }
                }
                
                if (Modify_Combo_Box.getSelectedItem().equals(Data_1[10]))
                {
                    remove(Educational_State_ComboBox);
                    remove(Social_State_Combo_Box_Modify);
                    remove(Resident_State_Combo_Box_Modify);
                    remove(Modified_Department_No_TextField);
                    remove(Modified_Street_TextField);
                    remove(Modified_Building_No_TextField);
                    remove(Modified_City_TextField);
                    remove(Modified_Department_Number_Label); 
                    remove(Modified_Street_Label);
                    remove(Modified_Building_Number_Label);
                    remove(Modified_City_Label);
//                    User_Type_Combo_Box.setVisible(true);
                    add(Background);
//                    add(User_Type_Combo_Box);
                }
                else if(Modify_Combo_Box.getSelectedItem().equals(Data_1[11]))
                {
//                    remove(User_Type_Combo_Box);
                    remove(Social_State_Combo_Box_Modify);
                    remove(Resident_State_Combo_Box_Modify);
                    remove(Modified_Department_No_TextField);
                    remove(Modified_Street_TextField);
                    remove(Modified_Building_No_TextField);
                    remove(Modified_City_TextField);
                    remove(Modified_Department_Number_Label); 
                    remove(Modified_Street_Label);
                    remove(Modified_Building_Number_Label);
                    remove(Modified_City_Label);
                    Educational_State_ComboBox.setVisible(true);
                    add(Background);
                    add(Educational_State_ComboBox);
                }
                else  if(Modify_Combo_Box.getSelectedItem().equals(Data_1[12]))
                {
//                    remove(User_Type_Combo_Box);
                    remove(Educational_State_ComboBox);
                    remove(Resident_State_Combo_Box_Modify);
                    remove(Modified_Department_No_TextField);
                    remove(Modified_Street_TextField);
                    remove(Modified_Building_No_TextField);
                    remove(Modified_City_TextField);
                    remove(Modified_Department_Number_Label); 
                    remove(Modified_Street_Label);
                    remove(Modified_Building_Number_Label);
                    remove(Modified_City_Label);
                    Social_State_Combo_Box_Modify.setVisible(true);
                    add(Background);
                    add(Social_State_Combo_Box_Modify);
                }
                else if(Modify_Combo_Box.getSelectedItem().equals(Data_1[13]))
                {
//                    remove(User_Type_Combo_Box);
                    remove(Educational_State_ComboBox);
                    remove(Social_State_Combo_Box_Modify);
                    remove(Modified_Department_No_TextField);
                    remove(Modified_Street_TextField);
                    remove(Modified_Building_No_TextField);
                    remove(Modified_City_TextField);
                    remove(Modified_Department_Number_Label); 
                    remove(Modified_Street_Label);
                    remove(Modified_Building_Number_Label);
                    remove(Modified_City_Label);
                    Resident_State_Combo_Box_Modify.setVisible(true);
                    add(Background);
                    add(Resident_State_Combo_Box_Modify);
                }
                else if(Modify_Combo_Box.getSelectedItem().equals(Data_1[14]))
                {
//                    remove(User_Type_Combo_Box);
                    remove(Educational_State_ComboBox);
                    remove(Social_State_Combo_Box_Modify);
                    remove(Resident_State_Combo_Box_Modify);
                    
                    Modified_Department_No_TextField.setVisible(true);
                    Modified_Street_TextField.setVisible(true);
                    Modified_Building_No_TextField.setVisible(true);
                    Modified_City_TextField.setVisible(true);  
                    Modified_Department_Number_Label.setVisible(true);
                    Modified_Street_Label.setVisible(true);
                    Modified_Building_Number_Label.setVisible(true);
                    Modified_City_Label.setVisible(true);  
                    add(Background);
                    add(Modified_Department_No_TextField);
                    add(Modified_Street_TextField);
                    add(Modified_Building_No_TextField);
                    add(Modified_Department_Number_Label); 
                    add(Modified_Street_Label);
                    add(Modified_Building_Number_Label);
                    add(Modified_City_Label);
                }
                add(Background);
            }});
        Save_Button.addActionListener(new Modify_Handler());
    }
    private class Modify_Handler implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if(Modify_Combo_Box.getSelectedItem().equals("Choose"))
            {
                JOptionPane.showMessageDialog(null, "Please Choose what you want to modify ", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if(Modify_Combo_Box.getSelectedItem().equals("Full Name"))
            {
                if (Modified_Text_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Your New Full Name !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {
                    try
                        {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setName(Modified_Text_Field.getText());
                    }
                    catch(Exception_Message ex)
                    {}
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Added.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Date Of Birth"))
            {
                try
                {
                    BDA.OnlineBanking.Save();
                }
                catch (IOException ex)
                {}
                
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Mobile Phone"))
            {
                if (Modified_Text_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Your New Mobile Phone !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {
                    try
                    {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).Mobile_Phone_Aggregation( Modified_Text_Field.getText());
                    }
                    catch(Exception_Message ex)
                    {}
                    
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
                    
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Added.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Home Phone"))
            {
                if (Modified_Text_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Your New Home Phone !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {
                    try
                    {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).Home_Phone_Aggregation(Modified_Text_Field.getText());
                    }
                    catch(Exception_Message ex)
                    {}
                    
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
                    
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Added.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Password"))
            {
                if (Modified_Text_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Your New Password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {
                    try
                    {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setPassword(Modified_Text_Field.getText());
                    }
                    catch(Exception_Message ex)
                    {}
                    
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
                    
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("E-Mail Address"))
            {
                if (Modified_Text_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Your New E-mail Address!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else    
                {
                    try
                    {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).E_Mail_Address_Aggregation(Modified_Text_Field.getText());
                    }
                    catch(Exception_Message ex)
                    {}
                    
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
                    JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Profession"))
            {
                if (Modified_Text_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Your New Profession!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {
                    try
                    {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setProfession(Modified_Text_Field.getText());
                    }
                    catch(Exception_Message ex)
                    {}
                    
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
                    
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
//            else if(Modify_Combo_Box.getSelectedItem().equals("Salary"))
//            {
//                if (Modified_Text_Field.getText().equals(""))
//                {
//                    JOptionPane.showMessageDialog(null, "Please Enter Your New Salary!", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                else 
//                {
//                    BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setSalary((Integer.parseInt(Modified_Text_Field.getText())));
//                    try
//                    {
//                        BDA.OnlineBanking.Save();
//                    }
//                    catch(IOException ex)
//                    {}
//                    
//                    JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
//                }
//            }
//            else if(Modify_Combo_Box.getSelectedItem().equals("Name Of Workplace"))
//            {
//                   if (Modified_Text_Field.getText().equals(""))
//                {
//                    JOptionPane.showMessageDialog(null, "Please Enter Your New Name Of WorkPlace!", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                else 
//                {
//                       try
//                       {
//                           BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setName_Of_Workplace(Modified_Text_Field.getText());
//                       } 
//                       catch (Exception_Message ex) 
//                       {}
//                try
//                {
//                    BDA.OnlineBanking.Save();
//                }
//                catch (IOException ex)
//                {}
//           
//                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
//                }
//                }
                   
//            else if(Modify_Combo_Box.getSelectedItem().equals("User Type"))
//            {
//                if (User_Type_Combo_Box.getSelectedItem().equals("Choose"))
//                {
//                    JOptionPane.showMessageDialog(null, "Please Choose Your New User Type!", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                else 
//                {
//                    try
//                        {
//                        BDA.OnlineBanking.Customer_Array_List.get(CustomerLayout.Search_Customer_Layout_Object.Index).setUser_Type((String) User_Type_Combo_Box.getSelectedItem());
//                    }
//                    catch(Exception_Message ex)
//                    {}
//                    try
//                    {
//                        BDA.OnlineBanking.Save();
//                    }
//                    catch (IOException ex)
//                    {}
//           
//                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
//                }
//            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Educational State"))
            {
             if (Educational_State_ComboBox.getSelectedItem().equals("Choose"))
                {
                    JOptionPane.showMessageDialog(null, "Please Choose Your New Educational State!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {   
                 try
                {
                     BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setEducational_State((String) Educational_State_ComboBox.getSelectedItem());
                } 
                 catch (Exception_Message ex) 
                 {}
                try
                {
                    BDA.OnlineBanking.Save();
                }
                catch (IOException ex)
                {}
           
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Social State"))
            {
                if (Social_State_Combo_Box_Modify.getSelectedItem().equals("Choose"))
                {
                    JOptionPane.showMessageDialog(null, "Please Choose Your New Social State!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {   
                    try
                        {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setSocial_State((String) Social_State_Combo_Box_Modify.getSelectedItem());
                    }
                    catch(Exception_Message ex)
                    {}
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
           
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(Modify_Combo_Box.getSelectedItem().equals("Resident State"))
            {
                if (Resident_State_Combo_Box_Modify.getSelectedItem().equals("Choose"))
                {
                    JOptionPane.showMessageDialog(null, "Please Choose Your New Resident State!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else 
                {   
                    try
                        {
                        BDA.OnlineBanking.Employee_Array_List.get(EmployeeLayout.Search_Employee_Layout_Object.Index).setResident_State((String) Resident_State_Combo_Box_Modify.getSelectedItem());
                    }
                    catch(Exception_Message ex)
                    {}
                    try
                    {
                        BDA.OnlineBanking.Save();
                    }
                    catch (IOException ex)
                    {}
           
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
                }
            }
            
            else if(Modify_Combo_Box.getSelectedItem().equals("Home Address"))
            {
                try
                {
                    BDA.OnlineBanking.Save();
                }
                catch (IOException ex)
                {}
           
                JOptionPane.showConfirmDialog(null, "Your Data Has Been Modified.", "Done", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
}
