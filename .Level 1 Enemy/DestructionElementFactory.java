/**
 * Write a description of class DestructionElementFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DestructionElementFactory  
{
    /**
     * Constructor for objects of class DestructionElementFactory
     */
    public DestructionElement DestructionElementFactory(int newDestructionElement)
    {
        DestructionElement newElement = null;
        
        if(newDestructionElement == 0)
        {
            FireballFactory newFireballFactory = new FireballFactory();
            newElement = newFireballFactory.makeDestructionElement();
            
        }
        else if(newDestructionElement == 1)
        {
            SpaceShipFactory newSpaceShipFactory = new SpaceShipFactory();
            newElement = newSpaceShipFactory.makeDestructionElement();
        }
        else if(newDestructionElement == 2)
        {
            RocketFactory newRocketFactory = new RocketFactory();
            newElement = newRocketFactory.makeDestructionElement();
        }
        
        return newElement;

    }
 
}

