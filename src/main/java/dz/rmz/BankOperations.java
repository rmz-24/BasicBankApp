package dz.rmz;

public class BankOperations {

    public static void deposit(BankAccount b, double amount) {
        if(amount > 0){
            b.setBalance(b.getBalance() + amount);
            System.out.println("Deposit successful. New balance: " + b.getBalance());
        } else{
            System.out.println("Useless transaction");
        }
    }

    public static void withdraw(BankAccount acc, double amount){
        if(amount <= 0){
            System.out.println("Useless transaction/Cannot withdraw negative amount from balance");
            return;
        }
        if(acc.getBalance() <= 0 || acc.getBalance() < amount){
            System.out.println("Insufficient funds, please refill your balance.");
            return;
        }
        if(acc.getBalance() <= acc.getLimit()){
            System.out.println("Cannot withdraw, limit reached !");
            return;
        }
        acc.setBalance(acc.getBalance() - amount);
        System.out.println("Withdraw successful. New balance: " + acc.getBalance());
        if(acc.getBalance() <= acc.getLimit()){
            System.out.println("Attention, limit reached !");
        }
    }

    public static void transfer(BankAccount giverAccount, BankAccount receiverAccount, double amount){
        if(amount <= 0){
            System.out.println("Useless transaction/Cannot transfer negative amount from balance");
            return;
        }
        if(giverAccount.getBalance() < amount){
            System.out.println("Insufficient funds, please refill your balance.");
            return;
        }
        if(giverAccount.getBalance() <= giverAccount.getLimit()){
            System.out.println("Cannot transfer, limit reached !");
            return;
        }
        giverAccount.setBalance(giverAccount.getBalance() - amount);
        receiverAccount.setBalance(receiverAccount.getBalance() + amount);
        System.out.println("Transfer successful. New balance: " + giverAccount.getBalance());
        if(giverAccount.getBalance() <= giverAccount.getLimit()){
            System.out.println("Attention, limit reached !");
        }
    }

    /*public void setInterestRate(BankAccount b, double rate) {
        if(b.getAccount_type().equals(BankAccount.AccountType.EPARGNE)){
            if(rate > 0){

            }
        }
    }*/

    public static void compare(BankAccount b1, BankAccount b2) {
        if(b1.getBalance() > b2.getBalance()){
            System.out.println("Here is the client with the higher balance: \n");
            System.out.println(b1.getClient().toString());
        } else if (b1.getBalance() < b2.getBalance()) {
            System.out.println("Here is the client with the higher balance: \n");
            System.out.println(b2.getClient().toString());
        } else{
            System.out.println("Equal balance!");
        }
    }

    public static void closeAccount(BankAccount b){
        Accounts accounts = Accounts.getInstance();
        b.setBalance(0);
        accounts.remove(b);
        System.out.println("The account has been successfully closed!");
    }
}
