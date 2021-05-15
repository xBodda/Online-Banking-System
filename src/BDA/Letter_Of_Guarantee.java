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
public class Letter_Of_Guarantee implements Serializable
{
    private int Guarantee_Number;
    private int REF;
    private int Agreement_Number;
    private String Name_Of_Financial_Institution;
    private String Name_Of_Cordinator;
    private String Address_Of_Cordinator;
    private String Amount_In_Words;
    private int Done_At;
    private int signature;

    public int getGuarantee_Number() {
        return Guarantee_Number;
    }

    public void setGuarantee_Number(int Guarantee_Number) {
        this.Guarantee_Number = Guarantee_Number;
    }

    public int getREF() {
        return REF;
    }

    public void setREF(int REF) {
        this.REF = REF;
    }

    public int getAgreement_Number() {
        return Agreement_Number;
    }

    public void setAgreement_Number(int Agreement_Number) {
        this.Agreement_Number = Agreement_Number;
    }

    public String getName_Of_Financial_Institution() {
        return Name_Of_Financial_Institution;
    }

    public void setName_Of_Financial_Institution(String Name_Of_Financial_Institution) {
        this.Name_Of_Financial_Institution = Name_Of_Financial_Institution;
    }

    public String getName_Of_Cordinator() {
        return Name_Of_Cordinator;
    }

    public void setName_Of_Cordinator(String Name_Of_Cordinator) {
        this.Name_Of_Cordinator = Name_Of_Cordinator;
    }

    public String getAddress_Of_Cordinator() {
        return Address_Of_Cordinator;
    }

    public void setAddress_Of_Cordinator(String Address_Of_Cordinator) {
        this.Address_Of_Cordinator = Address_Of_Cordinator;
    }

    public String getAmount_In_Words() {
        return Amount_In_Words;
    }

    public void setAmount_In_Words(String Amount_In_Words) {
        this.Amount_In_Words = Amount_In_Words;
    }

    public int getDone_At() {
        return Done_At;
    }

    public void setDone_At(int Done_At) {
        this.Done_At = Done_At;
    }

    public int getSignature() {
        return signature;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }
    
    public void CustomerFunction (Person.Customer X)
    {
        
    }
    
    public void Checkdate(Public.Date X)
    {
            
    }
 }