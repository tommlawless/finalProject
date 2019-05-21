package pkgfinal.project;

/**
 * Class Screen represents the screen of the ATM.
 * 
 * @author Prof. Carl B. Struck, JavaFX edit by Andy Osorio/Thomas Lawless/Justin Moran
 * @version 5/10/2018, SCCC Spring 2019
 */
public class Screen
{
    /**
     * Display a message without a carriage return.
     * 
     * @param message the message to display
     * @return returns the message
     */
    public String displayMessage(String message)
    {
        return message;
    }

    /**
     * Display a message with a carriage return.
     * 
     * @param message the message to display
     * @return returns the message with a new line 
     */
    public String displayMessageLine(String message)
    {
        return message + "\n";
    }

    /**
     * Display a dollar amount.
     * 
     * @param amount an amount to be displayed in currency format 
     * @return  returns the amount
     */
    public String displayDollarAmount(double amount)
    {
        return String.format("$%,.2f", amount);
    }
}
