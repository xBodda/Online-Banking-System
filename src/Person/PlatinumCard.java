package Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author abdel
 */
public class PlatinumCard extends Card implements Interfaces.IExtra
{
    public final int Interest = 0;
    public final int Gift_Point = 200;//Up To 20,000 Gift Points Worth EGP 100.
    public final int Bonus_Point = 3;//3 Bouns Point Per EGP 1 Spent.
    private Public.Date Temporary;
    public static double Price = 0;
    public static double Discount_After_Bonus = 0;
    public static double Discount_After_Gift = 0;
    
    public PlatinumCard()
    {
        try
        {
            LocalDate localDate = LocalDate.now();
            String Day = (DateTimeFormatter.ofPattern("dd").format(localDate));
            String Month = (DateTimeFormatter.ofPattern("MM").format(localDate));
            String Year = (DateTimeFormatter.ofPattern("YY").format(localDate));
            setProduced_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year)));
            setExpiry_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year + 1)));
            setUber_Percentage(65/100);
            setUber_Rides(3);
            setUber_Promo_Code("GOCIBPLT");
            Temporary.setDay(Integer.parseInt(Day));
            Temporary.setMonth(Integer.parseInt(Month));
            Temporary.setYear(Integer.parseInt(Year));
            setUber_Start_Date(Temporary);
            Temporary.setMonth(Integer.parseInt(Month) + 1);
            setUber_End_Date(Temporary);
        }
        catch(NullPointerException ex)
        {}
    }
    
    @Override
    public void Gift()
    {
        Discount_After_Gift=(Price/Gift_Point);
    }
    
    @Override
    public void Bonus()
    {
        Discount_After_Bonus=Price/Bonus_Point;
    }
}
