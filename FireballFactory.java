/**
 * Write a description of class FireballFactory here.
 * 
 * @author (Avni Gulati) 
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
    public Objects makeDestructionElement(ScoreDisplay disp)
    {
        return new Alien(disp);
    }
}
