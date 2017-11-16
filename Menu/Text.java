import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author Rucha Apte 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Text()  
    {  
        this("");  
    }  
 
    public Text(String text)  
    {          setText(text);  
    }  
 
    public void setText(String text)  
    {  
        setImage(new GreenfootImage(text, 50, Color.WHITE, Color.BLACK));  
    } 
        
}
