package dz.rmz;

import java.util.ArrayList;

public class Accounts {

    private final ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Accounts instance;

    private Accounts(){
        instance = this;
    }

    public static Accounts getInstance() {
        return instance == null ? new Accounts() : instance;
    }

    public void add(BankAccount acc) {
        accounts.add(acc);
    }

    public void remove(BankAccount acc) {
        accounts.remove(acc);
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public int getAccountsCount() {
        return accounts.size();
    }
}
