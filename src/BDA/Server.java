package BDA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author abdel
 */
public class Server implements Runnable
{
    Person.Customer Temporary_Customer_Send = new Person.Customer();
    Person.Customer Temporary_Customer_Receive = new Person.Customer();
    
    int Index;
    
    int Port_Number = 5000;
    ServerSocket ServerSocket_Object;
    Socket Socket_Object;
    InputStream Input_Stream_Object;
    OutputStream Output_Stream_Object;
    BufferedReader From_Client;
    PrintWriter To_Client;
    
    ObjectInputStream Object_Input_Stream_Object;
    ObjectOutputStream Object_Output_Stream_Object;
    
    public Server()
    {
        try
        {
            ServerSocket_Object = new ServerSocket(Port_Number);
        }
        catch(IOException ex)
        {
            System.out.println("Couldn't Connect To Port Number: " + Port_Number + ".");
        }
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Socket_Object = ServerSocket_Object.accept();
                Input_Stream_Object = Socket_Object.getInputStream();
                Output_Stream_Object = Socket_Object.getOutputStream();
                From_Client = new BufferedReader(new InputStreamReader(Input_Stream_Object));
                To_Client = new PrintWriter(Output_Stream_Object, true);
                
                Object_Output_Stream_Object = new ObjectOutputStream(Socket_Object.getOutputStream());
                
                String User_Name = From_Client.readLine();
                String Password = From_Client.readLine();
                
                if(BDA.OnlineBanking.Accounts.get(User_Name) == null)
                {
                    To_Client.println("U Invalid User Name, Please Input A Valid User Name.");
                    To_Client.flush();
                }
                else
                {
                    String Decrypted_Password = OnlineBanking.Caesar_Cipher_Decryption(OnlineBanking.Accounts.get(User_Name), 6);
                    
                    if(!Decrypted_Password.equals(Password))
                    {
                        To_Client.println("P Invalid Password, Please Input A Valid Password.");
                        To_Client.flush();
                    }
                    else
                    {
                        To_Client.println("Correct.");
                        To_Client.flush();
                        
                        int Temporary_Index = 0;
                        for(Person.Customer C : OnlineBanking.Customer_Array_List)
                        {
                            if(User_Name.equals(C.getNational_ID()))
                            {
                                Temporary_Customer_Send = C;
                                Index = Temporary_Index;
                                break;
                            }
                            Temporary_Index++;
                        }
                        Object_Output_Stream_Object.writeObject(Temporary_Customer_Send);
                        Object_Output_Stream_Object.flush();
                    }
                }
            }
            catch(IOException ex)
            {}
            
            try
            {
                Object_Input_Stream_Object = new ObjectInputStream(Socket_Object.getInputStream());
                Temporary_Customer_Receive = (Person.Customer) Object_Input_Stream_Object.readObject();
                
                OnlineBanking.Customer_Array_List.remove(Index);
                OnlineBanking.Customer_Array_List.add(Temporary_Customer_Receive);
                
                OnlineBanking.Save();
            }
            catch(IOException | ClassNotFoundException ex)
            {}
        }
    }
}
