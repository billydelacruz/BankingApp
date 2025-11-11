/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

/**
 *
 * @author admin
 */
public class CheckingAccount extends Account{
    private double overDraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double initialBalance, double overDraftLimit )
            throws InvalidAmountException {
        super(accountNumber, accountHolder, initialBalance);
        this.overDraftLimit = overDraftLimit;

    }
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException{
        validateAmount(amount);
        if (balance - amount < -overDraftLimit) {
            throw new InsufficientFundsException("Insufficient funds: exceeds overdraft limit");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful: " + amount);
        }
    }
    @Override
    public void displayAccountInfo(){
        System.out.println("Account type: Checking");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Overdraft limit: " +overDraftLimit);
        System.out.println("Available balance: " + (balance + overDraftLimit));
    }
}
