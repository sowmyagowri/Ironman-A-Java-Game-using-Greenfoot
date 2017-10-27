import greenfoot.*; 
/**
 * Write a description of class Object1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object1 extends Actor implements Strategy 
{
    // instance variables - replace the example below with your own
   private boolean toRemove=false;
    private int vx=3;
    public void act() 
    {
        if(!toRemove)
        {
            setLocation(getX()-vx,getY());
            if(getX()>getWorld().getWidth()+200) toRemove=true;
        }else
        {
            getWorld().removeObject(this);
        }
    }   
    
    public void fly()
    {
        //setImage(new GreenfootImage("square2.png"));
        act();
    }
}
