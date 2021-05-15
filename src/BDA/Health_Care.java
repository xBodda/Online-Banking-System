/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDA;

import java.io.Serializable;

/**
 *
 * @author abdel
 */
public class Health_Care implements Serializable{
    private int Health_Card_Number;
    private int Number_Of_Children;
    private Boolean Childern;

    public int getHealth_Card_Number() {
        return Health_Card_Number;
    }

    public void setHealth_Card_Number(int Health_Card_Number) {
        this.Health_Card_Number = Health_Card_Number;
    }

    public int getNumber_Of_Children() {
        return Number_Of_Children;
    }

    public void setNumber_Of_Children(int Number_Of_Children) {
        this.Number_Of_Children = Number_Of_Children;
    }

    public Boolean getChildern() {
        return Childern;
    }

    public void setChildern(Boolean Childern) {
        this.Childern = Childern;
    }   
}