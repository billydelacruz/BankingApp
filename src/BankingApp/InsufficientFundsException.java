/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

/**
 *
 * @author admin
 */
public class InsufficientFundsException extends Exception{
    private String message;
    
    public InsufficientFundsException(String message){
        super(message);
    }

    
}
