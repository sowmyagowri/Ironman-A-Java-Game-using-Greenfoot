import greenfoot.*;
import java.util.*; 
public class Enemy extends Objects implements Game
{
   
    private int targetx=0, targety=0,counter=0,vx=1,lives=50;
    public static int dir=0;
    public String str="object1";
    public boolean toRemove=false;
    private ScoreDisplay sd1;
        private ScoreDisplay sd2;
            private ScoreDisplay sd3;
                private ScoreDisplay sd4;
    
    public Enemy(ScoreDisplay score1, ScoreDisplay score2, ScoreDisplay score3, ScoreDisplay score4 )
    {
        this.sd1=score1;
        this.sd2=score2;
        this.sd3=score3;
        this.sd4=score4;
    }
    
    public void checkwalls()
    {
            if(isAtEdge()&&dir==0)
              {
                  setLocation(getX(),getY()-50);
                  dir=1;                  
              }
            if(isAtEdge()&&dir==1)
            {
                  setLocation(getX(),getY()+50);
                  dir=0;                  
            }
    }
    public void destroy()
    {
        getWorld().addObject(new B(),getX(),getY());
        remEnemy();
        if(get_sb().getVillanLives()==0) toRemove=true;
        else toRemove=false;       
    }
    public void remEnemy()
    {
        //lives--;
        notifyObservers();
        sd4.updateDisplay(this);
    }
    public void notifyObservers()
    {
        get_sb().updateScore(this);
    }
    
    public void move()
    {
    if(dir==0)
    {
        setLocation(getX(),getY()+vx);
        checkwalls();
    }
    if(dir==1)
    {
        setLocation(getX(),getY()-vx);
        checkwalls();
    }
        Enemy e=this;
        World world=getWorld();
    
        Handler s1 = new Object1(sd3);
        Handler s2 = new Object2(sd2);
        Handler s3 = new Object3(sd1);
    
        s1.setSuccessor(s2);
        s2.setSuccessor(s3);
    
        if(counter>0) counter--;
        if(counter%170==169) { s1.setObject(world,e,"OBJECT1"); }
        if(counter%170==110) { s1.setObject(world,e,"OBJECT2"); }
        if(counter%170==40) { s1.setObject(world,e,"OBJECT3"); }
        if(counter==0) counter=170;
    }
    public void act() 
    {
        
        if(!toRemove) 
            move();
        else
            getWorld().removeObject(this);
        
    }    
}