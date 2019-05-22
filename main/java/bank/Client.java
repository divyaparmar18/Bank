package bank;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        Account divya = new Account("Divya","235566767",0, new Date(2019, 5, 21));
        divya.credit(100, new Date(21, 5, 2019));
    }


}
