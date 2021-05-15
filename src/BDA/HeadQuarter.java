package BDA;
import java.io.Serializable;
/**
 *
 * @author abdel
 */
public class HeadQuarter implements Serializable 
{
    private Person.Contact X;
    private String Name;
    private int Code;

    public HeadQuarter() 
    {
        this.Name = "BDA Bank Server";
        this.Code = 1;
        X = new Person.Contact();
    }

    public Person.Contact getX() 
    {
        return X;
    }

    public void setX(Person.Contact X) 
    {
        this.X = X;
    }

    public String getName() 
    {
        return Name;
    }

    public void setName(String Name) 
    {
        this.Name = Name;
    }

    public int getCode() 
    {
        return Code;
    }

    public void setCode(int Code) 
    {
        this.Code = Code;
    }
}
