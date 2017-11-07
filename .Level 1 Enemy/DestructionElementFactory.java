/**
 * Write a description of class DestructionElementFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DestructionElementFactory  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class DestructionElementFactory
     */
    public DestructionElement DestructionElementFactory(int newDestructionElement)
    {
        DestructionElement newElement = null;
        
        if(newDestructionElement ==0)
        {
            FireballFactory newFireballFactory = new FireballFactory();
            newElement = newFireballFactory.makeDectructionElement();
            
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   
}
