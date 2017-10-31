import greenfoot.*; 
/**
 * Write a description of class Object2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object2 extends Actor implements Strategy 
{
    // instance variables - replace the example below with your own
    
    private boolean toRemove=false;
    private int vx=3;
    private Strategy successor=null;
    //Enemy en;
    Object2 ob=this;
    public void act() 
    {
       
    }   
    public void setSuccessor(Strategy s)
    {
        this.successor = s;
    }
    public void setObject(World w, Enemy e)
    {
        w.addObject(new Object2(), e.getX(),e.getY());
        this.setLocation(e.getX()-vx,e.getY());
        
    }
    public void fly(String f,World w, Enemy e)
    {
        if(!toRemove)
        {
            ob.setLocation(e.getX()-vx,e.getY());
            if(e.getX()>w.getWidth()) toRemove=true;
        }else
        {
            w.removeObject(this);
        }
       
    }
}
