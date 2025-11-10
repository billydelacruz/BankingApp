/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

/**
 *
 * @author admin
 */
public interface Transactable {
    void deposit(double amount) throws InvalidAmountException;
    void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException;
    double getBalance();
    }

