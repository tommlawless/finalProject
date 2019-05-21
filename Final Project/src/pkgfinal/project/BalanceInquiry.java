package pkgfinal.project;

/**
 * Class BalanceInquiry represents a balance inquiry ATM transaction.  Superclass
 * Transaction includes "helper" methods that provide the functionality to 
 * instantiate a BankDatabase object with method getBankDatabase() and a Screen 
 * object with method getScreen().
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class BalanceInquiry extends Transaction
{
    /**
     * Constructor passes parameters for account number, screen and bank database
     * to the superclass constructor.
     * 
     * @param accountNumber the account number for the withdrawal
     * @param screen for display of account balance information
     * @param bankDatabase to access account balance information
     */
    public BalanceInquiry(int accountNumber, Screen screen, BankDatabase bankDatabase)
    {
        super(accountNumber, screen, bankDatabase);
    }
    
    /**
     * Performs the balance inquiry transaction.  Instantiates a bank database
     * object to access the account balances and a screen object from to access 
     * the screen for output.  Accesses the current account number from superclass 
     * method getAccountNumber().
     */
    @Override
    public void execute()
    {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        
        double availableBalance = bankDatabase.getAvailableBalance( getAccountNumber() );
        double totalBalance = bankDatabase.getTotalBalance( getAccountNumber() );
        
        screen.displayMessageLine("\nBalance information:");
        screen.displayMessage(" - Available balance: ");
        screen.displayDollarAmount(availableBalance);
        screen.displayMessage("\n - Total balance: ");
        screen.displayDollarAmount(totalBalance);
        screen.displayMessageLine("");
    }
}
