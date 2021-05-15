package Exceptions;

import javax.swing.JOptionPane;

public class Exception_Message extends Exception
{
    public Exception_Message(String Message)
    {
        super(Message);
        JOptionPane.showMessageDialog(null, Message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
