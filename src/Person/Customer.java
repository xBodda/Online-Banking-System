
package Person;

import java.util.ArrayList;


/**
 *
 * @author abdel
 */
public class Customer extends Person 
{
    private String User_Type;
    private String Profession;
    private String Name_Of_Workplace;
    private int Balance;

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }
    
    private ArrayList<Account> Account_Object = new ArrayList<>();

    public String getUser_Type() {
        return User_Type;
    }

    public void setUser_Type(String User_Type) throws Exceptions.Exception_Message
    {
        if(User_Type.equals("Normal") || User_Type.equals("VIP"))
        {
           this.User_Type = User_Type;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid User Type, Please Choose A Valid User Type.");
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

    public String getName_Of_Workplace() {
        return Name_Of_Workplace;
    }

    public void setName_Of_Workplace(String Name_Of_Workplace) throws Exceptions.Exception_Message
    {
        if(Name_Of_Workplace.length() > 2)
        {
            this.Name_Of_Workplace = Name_Of_Workplace;
        }
        else
        {
            throw new Exceptions.Exception_Message("Name Of Workplace Length Is Too Short, Please Input A Valid Name Of Workplace.");
        }
    }

    public ArrayList<Account> getAccount_Object() {
        return Account_Object;
    }

    public void setAccount_Object(ArrayList<Account> Account_Object) {
        this.Account_Object = Account_Object;
    }
    
    
    
}