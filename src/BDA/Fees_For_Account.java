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
public class Fees_For_Account implements Serializable
{
    private int Opening_Account;
    private int Monthly_gross_salary;
    private int Minimum_monthly_average_balance;
    private int Monthly_account_maintenance_fees;
    private int Account_closing_fees;
    private int Salary_based_fixed_monthly_service_charge;

    public int getOpening_Account() {
        return Opening_Account;
    }

    public void setOpening_Account(int Opening_Account) {
        this.Opening_Account = Opening_Account;
    }

    public int getMonthly_gross_salary() {
        return Monthly_gross_salary;
    }

    public void setMonthly_gross_salary(int Monthly_gross_salary) {
        this.Monthly_gross_salary = Monthly_gross_salary;
    }

    public int getMinimum_monthly_average_balance() {
        return Minimum_monthly_average_balance;
    }

    public void setMinimum_monthly_average_balance(int Minimum_monthly_average_balance) {
        this.Minimum_monthly_average_balance = Minimum_monthly_average_balance;
    }
    public int getMonthly_account_maintenance_fees() {
        return Monthly_account_maintenance_fees;
    }

    public void setMonthly_account_maintenance_fees(int Monthly_account_maintenance_fees) {
        this.Monthly_account_maintenance_fees = Monthly_account_maintenance_fees;
    }

    public int getAccount_closing_fees() {
        return Account_closing_fees;
    }

    public void setAccount_closing_fees(int Account_closing_fees) {
        this.Account_closing_fees = Account_closing_fees;
    }

    public int getSalary_based_fixed_monthly_service_charge() {
        return Salary_based_fixed_monthly_service_charge;
    }

    public void setSalary_based_fixed_monthly_service_charge(int Salary_based_fixed_monthly_service_charge) {
        this.Salary_based_fixed_monthly_service_charge = Salary_based_fixed_monthly_service_charge;
    }

    public Fees_For_Account(){
        
    }   
}