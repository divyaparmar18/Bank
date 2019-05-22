package bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    public static final Date TODAY = new Date(2019, 5, 21);

    @Test
    public void itShouldGiveTHeAmountAfterCredit() {
        Account divya = new Account("Divya", "235566767", 0, TODAY);
        divya.credit(100, new Date(21, 5, 2019));
        assertEquals(100.0, divya.getBalance(), 0.1);
    }

    @Test
    public void itShouldGiveTHeAmountAfterDebit() {
        Account zoyaa = new Account("zoyaa", "2354t666767", 100, TODAY);
        zoyaa.debit(10, new Date(21, 5, 2019));
        assertEquals(90.0, zoyaa.getBalance(), 1);
    }

    @Test
    public void itShouldNotChangeTheBalanceAfterCreditingAndDebitingSameAmount() {
        Account danny = new Account("danny", "2566766767", 100, TODAY);
        danny.credit(10, new Date(21, 5, 2019));
        danny.debit(10, new Date(21, 5, 2019));
        assertEquals(100.0, danny.getBalance(), 1);
    }

    @Test
    public void creditInOneAccountShouldNotAffectAnother() {
        Account deepa = new Account("deepa", "25667466767", 0, TODAY);
        Account priya = new Account("priya", "834775875786", 0, TODAY);
        deepa.credit(100, new Date(21, 5, 2019));
        priya.credit(200, new Date(21, 5, 2019));
        assertEquals(100.0, deepa.getBalance(), 1);
        assertEquals(200.0, priya.getBalance(), 1);
    }

    @Test
    public void itshouldGiveTheTotalBalanceAfterAddingInterest() {
        Account zoyaa = new Account("zoyaa", "2354t666767", 100, TODAY);
        assertEquals(100, zoyaa.getBalance(0),0.1);
        assertEquals(110, zoyaa.getBalance(1),0.1);
        assertEquals(120, zoyaa.getBalance(2),0.1);
        assertEquals(130, zoyaa.getBalance(3),0.1);
    }
    @Test
    public void ifNoTransactionsDoneItShouldGiveEmptyList() {
        Account danny = new Account("danny", "2566766767", 100, TODAY);
        List<Transaction> expected = new ArrayList<>();
        assertEquals(expected, danny.getPassbook());
    }
    @Test
    public void ifOneTransactionDoneItShouldGiveOneTransactionInList() {
        List<Transaction> expectedTransactions = new ArrayList<>();
        Account danny = new Account("danny", "2566766767", 100, TODAY);
        Transaction credit = new Transaction("2566766767",TODAY,500);
        danny.credit(100,TODAY);
        expectedTransactions.add(credit);
        assertEquals(expectedTransactions.get(0).amount, danny.getPassbook().get(0).amount,1);
        assertEquals(expectedTransactions.get(0).number, danny.getPassbook().get(0).number);
        assertEquals(expectedTransactions.get(0).transactionDate, danny.getPassbook().get(0).transactionDate);
    }

}
