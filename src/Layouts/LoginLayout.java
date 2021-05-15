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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
/**
 *
 * @author abdel
 */
public class LoginLayout extends JFrame implements Runnable
{
    int Frame = 600;
    int Width = 200;
    int Hight = 30;
    
    public static ModifyingLayout Modifying_Layout_Object = new ModifyingLayout();
    public static CustomerActionLayout Customer_Action_Layout_Object;
    
    public static Person.Customer Temporary_Customer = new Person.Customer();
    
    public static String Decrypted_Password;
    
    public static boolean Found = false;
    
    JLabel User_Name_Label = new JLabel("User Name");
    JLabel Password_Label = new JLabel("Password");
    
    JTextField User_Name_Text_Field = new JTextField("National ID");
    
    JPasswordField Password_Password_Field = new JPasswordField();
    char Default = Password_Password_Field.getEchoChar();
    
    JButton Sign_In_Button = new JButton("Sign In");
    JButton Teller_Sign_In_Button = new JButton("Teller Sign In");
    JButton Show_Button = new JButton("Show");
    JButton Hide_Button = new JButton("Hide");
    
    JLabel Logo = new JLabel();
    
    public LoginLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Frame, Frame);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        User_Name_Label.setBounds(50, 100, Width, Hight);
        User_Name_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, Hight));
        User_Name_Label.setForeground(Color.BLACK);
        
        Password_Label.setBounds(50, 200, Width, Hight);
        Password_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, Hight));
        Password_Label.setForeground(Color.BLACK);
        
        User_Name_Text_Field.setBounds(250, 100, Width, Hight);
        User_Name_Text_Field.setToolTipText("User Name Must Have At Least 4 Characters.");
        User_Name_Text_Field.setForeground(Color.GRAY);
        
        Password_Password_Field.setBounds(250, 200, Width, Hight);
        Password_Password_Field.setToolTipText("Passwords Must Have At Least 8 Characters And Contain Numbers.");
        
        Sign_In_Button.setBounds(80, 300, Width, 50);
        Teller_Sign_In_Button.setBounds(320, 300, Width, 50);
        Show_Button.setBounds(450, 200, 80, Hight);
        Hide_Button.setBounds(450, 200, 80, Hight);
        Hide_Button.setVisible(false);
        
        Logo.setIcon(new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
        Logo.setBounds(200, 380, 150, 150);
        
        add(User_Name_Label);
        add(Password_Label);
        add(User_Name_Text_Field);
        add(Password_Password_Field);
        add(Sign_In_Button);
        add(Teller_Sign_In_Button);
        add(Show_Button);
        add(Hide_Button);
        add(Logo);
        
        User_Name_Text_Field.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {
                if(User_Name_Text_Field.getText().equals("National ID"))
                {
                    User_Name_Text_Field.setText("");
                    User_Name_Text_Field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe)
            {
                if(User_Name_Text_Field.getText().equals(""))
                {
                    User_Name_Text_Field.setForeground(Color.GRAY);
                    User_Name_Text_Field.setText("National ID");
                }
            }
        });
        
        Sign_In_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    Decrypted_Password = BDA.OnlineBanking.Caesar_Cipher_Decryption(BDA.OnlineBanking.Accounts.get(User_Name_Text_Field.getText()), 6);
                }
                catch(NullPointerException ex)
                {}
                
                if(User_Name_Text_Field.getText().equals("National ID"))
                {
                    JOptionPane.showMessageDialog(null, "The User Name Field Is Empty, Please Input A Valid User Name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(Password_Password_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "The Password Field Is Empty, Please Input A Valid Password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(BDA.OnlineBanking.Accounts.get(User_Name_Text_Field.getText()) == null)
                {
                    JOptionPane.showMessageDialog(null, "Invalid User Name, Please Input A Valid User Name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!Decrypted_Password.equals(Password_Password_Field.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Password, Please Input A Valid Password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(Decrypted_Password.equals(Password_Password_Field.getText()))
                {
                    for(Person.Customer C : BDA.OnlineBanking.Customer_Array_List)
                    {
                        if(User_Name_Text_Field.getText().equals(C.getNational_ID()))
                        {
                            Found = true;
                            Temporary_Customer = C;
                        }
                    }
                    
                    dispose();
                    
                    if(Found == true)
                    {
                        Customer_Action_Layout_Object = new CustomerActionLayout();
                        Customer_Action_Layout_Object.setVisible(true);
                        Customer_Action_Layout_Object.setResizable(false);
                        Customer_Action_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                    else
                    {
                        Modifying_Layout_Object.setVisible(true);
                        Modifying_Layout_Object.setResizable(false);
                        Modifying_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                }
            }
        });
        
        Teller_Sign_In_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(User_Name_Text_Field.getText().equals("National ID"))
                {
                    JOptionPane.showMessageDialog(null, "The User Name Field Is Empty, Please Input A Valid User Name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(BDA.OnlineBanking.Accounts.get(User_Name_Text_Field.getText()) == null)
                {
                    JOptionPane.showMessageDialog(null, "Invalid User Name, Please Input A Valid User Name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(User_Name_Text_Field.getText().equals("Admin"))
                {
                    JOptionPane.showMessageDialog(null, "Invalid User Name, Please Input A Valid User Name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(Password_Password_Field.getText().equals("Admin"))
                {
                    JOptionPane.showMessageDialog(null, "Invalid Password, Please Input A Valid Password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    for(Person.Customer C : BDA.OnlineBanking.Customer_Array_List)
                    {
                        if(User_Name_Text_Field.getText().equals(C.getNational_ID()) && Password_Password_Field.getText().equals(C.getPassword()))
                        {
                            Temporary_Customer = C;
                        }
                    }
                    
                    dispose();
                    
                    Customer_Action_Layout_Object = new CustomerActionLayout();
                    Customer_Action_Layout_Object.setVisible(true);
                    Customer_Action_Layout_Object.setResizable(false);
                    Customer_Action_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
        Show_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                Password_Password_Field.setEchoChar((char)0);
                Show_Button.setVisible(false);
                Hide_Button.setVisible(true);
            }
        });
        
        Hide_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                Password_Password_Field.setEchoChar(Default);
                Hide_Button.setVisible(false);
                Show_Button.setVisible(true);
            }
        });
        
        User_Name_Text_Field.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(User_Name_Text_Field.getText().length() == 14)
                {
                    e.consume();
                }
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
    @Override
    public void run()
    {
        while(true)
        {
            int Play_Time = 4000;
            int Start_X = -100;
            int Start_Y = 380;
            
            int Target_X = 600;
            int Target_Y = 380;
            
            long Start_Time = System.currentTimeMillis();
            
            Timer timer = new Timer(0, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    long Duration = System.currentTimeMillis() - Start_Time;
                    float Progress = (float)Duration / (float)Play_Time;
                    if(Progress > 1f)
                    {
                        Progress = 1f;
                        ((Timer)(ae.getSource())).stop();
                    }

                    int x = Start_X + (int)Math.round((Target_X - Start_X) * Progress);
                    int y = Start_Y + (int)Math.round((Target_Y - Start_Y) * Progress);

                    Logo.setLocation(x, y);
                }
            });
            timer.start();
            
            try
            {
                Thread.sleep(4000);
            }
            catch(InterruptedException ex)
            {}
        }
    }
}
