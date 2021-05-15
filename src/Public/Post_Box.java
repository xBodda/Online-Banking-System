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
public class Post_Box implements Serializable
{
    private int postal_code;
    private String Country;
    private String City;
    private String postalbox;

    public int getPostal_code() 
    {
        return postal_code;
    }

    public void setPostal_code(int postal_code) 
    {
        this.postal_code = postal_code;
    }

    public String getCountry() 
    {
        return Country;
    }

    public void setCountry(String Country) 
    {
        this.Country = Country;
    }

    public String getCity() 
    {
        return City;
    }

    public void setCity(String City) 
    {
        this.City = City;
    }

    public String getPostalbox() 
    {
        return postalbox;
    }

    public void setPostalbox(String postalbox) 
    {
        this.postalbox = postalbox;
    }   
}
