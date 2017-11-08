/**
 * Write a description of class FireballFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireballFactory extends DestructionElementFactory 
{
   
    
    /**
     * Constructor for objects of class FireballFactory
     */
    public FireballFactory(ScoreDisplay display)
    {
        makeDestructionElement(display);
    }
    public DestructionElements makeDestructionElement(ScoreDisplay disp)
    {
        return new FireballElement(disp);
    }
}

