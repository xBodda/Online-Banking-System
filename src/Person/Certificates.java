package Person;
import java.io.Serializable;

/**
 *
 * @author abdel
 */
public class Certificates implements Serializable
{
    private int Percentage;
    
    public void CheckDate(Public.Date x)
    {
        
    }
    
    public int getPercentage()
    {
        return Percentage;
    }
    
    public void setPercentage(int Percentage)
    {
        this.Percentage = Percentage;
    }
}
