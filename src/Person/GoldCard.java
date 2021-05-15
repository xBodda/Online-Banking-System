package Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author abdel
 */
public class GoldCard extends Card implements Interfaces.IExtra
{
    public final int Interest = 0;
    public final int Gift_Point = 6;
    public final int Bonus_Point = 2;
    public static double Price = 0;
    public static double Discount_After_Bonus = 0;
    public static double Discount_After_Gift = 0;
    
    public GoldCard()
    {
        LocalDate localDate = LocalDate.now();
        String Day = (DateTimeFormatter.ofPattern("dd").format(localDate));
        String Month = (DateTimeFormatter.ofPattern("MM").format(localDate));
        String Year = (DateTimeFormatter.ofPattern("YY").format(localDate));
        setProduced_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year)));
        setExpiry_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year + 1)));
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
