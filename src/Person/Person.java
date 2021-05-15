package Person;

import Exceptions.Exception_Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public abstract class Person  implements Serializable 
{
    private Contact Contact_Object;
    
    private String Name;
    private String Gender;
    private String Nationality;
    private String Educational_State;
    private String Social_State;
    private String Resident_State;
    private String Password;
    private String National_ID;
    private int Age;
    private int Salary;

    public Person()
    {
        Contact_Object = new Contact();
    }
    
    public Contact getContact_Object() {
        return Contact_Object;
    }

    public void setContact_Object(Contact Contact_Object) {
        this.Contact_Object = Contact_Object;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) throws Exceptions.Exception_Message
    {
        if(Name.length() >= 8)
        {
            this.Name = Name;
        }
        else
        {
            throw new Exceptions.Exception_Message("Full Name Length Is Too Short, Please Input A Valid Full Name.");
        }
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) throws Exceptions.Exception_Message
    {
        if(Gender.equals("Male") || Gender.equals("Female"))
        {
            this.Gender = Gender;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Gender, Please Choose A Valid Gender.");
        }
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) throws Exceptions.Exception_Message
    {
        String Nationalities[] = Get_All_Countries();
        for(String N : Nationalities)
        {
            if(Nationality.equals(N))
            {
                this.Nationality = Nationality;
                return;
            }
        }
        throw new Exceptions.Exception_Message("Invalid Nationality, Please Choose A Valid Nationality.");
    }

    public String getEducational_State() {
        return Educational_State;
    }

    public void setEducational_State(String Educational_State) throws Exceptions.Exception_Message
    {
        if(Educational_State.equals("Illiterate") || Educational_State.equals("High School") || Educational_State.equals("Diploma")
        || Educational_State.equals("College") || Educational_State.equals("Associate's Degree") || Educational_State.equals("Bachelor's Degree")
        || Educational_State.equals("Master's Degree") || Educational_State.equals("Doctorate Degree"))
        {
            this.Educational_State = Educational_State;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Educational State, Please Choose A Valid Educational State.");
        }
    }

    public String getSocial_State() {
        return Social_State;
    }

    public void setSocial_State(String Social_State) throws Exceptions.Exception_Message
    {
        if(Social_State.equals("Single") || Social_State.equals("Married") || Social_State.equals("Widowed") || Social_State.equals("Divorced"))
        {
            this.Social_State = Social_State;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Social State, Please Choose A Valid Social State.");
        }
    }

    public String getResident_State() {
        return Resident_State;
    }

    public void setResident_State(String Resident_State) throws Exceptions.Exception_Message
    {
        if(Resident_State.equals("Resident") || Resident_State.equals("Non-Resident") || Resident_State.equals("Statutory Resident")
        || Resident_State.equals("Part-Year Residents"))
        {
            this.Resident_State = Resident_State;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Resident State, Please Choose A Valid Resident State.");
        }
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) throws Exceptions.Exception_Message
    {
        if(Password.length() < 8)
        {
            throw new Exceptions.Exception_Message("Password Length Is Too Short, Please Input A Valid Password.");
        }
        else if(Password.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*"))
        {
            this.Password = Password;
            return;
        }
        throw new Exceptions.Exception_Message("Password Must At least Contain One Number, Please Input A Valid Password.");
    }
    
    public String getNational_ID() {
        return National_ID;
    }

    public void setNational_ID(String National_ID) throws Exceptions.Exception_Message
    {
        if(National_ID.length() == 14 && National_ID.matches("[0-9]+"))
        {
            this.National_ID = National_ID;
        }
        else
        {
            throw new Exceptions.Exception_Message("National ID Must Be Exactly 14 Number, Please Input A Valid National ID.");
        }
    }
    
    public int getAge() {
        return Age;
    }

    public void setAge(int Age) throws Exceptions.Exception_Message
    {
        if(Age >= 18 && Age <= 150 && Integer.toString(Age).matches("[0-9]+"))
        {
            this.Age = Age;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Age, Please Input A Valid Age.");
        }
    }
    
    public double getSalary() {
        return Salary;
    }

    public void setSalary(int Salary)
    {
        if(Integer.toString(Salary).matches("[0-9]+"))
        {
            this.Salary = Salary;
        }
    }
    
    public void E_Mail_Address_Aggregation(String E_Mail_Address) throws Exception_Message
    {
        Contact_Object.setE_Mail_Address(E_Mail_Address);
    }
    
    public void Mobile_Phone_Aggregation(String Mobile_Phone) throws Exception_Message
    {
        Contact_Object.setMobile_Phone(Mobile_Phone);
    }
    
    public void Home_Phone_Aggregation(String Home_Phone) throws Exception_Message
    {
        Contact_Object.setHome_Phone(Home_Phone);
    }
    
    public void City_Aggregation(String City) throws Exception_Message
    {
        Contact_Object.setCity(City);
    }
    
    public void Street_Aggregation(String Street) throws Exception_Message
    {
        Contact_Object.setStreet(Street);
    }
    
    public void Postal_Code_Aggregation(String Postal_Code) throws Exception_Message
    {
        Contact_Object.setPostal_Code(Postal_Code);
    }
    
    public void Building_Number_Aggregation(int Building_Number) throws Exception_Message
    {
        Contact_Object.setBuilding_Number(Building_Number);
    }
    
    public void Department_Number_Aggregation(int Department_Number) throws Exception_Message
    {
        Contact_Object.setDepartment_Number(Department_Number);
    }
    public static String[] Get_All_Countries()
    {
        String[] Temporary_Countries = new String[Locale.getISOCountries().length];
        String[] CountryCodes = Locale.getISOCountries();
        
        for (int i = 0; i < CountryCodes.length; i++)
        {
            Locale Locale_Object = new Locale("", CountryCodes[i]);
            Temporary_Countries[i] = Locale_Object.getDisplayCountry();
        }
        
        ArrayList<String> Sort = new ArrayList<>(); 
        Collections.addAll(Sort, Temporary_Countries); 
        Collections.sort(Sort);
        
        Temporary_Countries = Sort.toArray(new String[Sort.size()]);
        
        String[] Countries = new String[Temporary_Countries.length];
        Countries[0] = "Choose";
        int Counter = 0;
        for(int i = 1; i < Countries.length; i++)
        {
            if(!Temporary_Countries[Counter].equals("Israel"))
            {
                Countries[i] = Temporary_Countries[Counter];
            }
            else
            {
                i--;
            }
            Counter++;
        }
        return Countries;
    }
}
