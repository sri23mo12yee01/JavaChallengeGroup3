package com.challenge;
public class BankAccount {
    private String accountName;
    private double balance;



    public String accountType = "BankAccount";



    public BankAccount(String accountName, double balance) {
        this.setAccountName(accountName);
        this.setBalance(balance);
    }



    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }



    public void setBalance(double balance) {
        this.balance = balance;
    }



    public String getAccountName() {
        return this.accountName;
    }



    public double getBalance() {
        return this.balance;
    }



    @Override
    public String toString() {
        return "AccountType: " + accountType + "\nName: " + this.getAccountName() + "\nBalance: " + this.getBalance();
    }



    ////



    public void deposit(String name, double deposit) {
        double newBalance = this.getBalance() + deposit;
        this.setBalance(newBalance);



        System.out.println("Balance after deposit in " + name + " account: " + this.getBalance());
    }



    public void withDraw(String name, double withDrawal) {
        if (this.getBalance() >= withDrawal) {



            double newBalance = this.getBalance() - withDrawal;
            setBalance(newBalance);
            System.out.println("Balance after deposit in " + name + " account: " + this.getBalance());
        }
        else {
            System.out.println(name + " you can not withdraw "
                    + withDrawal + ", Since Balance is: " + this.getBalance());
        }
    }
}
