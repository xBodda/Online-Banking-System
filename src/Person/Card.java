package Person;
import Public.Date;
import java.io.Serializable;
/**
 *
 * @author abdel
 */
public abstract class Card implements Serializable
{
    private int Card_Number;
    private int Card_Pin;
    private int Minimum_Amount;
    private Public.Date Produced_Date;
    private Public.Date Expiry_Date;
    private int Uber_Percentage;
    private int Uber_Rides;
    private Public.Date Uber_Start_Date;
    private Public.Date Uber_End_Date;
    private String Uber_Promo_Code;

    public int getUber_Percentage() 
    {
        return Uber_Percentage;
    }

    public void setUber_Percentage(int Uber_Percentage) 
    {
        this.Uber_Percentage = Uber_Percentage;
    }

    public int getUber_Rides() 
    {
        return Uber_Rides;
    }

    public void setUber_Rides(int Uber_Rides) 
    {
        this.Uber_Rides = Uber_Rides;
    }

    public Public.Date getUber_Start_Date() 
    {
        return Uber_Start_Date;
    }

    public void setUber_Start_Date(Public.Date Uber_Start_Date) 
    {
        this.Uber_Start_Date = Uber_Start_Date;
    }

    public Public.Date getUber_End_Date() 
    {
        return Uber_End_Date;
    }

    public void setUber_End_Date(Public.Date Uber_End_Date) 
    {
        this.Uber_End_Date = Uber_End_Date;
    }

    public String getUber_Promo_Code() 
    {
        return Uber_Promo_Code;
    }

    public void setUber_Promo_Code(String Uber_Promo_Code) 
    {
        this.Uber_Promo_Code = Uber_Promo_Code;
    }

    public Public.Date getProduced_Date() 
    {
        return Produced_Date;
    }

    public void setProduced_Date(Public.Date Produced_Date) 
    {
        this.Produced_Date = Produced_Date;
    }

    public Public.Date getExpiry_Date() 
    {
        return Expiry_Date;
    }

    public void setExpiry_Date(Public.Date Expiry_Date) 
    {
        this.Expiry_Date = Expiry_Date;
    }
    
    
    public int getCard_Number() 
    {
        return Card_Number;
    }

    public void setCard_Number(int Card_Number) 
    {
        this.Card_Number = Card_Number;
    }

    public int getCard_Pin() 
    {
        return Card_Pin;
    }

    public void setCard_Pin(int Card_Pin) 
    {
        this.Card_Pin = Card_Pin;
    }

    public int getMinimum_Amount() 
    {
        return Minimum_Amount;
    }

    public void setMinimum_Amount(int Minimum_Amount) 
    {
        this.Minimum_Amount = Minimum_Amount;
    }
}
