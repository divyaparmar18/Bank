package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    public String holder;
    public String number;
    private double balance;
    private Date openingDate;
    public final int RATE_OF_INTEREST_PER_ANNUM = 10;
    private final List<Transaction> transactions = new ArrayList<>();
    private static int counter = 0;

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
        this.counter++;
    }

    public void credit(double amount, Date creditDate) {
        Transaction credit = new Transaction(number,creditDate,amount);
        transactions.add(credit);
        this.balance += amount;

    }
    public double getBalance(int year){
        double simpleInterest = (balance*RATE_OF_INTEREST_PER_ANNUM*year)/100;
        double netBalance = simpleInterest+balance;
        return netBalance;
    }

    public void debit(double amount, Date debitDate) {
        if (amount <= this.balance) {
            Transaction debit = new Transaction(number,debitDate,-amount);
            transactions.add(debit);
            this.balance -= amount;
        }
    }
    public List<Transaction> getPassbook(){
        return transactions;
    }

    public static int getCounter(){
        return counter;
    }

}


