import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Context here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Context extends Actor
{
    private Strategy strategy;
    /**
     * Act - do whatever the Context wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Context(Strategy strategy)
    {
        this.strategy=strategy;
        strategy.act();
    }
    public void executeStrategy()
    {
        strategy.fly();
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
