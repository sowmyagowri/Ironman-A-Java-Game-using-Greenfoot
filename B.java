import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class B here.
 * 
 * @author (Sowmya Viswanathan) 
 * @version (a version number or a date)
 */
public class B extends Actor
{
    private int jeda=5;
    
    public void addedToWorld(World MyWorld)
    {
        GreenfootImage image =new GreenfootImage(50,50);
        image.setColor(new Color(255,255,0,180));
        image.fillOval(0,0,image.getWidth()-10, image.getHeight()-10);
        image.fillOval(10,10,image.getWidth()-31, image.getHeight()-31);
        setImage(image);
        jeda=5;
    }
    public void act() 
    {
        if(jeda>0) jeda--;
        else getWorld().removeObject(this);
    }    
}
