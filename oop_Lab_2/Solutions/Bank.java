public class Bank {

    private java.lang.String name;
    private BankAccount[] accounts;
    private int no_of_accounts;
    static final int MAX_ACCOUNTS = 15;

    public Bank(java.lang.String name) {
        this.setName(name);
        this.no_of_accounts = 0;
        accounts = new BankAccount[MAX_ACCOUNTS];
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int createAccount() {
        if (no_of_accounts<MAX_ACCOUNTS){
            accounts[no_of_accounts] = new BankAccount(no_of_accounts+1);
            no_of_accounts++;
            return 1;
        }
        else{
            return 0;
        }
    }
    public int createAccount(double balance){
        if (no_of_accounts<MAX_ACCOUNTS){
            accounts[no_of_accounts] = new BankAccount(no_of_accounts+1,balance);
            no_of_accounts++;
            return 1;
        }
        else{
            return 0;
        }
    }
    public int createAccount(java.lang.String email){
        if (no_of_accounts<MAX_ACCOUNTS){
            accounts[no_of_accounts] = new BankAccount(no_of_accounts+1,email);
            no_of_accounts++;
            return 1;
        }
        else{
            return 0;
        }
    }
    public int createAccount(java.lang.String email,double balance){
        if (no_of_accounts<MAX_ACCOUNTS){
            accounts[no_of_accounts] = new BankAccount(no_of_accounts+1,email,balance);
            no_of_accounts++;
            return 1;
        }
        else{
            return 0;
        }
    }
    public int getNoAccounts(){
        return no_of_accounts;
    }
    public int transaction(BankAccount b1,BankAccount b2,double amount){
        if (b1.withdraw(amount)==1 && b2.deposit(amount)==1 && amount>=0){
            return 1;
        }
        else if (amount < 0){
            return -1;
        }
        else{
            return 0;
        }
    }

}