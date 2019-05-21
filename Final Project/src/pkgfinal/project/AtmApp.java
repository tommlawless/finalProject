package pkgfinal.project;

/**
 *
 * @author Prof. Carl B. Struck
 * JavaFX integration by Thomas Lawless/Justin Moran/Andy Osorio
 * @version 5/21/19 SCCC Spring 2019 
 */
public class AtmApp
{
    /**
     * Instantiates an ATM objects and starts it running.
     *
     * @param args the String[] array command line arguments
     */
    public static void main(String[] args)
    {
        ATM atm = new ATM();
        atm.run();
    }
}
