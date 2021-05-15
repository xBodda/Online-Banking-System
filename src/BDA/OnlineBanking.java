package BDA;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


public class OnlineBanking 
{
    
   
    public static HashMap<String, String> Accounts = new HashMap<String, String>();
    public static Server Server_Object = new Server();
    public static ArrayList<Person.Customer> Customer_Array_List = new ArrayList<>();
    public static ArrayList<Person.Employee> Employee_Array_List = new ArrayList<>();
    public static String Accounts_Counter = "1000000000000001";
    public static int Encryption_Key = 6;
    public static Layouts.LoginLayout Login_Layout_Object = new Layouts.LoginLayout();
    public static void main (String[] args) throws IOException, ClassNotFoundException, LineUnavailableException, UnsupportedAudioFileException
    {
        
  
        try
        {
            try(ObjectInputStream Customer_In_File = new ObjectInputStream(new FileInputStream("Customer Data.bin")))
            {
                Customer_Array_List = (ArrayList<Person.Customer>) Customer_In_File.readObject();
                Customer_In_File.close();
            }
        }
            catch(FileNotFoundException | EOFException e)
            {
            PrintWriter Empty_String = new PrintWriter(new File("Customer Data.bin"));
            Empty_String.close();
            }
        
        try
        {
            try(ObjectInputStream Employee_In_File = new ObjectInputStream(new FileInputStream("Employee Data.bin")))
            {
                Employee_Array_List = (ArrayList<Person.Employee>) Employee_In_File.readObject();
                Employee_In_File.close();
            }
        }
            catch(FileNotFoundException | EOFException e)
            {
            PrintWriter Empty_String = new PrintWriter(new File("Employee Data.bin"));
            Empty_String.close();
            }
        
        try
        {
            try(Scanner Bank_In_File = new Scanner(new File("Bank Data.txt")))
            {
                Accounts_Counter = Bank_In_File.nextLine();
                Bank_In_File.close();
            }
        }
        catch(FileNotFoundException e)
        {
            try(PrintWriter Bank_Out_File = new PrintWriter(new File("Bank Data.txt")))
            {
                Bank_Out_File.write(Accounts_Counter);
                Bank_Out_File.close();
            }
        }
        
        Accounts.put("Admin", Caesar_Cipher_Encryption("Admin", Encryption_Key));
        
        for(Person.Customer C : Customer_Array_List)
        {
            Accounts.put(C.getNational_ID(), Caesar_Cipher_Encryption(C.getPassword(), Encryption_Key));
        }
        
        for(Person.Employee E : Employee_Array_List)
        {
            Accounts.put(E.getNational_ID(), Caesar_Cipher_Encryption(E.getPassword(), Encryption_Key));
        }
        
        Login_Layout_Object.setVisible(true);
        Login_Layout_Object.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Login_Layout_Object.setResizable(false);
        
        Thread Login_Layout_Thread = new Thread(Login_Layout_Object);
        Login_Layout_Thread.start();
        
        Thread Server_Thread = new Thread(Server_Object);
        Server_Thread.start();

        Clip Clip_Object = AudioSystem.getClip();
        
        AudioInputStream Audio_Input_Stream_Object = AudioSystem.getAudioInputStream(new File("Background Music.wav"));
        
        Clip_Object.open(Audio_Input_Stream_Object);
        
        FloatControl Gain_Control = (FloatControl) Clip_Object.getControl(FloatControl.Type.MASTER_GAIN);
        
        Gain_Control.setValue(-15.0f);
        
        Clip_Object.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public static void Save() throws FileNotFoundException, IOException
    {
        try(ObjectOutputStream Customer_Out_File = new ObjectOutputStream(new FileOutputStream("Customer Data.bin")))
        {
            Customer_Out_File.writeObject(Customer_Array_List);
            Customer_Out_File.close();
        }
        
        try(ObjectOutputStream Employee_Out_File = new ObjectOutputStream(new FileOutputStream("Employee Data.bin")))
        {
            Employee_Out_File.writeObject(Employee_Array_List);
            Employee_Out_File.close();
        }
        
        try(PrintWriter Bank_Out_File = new PrintWriter(new File("Bank Data.txt")))
        {
            Bank_Out_File.write(Accounts_Counter);
            Bank_Out_File.close();
        }
    }
    public static String Caesar_Cipher_Encryption(String T, int K)
    {
        String Encrypted = "";
        
        for(int i = 0; i < T.length(); i++)
        {
            Encrypted += (char)(T.charAt(i) + K);
        }
        return Encrypted;
    }
    public static String Caesar_Cipher_Decryption(String T, int K)
    {
        String Decrypted = "";
        
        for(int i = 0; i < T.length(); i++)
        {
            Decrypted += (char)(T.charAt(i) - K);
        }
        return Decrypted;
    }
    public String enc(String line)
    {
        String Encted = "";
        Accounts.put("A", "@$");
        char characters[] = line.toCharArray();
        for(int i = 0; i < line.length(); i++)
        {
            if(Accounts.get(characters[i]) != null)
            {
                Encted += Accounts.get(characters[i]);
            }
        }
        return Encted;
        
        
        
//        Person.FileCustomers bnk=new Person.FileCustomers();
//        Person.FileEmployee asd=new Person.FileEmployee();
//        Scanner input = new Scanner (System.in);
//        int choice;
//        int choice2;
//        //int choice;
//        System.out.println("**********Wellcome to BDA Online Banking System**********");
//        System.out.println("");
//        System.out.println("");
//        do{
//        System.out.println("Choose From The Menu Below");
//        System.out.println("1.Customer");
//        System.out.println("2.Teller");
//        System.out.println("3.Exit");
//        choice2 = input.nextInt();
//        
//        switch(choice2)
//        {
//            case 1:
//                Person.Account a1 = new Person.Account();
//                Person.Card card1 = new Person.Card();
//                
//                
//                card1.setCard_Number("5262442062031717");
//                card1.setCard_Pin(1234);
//                card1.setExpiry_Date("09/23");
//                card1.setMinimum_Amount(100);
//                card1.setProduced_Date("10/19");
//                card1.setUber_End_Date("10/20");
//                card1.setUber_Percentage(25);
//                card1.setUber_Promo_Code("GOBDA");
//                card1.setUber_Rides(3);
//                card1.setUber_Start_Date("10/19");
//                a1.setAccount_Number();
//                a1.setBalance();
//                if(a1.getBalance()>100 && a1.getBalance()<5000 )
//                {
//                    System.out.println("You are on White Card Program");
//                    Person.WhiteCard w1 = new Person.WhiteCard();
//                    System.out.println("Number of uber rides " +w1.getUber_Rides());
//                    System.out.println("Percentage of uber rides "+w1.getUber_Percentage());
//                    System.out.println("Uber Promo Code is "+w1.getUber_Promo_Code());
//                    break;
//                }
//            
//                if(a1.getBalance()>5000 && a1.getBalance()<15000 )
//                {
//                    System.out.println("You are on Gold Card Program");
//                    Person.GoldCard g1 = new Person.GoldCard();
//                    System.out.println("Number of uber rides " +g1.getUber_Rides());
//                    System.out.println("Percentage of uber rides "+g1.getUber_Percentage());
//                    System.out.println("Uber Promo Code is "+g1.getUber_Promo_Code());
//                    break;
//                }
//                if(a1.getBalance()>15000 && a1.getBalance()<50000 )
//                {
//                    System.out.println("You are on Titanium Card Program");
//                    Person.TitaniumCard t1 = new Person.TitaniumCard();
//                    System.out.println("Number of uber rides " +t1.getUber_Rides());
//                    System.out.println("Percentage of uber rides "+t1.getUber_Percentage());
//                    System.out.println("Uber Promo Code is "+t1.getUber_Promo_Code());
//                    break;
//                }
//                if(a1.getBalance()>50000)
//                {
//                    System.out.println("You are on Platinum Card Program");
//                    Person.PlatinumCard p1 = new Person.PlatinumCard();
//                    System.out.println("Number of uber rides " +p1.getUber_Rides());
//                    System.out.println("Percentage of uber rides "+p1.getUber_Percentage());
//                    System.out.println("Uber Promo Code is "+p1.getUber_Promo_Code());
//                    break;
//                }
//            case 2:
//                do{
//        System.out.println("Choose From The Menu Below");
//        System.out.println("1.Add new Customer");
//        System.out.println("2.Add new Employee");
//
//        System.out.println("5.exit");
//        choice = input.nextInt();
//
//        switch(choice)
//        {
//         
//            case 1:
//                Person.Customer c1 = new Person.Customer();
//                c1.setName();
//                c1.setNationality();
//                c1.setGender();
//                c1.setSocial_State();
//                c1.setResident_State();
//                c1.setPassword();
//                c1.setNational_ID();
//                c1.setAge();
//                c1.setSalary();
//                c1.setUser_Type();
//                c1.setProfession();
//                c1.setName_Of_Workplace();
//                Person.Contact cc1= new Person.Contact();
//                cc1.setCity();
//                cc1.setBuilding_Number();
//                cc1.setDepartment_Number();
//                cc1.setE_Mail_Address();
//                cc1.setHome_Phone();
//                cc1.setMobile_Phone();
//                cc1.setPostal_Code();
//                Customer_Array_List.add(c1);
//                Customers_Contacts_Array_List.add(cc1);
//                bnk.addcustomer(c1);
//                
//                break;
//            case 2:
//                Person.Employee e1 = new Person.Employee();
//                e1.setName();
//                e1.setGender();
//                e1.setNationality();
//                e1.setSocial_State();
//                e1.setResident_State();
//                e1.setPassword();
//                e1.setNational_ID();
//                e1.setAge();
//                e1.setSalary();
//                e1.setEmployee_Position();
//                Person.Contact ce1= new Person.Contact();
//                ce1.setCity();
//                ce1.setBuilding_Number();
//                ce1.setDepartment_Number();
//                ce1.setE_Mail_Address();
//                ce1.setHome_Phone();
//                ce1.setMobile_Phone();
//                ce1.setPostal_Code();
//                Employee_Array_List.add(e1);
//                Employees_Contacts_Array_List.add(ce1);
//                asd.addemp(e1);
//                break;
//            case 5:
//                System.out.println("Good Bye, See You Again");
//                break;
//                
//        }
//                
//                
//        
//        
//                
//            
//            
//        }while(choice !=5);
//            case 3:
//                System.out.println("Good bye,See you again");
//        }
//        }while(choice2 != 3);
        

    }
}

    
  /*
        try ( BufferedWriter BW = new BufferedWriter (new FileWriter (FNAME)) ) 
		{			
			for (String line : Customer_Array_List) 
                        {
				BW.write (line + "\n");
			}
			
			BW.close ();
			
		} 
                 catch (IOException e) 
                {
			e.printStackTrace ();
		}
         */
//    public static void Save() throws FileNotFoundException, IOException
//    {
//        try(ObjectOutputStream Customer_Out_File = new ObjectOutputStream(new FileOutputStream("Customer Data.txt")))
//        {
//            Customer_Out_File.writeObject(Customer_Array_List);
//            Customer_Out_File.close();
//        }
//        
//        try(ObjectOutputStream Employee_Out_File = new ObjectOutputStream(new FileOutputStream("Employee Data.txt")))
//        {
//            Employee_Out_File.writeObject(Employee_Array_List);
//            Employee_Out_File.close();
//        }
//        
//        try(PrintWriter Bank_Out_File = new PrintWriter(new File("Bank Data.txt")))
//        {
//            Bank_Out_File.write(Accounts_Counter);
//            Bank_Out_File.close();
//        }
//    }



//    public static HashMap<String, String> Accounts = new HashMap<String, String>();
//    public static ArrayList<Person.Customer> Customer_Array_List = new ArrayList<>();
//    public static ArrayList<Person.Employee> Employee_Array_List = new ArrayList<>();
//    public static String Accounts_Counter = "1000000000000001";
//    public static int Encryption_Key = 7;
//    
//    public static void main(String[] args) throws IOException, ClassNotFoundException
//    {
//        try
//        {
//            try(ObjectInputStream Customer_In_File = new ObjectInputStream(new FileInputStream("Customer Data.txt")))
//            {
//                Customer_Array_List = (ArrayList<Person.Customer>) Customer_In_File.readObject();
//                Customer_In_File.close();
//            }
//        }
//        catch(FileNotFoundException | EOFException e)
//        {
//            PrintWriter Empty_String = new PrintWriter(new File("Customer Data.txt"));
//            Empty_String.close();
//        }
//        
//        try
//        {
//            try(Scanner Bank_In_File = new Scanner(new File("Bank Data.txt")))
//            {
//                Accounts_Counter = Bank_In_File.nextLine();
//                Bank_In_File.close();
//            }
//        }
//        catch(FileNotFoundException e)
//        {
//            try(PrintWriter Bank_Out_File = new PrintWriter(new File("Bank Data.txt")))
//            {
//                Bank_Out_File.write(Accounts_Counter);
//                Bank_Out_File.close();
//            }
//        }
//        
//        Accounts.put("Admin", Caesar_Cipher_Encryption("Admin", Encryption_Key));
//        
//        for(Person.Customer C : Customer_Array_List)
//        {
//            Accounts.put(C.getNational_ID(), Caesar_Cipher_Encryption(C.getPassword(), Encryption_Key));
//        }
//        
//        for(Person.Employee E : Employee_Array_List)
//        {
//            Accounts.put(E.getNational_ID(), Caesar_Cipher_Encryption(E.getPassword(), Encryption_Key));
//        }
//    }
//    public static void Save() throws FileNotFoundException, IOException
//    {
//        try(ObjectOutputStream Customer_Out_File = new ObjectOutputStream(new FileOutputStream("Customer Data.txt")))
//        {
//            Customer_Out_File.writeObject(Customer_Array_List);
//            Customer_Out_File.close();
//        }
//        
//        try(ObjectOutputStream Employee_Out_File = new ObjectOutputStream(new FileOutputStream("Employee Data.txt")))
//        {
//            Employee_Out_File.writeObject(Employee_Array_List);
//            Employee_Out_File.close();
//        }
//        
//        try(PrintWriter Bank_Out_File = new PrintWriter(new File("Bank Data.txt")))
//        {
//            Bank_Out_File.write(Accounts_Counter);
//            Bank_Out_File.close();
//        }
//    }
//    public static String Caesar_Cipher_Encryption(String T, int K)
//    {
//        String Encrypted = "";
//        
//        for(int i = 0; i < T.length(); i++)
//        {
//            Encrypted += (char)(T.charAt(i) + K);
//        }
//        return Encrypted;
//    }
//    public static String Caesar_Cipher_Decryption(String T, int K)
//    {
//        String Decrypted = "";
//        
//        for(int i = 0; i < T.length(); i++)
//        {
//            Decrypted += (char)(T.charAt(i) - K);
//        }
//        return Decrypted;
//    }
//    public String enc(String line)
//    {
//        String Encted = "";
//        Accounts.put("A", "@$");
//        char characters[] = line.toCharArray();
//        for(int i = 0; i < line.length(); i++)
//        {
//            if(Accounts.get(characters[i]) != null)
//            {
//                Encted += Accounts.get(characters[i]);
//            }
//        }
//        return Encted;
//    }
//}}