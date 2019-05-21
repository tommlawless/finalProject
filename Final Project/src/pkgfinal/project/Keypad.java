package pkgfinal.project;

import java.util.Scanner;

/**
 * Class Keypad represents the keypad of the ATM.
 * 
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class Keypad 
{
    // A Scanner object that reads data from the console.
    private Scanner input;
    
    /**
     * The no-parameter constructor that instantiates the Scanner.
     */
    public Keypad()
    {
        input = new Scanner(System.in);
    }
    
    /**
     * Returns an integer value entered by the user.
     * 
     * @return an integer value
     */
    public int getInt()
    {
        return input.nextInt();
    }
    
    /**
     * Returns a double value entered by the user.
     * 
     * @return a double value
     */
    public double getDouble()
    {
        return input.nextDouble();
    }
}
