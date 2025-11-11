/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

/**
 *
 * @author admin
 */
public abstract class Account implements Transactable{
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public Account(String accountNumber, String accountHolder, double initialBalance) throws InvalidAmountException{
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        if(initialBalance < 0) {throw new InvalidAmountException("You have 0 balance/ Initial balance cant be negative");}

    }

    @Override
    public void deposit(double amount) throws InvalidAmountException{
        validateAmount(amount);
        balance += amount;
        System.out.println("Successfully deposited" + amount);
    }

    protected void validateAmount(double amount) throws InvalidAmountException{
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be greater than zero");
        }

    }
    @Override
    public double getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public abstract void displayAccountInfo();
    public abstract void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException;
}
