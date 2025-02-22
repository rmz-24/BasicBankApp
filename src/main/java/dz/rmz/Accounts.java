package dz.rmz;

import java.util.ArrayList;

public class Accounts {

    private final ArrayList<BankAccount> accounts;
    private static Accounts instance;

    public Accounts(){
        accounts = new ArrayList<>();
    }

    public static synchronized Accounts getInstance(){
        if(instance == null){
            instance = new Accounts();
        }
        return instance;
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
