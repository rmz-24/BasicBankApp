package dz.rmz;

public class BankAccount {

    public enum AccountType {
        COURANT,
        EPARGNE
    }

    private static final String bankName = "AL-BARAKA";
    private final String agencyCode = "AGENCE-CODE-107";
    private final Client client;
    private final int accountNbr;
    private final AccountType account_type;
    private double balance = 0;
    private double limit;

    public String getBankName(){
        return bankName;
    }

    public String getAgencyCode(){
        return agencyCode;
    }

    public Client getClient(){
        return client;
    }

    public int getAccountNbr(){
        return accountNbr;
    }

    public AccountType getAccount_type(){
        return account_type;
    }

    public double getBalance(){
        return balance;
    }

    public double getLimit(){
        return limit;
    }

    public void setBalance(double amount){
        this.balance = amount;
    }

    public void setLimit(double amount){
        this.limit = amount;
    }

    @Override
    public String toString() {
        return String.format("Bank Name: %s || Agency Code: %s \n" +
                "Client: %s\n" +
                " Account Number: %d || Account Type: %s || Balance: %f || Limit: %f\n", bankName, agencyCode, client.toString(), accountNbr, account_type.toString(), balance, limit);
    }

    private BankAccount(Builder builder){
        this.client = builder.client;
        this.accountNbr = builder.accountNbr;
        this.account_type = builder.account_type;
        this.balance = builder.balance;
        this.limit = builder.limit;
    }

    public static class Builder{

        Accounts accounts = Accounts.getInstance();

        private Client client;
        private int accountNbr;
        private AccountType account_type;
        private double balance;
        private double limit;

        public Builder setClient(Client client){
            this.client = client;
            return this;
        }

        public Builder setAccountNbr(int accountNbr){
            this.accountNbr = accountNbr;
            return this;
        }

        public Builder setAccountType(AccountType account_type){
            this.account_type = account_type;
            return this;
        }

        public Builder setInitialBalance(double amount){
            this.balance = amount;
            return this;
        }

        public Builder setLimit(double amount){
            this.limit = amount;
            return this;
        }

        public BankAccount build() {
            if (client == null || accountNbr <= 0 || account_type == null) {
                throw new IllegalArgumentException("Invalid arguments for BankAccount");
            }
            BankAccount account = new BankAccount(this);
            accounts.add(account);
            return account;
        }
    }

}
