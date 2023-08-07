package com.challenge;

public class SavingsAccount extends BankAccount {
    public String accountType = "SavingsAccount";
    public SavingsAccount(String accountName, double balance) {
        super(accountName, balance);
    }



    @Override
    public String toString() {
        return "AccountType: " + accountType + "\nName: " + getAccountName() + "\nBalance: " + getBalance();
    }



    @Override
    public void withDraw(String name, double withDraw) {
        double newBalance;
        if ((getBalance() - withDraw) >= 100) {
            newBalance = getBalance() - withDraw;
            setBalance(newBalance);
            System.out.println("Balance after deposit in " + name + " account: " + getBalance());
        }
        else {
            System.out.println(name + " you can not withdraw "
                    + withDraw + ", Since Balance will falls below 100!!!");
        }
    }
}