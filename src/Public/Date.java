/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;
import java.io.Serializable;

/**
 *
 * @author abdel
 */
public class Date implements Serializable
{
    private int Day;
    private int Month;
    private int Year;
    
    public Date(int Day, int Month, int Year) 
    {
        this.Day = Day;
        this.Month = Month;
        this.Year = Year;
    }
    
    public int getDay() 
    {
        return Day;
    }
    
    public void setDay(int Day) 
    {
        this.Day = Day;
    }
    
    public int getMonth() 
    {
        return Month;
    }
    
    public void setMonth(int Month) 
    {
        this.Month = Month;
    }
    
    public int getYear() 
    {
        return Year;
    }
    
    public void setYear(int Year) 
    {
        this.Year = Year;
    }
}
