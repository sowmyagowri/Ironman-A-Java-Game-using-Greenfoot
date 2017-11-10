import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Object1 here.
 * 
 * @author (Sowmya Viswanathan) 
 * @version (a version number or a date)
 */
public class Object1 extends Objects implements Handler 
{
    private boolean toRemove=false;
    private int vx=3;
    private Handler successor=null;
    
    public void act() 
    {
       move(-vx);
       if(getX() == 0)
        getWorld().removeObject(this);
    }   
    public void setSuccessor(Handler s)
    {
        this.successor = s;
    }
    public void setObject(World w, Enemy e,String str)
    {
        if(str=="OBJECT1")
        {
            w.addObject(new Object1(), e.getX(),e.getY());
            this.setLocation(e.getX()-vx,e.getY());
        }
        else
            successor.setObject(w,e,str);
    }
}
