package dz.rmz;

import static dz.rmz.BankOperations.*;

public class BankApplication {
    public static void main(String[] args) {
        Client firstClient = new Client("Doe", "John", "123 Happy Street");
        BankAccount firstAccount = new BankAccount.Builder()
                .setClient(firstClient)
                .setAccountNbr(1)
                .setAccountType(BankAccount.AccountType.COURANT)
                .setInitialBalance(100)
                .setLimit(10)
                .build();

        Client secondClient = new Client("Michael", "Swarley", "321 Long Island");
        BankAccount secondAccount = new BankAccount.Builder()
                .setClient(secondClient)
                .setAccountNbr(2)
                .setAccountType(BankAccount.AccountType.EPARGNE)
                .setInitialBalance(200)
                .setLimit(50)
                .build();

        System.out.println("-------------------------SEPARATOR 1-------------------------");

        Accounts accounts = Accounts.getInstance();
        withdraw(firstAccount, 90); //10
        withdraw(firstAccount, 1); //10
        deposit(firstAccount, 1); //11
        withdraw(firstAccount, 1); //10
        deposit(firstAccount, 90); //100
        System.out.println("ACC1 BALANCE: " + firstAccount.getBalance());
        System.out.println("ACC2 BALANCE: " + secondAccount.getBalance());
        transfer(firstAccount, secondAccount, 90); //10
        System.out.println("ACC1 BALANCE: " + firstAccount.getBalance());
        System.out.println("ACC2 BALANCE: " + secondAccount.getBalance());
        transfer(firstAccount, secondAccount, 9); //10
        System.out.println("ACC1 BALANCE: " + firstAccount.getBalance());
        System.out.println("ACC2 BALANCE: " + secondAccount.getBalance());

        System.out.println("-------------------------SEPARATOR 2-------------------------");

        System.out.println(accounts.getAccounts());
        closeAccount(firstAccount);
        System.out.println(accounts.getAccounts());
        closeAccount(secondAccount);
        System.out.println(accounts.getAccounts());
    }
}