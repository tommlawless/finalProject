package pkgfinal.project;

/**
 * Class CashDispenser represents the cash dispenser of the ATM and how much
 * cash currently is available.
 *
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class CashDispenser 
{
    private final static int INITIAL_COUNT = 500;
    private int count;
    
    /**
     * Initializes the count of $20 bills.
     */
    public CashDispenser()
    {
        count = INITIAL_COUNT;
    }
    
    /**
     * Simulates the dispensing a specified amount of cash by subtracting that
     * many bills from the count of bills.
     * 
     * @param amount the amount of the withdrawal
     */
    public void dispenseCash(int amount)
    {
        int billsRequired = amount / 20;
        count -= billsRequired;
    }
    
    /**
     * Returns a boolean value indicating whether the cash dispenser can dispense
     * the desire amount of cash.
     * 
     * @param amount the amount of the withdrawal
     * @return whether or not there is enough cash available for the withdrawal
     */
    public boolean isSufficientCashAvailable(int amount)
    {
        int billsRequired = amount / 20;
        
        return (count >= billsRequired);
    }
}
