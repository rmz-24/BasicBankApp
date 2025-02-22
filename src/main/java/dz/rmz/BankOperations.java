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

    public static void withdraw(BankAccount b, double amount) {
        if(amount <= 0){
            System.out.println("Useless transaction/Cannot withdraw negative amount from balance");
        } else{
            if(b.getBalance() <= 0 || b.getBalance() < amount){
                System.out.println("Insufficient funds, please refill your balance.");
            }
            if(b.getBalance() >= amount){
                if(b.getBalance() <= b.getLimit()){
                    System.out.println("Cannot withdraw, limit reached !");
                } else{
                    b.setBalance(b.getBalance() - amount);
                    System.out.println("Withdraw successful. New balance: " + b.getBalance());
                    if(b.getBalance() <= b.getLimit()){
                        System.out.println("Attention, limit reached !");
                    }
                }
            }
        }
    }

    public static void transfer(BankAccount from, BankAccount to, double amount) {
        if(amount > 0){
            if(from.getBalance() >= amount){
                if(from.getBalance() > from.getLimit()){
                    from.setBalance(from.getBalance() - amount);
                    to.setBalance(to.getBalance() + amount);
                    System.out.println("Transfer successful. New balance: " + from.getBalance());
                    if(from.getBalance() <= from.getLimit()){
                        System.out.println("Attention, limit reached !");
                    }
                } else{
                    System.out.println("Cannot transfer, limit reached !");
                }
            } else{
                System.out.println("Insufficient funds");
            }
        } else{
            System.out.println("Useless transaction/Cannot transfer negative amount from balance");
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
