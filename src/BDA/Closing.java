/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDA;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
/**
 *
 * @author abdel
 */
public class Closing implements WindowListener
{
    @Override
    public void windowOpened(WindowEvent we)
    {}

    @Override
    public void windowClosing(WindowEvent we)
    {
        int Result;
        
        Result = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit The Program ?", "Warning", JOptionPane.YES_NO_OPTION);
        
        if(Result == JOptionPane.OK_OPTION)
        {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent we)
    {}

    @Override
    public void windowIconified(WindowEvent we)
    {}

    @Override
    public void windowDeiconified(WindowEvent we)
    {}

    @Override
    public void windowActivated(WindowEvent we)
    {}

    @Override
    public void windowDeactivated(WindowEvent we)
    {}
}
