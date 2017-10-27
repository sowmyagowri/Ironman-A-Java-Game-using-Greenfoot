import greenfoot.*;  
import greenfoot.Color;
public class Laser extends Actor
{
    private boolean toRemove=false;
    private int vx=3;
    public void addedToWorld(World MyWorld)
    {
        GreenfootImage image=new GreenfootImage(50,10);
        image.setColor(Color.BLACK);
        image.drawLine(0,5,image.getWidth()-1,5);
        setImage(image);
    }
    
    public void act() 
    {
        if(!toRemove)
        {
            setLocation(getX()+vx,getY());
            if(getX()>getWorld().getWidth()+200) toRemove=true;
        }else
        {
            getWorld().removeObject(this);
        }
    }    
}
