/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author abdel
 */
public class AddNewEmployeeLayout extends JFrame
{
   int Frame = 600;
   int Button_Width = 130;
   int Button_Hight = 50;
   int X = 10;
   int Y = 10;
   int Width = 200;
   int Hight = 30;
   
   public static AddNewEmployeeLayout2 Add_New_Employee_Layout2_Object = new AddNewEmployeeLayout2();
   
   public static String Password;
   public static boolean Correct_Password = true;
   
   JLabel Full_Name_Label = new JLabel("Full Name");                 JLabel Age_Label = new JLabel("Age");
   JLabel Nationality_Label = new JLabel("Nationality");             JLabel Gender_Label = new JLabel("Gender");
   JLabel Mobile_Phone_Label = new JLabel("Mobile Phone");           JLabel Home_Phone_Label = new JLabel("Home Phone");
   JLabel National_ID_Label = new JLabel("National ID");             JLabel Educational_State_Label = new JLabel("Educational State");
   JLabel E_Mail_Address_Label = new JLabel("E-Mail Address");
   JLabel Password_Label = new JLabel("Password");                 // JLabel User_Type_Label = new JLabel("User Type");
   
   public static JTextField Full_Name_Text_Field = new JTextField();         public static JTextField Age_Text_Field = new JTextField();
   public static JTextField Mobile_Phone_Text_Field = new JTextField();      public static JTextField Home_Phone_Text_Field = new JTextField();
   public static JTextField National_ID_Text_Field = new JTextField();       public static JTextField E_Mail_Address_Text_Field = new JTextField();
   
   public static JPasswordField Password_Password_Field = new JPasswordField();
   public static JComboBox Nationality_Combo_Box = new JComboBox(Get_All_Countries());
   public static JComboBox Educational_State_Combo_Box = new JComboBox();
   public static JComboBox User_Type_Combo_Box = new JComboBox();
   
   public static JRadioButton Male_Radio_Button = new JRadioButton("Male");
   public static JRadioButton Female_Radio_Button = new JRadioButton("Female");
   
   ButtonGroup Gender_Radio_Button_Group = new ButtonGroup();
    
   JButton Back_Button = new JButton();
   JButton Next_Button = new JButton("Next");
   JLabel Background = new JLabel();
   
   public AddNewEmployeeLayout()
   {
       setFocusable(true);
       addWindowListener(new BDA.Closing());
       setSize(Frame,Frame);
       setTitle("BDA Bank Server");
       setLayout(null);
       
       Full_Name_Label.setBounds(X, Y, Width - 40, Hight);                Full_Name_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));          Full_Name_Label.setForeground(Color.BLACK);
       Age_Label.setBounds(X, Y + 40, Width - 40, Hight);                 Age_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));                Age_Label.setForeground(Color.BLACK);
       Nationality_Label.setBounds(X, Y + 80, Width - 40, Hight);         Nationality_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));        Nationality_Label.setForeground(Color.BLACK);
//       User_Type_Label.setBounds(X, Y + 280, Width - 40, Hight);          User_Type_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));          User_Type_Label.setForeground(Color.BLACK);
       Gender_Label.setBounds(X, Y + 120, Width - 40, Hight);             Gender_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));             Gender_Label.setForeground(Color.BLACK);
       Mobile_Phone_Label.setBounds(X, Y + 160, Width - 40, Hight);       Mobile_Phone_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));       Mobile_Phone_Label.setForeground(Color.BLACK);
       Home_Phone_Label.setBounds(X, Y + 200, Width - 40, Hight);         Home_Phone_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));         Home_Phone_Label.setForeground(Color.BLACK);
       National_ID_Label.setBounds(X, Y + 240, Width - 40, Hight);        National_ID_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));        National_ID_Label.setForeground(Color.BLACK);
       E_Mail_Address_Label.setBounds(X, Y + 320, Width - 40, Hight);     E_Mail_Address_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));     E_Mail_Address_Label.setForeground(Color.BLACK);
       Password_Label.setBounds(X, Y + 280, Width - 40, Hight);           Password_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));           Password_Label.setForeground(Color.BLACK);
       Educational_State_Label.setBounds(X, Y + 360, Width - 40, Hight);  Educational_State_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));  Educational_State_Label.setForeground(Color.BLACK);
       
       Full_Name_Text_Field.setBounds(Width, Y, Width, Hight);             Full_Name_Text_Field.setToolTipText("First Name, Middle Name And Last Name.");
       Age_Text_Field.setBounds(Width, Y + 40, Width, Hight);
       Mobile_Phone_Text_Field.setBounds(Width, Y + 160, Width, Hight);
       Home_Phone_Text_Field.setBounds(Width, Y + 200, Width, Hight);
       National_ID_Text_Field.setBounds(Width, Y + 240, Width, Hight);     National_ID_Text_Field.setToolTipText("National ID Must Be 14 Numbers.");
       E_Mail_Address_Text_Field.setBounds(Width, Y + 320, Width, Hight);  E_Mail_Address_Text_Field.setToolTipText("Please Use A Valid E-Mail Address.");
       Password_Password_Field.setBounds(Width, Y + 280, Width, Hight);    Password_Password_Field.setToolTipText("Passwords Must Have At Least 8 Characters And Contain Numbers.");
       Nationality_Combo_Box.setBounds(Width, Y + 80, Width, Hight);
       Educational_State_Combo_Box.setBounds(Width, Y + 360, Width, Hight);
       Male_Radio_Button.setBounds(Width, Y + 120, Width / 2, Hight);
       Female_Radio_Button.setBounds(Width + Width / 2, Y + 120, Width / 2, Hight);
     //  User_Type_Combo_Box.setBounds(Width, Y + 280, Width, Hight);
       
       Educational_State_Combo_Box.addItem("Choose");
       Educational_State_Combo_Box.addItem("Illiterate");
       Educational_State_Combo_Box.addItem("High School");
       Educational_State_Combo_Box.addItem("Diploma");
       Educational_State_Combo_Box.addItem("College");
       Educational_State_Combo_Box.addItem("Associate's Degree");
       Educational_State_Combo_Box.addItem("Bachelor's Degree");
       Educational_State_Combo_Box.addItem("Master's Degree");
       Educational_State_Combo_Box.addItem("Doctorate Degree");
       
//       User_Type_Combo_Box.addItem("Choose");
//       User_Type_Combo_Box.addItem("Normal");
//       User_Type_Combo_Box.addItem("VIP");
       
       Gender_Radio_Button_Group.add(Male_Radio_Button);
       Gender_Radio_Button_Group.add(Female_Radio_Button);
       
       Back_Button.setBounds(0, 0, 50, 50);
       Back_Button.setOpaque(false);
       Back_Button.setBorderPainted(false);
       Back_Button.setBackground(java.awt.Color.WHITE);
       Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
       
       Next_Button.setBounds(400, 450, Button_Width, Button_Hight);
       
       Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
       Background.setBounds(0, 0, Frame, Frame);
       
       add(Back_Button);
        
        add(Full_Name_Label);   add(Age_Label);           add(Nationality_Label);
        add(Gender_Label);      add(Mobile_Phone_Label);  add(Home_Phone_Label);
        add(National_ID_Label); add(E_Mail_Address_Label);
        add(Password_Label);    add(Educational_State_Label);
        
        add(Full_Name_Text_Field);     add(Age_Text_Field);           add(Mobile_Phone_Text_Field);
        add(Home_Phone_Text_Field);    add(National_ID_Text_Field);   add(E_Mail_Address_Text_Field);
        
        add(Password_Password_Field);
//        add(User_Type_Label);
        add(Nationality_Combo_Box);
        add(User_Type_Combo_Box);
        add(Educational_State_Combo_Box);
         
        add(Male_Radio_Button);    add(Female_Radio_Button);
        
        add(Next_Button);
        
        add(Background);
        
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ModifyingLayout.Employee_Layout_Object.setVisible(true);
            }
        });
        Next_Button.addActionListener(new Next_Handler());
        Age_Text_Field.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(Age_Text_Field.getText().length() == 3)
                {
                    e.consume();
                }
            }
        });
        National_ID_Text_Field.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(National_ID_Text_Field.getText().length() == 14)
                {
                    e.consume();
                }
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
        SwingUtilities.getRootPane(Next_Button).setDefaultButton(Next_Button);
   }
   public static String[] Get_All_Countries()
    {
        String[] Temporary_Countries = new String[Locale.getISOCountries().length];
        String[] CountryCodes = Locale.getISOCountries();
        
        for (int i = 0; i < CountryCodes.length; i++)
        {
            Locale Locale_Object = new Locale("", CountryCodes[i]);
            Temporary_Countries[i] = Locale_Object.getDisplayCountry();
        }
        
        ArrayList<String> Sort = new ArrayList<>(); 
        Collections.addAll(Sort, Temporary_Countries); 
        Collections.sort(Sort);
        
        Temporary_Countries = Sort.toArray(new String[Sort.size()]);
        
        String[] Countries = new String[Temporary_Countries.length];
        Countries[0] = "Choose";
        int Counter = 0;
        for(int i = 1; i < Countries.length; i++)
        {
            if(!Temporary_Countries[Counter].equals("Israel"))
            {
                Countries[i] = Temporary_Countries[Counter];
            }
            else
            {
                i--;
            }
            Counter++;
        }
        return Countries;
    }
   private class Next_Handler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            Password = Password_Password_Field.getText();
            char Character_Array[] = Password.toCharArray();
            for(int i = 0; i < Character_Array.length; i++)
            {
                for(int j = 0; j < 10; j++)
                {
                    if(Character_Array[i] == j)
                    {
                        Correct_Password = false;
                        JOptionPane.showMessageDialog(null, "The Password Field Contains Numbers, Please Input A Valid Password.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if(Correct_Password == false)
                {
                    break;
                }
            }
            
            if(Full_Name_Text_Field.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Full Name Field Is Empty, Please Input A Valid Full Name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Age_Text_Field.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Age Field Is Empty, Please Input A Valid Age.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Nationality_Combo_Box.getSelectedItem().equals("Choose"))
            {
                JOptionPane.showMessageDialog(null, "You Didn't Select The Nationality, Please Select A Valid Nationality.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(!Male_Radio_Button.isSelected() && !Female_Radio_Button.isSelected())
            {
                JOptionPane.showMessageDialog(null, "You Didn't Select The Gender Type, Please Select A Valid Gender Type.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Mobile_Phone_Text_Field.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Mobile Phone Field Is Empty, Please Input A Valid Mobile Phone.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Home_Phone_Text_Field.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Home Phone Field Is Empty, Please Input A Valid Home Phone.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(National_ID_Text_Field.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The National ID Field Is Empty, Please Input A Valid National ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
//            else if(User_Type_Combo_Box.getSelectedItem().equals("Choose"))
//            {
//                JOptionPane.showMessageDialog(null, "You Didn't Select The User Type, Please Select A Valid User Type.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
            else if(E_Mail_Address_Text_Field.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The E-Mail Address Field Is Empty, Please Input A Valid E-Mail Address.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Password_Password_Field.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Password Field Is Empty, Please Input A Valid Password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(Correct_Password == false)
            {}
            else if(Educational_State_Combo_Box.getSelectedItem().equals("Choose"))
            {
                JOptionPane.showMessageDialog(null, "You Didn't Select The Educational State, Please Select A Valid Educational State.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                dispose();
                Add_New_Employee_Layout2_Object.setVisible(true);
                Add_New_Employee_Layout2_Object.setResizable(false);
                Add_New_Employee_Layout2_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }
    }
}
