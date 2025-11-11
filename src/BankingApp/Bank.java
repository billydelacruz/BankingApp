/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Bank {
    private String bankName;
    private List<Account> accounts;

    public Bank(String bankName){
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public SavingsAccount createSavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate)
            throws InvalidAmountException{
        SavingsAccount newAccount = new SavingsAccount(accountNumber,accountHolder, initialBalance, interestRate);
        accounts.add(newAccount);
        return newAccount;
    }

    public CheckingAccount createCheckingAccount(String accountNumber, String accountHolder, double initialBalance, double overDraftLimit)
            throws InvalidAmountException{
        CheckingAccount newAccount = new CheckingAccount(accountNumber,accountHolder, initialBalance, overDraftLimit);
        accounts.add(newAccount);
        return  newAccount;

    }

    public Account findAccount(String accountNumber){
        for (Account acc : accounts){
            if(acc.getAccountNumber().equals(accountNumber)){
                return acc;
            }
        }
        return null;
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
            throws InsufficientFundsException, InvalidAmountException{
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

            if (fromAccount == null){
                System.out.println("Source account not found: " + fromAccountNumber);
                return;
            }
            if (toAccount == null){
                System.out.println("Destination account not found: " + toAccountNumber);
                return;
            }

            fromAccount.withdraw(amount);
            toAccount.deposit(amount);

            System.out.println("Transfer successful: " + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
    }

    public void displayAllAccounts(){
        System.out.println(bankName);
        for(Account acc : accounts){
            acc.displayAccountInfo();
            System.out.println("--------------------------------------");
        }
    }


}
