import greenfoot.*; 
public class Object2 extends Objects implements Handler 
{
    private boolean toRemove=false;
    private int vx=3;
    private Handler successor=null;
    private ScoreDisplay sd;
    
    public Object2(ScoreDisplay score)
    {
        this.sd=score;
    }
    public void act() 
    {
       move(-vx);
       /*Actor actor=getOneIntersectingObject(Fighter.class);
       if(actor!=null)
       {
           getWorld().addObject(new B(),getX(),getY());
           getWorld().removeObject(actor);
       }*/
    }   
    public void setSuccessor(Handler s)
    {
        this.successor = s;
    }
    public void setObject(World w, Villain e,String str)
    {
        if(str=="OBJECT2")
        {
            w.addObject(new Object2(sd), e.getX(),e.getY());
            this.setLocation(e.getX()-vx,e.getY());
        }
        else
            successor.setObject(w,e,str);
    }
    
}
