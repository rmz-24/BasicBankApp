package dz.rmz;

import static dz.rmz.BankOperations.*;

public class BankApplication {
    public static void main(String[] args) {
        Client c1 = new Client("Tabbech", "Mohamed Ramzi", "Chemin Romain");
        BankAccount b1 = new BankAccount.Builder()
                .setClient(c1)
                .setAccountNbr(1)
                .setAccountType(BankAccount.AccountType.COURANT)
                .setInitialBalance(100)
                .setLimit(10)
                .build();

        Client c2 = new Client("Chedouba", "Anis", "Cité militaire");
        BankAccount b2 = new BankAccount.Builder()
                .setClient(c2)
                .setAccountNbr(2)
                .setAccountType(BankAccount.AccountType.EPARGNE)
                .setInitialBalance(200)
                .setLimit(50)
                .build();

        System.out.println("-------------------------SEPARATOR 1-------------------------");

        Accounts accounts = Accounts.getInstance();
        withdraw(b1, 90); //10
        withdraw(b1, 1); //10
        deposit(b1, 1); //11
        withdraw(b1, 1); //10
        deposit(b1, 90); //100
        System.out.println("RAMZI BALANCE: " + b1.getBalance());
        System.out.println("ANIS BALANCE: " + b2.getBalance());
        transfer(b1, b2, 90); //10
        System.out.println("RAMZI BALANCE: " + b1.getBalance());
        System.out.println("ANIS BALANCE: " + b2.getBalance());
        transfer(b1, b2, 9); //10
        System.out.println("RAMZI BALANCE: " + b1.getBalance());
        System.out.println("ANIS BALANCE: " + b2.getBalance());

        System.out.println("-------------------------SEPARATOR 2-------------------------");

        System.out.println(accounts.getAccounts());
        closeAccount(b1);
        System.out.println(accounts.getAccounts());
        closeAccount(b2);
        System.out.println(accounts.getAccounts());
    }
}