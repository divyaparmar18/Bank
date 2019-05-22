package bank;

import java.util.Date;

public class Account {
    public String holder;
    public String number;
    private double balance;
    private Date openingDate;
    public final int RATE_OF_INTEREST_PER_ANNUM = 10;

    @Override
    public String toString() {
        return holder + ", " + number + ", " + balance;
    }

    public double getBalance() {
        return getBalance(0);
    }

    public Account(String holder, String number, double balance, Date openingDate) {
        this.holder = holder;
        this.number = number;
        this.balance = balance;
        this.openingDate = openingDate;
    }

    public void credit(double balance) {
        this.balance += balance;
    }
    public double getBalance(int year){
        double simpleInterest = (balance*RATE_OF_INTEREST_PER_ANNUM*year)/100;
        double netBalance = simpleInterest+balance;
        return netBalance;
    }

    public void debit(double amount) {
        if (amount < this.balance) {
            this.balance -= amount;
        }
    }

}


