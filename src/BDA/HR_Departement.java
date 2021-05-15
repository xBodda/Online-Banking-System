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
public class HR_Departement implements Serializable
{
    private Transportation Transportation_Information;
    private Health_Care Health_Care_Information;

    public Transportation getTransportation_Information() {
        return Transportation_Information;
    }

    public void setTransportation_Information(Transportation Transportation_Information) {
        this.Transportation_Information = Transportation_Information;
    }

    public Health_Care getHealth_Care_Information() {
        return Health_Care_Information;
    }

    public void setHealth_Care_Information(Health_Care Health_Care_Information) {
        this.Health_Care_Information = Health_Care_Information;
    }
}