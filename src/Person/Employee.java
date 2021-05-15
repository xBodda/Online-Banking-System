package Person;

/**
 *
 * @author abdel
 */
public class Employee extends Person
{
    String Employee_Position;
    private String Profession;
    
    public String getEmployee_Position() 
    {
        return Employee_Position;
    }

    public void setEmployee_Position(String Employee_Position) throws Exceptions.Exception_Message
    {
        if(Employee_Position.length() > 2)
        {
            this.Employee_Position = Employee_Position;
        }
        else
        {
            throw new Exceptions.Exception_Message("Employee Position Length Is Too Short, Please Input A Valid Employee Position.");
        }
    }
    
    public String getProfession() {
        return Profession;
    }

    public void setProfession(String Profession) throws Exceptions.Exception_Message
    {
        if(Profession.length() > 2)
        {
            this.Profession = Profession;
        }
        else
        {
            throw new Exceptions.Exception_Message("Profession Length Is Too Short, Please Input A Valid Profession.");
        }
    }

    
}