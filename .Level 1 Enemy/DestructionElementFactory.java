/**
 * Write a description of class DestructionElementFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DestructionElementFactory  
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class DestructionElementFactory
     */
    public Objects selectDestructionElementFactory(int newDestructionElement,ScoreDisplay display2,ScoreDisplay display3,ScoreDisplay display4)
    {
        Objects newElement = null;
        
        if(newDestructionElement == 0)
        {
            FireballFactory newFireballFactory = new FireballFactory(display4);
            newElement = newFireballFactory.makeDestructionElement(display4);
            
        }
        else if(newDestructionElement == 1)
        {
            SpaceShipFactory newSpaceShipFactory = new SpaceShipFactory(display2);
            newElement = newSpaceShipFactory.makeDestructionElement(display2);
        }
        else if(newDestructionElement == 2)
        {
            RocketFactory newRocketFactory = new RocketFactory(display3);
            newElement = newRocketFactory.makeDestructionElement(display3);
        }
        
        return newElement;

    }
}


