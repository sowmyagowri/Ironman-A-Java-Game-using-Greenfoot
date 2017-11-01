import greenfoot.*; 
public class Object2 extends Actor implements Handler 
{
    private boolean toRemove=false;
    private int vx=3;
    private Handler successor=null;
    
    public void act() 
    {
       move(-vx);
    }   
    public void setSuccessor(Handler s)
    {
        this.successor = s;
    }
    public void setObject(World w, Enemy e,String str)
    {
        if(str=="OBJECT2")
        {
            w.addObject(new Object2(), e.getX(),e.getY());
            this.setLocation(e.getX()-vx,e.getY());
        }
        else
            successor.setObject(w,e,str);
    }
    
}
