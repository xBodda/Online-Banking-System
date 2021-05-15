package Person;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;

public abstract class Account implements Serializable
{
    private String Account_Number;
    private int Balance;
    
    public Account() throws IOException
    {
        Account_Number = BDA.OnlineBanking.Accounts_Counter;
        BDA.OnlineBanking.Accounts_Counter = new BigInteger(BDA.OnlineBanking.Accounts_Counter).add(BigInteger.ONE).toString();
        Balance = 100;
        BDA.OnlineBanking.Save();
    }
    
    public String getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(String Account_Number) throws Exceptions.Exception_Message
    {
        if(Account_Number.length() == 16 && Account_Number.matches("[0-9]+"))
        {
            this.Account_Number = Account_Number;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Account Number, Please Choose A Valid Account Number.");
        }
    }
    
    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) throws Exceptions.Exception_Message
    {
        if(Integer.toString(Balance).matches("[0-9]+"))
        {
            this.Balance = Balance;
        }
        else
        {
            throw new Exceptions.Exception_Message("Invalid Balance, Please Input A Valid Balance.");
        }
    }
}
