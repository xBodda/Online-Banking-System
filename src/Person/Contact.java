
package Person;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact implements Serializable
{
    private String E_Mail_Address;
    private String Mobile_Phone;
    private String Home_Phone;
    private String City;
    private String Street;
    private String Postal_Code;
    private int Building_Number;
    private int Department_Number;

    public String getE_Mail_Address() 
    {
        return E_Mail_Address;
    }

    public void setE_Mail_Address(String E_Mail_Address) throws Exceptions.Exception_Message
    {
        String E_Mail_Address_Pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern Pattern_Object = Pattern.compile(E_Mail_Address_Pattern);
	Matcher Matcher_Object = Pattern_Object.matcher(E_Mail_Address);
        
        if(Matcher_Object.matches())
        {
            this.E_Mail_Address = E_Mail_Address;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid E-Mail Address, Please Input A Valid E-Mail Address.");
        }
    }

    public String getMobile_Phone() 
    {
        return Mobile_Phone;
    }

    public void setMobile_Phone(String Mobile_Phone) throws Exceptions.Exception_Message
    {
        if(Mobile_Phone.length() > 6 && Mobile_Phone.matches("[0-9]+"))
        {
            this.Mobile_Phone = Mobile_Phone;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Home Phone, Please Input A Valid Home Phone.");
        }
    }

    public String getHome_Phone() 
    {
        return Home_Phone;
    }

    public void setHome_Phone(String Home_Phone) throws Exceptions.Exception_Message
    {
        if(Home_Phone.length() > 6 && Home_Phone.matches("[0-9]+"))
        {
            this.Home_Phone = Home_Phone;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Home Phone, Please Input A Valid Home Phone.");
        }
    }

    public String getCity() 
    {
        return City;
    }

    public void setCity(String City) throws Exceptions.Exception_Message
    {
        if(City.length() >= 0)
        {
           this.City = City;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid City, Please Input A Valid City.");
        }
    }

    public String getStreet() 
    {
        return Street;
    }

    public void setStreet(String Street) throws Exceptions.Exception_Message
    {
        if(Street.length() >= 2)
        {
          this.Street = Street;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Street, Please Input A Valid Street.");
        }
    }
    
    public String getPostal_Code() 
    {
        return Postal_Code;
    }

    public void setPostal_Code(String Postal_Code) throws Exceptions.Exception_Message
    {
        if(Postal_Code.length() == 5 && Postal_Code.matches("[0-9]+"))
        {
            this.Postal_Code = Postal_Code;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Postal Code, Please Input A Valid Postal Code.");
        }
    }
    
    public int getBuilding_Number() 
    {
        return Building_Number;
    }

    public void setBuilding_Number(int Building_Number) throws Exceptions.Exception_Message
    {
        if(Integer.toString(Building_Number).length() > 0 && Building_Number > 0 && Integer.toString(Building_Number).matches("[0-9]+"))
        {
             this.Building_Number = Building_Number;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Building Number, Please Input A Valid Building Number.");
        }
    }

    public int getDepartment_Number() 
    {
        return Department_Number;
    }

    public void setDepartment_Number(int Department_Number) throws Exceptions.Exception_Message
    {
        if(Integer.toString(Department_Number).length() > 0 && Department_Number > 0 && Integer.toString(Department_Number).matches("[0-9]+"))
        {
            this.Department_Number = Department_Number;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Department Number, Please Input A Valid Department Number.");
        }
    }
}