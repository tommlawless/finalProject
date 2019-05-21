package pkgfinal.project;

/**
 * Class Withdrawal represents an ATM withdrawal transaction.  Superclass
 * Transaction includes "helper" methods that provide the functionality to 
 * instantiate a BankDatabase object with method getBankDatabase() and a 
 * Screen object with method getScreen().
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class Withdrawal extends Transaction
{
    // Attributes
    private int amount;
    
    // Reference to associated ATM simulated objects
    private Keypad keypad;
    private CashDispenser cashDispenser;
    
    // Constants corresponding to menu items
    private static final int DOLLARS_20 = 1;
    private static final int DOLLARS_40 = 2;
    private static final int DOLLARS_60 = 3;
    private static final int DOLLARS_100 = 4;
    private static final int DOLLARS_200 = 5;
    private static final int CANCEL = 6;
    
    /**
     * Constructor passes parameters for account number, screen and bank database
     * to the superclass constructor, and then assigns keypad and cashDispenser
     * parameters to the ATM simulated object instance variables.
     * 
     * @param accountNumber the account number for the withdrawal
     * @param screen for amount to withdraw and withdrawal output
     * @param bankDatabase to access cash available and account information
     * @param keypad to get user interaction
     * @param cashDispenser to validate that cash was dispensed
     */
    public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase,
                      Keypad keypad, CashDispenser cashDispenser)
    {
        super(accountNumber, screen, bankDatabase);
        
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }
    
    /**
     * Displays the "Withdrawal Menu" of amounts for the user to select the amount 
     * of withdrawal and performs the withdrawal operation if all conditions are 
     * valid.  The withdrawal will be terminated and a message displayed to the 
     * user if: (1) the user selected "Cancel" from the menu; (2) if the balance 
     * of funds for the withdrawal are not available in the user's account; or 
     * (3) if the necessary funds for the withdrawal are not available in the 
     * cash dispenser.
     */
    @Override
    public void execute()
    {
        boolean cashDispensed = false;
        double availableBalance;
        
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        
        do
        {
            amount = displayMenuOfAmounts();
            
            if (amount != CANCEL)
            {
                availableBalance = bankDatabase.getAvailableBalance( getAccountNumber() );
                
                if (amount <= availableBalance)
                {
                    if ( cashDispenser.isSufficientCashAvailable(amount) )
                    {
                        bankDatabase.debit( getAccountNumber(), amount);
                        cashDispenser.dispenseCash(amount);
                        cashDispensed = true;
                        screen.displayMessageLine("\nYour cash has been dispensed.");
                        screen.displayMessageLine("Please take your cash now.");
                    }
                    else
                    {
                    screen.displayMessageLine("\nInsufficient cash available in the ATM.");
                    screen.displayMessageLine("\nPlease choose a smaller amount.");
                    }
                }
                else
                {
                    screen.displayMessageLine("\nInsufficient funds in your account.");
                    screen.displayMessageLine("\nPlease choose a smaller amount.");
                }
            }
            else
            {
                screen.displayMessageLine("\nCanceling transaction...");
                return;
            }

        } while (! cashDispensed);
    }
    
    /**
     * Displays a menu of cash withdrawal amounts, plus the option to cancel;
     * returns the chosen amount from the amounts array, or 6 if user chooses 
     * to cancel.
     * 
     * @return an integer indicating the amount of cash user selected from menu
     */
    private int displayMenuOfAmounts()
    {
        Screen screen = getScreen();
        
        int userChoice = 0;
        int[] amounts = {20, 40, 60, 100, 200};
        
        while (userChoice == 0)
        {
            screen.displayMessageLine("\nWithdrawal Menu:");
            screen.displayMessageLine("1 - $20");
            screen.displayMessageLine("2 - $40");
            screen.displayMessageLine("3 - $60");
            screen.displayMessageLine("4 - $100");
            screen.displayMessageLine("5 - $200");
            screen.displayMessageLine("6 - Cancel transaction");
            screen.displayMessage("\nChoose a withdrawal amount: ");
            
            int input = keypad.getInt();
            
            switch (input)
            {
                case DOLLARS_20:
                case DOLLARS_40:
                case DOLLARS_60:
                case DOLLARS_100:
                case DOLLARS_200:
                    userChoice = amounts[input - 1];
                    break;
                    
                case CANCEL:
                    userChoice = CANCEL;
                    break;
                    
                default:
                    screen.displayMessageLine("\nInvalid entry - try again.");
                    break;
            }
        }
        
        return userChoice;
    }
}
