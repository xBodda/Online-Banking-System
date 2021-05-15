
package Person;
import java.time.*;
import java.time.format.*;
/**
 *
 * @author abdel
 */
public class DebitCard extends Card
{
    public  final int Interest = 0;
    private final int debit_card=35;
    private final int youth_card=25;
    
    public DebitCard()
    {
        LocalDate localDate = LocalDate.now();
        String Day = (DateTimeFormatter.ofPattern("dd").format(localDate));
        String Month = (DateTimeFormatter.ofPattern("MM").format(localDate));
        String Year = (DateTimeFormatter.ofPattern("YY").format(localDate));
        setProduced_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year)));
        setExpiry_Date (new Public.Date(Integer.parseInt(Day), Integer.parseInt(Month), Integer.parseInt(Year + 1)));
    }
    
    public int getDebit_card() {
        return debit_card;
    }

    public int getYouth_card() {
        return youth_card;
    }
}
