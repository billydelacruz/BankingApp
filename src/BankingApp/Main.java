/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankingApp;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args){
        try {
            Bank bank = new Bank("My Bank");


            SavingsAccount savings = bank.createSavingsAccount("SA1000", "Billy Dela Cruz", 1000, 0.5);
            CheckingAccount checking = bank.createCheckingAccount("CA2000", "Billy Dela Cruz", 500, 200);

            System.out.println("\n------Initial accounts states------");
            bank.displayAllAccounts();

            System.out.println("\n------Testing deposits-----");
            savings.deposit(500);
            checking.deposit(300);

            System.out.println("\n-----Testing withdrawals-----");
            System.out.println("Savings account: Withdrawing P1200");
            savings.withdraw(1200);

            System.out.println("CheckingAccount: Withdrawing ₱650 (within overdraft limit)");
            checking.withdraw(650);

            try {
                checking.withdraw(900);  // exceeds overdraft
            } catch (InsufficientFundsException e) {
                System.out.println("❌ Exception caught: " + e.getMessage());
            }

            // 6️⃣ Test transfer
            System.out.println("\n--- Testing Transfer ---");
            bank.transfer("SA1000", "CA2000", 200);  // transfer 200 from savings to checking

            // 7️⃣ Test exceptions
            System.out.println("\n--- Testing Exception Cases ---");

            // Withdraw below balance in savings
            try {
                savings.withdraw(2000);
            } catch (InsufficientFundsException e) {
                System.out.println("❌ Exception caught: " + e.getMessage());
            }

            // Deposit negative amount
            try {
                checking.deposit(-100);
            } catch (InvalidAmountException e) {
                System.out.println("❌ Exception caught: " + e.getMessage());
            }

            // 8️⃣ Final display
            System.out.println("\n--- Final Account States ---");
            bank.displayAllAccounts();

        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        }

}
