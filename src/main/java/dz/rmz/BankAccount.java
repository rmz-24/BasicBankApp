package dz.rmz;

public class BankAccount {

    public enum AccountType {
        COURANT,
        EPARGNE
    }

    private static final String BANK_NAME = "AL-BARAKA";
    private static final String AGENCY_CODE = "AGENCE-CODE-107";
    private final Client client;
    private final int accountNbr;
    private final AccountType accountType;
    private double balance = 0;
    private double limit;

    private BankAccount(Builder builder){
        this.client = builder.client;
        this.accountNbr = builder.accountNbr;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.limit = builder.limit;
    }

    public String getBankName(){
        return BANK_NAME;
    }

    public String getAgencyCode(){
        return AGENCY_CODE;
    }

    public Client getClient(){
        return client;
    }

    public int getAccountNbr(){
        return accountNbr;
    }

    public AccountType getAccountType(){
        return accountType;
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
                " Account Number: %d || Account Type: %s || Balance: %f || Limit: %f\n", BANK_NAME, AGENCY_CODE, client.toString(), accountNbr, accountType.toString(), balance, limit);
    }

    public static class Builder{

        Accounts accounts = Accounts.getInstance();

        private Client client;
        private int accountNbr;
        private AccountType accountType;
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
            this.accountType = account_type;
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
            if (client == null || accountNbr <= 0 || accountType == null) {
                throw new IllegalArgumentException("Invalid arguments for BankAccount");
            }
            BankAccount account = new BankAccount(this);
            accounts.add(account);
            return account;
        }
    }

}
