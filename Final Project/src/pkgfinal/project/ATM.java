package pkgfinal.project;

/**
 * Class ATM represents an automated teller machine.
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class ATM 
{
    // Attributes
    private boolean userAuthenticated;
    private int accountNumber;
    
    // Reference to associated ATM simulated objects
    private final Screen screen;
    private final Keypad keypad;
    private final CashDispenser cashDispenser;
    private final DepositSlot depositSlot;
    private final BankDatabase bankDatabase;
    
    // Constants corresponding to the main menu options
    private final static int BALANCE_INQUIRY = 1;
    private final static int WITHDRAWAL = 2;
    private final static int DEPOSIT = 3;
    private final static int EXIT = 4;
    
    /**
     * The no-parameter constructor initializes instance variables. The user
     * is not authenticated to start and there is no current account number.
     */
    public ATM()
    {
        userAuthenticated = false;
        accountNumber = 0;
        
        screen = new Screen();
        keypad = new Keypad();
        cashDispenser = new CashDispenser();
        depositSlot = new DepositSlot();
        bankDatabase = new BankDatabase();
    }
    
    /**
     * Starts the ATM running.  Welcomes and authenticates the user and then 
     * performs transactions.  When the user is finished, resets authentication
     * and the account number so another user may login, and says "Goodbye" to 
     * the current user.
     */
    public void run()
    {
        while (true)
        {
            while (! userAuthenticated)
            {
                screen.displayMessageLine("\nWelcome");
                authenticateUser();
            }
            
            performTransactions();
            
            userAuthenticated = false;
            accountNumber = 0;
        
            screen.displayMessageLine("\nThank you!  Goodbye!!!\n\n\n\n\n");
        }
    }
    
    /**
     * Attempts to authenticate user against database.
     */
    private void authenticateUser()
    {
        screen.displayMessage("\nPlease enter your account number ==> ");
        int accountNumber = keypad.getInt();
        screen.displayMessage("\nEnter your pin ==> ");
        int pin = keypad.getInt();
        
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
        
        if (userAuthenticated)
        {
            this.accountNumber = accountNumber;
        }
        else
        {
            screen.displayMessageLine("\nInvalid account number or PIN.  Please try again.");
        }
    }
    
    /**
     * Displays the main menu and performs transactions.  The "Main Menu" loop
     * instantiates a new transaction object and executes that transaction if 
     * the selects "Balance inquiry" or "Withdrawal" or "Deposit" from the menu.
     * If the user selects "Exit" the main menu loop ends.  Any other value 
     * entered for the main menu results in an error message and the loop repeats.
     */
    private void performTransactions()
    {
        Transaction transaction = null;
        
        boolean userExited = false;
        
        while (! userExited)
        {
            int mainMenuSelection = displayMainMenu();
            
            switch (mainMenuSelection)
            {
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    transaction = createTransaction(mainMenuSelection);
                    transaction.execute();
                    break;
                    
                case EXIT:
                    screen.displayMessageLine("\nExiting the system...");
                    userExited = true;
                    break;
                    
                default:
                    screen.displayMessageLine("\nInvalid entry - try again.");
                    break;
            }
        }
    }
    
    /**
     * Displays the main menu and returns an input selection.
     * 
     * @return the input selection
     */
    private int displayMainMenu()
    {
        screen.displayMessageLine("\nMain Menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Exit");
        screen.displayMessage("\nEnter a choice: ");
        
        return keypad.getInt();
    }
     
    /**
     * Returns an object of specified Transaction type.  The type is either
     * BalanceInquiry or Withdrawal or Deposit based upon the type parameter.
     * 
     * @param type an integer selected from the "Transactions" main menu options
     * @return the newly created Transaction object
     */
    private Transaction createTransaction(int type)
    {
        Transaction transaction = null;
        
        switch(type)
        {
            case BALANCE_INQUIRY:
                transaction = new BalanceInquiry(accountNumber, screen, bankDatabase);
                break;
            case WITHDRAWAL:
                transaction = new Withdrawal(accountNumber, screen, bankDatabase,
                                             keypad, cashDispenser);
                break;  
            case DEPOSIT:
                transaction = new Deposit(accountNumber, screen, bankDatabase,
                                          keypad, depositSlot);
                break;
        }
        
        return transaction;
    }
}
