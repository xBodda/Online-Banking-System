/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CardsLayout extends JFrame
{
    int Frame = 600;
    int Hight = 30;
    
    public static SearchCustomerTableLayout Search_Customer_Table_Layout_Object= new SearchCustomerTableLayout();
    
    public static Person.GoldCard Gold_Card_Object;
    public static Person.PlatinumCard Platinum_Card_Object;
    
    JComboBox Use_Card=new JComboBox();
    JLabel Price_Label=new JLabel("Enter the price");
    JTextField Price_Text_Field=new JTextField();
    JButton Ok_Button = new JButton("Ok");
    
    JLabel Background = new JLabel();
    
    JButton Back_Button = new JButton();
    
    public CardsLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Frame, Frame);
        setLayout(null);
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        Use_Card.setBounds(100, 100, 300, 30);
        Use_Card.addItem("Gold Card");
        Use_Card.addItem("Platinum Card");
        
        Price_Label.setBounds(100, 150, 300, 30);
        Price_Text_Field.setBounds(100, 200, 300, 30);
        Ok_Button.setBounds(100, 250, 300, 30);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Use_Card);
        add(Price_Label);
        add(Price_Text_Field);
        add(Ok_Button);
        add(Back_Button);
        add(Background);
        
        Ok_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(Use_Card.getSelectedItem().equals("Gold Card"))
                {
                    Gold_Card_Object = new Person.GoldCard();
                    Gold_Card_Object.Price = Double.parseDouble(Price_Text_Field.getText());
                    Gold_Card_Object.Gift();
                    Gold_Card_Object.Bonus();
                    JOptionPane.showConfirmDialog(null, "Gift: " + Gold_Card_Object.Discount_After_Gift + " LE " + " Bonus: " + Gold_Card_Object.Discount_After_Bonus + " LE.", "Warning", JOptionPane.DEFAULT_OPTION);
                }
                else if(Use_Card.getSelectedItem().equals("Platinum Card"))
                {
                    Platinum_Card_Object = new Person.PlatinumCard();
                    Platinum_Card_Object.Price = Double.parseDouble(Price_Text_Field.getText());
                    Platinum_Card_Object.Gift();
                    Platinum_Card_Object.Bonus();
                    JOptionPane.showConfirmDialog(null, "Gift: " + Platinum_Card_Object.Discount_After_Gift + " LE " + " Bonus: " + Platinum_Card_Object.Discount_After_Bonus + " LE.", "Warning", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        
        Back_Button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
                Search_Customer_Table_Layout_Object.setVisible(true);
                Search_Customer_Table_Layout_Object.setResizable(false);
                Search_Customer_Table_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
    }
}
