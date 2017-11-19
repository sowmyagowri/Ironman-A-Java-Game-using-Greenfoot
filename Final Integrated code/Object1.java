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
    private ScoreDisplay sd;
    
    public Object1(ScoreDisplay score)
    {
        this.sd=score;
    }
    public void act() 
    {
       move(-vx);
       removeObj1();
    }   
    public void setSuccessor(Handler s)
    {
        this.successor = s;
    }
    public void setObject(World w, Enemy e,String str)
    {
        if(str=="OBJECT1")
        {
            w.addObject(new Object1(sd), e.getX(),e.getY());
            this.setLocation(e.getX()-vx,e.getY());
        }
        else
            successor.setObject(w,e,str);
    }
    
    public void removeObj1()
    {
         if(isTouching(shot.class))
         {
            //explosionSound.play();
            Explosion bomb = new Explosion();
            getWorld().addObject(bomb, getX(), getY()); 
            removeTouching(shot.class);
            notifyObservers();
            getWorld().removeObject(this);
         }
    }
    
    public void notifyObservers()
    {
        get_scoreboard().updateScore(this);
        sd.updateDisplay(this);
    }
}
