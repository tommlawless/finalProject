package pkgfinal.project;

/**
 * Class BankDatabase represents the bank account information database.
 *
 * @author Prof. Carl B. Struck, JavaFX edit by Andy Osorio/Thomas Lawless/Justin Moran
 * @version 5/10/2018, FX version SCCC Spring 2019
 */
public class BankDatabase 
{
    // The array of bank accounts
    private Account[] accounts;
    
    /**
     * The no-parameter constructor initializes bank accounts for users.
     */
    public BankDatabase()
    {
        accounts = new Account[3];
        accounts[0] = new Account(12345, 54321, 1000.00, 1200.00);
        accounts[1] = new Account(98765, 56789, 200.00, 200.00);
        accounts[2] = new Account(11122, 22211, 0.00, 0.00);
    }
    
    /**
     * "Helper method" that loops through the existing accounts in the bank 
     * database retrieve an Account object with an account number that matches 
     * the account number parameter.  Returns the account for a matching account 
     * number or returns null if no matching account if found.
     * 
     * @param accountNumber an account number input from the keypad
     * @return an Account object for an existing account
     */
    private Account getAccount(int accountNumber)
    {
        for (Account account : accounts)
        {
            if (account.getAccountNumber() == accountNumber)
            {
                return account;
            }
        }
        
        return null;
    }
    
    /**
     * A boolean method that returns true if the account number input from the
     * keypad exists in the bank database, and the account number for that existing 
     * account matches the corresponding PIN number.  Otherwise the method returns
     * false.
     * 
     * @param accountNumber an account number input from the keypad
     * @param pin a PIN number input from the keypad
     * @return true if the account exists and matches the input PIN number; otherwise false
     */
    public boolean authenticateUser(int accountNumber, int pin)
    {
        Account account = getAccount(accountNumber);
        
        if (account != null)
        {
            return account.validatePin(pin);
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Return the available balance of account for specified account number.
     * 
     * @param accountNumber an account number input from the keypad
     * @return the available balance for a specified account
     */
    public double getAvailableBalance(int accountNumber)
    {
        return getAccount(accountNumber).getAvailableBalance();
    }
    
    /**
     * Return the total balance of account for specified account number.
     * 
     * @param accountNumber an account number input from the keypad
     * @return the total balance for a specified account
     */
    public double getTotalBalance(int accountNumber)
    {
        return getAccount(accountNumber).getTotalBalance();
    }
    
    /**
     * Credits an amount to an account with the specified account number.
     * 
     * @param accountNumber an account number input from the keypad
     * @param amount the amount credited to the account
     */
    public void credit(int accountNumber, double amount)
    {
        getAccount(accountNumber).credit(amount);
    }
    
    /**
     * Debits an amount from an account with the specified account number.
     * 
     * @param accountNumber an account number input from the keypad
     * @param amount the amount debited from the account
     */
    public void debit(int accountNumber, double amount)
    {
        getAccount(accountNumber).debit(amount);
    }
}
