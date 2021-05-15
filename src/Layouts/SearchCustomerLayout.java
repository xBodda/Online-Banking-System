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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
 *
 * @author abdel
 */
public class SearchCustomerLayout extends JFrame
{
    int Frame = 600;
    int Width = 200;
    int Hight = 30;
    
    public static SearchCustomerTableLayout Search_Customer_Table_Layout_Object;
    
    public static Person.Customer Temporary_Customer = new Person.Customer();
    
    JLabel National_ID_Label = new JLabel("National ID");
    
    JTextField National_ID_Text_Field = new JTextField();
    
    JButton Back_Button = new JButton();
    JButton Search_Button = new JButton("Search");
    
    JLabel Background = new JLabel();
    
    public static int Index = 0;
    
    public SearchCustomerLayout()
    {
        setFocusable(true);
        addWindowListener(new BDA.Closing());
        setTitle("BDA Bank Server");
        setSize(Frame, Frame);
        setLayout(null);
        
        National_ID_Label.setBounds((Frame - Width) / 2, (Frame - Hight) / 4, Width, Hight);
        National_ID_Label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, Hight));
        National_ID_Label.setForeground(Color.BLACK);
        
        National_ID_Text_Field.setBounds((Frame - Width) / 2, (Frame - Hight) / 3, Width, Hight);
        National_ID_Text_Field.setToolTipText("National ID Must Be 14 Numbers.");
        
        Back_Button.setBounds(0, 0, 50, 50);
        Back_Button.setOpaque(false);
        Back_Button.setBorderPainted(false);
        Back_Button.setBackground(java.awt.Color.WHITE);
        Back_Button.setIcon(new ImageIcon(new ImageIcon("Back.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        
        Search_Button.setBounds((Frame - Width) / 2, (Frame - Hight) / 2, Width, 50);
        
        Background.setIcon(new ImageIcon(new ImageIcon("Background.jpg").getImage().getScaledInstance(Frame, Frame, Image.SCALE_DEFAULT)));
        Background.setBounds(0, 0, Frame, Frame);
        
        add(Back_Button);
        add(National_ID_Label);
        add(National_ID_Text_Field);
        add(Search_Button);
        add(Background);
        
        Back_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ModifyingLayout.Customer_Layout_Object.setVisible(true);
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
        
        Search_Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                boolean Found = false;
                if(National_ID_Text_Field.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "The ID Field Is Empty, Please Input A Valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    for(Person.Customer C : BDA.OnlineBanking.Customer_Array_List)
                    {
                        if(C.getNational_ID().equals(National_ID_Text_Field.getText()))
                        {
                            Found = true;
                            
                            Temporary_Customer = C;
                            
                            dispose();
                            Search_Customer_Table_Layout_Object = new SearchCustomerTableLayout();
                            Search_Customer_Table_Layout_Object.setVisible(true);
                            Search_Customer_Table_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                            Search_Customer_Table_Layout_Object.setResizable(false);
                            break;
                        }
                        Index++;
                    }
                    if(Found == false)
                    {
                        JOptionPane.showMessageDialog(null, "ID Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
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
        
        SwingUtilities.getRootPane(Search_Button).setDefaultButton(Search_Button);
    }
}
