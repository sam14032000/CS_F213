import java.util.StringTokenizer;

public class BankAccount{
    private int acc_no;
    private java.lang.String firstName;
    private java.lang.String lastName;
    private double balance;
    private int num_transactions;
    static final double MIN_BALANCE = 1000.0;
    static final int MAX_TRANSACTIONS_DAY = 5;

    public BankAccount(int acc_no){
        this.balance = MIN_BALANCE;
        this.acc_no = acc_no;
        this.num_transactions = 0;
        this.firstName = "John";
        this.lastName = "Doe";
        this.lastName += acc_no;
    }
    public BankAccount(int acc_no, double balance){
        this.balance = MIN_BALANCE + balance;
        this.acc_no = acc_no;
        this.num_transactions = 0;
        this.firstName = "John";
        this.lastName = "Doe";
        this.lastName += acc_no;
    }
    public BankAccount(int acc_no, java.lang.String email){
        this.balance = MIN_BALANCE;
        this.acc_no = acc_no;
        this.num_transactions = 0;
        String n = email.toUpperCase();
        StringTokenizer str1 = new StringTokenizer(n, ".");
        this.firstName = str1.nextToken();
        this.lastName = str1.nextToken("@");
        this.firstName = this.firstName.substring(0,1).toUpperCase()+this.firstName.substring(1).toLowerCase();
        this.lastName = this.lastName.substring(1,2).toUpperCase()+this.lastName.substring(2).toLowerCase();
    }
    public BankAccount(int acc_no,java.lang.String email,double balance){
        this.balance = MIN_BALANCE + balance;
        this.acc_no = acc_no;
        this.num_transactions = 0;
        String n = email.toUpperCase();
        StringTokenizer str1 = new StringTokenizer(n, ".");
        this.firstName = str1.nextToken();
        this.lastName = str1.nextToken("@");
        this.firstName = this.firstName.substring(0,1).toUpperCase()+this.firstName.substring(1).toLowerCase();
        this.lastName = this.lastName.substring(1,2).toUpperCase()+this.lastName.substring(2).toLowerCase();
    }

    public int getAccountNumber(){
        return acc_no;
    }
    public java.lang.String getName(){
        return this.firstName + " " + this.lastName;
    }
    public double getBalance(){
        return balance;
    }
    public int deposit(double amount){
        if (amount <= 0){
            return 0;
        }
        else if (num_transactions<MAX_TRANSACTIONS_DAY){
            this.balance += amount;
            num_transactions++;
            return 1;
        }
        else{
            this.balance += 0.95*amount;
            num_transactions++;
            return 1;
        }
    }
    public int withdraw(double amount){
        if (amount <= 0){
            return -1;
        }
        else if (amount > 0 && amount<(balance-MIN_BALANCE) && num_transactions<MAX_TRANSACTIONS_DAY){
            this.balance -= amount;
            num_transactions++;
            return 1;
        }
        else if (amount > 0 && 1.05*amount<(balance-MIN_BALANCE) && num_transactions>MAX_TRANSACTIONS_DAY){
            this.balance -= (1.05)*amount;
            num_transactions++;
            return 1;
        }
        else{
            return 0;
        }

    }
    public void printDetails(){
        System.out.println("Acc No : " + this.getAccountNumber()+'\n');
        System.out.println("Name : " + this.getName()+'\n');
        System.out.println("Balance : " + this.getBalance()+'\n');
    }
}