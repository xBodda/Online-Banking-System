
package BDA;

import java.io.Serializable;

/**
 *
 * @author abdel
 */
public class Transportation implements Serializable
{
    private String Destination_From;
    private String Destination_To;
    private String Name_Of_Driver;
    private String Model_Name;
    private int Bus_ID;
    private int Number_Of_Buses;
    private int Person_Per_Each_Bus;

    public String getDestination_From() {
        return Destination_From;
    }

    public void setDestination_From(String Destination_From) {
        this.Destination_From = Destination_From;
    }

    public String getDestination_To() {
        return Destination_To;
    }

    public void setDestination_To(String Destination_To) {
        this.Destination_To = Destination_To;
    }

    public String getName_Of_Driver() {
        return Name_Of_Driver;
    }

    public void setName_Of_Driver(String Name_Of_Driver) {
        this.Name_Of_Driver = Name_Of_Driver;
    }

    public String getModel_Name() {
        return Model_Name;
    }

    public void setModel_Name(String Model_Name) {
        this.Model_Name = Model_Name;
    }

    public int getBus_ID() {
        return Bus_ID;
    }

    public void setBus_ID(int Bus_ID) {
        this.Bus_ID = Bus_ID;
    }

    public int getNumber_Of_Buses() {
        return Number_Of_Buses;
    }

    public void setNumber_Of_Buses(int Number_Of_Buses) {
        this.Number_Of_Buses = Number_Of_Buses;
    }

    public int getPerson_Per_Each_Bus() {
        return Person_Per_Each_Bus;
    }

    public void setPerson_Per_Each_Bus(int Person_Per_Each_Bus) {
        this.Person_Per_Each_Bus = Person_Per_Each_Bus;
    }   
}
