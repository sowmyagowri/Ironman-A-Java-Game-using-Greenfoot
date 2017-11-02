import greenfoot.*; 
public class Object2 extends Actor implements Handler 
{
    private boolean toRemove=false;
    private int vx=3;
    private Handler successor=null;
    
    public void act() 
    {
       move(-vx);
       Actor actor=getOneIntersectingObject(Fighter.class);
       if(actor!=null)
       {
           getWorld().addObject(new B(),getX(),getY());
           getWorld().removeObject(actor);
       }
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
