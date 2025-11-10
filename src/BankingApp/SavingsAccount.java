/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

/**
 *
 * @author admin
 */
public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate)
            throws InvalidAmountException{
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;

    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        validateAmount(amount);
        if(balance - amount < 100){
            throw new InsufficientFundsException("Must maintain $100 minimum");
        }
        balance -= amount;
        System.out.println("Withdrawal successful " + amount);
    }
    public double calculateInterest(){
        return balance * interestRate / 100;
    }
    @Override
    public void displayAccountInfo(){
        System.out.println("Saving Account");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Interest rate: " + interestRate);
        System.out.println("Calculated interest: " + calculateInterest());

    }
}
