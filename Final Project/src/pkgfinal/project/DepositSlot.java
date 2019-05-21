package pkgfinal.project;

/**
 * Class DepositSlop represents the deposit slot of the ATM.
 *
 * @author Prof. Carl B. Struck
 * @version 5/10/2018
 */
public class DepositSlot 
{
    /**
     * Indicates whether or not the envelope is received (always returns true 
     * since this is just a simulation of a real deposit slip).
     * 
     * @return whether or not the envelope is received
     */
    public boolean isEnvelopeReceived()
    {
        return true;
    }
}
