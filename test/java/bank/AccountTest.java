package bank;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void itShouldGiveTHeAmountAfterCredit() {
        Account divya = new Account("Divya", "235566767", 0, new Date(2019, 5, 21));
        divya.credit(100);
        assertEquals(100.0, divya.getBalance(), 0.1);
    }

    @Test
    public void itShouldGiveTHeAmountAfterDebit() {
        Account zoyaa = new Account("zoyaa", "2354t666767", 100, new Date(2019, 5, 21));
        zoyaa.debit(10);
        assertEquals(90.0, zoyaa.getBalance(), 1);
    }

    @Test
    public void itShouldNotChangeTheBalanceAfterCreditingAndDebitingSameAmount() {
        Account danny = new Account("danny", "2566766767", 100, new Date(2019, 5, 21));
        danny.credit(10);
        danny.debit(10);
        assertEquals(100.0, danny.getBalance(), 1);
    }

    @Test
    public void creditInOneAccountShouldNotAffectAnother() {
        Account deepa = new Account("deepa", "25667466767", 0, new Date(2019, 5, 21));
        Account priya = new Account("priya", "834775875786", 0, new Date(2019, 5, 21));
        deepa.credit(100);
        priya.credit(200);
        assertEquals(100.0, deepa.getBalance(), 1);
        assertEquals(200.0, priya.getBalance(), 1);
    }

    @Test
    public void itshouldGiveTheTotalBalanceAfterAddingInterest() {
        Account zoyaa = new Account("zoyaa", "2354t666767", 100, new Date(2019, 5, 21));
        assertEquals(100, zoyaa.getBalance(0),0.1);
        assertEquals(110, zoyaa.getBalance(1),0.1);
        assertEquals(120, zoyaa.getBalance(2),0.1);
        assertEquals(130, zoyaa.getBalance(3),0.1);



    }

}
