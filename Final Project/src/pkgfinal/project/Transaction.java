package pkgfinal.project;

/**
 * Abstract class Transaction represents an ATM transaction.  This class is
 * "immutable" since there are no set methods, and thus that all instance 
 * variables may be defined as final.
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public abstract class Transaction 
{
    // Attributes
    private final int accountNumber;
    
    // Reference to associated ATM simulated objects
    private final Screen screen;
    private final BankDatabase bankDatabase;
    
    /**
     * Gets parameters from the subclass and assigns them to the instance variables.
     * 
     * @param accountNumber the account number for the current account
     * @param screen an ATM Screen object 
     * @param bankDatabase an ATM BankDatabase object
     */
    public Transaction(int accountNumber, Screen screen, BankDatabase bankDatabase)
    {
        this.accountNumber = accountNumber;
        this.screen = screen;
        this.bankDatabase = bankDatabase;
    }
    
    /**
     * Returns the account number for the current account.
     * 
     * @return account number for current account
     */
    public int getAccountNumber()
    {
        return accountNumber;
    }
    
    /**
     * Returns a reference to the screen object.
     * 
     * @return the screen object
     */
    public Screen getScreen()
    {
        return screen;
    }
    
    /**
     * Returns a reference to the bank database object.
     * 
     * @return the bank database object
     */
    public BankDatabase getBankDatabase()
    {
        return bankDatabase;
    }
    
    /**
     * Abstract placeholder to execute a transaction from the subclass.
     */
    public abstract void execute();
}
