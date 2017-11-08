import greenfoot.*; 
public class Object1 extends Objects implements Handler 
{
    private boolean toRemove=false;
    private int vx=3;
    private Handler successor=null;
    private ScoreDisplay sd;
    
    public Object1(ScoreDisplay score)
    {
        this.sd = score;
    }
    public void act() 
    {
       move(-vx);
       object1_destroyed();
       /*Actor actor=getOneIntersectingObject(Fighter.class);
       if(actor!=null)
       {
           getWorld().addObject(new B(),getX(),getY());
           getWorld().removeObject(actor);
       }*/
    }   
    
    public void object1_destroyed()
    {
        if(isTouching(Bullet.class))
        {
            World w = getWorld();
            Explosion bomb = new Explosion();
            w.addObject(bomb, getX(), getY()); 
            removeTouching(Bullet.class);
            notifyObservers();
            sd.updateDisplay(this);
            w.removeObject(this);
        }
    }
    
    public void notifyObservers()
    {
        get_sb().updateScore(this);
    }
    
    public void setSuccessor(Handler s)
    {
        this.successor = s;
    }
    public void setObject(World w, Villain e,String str)
    {
        if(str=="OBJECT1")
        {
            w.addObject(new Object1(sd), e.getX(),e.getY());
            this.setLocation(e.getX()-vx,e.getY());
        }
        else
            successor.setObject(w,e,str);
        
    }
}
