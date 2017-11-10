/**
 * Write a description of class RocketFactory here.
 * 
 * 
 * @author (Avni Gulati) 
 * @version (a version number or a date)
 */
public class RocketFactory extends DestructionElementFactory 
{
    public RocketFactory(ScoreDisplay display)
    {
        makeDestructionElement(display);
    }
    // instance variables - replace the example below with your own
    public Objects makeDestructionElement(ScoreDisplay display3)
    {
        return new AlienSoldier(display3);
        
    }
}
