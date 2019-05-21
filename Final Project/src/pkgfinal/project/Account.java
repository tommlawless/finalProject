package pkgfinal.project;

/**
 * Class Account represents as bank account.
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class Account
{
    // Attributes
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    
    /**
     * Constructor initializes the instance variable from the parameters.
     * 
     * @param accountNumber the account number for the account
     * @param pin the pin number related to the account number for the account
     * @param availableBalance funds available for withdrawal
     * @param totalBalance funds available plus pending deposits
     */
    public Account(int accountNumber, int pin, double availableBalance, double totalBalance)
    {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }
    
    /**
     * Determines whether a the input user PIN matches the PIN in account.
     * 
     * @param pin the input PIN from the keypad
     * @return a boolean value that validates if the input PIN matches PIN in account.
     */
    public boolean validatePin(int pin)
    {
        return (this.pin == pin);
    }
    
    /**
     * Returns the account number.
     * @return the account number
     */
    public int getAccountNumber()
    {
        return accountNumber;
    }
    
    /**
     * Returns the funds available for withdrawal.
     * 
     * @return the available balance for the account
     */
    public double getAvailableBalance()
    {
        return availableBalance;
    }
    
    /**
     * Returns funds available plus pending deposits.
     * 
     * @return the total balance for the account
     */
    public double getTotalBalance()
    {
        return totalBalance;
    }
    
    /**
     * Credits the account by adding the deposit amount to the total balance.
     * 
     * @param amount the amount credited to the total balance
     */
    public void credit(double amount)
    {
        totalBalance += amount;
    }
    
    /**
     * Debits the account by subtracting the withdrawal amount from the total balance.
     * 
     * @param amount the amount debited from the total balance
     */
    public void debit(double amount)
    {
        availableBalance -= amount;
        totalBalance -= amount;
    }
}
