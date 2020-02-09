
package testloanclass;

public class Loan {
    private double annualInterestRate = 2.5;
    private int numberOfYears = 1;
    private double loanAmount = 1000;
    private java.util.Date loanDate;
    
    public Loan(){
        this(2.5, 1, 1000);
    }
    
    public Loan(double annualInterestRate, 
            int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    
    public int getNumberOfYears(){
        return numberOfYears;
    }
    
    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }
    
    public double getLoanAmount(){
        return numberOfYears;
    }
    
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }
    
    public java.util.Date getLoanDate(){
        return loanDate;
    }
    
    public double getMonthlyPaymnet(){
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / 
                (1 - (1 / Math.pow(1 + monthlyInterestRate, 
                        numberOfYears * 12)));
        return monthlyPayment;
    }
    
    public double getTotalPayment(){
        double totalPayment = getMonthlyPaymnet() * numberOfYears * 12;
        return totalPayment;
    }
}
