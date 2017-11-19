/**
 * Write a description of class timer here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class timer  
{
    private long lastshot = System.currentTimeMillis();
    
    public void shot()
    {
        lastshot = System.currentTimeMillis();
    }
    
    /**
     * Returns the amount of milliseconds that have elapsed since shot()
     * was last called.  This timer runs irrespective of Greenfoot's
     * act() cycle, so if you call it many times during the same Greenfoot frame,
     * you may get different values returned.
     */
    public int millisecondsElapsed()
    {
        return (int) (System.currentTimeMillis() - lastshot);
    }
}
