package pkgfinal.project;

/**
 * Class Deposit represents an ATM deposit transaction.  Superclass Transaction 
 * includes "helper" methods that provide the functionality to instantiate a 
 * BankDatabase object with method getBankDatabase() and a Screen object with 
 * method getScreen().
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class Deposit extends Transaction
{
    // Attributes
    private double amount;
    
    // Reference to associated ATM simulated objects
    Keypad keypad;
    DepositSlot depositSlot;
    
    // Constants corresponding to cancel option
    private static final int CANCELED = 0;
    
    /**
     * Constructor passes parameters for account number, screen and bank database
     * to the superclass constructor, and then assigns keypad and depositSlot
     * parameters to the ATM simulated object instance variables.
     * 
     * @param accountNumber the account number for the deposit
     * @param screen for amount to deposit and deposit output
     * @param bankDatabase to access account information
     * @param keypad to get user interaction
     * @param depositSlot to validate the deposit was completed
     */
    public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase,
                   Keypad keypad, DepositSlot depositSlot)
    {
        super(accountNumber, screen, bankDatabase);
        
        this.keypad = keypad;
        this.depositSlot = depositSlot;
    }
    
    /**
     * Prompts the user for the amount of deposit and performs the deposit 
     * operation if all conditions are valid.  The deposit will be terminated
     * and a message displayed to the user if: (1) the user selected "Cancel" 
     * by entering a value of zero (0) or less for the deposit; (2) or if the
     * envelope was not received (actually impossible in this simulation so 
     * condition never is true).
     */
    @Override
    public void execute()
    {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        
        amount = promptForDepositAmount();
        
        if (amount != CANCELED)
        {
            screen.displayMessage("\nPlease insert a deposit envelope containing ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine(".");
            
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();
            
            if (envelopeReceived)
            {
                screen.displayMessageLine("\nYour envelope has been received");
                screen.displayMessageLine("NOTE: The money just deposited will not be available until ");
                screen.displayMessageLine("we verify the amount of any enclosed cash and your checks clear.");
                
                bankDatabase.credit( getAccountNumber(), amount);
            }
            else
            {
                screen.displayMessage("\n You did not insert an envelope, so ");
                screen.displayMessageLine("the ATM has canceled your transaction.");
            }
        }
        else
        {
            screen.displayMessageLine("\nCanceling transaction...");
        }
    }
    
    /**
     * Prompts the user to enter the deposit amount, or gives the option to cancel;
     * returns the chosen amount of cash, or zero (0) if user chooses to cancel.
     * 
     * @return the input of the deposit amount, or zero (0) if canceled
     */
    private double promptForDepositAmount()
    {
        Screen screen = getScreen();
        
        screen.displayMessage("\nPlease enter a deposit (or 0 to cancel): ");
        double input = keypad.getDouble();
        
        if (input <= CANCELED)
        {
            return CANCELED;
        }
        else
        {
            return input;
        }
    }
}
