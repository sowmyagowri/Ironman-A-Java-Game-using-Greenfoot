import greenfoot.*; 
/**
 * Write a description of class Object3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object3 extends Objects implements Handler 
{
    private boolean toRemove=false;
    private int vx=3;
    private Handler successor=null;
    private ScoreDisplay sd;
    
    public Object3(ScoreDisplay score)
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
        if(str=="OBJECT3")
        {
            w.addObject(new Object3(sd), e.getX(),e.getY());
            this.setLocation(e.getX()-vx,e.getY());
        }
        else
            return;
        
    }
}
