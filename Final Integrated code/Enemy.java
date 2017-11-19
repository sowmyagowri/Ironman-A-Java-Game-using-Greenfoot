import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (Sowmya Viswanathan) 
 * @version (a version number or a date)
 */
public class Enemy extends Objects
{
   private int counter=0,vx=1;
   public static int dir=0;
   public boolean toRemove=false;
   private ScoreDisplay sd1;
   private ScoreDisplay sd2;
   private ScoreDisplay sd3;
   private ScoreDisplay sd4;
   int lives_left;
   
   public Enemy(ScoreDisplay score1, ScoreDisplay score2, ScoreDisplay score3, ScoreDisplay score4 )
    {
        this.sd1=score1;
        this.sd2=score2;
        this.sd3=score3;
        this.sd4=score4;
        lives_left = get_scoreboard().get_enemy_hit();
    }
   
   public void checkwalls()
   {
       if(getY() == 0)
       {
           setLocation(getX(),getY()+50);
           dir=1;                  
       }
       if(getY() == getWorld().getHeight()-1)
       {
           setLocation(getX(),getY()-50);
           dir=0;                  
       }
   }
   public void check_lives()
   {
       lives_left = get_scoreboard().get_enemy_hit();
       if(lives_left > 0)
       {
           toRemove=false;
       }
       /*else 
       {
           toRemove=true;  
           
       }*/
   }
    
   public void move()
   {
   if(dir==0)
   {
       setLocation(getX(),getY()-vx);
       checkwalls();
   }
   if(dir==1)
   {
       setLocation(getX(),getY()+vx);
       checkwalls();
   }
   Enemy e=this;
   World world=getWorld();
    
   Handler s1 = new Object1(sd2);
   Handler s2 = new Object2(sd3);
   Handler s3 = new Object3(sd4);
    
   s1.setSuccessor(s2);
   s2.setSuccessor(s3);
   counter=getRandomNumber(20,150);
   //if(counter>0) counter--;
   if(counter==30) { s1.setObject(world,e,"OBJECT1"); }
   if(counter==100) { s1.setObject(world,e,"OBJECT2"); }
   if(counter==90) { s1.setObject(world,e,"OBJECT3"); }
   //if(counter%170==149) { s1.setObject(world,e,"OBJECT2"); }
   //if(counter%170==105) { s1.setObject(world,e,"OBJECT3"); }
   //if(counter%170==40) { s1.setObject(world,e,"OBJECT2"); }
   //if(counter==0) counter=170;
   }
   public int getRandomNumber(int start,int end)
   {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
   public void act() 
   {
       check_lives();
       if(!toRemove) 
       {
           move();
           removeEnemy();
       }
       /*else
       {
            getWorld().removeObject(this);
       }*/
   }    
   
   public void removeEnemy()
    {
         if(isTouching(shot.class))
         {
            //explosionSound.play();
            Explosion bomb = new Explosion();
            getWorld().addObject(bomb, getX(), getY()); 
            removeTouching(shot.class);
            notifyObservers();
         }
    }
    
    public void notifyObservers()
    {
        get_scoreboard().updateScore(this);
        sd1.updateDisplay(this);
    }
}