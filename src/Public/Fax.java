/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;
import java.io.Serializable;

/**
 *
 * @author abdel
 */
public class Fax implements Serializable
{
    private int Country_code;
    private int city_code;
    private int fax_number;

    public int getCountry_code() 
    {
        return Country_code;
    }

    public void setCountry_code(int Country_code) 
    {
        this.Country_code = Country_code;
    }

    public int getCity_code() 
    {
        return city_code;
    }

    public void setCity_code(int city_code) 
    {
        this.city_code = city_code;
    }

    public int getFax_number() 
    {
        return fax_number;
    }

    public void setFax_number(int fax_number) 
    {
        this.fax_number = fax_number;
    }   
}
