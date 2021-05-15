/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author abdel
 */
public class CustomerActionLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 50;
    
    public static DisplayCustomerDataLayout Display_Customer_Data_Layout_Object = new DisplayCustomerDataLayout();
    public static DepositLayout Deposite_Layout_Object;
    public static WithdrawLayout Withdraw_Layout_Object = new WithdrawLayout();
    public static MoneyTransferLayout Money_Transfer_Layout_Object = new MoneyTransferLayout();
    public static LiveChatLayout Live_Chat_Layout_Object;

    
    
    JButton Back_Button = new JButton();
    JButton Display_Data_Button = new JButton("Display Data");
    JButton Deposite_Button = new JButton("Deposite");
    JButton Withdraw_Button = new JButton("Withdraw");
    JButton LiveChat_Button = new JButton("Live Chat");
    JButton Money_Transfer_Button = new JButton("Money Transfer");
    JButton View_Balance_Button = new JButton("View Balance");
    
    JLabel Background = new JLabel();
    
    public CustomerActionLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Client");
        setSize(Frame, Frame);
        setLayout(null);
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        Display_Data_Button.setBounds((Frame - Width) / 2, (Frame - Hight) / 6, Width, Hight);
        Deposite_Button.setBounds((Frame - Width) / 2, (Frame - Hight) / 3, Width, Hight);
        Withdraw_Button.setBounds((Frame - Width) / 2, (Frame - Hight) / 2, Width, Hight);
//        LiveChat_Button.setBounds((Frame - Width) / 2, (Frame - Hight) - 180, Width, Hight);
        Money_Transfer_Button.setBounds((Frame - Width) / 2, (Frame - Hight) - 180, Width, Hight);
        View_Balance_Button.setBounds((Frame - Width) / 2, (Frame - Hight) - 180, Width, Hight);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(Display_Data_Button);
        add(Deposite_Button);
        add(Withdraw_Button);
        add(View_Balance_Button);
//        add(LiveChat_Button);
        //add(Money_Transfer_Button);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                BDA.OnlineBanking.Login_Layout_Object.setVisible(true);
                LoginLayout.Temporary_Customer = null;
            }
        });
        
        //Deposite_Layout_Object.run();
        //Withdraw_Layout_Object.run();
        
        Display_Data_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Display_Customer_Data_Layout_Object.setVisible(true);
                Display_Customer_Data_Layout_Object.setResizable(false);
                Display_Customer_Data_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Deposite_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Deposite_Layout_Object = new DepositLayout();
                Deposite_Layout_Object.setVisible(true);
                Deposite_Layout_Object.setResizable(false);
                Deposite_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Withdraw_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Withdraw_Layout_Object.setVisible(true);
                Withdraw_Layout_Object.setResizable(false);
                Withdraw_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
        Money_Transfer_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Money_Transfer_Layout_Object.setVisible(true);
                Money_Transfer_Layout_Object.setResizable(false);
                Money_Transfer_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        
//        LiveChat_Button.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent ae) 
//            {
//                dispose();
//                Chat_Server_Object.setVisible(true);
//                Chat_Client_Object.setVisible(true);
//            }
//        });
        
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
        View_Balance_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                JOptionPane.showConfirmDialog(null," Your balance is "+LoginLayout.Temporary_Customer.getBalance() , "Done", JOptionPane.DEFAULT_OPTION);
            }
        });
    }
}
