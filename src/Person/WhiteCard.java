package Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author abdel
 */
public class WhiteCard extends Card
{
   public final int Interest = 0;
    private Public.Date Temporary;
    
    public WhiteCard() 
    {
        LocalDate localDate = LocalDate.now();
        String Day = (DateTimeFormatter.ofPattern("dd").format(localDate));
        String Month = (DateTimeFormatter.ofPattern("MM").format(localDate));
        String Year = (DateTimeFormatter.ofPattern("YY").format(localDate));
        setProduced_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year)));
        setExpiry_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year + 1)));
        setUber_Percentage(25/100);
        setUber_Rides(1);
        setUber_Promo_Code("GOBDAWHT");
        Temporary.setDay(Integer.parseInt(Day));
        Temporary.setMonth(Integer.parseInt(Month));
        Temporary.setYear(Integer.parseInt(Year));
        setUber_Start_Date(Temporary);
        Temporary.setMonth(Integer.parseInt(Month) + 1);
        setUber_End_Date(Temporary);
    }
}
