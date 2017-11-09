/**
 * Write a description of class SpaceShipFactory here.
 * 
 * @author (Avni Gulati) 
 * @version (a version number or a date)
 */
public class SpaceShipFactory extends DestructionElementFactory 
{
    public SpaceShipFactory(ScoreDisplay display)
    {
        makeDestructionElement(display);
    }
    // instance variables - replace the example below with your own
    public Objects makeDestructionElement(ScoreDisplay display2)
    {
       // ScoreDisplay display;
       
        return new AlienShip(display2);
        
    }
}
