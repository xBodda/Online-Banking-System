package BDA;
//import java.util.Arrays;
//import java.util.Comparator;

import java.util.Scanner;

public class Transactions
{
    public double balance;
    Scanner input = new Scanner (System.in);
    private final String  who;     
    private final String    when;     
    private final double  amount;   
    public Transactions(String who, String when, double amount) 
    {
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be None or infinite");
        this.who    = who;
        this.when   = when;
        this.amount = amount;
    }
    public Transactions(String transaction)
    {
        String[] a = transaction.split("\\s+");
        who    = a[0];
        when   = a[1];
        amount = Double.parseDouble(a[2]);
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be None or infinite");
    }
    public String who() 
    {
        return who;
    }
    public String when()
    {
        return when;
    }
    public double amount() 
    {
        return amount;
    }
    @Override
    public String toString() 
    {
        return String.format("%-10s %10s %8.2f", who, when, amount);
    }
    public int compareTo(Transactions that)
    {
        return Double.compare(this.amount, that.amount);
    }    
    @Override
    public boolean equals(Object other)
    {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Transactions that = (Transactions) other;
        return (this.amount == that.amount) && (this.who.equals(that.who)) && (this.when.equals(that.when));
    }
    public void Deposit()
    {
        int Amount;
        System.out.println("Enter Amount U Want to Deposit : ");
        Amount = input.nextInt();
        balance += Amount;
    }
}
