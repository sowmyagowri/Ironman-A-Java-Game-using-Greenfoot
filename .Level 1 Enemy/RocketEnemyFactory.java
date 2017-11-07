/**
 * Write a description of class FireballFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketEnemyFactory extends DestructionElementFactory 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class FireballFactory
     */
    public DestructionElement makeDestructionElement()
    {
        return new RocketElement();
    } 
}

