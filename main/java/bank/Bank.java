package bank;

public class Bank {
    private static int numberOfAccounts = 0;


    public static Account createAccount(String name) {
        double balance = 0;
        numberOfAccounts++;
        Account account = new Account(name, Integer.toString(numberOfAccounts), balance);
        return account;
    }

    public static void main(String[] args) {
        System.out.println(createAccount("zoyaa"));
        System.out.println(createAccount("divya"));
    }


}
