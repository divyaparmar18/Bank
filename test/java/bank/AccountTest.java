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
        divya.credit(100, TODAY);
        assertEquals(100.0, divya.getBalance(), 0.1);
    }

    @Test
    public void itShouldGiveTHeAmountAfterDebit() {
        Account zoyaa = new Account("zoyaa", "2354t666767", 100, TODAY);
        zoyaa.debit(10, TODAY);
        assertEquals(90.0, zoyaa.getBalance(), 1);
    }

    @Test
    public void itShouldNotChangeTheBalanceAfterCreditingAndDebitingSameAmount() {
        Account danny = new Account("danny", "2566766767", 100, TODAY);
        danny.credit(10, TODAY);
        danny.debit(10, TODAY);
        assertEquals(100.0, danny.getBalance(), 1);
    }

    @Test
    public void creditInOneAccountShouldNotAffectAnother() {
        Account deepa = new Account("deepa", "25667466767", 0, TODAY);
        Account priya = new Account("priya", "834775875786", 0, TODAY);
        deepa.credit(100, TODAY);
        priya.credit(200, TODAY);
        assertEquals(100.0, deepa.getBalance(), 1);
        assertEquals(200.0, priya.getBalance(), 1);
    }

    @Test
    public void itshouldGiveTheTotalBalanceAfterAddingInterest() {
        Account zoyaa = new Account("zoyaa", "2354t666767", 100, TODAY);
        assertEquals(100, zoyaa.getBalance(0), 0.1);
        assertEquals(110, zoyaa.getBalance(1), 0.1);
        assertEquals(120, zoyaa.getBalance(2), 0.1);
        assertEquals(130, zoyaa.getBalance(3), 0.1);
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
        Account danny = new Account("danny", "1", 100, TODAY);
        Transaction creditTransaction = new Transaction("1", TODAY, 100);
        danny.credit(100, TODAY);
        expectedTransactions.add(creditTransaction);
        assertEquals(expectedTransactions, danny.getPassbook());
    }
    @Test
    public void ifOneTransactionDoneItShouldGiveOneTransactionInListOfDeduction() {
        List<Transaction> expectedTransactions = new ArrayList<>();
        Account danny = new Account("danny", "2", 1000, TODAY);
        Transaction debitTransaction = new Transaction("2", TODAY, 100);
        danny.debit(-100,TODAY);
        expectedTransactions.add(debitTransaction);
        assertEquals(expectedTransactions, danny.getPassbook());
    }
    @Test
    public void ifTheAmountToBeDeductedIsMoreThanBalanceItShouldGiveNoTGiveTransaction() {
        List<Transaction> expectedTransactions = new ArrayList<>();
        Account danny = new Account("danny", "2", 0, TODAY);
        danny.debit(100,TODAY);
        assertEquals(expectedTransactions, danny.getPassbook());
    }
    @Test
    public void ifMultipleTransactionsAreDoneItShouldGiveAllTheTransactions() {
        List<Transaction> expectedTransactions = new ArrayList<>();
        Account danny = new Account("danny", "2", 1000, TODAY);
        Transaction debitTransaction = new Transaction("2", TODAY, 10);
        Transaction creditTransaction = new Transaction("2",TODAY,100);
        danny.credit(100,TODAY);
        danny.debit(-10,TODAY);
        expectedTransactions.add(creditTransaction);
        expectedTransactions.add(debitTransaction);
        assertEquals(expectedTransactions, danny.getPassbook());
    }

    @Test
    public void itShouldGiveTheNumberOfAccountsWithMultipleAccounts(){
        Account danny = new Account("danny","2",100,TODAY);
        Account zoyaa = new Account("zoyaa","3",100,TODAY);
        assertEquals(2,Account.getCounter());
    }


}
