
package testloanclass;

import java.util.Scanner;

public class TestLoanClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter annual ınterest rate, for example, 6.56: ");
        double annualInterestRate = input.nextDouble();
        
        System.out.print("enter number of years, for example, 6: ");
        int numberOfYears = input.nextInt();
        
        System.out.print("enter loan amount, for example, 1200006.56: ");
        double loanAmount = input.nextDouble();
        
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        
        System.out.printf("the loan was created on %s\n" 
                + "the monthly payment is %.2f\nThe total payment is %.2f\n", 
                loan.getLoanDate().toString(), loan.getMonthlyPaymnet(), 
                loan.getTotalPayment());
    }
    
}
