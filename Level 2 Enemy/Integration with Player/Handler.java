import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Handler here.
 * 
 * @author (Sowmya Viswanathan) 
 * @version (a version number or a date)
 */
public interface Handler 
{
    /**
     * Act - do whatever the Strategy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(); 
    public void setObject(World w, Enemy e, String str);
    public void setSuccessor(Handler s);
}
