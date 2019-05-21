package pkgfinal.project;

/**
 * Class Screen represents the screen of the ATM.
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class Screen
{
    /**
     * Display a message without a carriage return.
     * 
     * @param message the message to display
     */
    public void displayMessage(String message)
    {
        System.out.print(message);
    }

    /**
     * Display a message with a carriage return.
     * 
     * @param message the message to display
     */
    public void displayMessageLine(String message)
    {
        System.out.println(message);
    }

    /**
     * Display a dollar amount.
     * 
     * @param amount an amount to be displayed in currency format 
     */
    public void displayDollarAmount(double amount)
    {
        System.out.printf("$%,.2f", amount);
    }
}
