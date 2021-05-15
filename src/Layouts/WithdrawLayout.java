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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
public class WithdrawLayout extends JFrame implements Runnable
{
    int Frame = 600;
    int Width = 200;
    int Hight = 50;
    
    JLabel Account_Numbers_Label = new JLabel("Account Number");
    JLabel Amount_Label = new JLabel("Amount");
    
    JTextField Amount_Text_Field = new JTextField();
    
    JComboBox Accounts_Combo_Box = new JComboBox();
    
    JButton Back_Button = new JButton();
    JButton Withdraw_Button = new JButton("Withdraw");
    
    JLabel Background = new JLabel();
    
    public WithdrawLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Frame, Frame);
        setLayout(null);
        
        Account_Numbers_Label.setBounds((Frame - 500) / 2, 100, 500, Hight);
        Account_Numbers_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, Hight));
        Account_Numbers_Label.setForeground(Color.BLACK);
        
        Amount_Label.setBounds(50, 300, Width, Hight);
        Amount_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, Hight));
        Amount_Label.setForeground(Color.BLACK);
        
        Amount_Text_Field.setBounds(250, 300, Width, Hight);
        Amount_Text_Field.setToolTipText("Amount Must Be Gearter Than 0 and Less Than Or Equal Your Balanace And Less Than 8000 Pounds Per Day.");
        
        Accounts_Combo_Box.addItem("Choose");
        for(Person.Account A : LoginLayout.Temporary_Customer.getAccount_Object())
        {
            Accounts_Combo_Box.addItem(A.getAccount_Number());
        }
        
        Accounts_Combo_Box.setBounds((Frame - Width) / 2, 200, Width, Hight);
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        Withdraw_Button.setBounds((Frame - Width) / 2, (Frame - Hight) - 100, Width, Hight);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
//        add(Account_Numbers_Label);
        add(Amount_Label);
        add(Amount_Text_Field);
//        add(Accounts_Combo_Box);
        add(Withdraw_Button);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                LoginLayout.Customer_Action_Layout_Object.setVisible(true);
            }
        });
        
        Amount_Text_Field.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(Amount_Text_Field.getText().length() == 4)
                {
                    e.consume();
                }
            }
        });
        
        Withdraw_Button.addActionListener(new ActionListener()
        {
            @Override
            public synchronized void actionPerformed(ActionEvent ae)
            {
                int Result;
                
                Result = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Withdraw ?", "Warning", JOptionPane.YES_NO_OPTION);
                
                if(Result == JOptionPane.YES_OPTION)
                {
                    
                    if(Amount_Text_Field.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "The Amount Field Is Empty, Please Input A Valid Amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(!Amount_Text_Field.getText().matches("[0-9]+"))
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Amount, Please Input A Valid Amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(Double.parseDouble(Amount_Text_Field.getText()) <= LoginLayout.Temporary_Customer.getBalance() && Integer.parseInt(Amount_Text_Field.getText()) <= 8000)
                    {
                        
                        LoginLayout.Temporary_Customer.setBalance(
                        LoginLayout.Temporary_Customer.getBalance() - Integer.parseInt(Amount_Text_Field.getText()));


                        try
                        {
                            Clip Clip_Object = AudioSystem.getClip();

                            AudioInputStream Audio_Input_Stream_Object = AudioSystem.getAudioInputStream(new File("Cash Register.wav"));

                            Clip_Object.open(Audio_Input_Stream_Object);

                            Clip_Object.start();
                        }
                        catch(UnsupportedAudioFileException | LineUnavailableException | IOException ex)
                        {}

                        Result = JOptionPane.showConfirmDialog(null,Amount_Text_Field.getText() + " Amount Withdrawed Successfully " + "\n" +"        Your new balance is "+LoginLayout.Temporary_Customer.getBalance(), "Done", JOptionPane.DEFAULT_OPTION);

                        if(Result == JOptionPane.OK_OPTION)
                        {
                            dispose();
                            LoginLayout.Customer_Action_Layout_Object.setVisible(true);
                        }
                        
                    }
                    else if(Integer.parseInt(Amount_Text_Field.getText()) > 8000)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Amount, Please Input A Valid Amount Less Than Or Equal 8000.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The Amount You Have Entered Is Bigger Than Your Balance.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
        
        SwingUtilities.getRootPane(Withdraw_Button).setDefaultButton(Withdraw_Button);
    }
    
    @Override
    public void run()
    {
        try
        {
            sleep(10);
        }
        catch(InterruptedException ex)
        {}
    }
}
