class BankAccount extends Bank {
    private int a;
    private double b;
    
    public BankAccount(int accountNumber, double initialBalance) {
        a = accountNumber;
        b = initialBalance;   
    }  
    public double getBalance() {
        return b;   
    } 
    public void setBalance(double balance) {
        b = balance;   
    } 
    public int getAccountNumber() {
        return a;
    } 
} 