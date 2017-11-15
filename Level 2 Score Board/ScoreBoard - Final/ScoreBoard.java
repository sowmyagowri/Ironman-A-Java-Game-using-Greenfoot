import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (Ishwarya Varadarajan) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor implements GameObserver
{
    private GreenfootImage counter;
    private static int numIronManlives = 3;
    private static int alienShipsHit = 0;
    private static int alienSoldiersHit = 0;
    private static int aliensHit = 0;
    private static int ironManShots = 50;
    private static int object1_hit = 0;
    private static int object2_hit = 0;
    private static int object3_hit = 0;
    private static int enemy_hit = 3;
    private String state = "Initial";
   
    public String getState()
    {
        return state;
    }
    
    public int get_alienShipsHitCount()
    {
        return alienShipsHit;
    }
    
    public int get_numIronManlives()
    {
        return numIronManlives;
    }
    
    public int get_alienSoldierHitCount()
    {
        return alienSoldiersHit;
    }
    
    public int get_aliensHitCount()
    {
        return aliensHit;
    }
    
    public int get_ironManShots()
    {
        return ironManShots;
    }
    
    public int get_object1_hit()
    {
        return object1_hit;
    }
    
    public int get_object2_hit()
    {
        return object2_hit;
    }
    
    public int get_object3_hit()
    {
        return object3_hit;
    }
    
    public int get_enemy_hit()
    {
        return enemy_hit;
    }
    
    public void set_alienShipsHitCount()
    {
        alienShipsHit++;
    }
    
    public void set_alienSoldierHitCount()
    {
        alienSoldiersHit++;
    }
    
    public void set_numIronManlives()
    {
       numIronManlives =  numIronManlives - 1;
    }
    
    public void inc_numIronManlives()
    {
       numIronManlives =  numIronManlives + 1;
    }
    
    public void set_aliensHitCount()
    {
        aliensHit++;
    }
  
    public void set_ironManShots()
    {
        ironManShots--;
    }
    
    public void inc_ironManShots()
    {
        ironManShots+=10;
    }
    
    public void set_object1_hit()
    {
        object1_hit++;
    }
    
    public void set_object2_hit()
    {
        object2_hit++;
    }
    
    public void set_object3_hit()
    {
        object3_hit++;
    }
    
    public void set_enemy_hit()
    {
        enemy_hit--;
    }
    
    
    public void reset_score()
    {
        numIronManlives = 3;
        ironManShots = 50;
        alienShipsHit = 0;
        alienSoldiersHit = 0;
        aliensHit = 0;
        object1_hit = 0;
        object2_hit = 0;
        object3_hit = 0;
        enemy_hit = 3;
    }
    
    public void act() 
    {
       
    }    
    
    public void updateScore(Objects subject)
    {
        if(subject.getClass().getName() == "Ironman")
        {
            set_numIronManlives();
        }
        else if(subject.getClass().getName() == "AlienShip")
        {
            set_alienShipsHitCount();
        }
        else if(subject.getClass().getName() == "AlienSoldier")
        {
            set_alienSoldierHitCount();
        }
        else if(subject.getClass().getName() == "Alien")
        {
            set_aliensHitCount();
        }
        else if(subject.getClass().getName() == "shot")
        {
            set_ironManShots();
        }
        else if(subject.getClass().getName() == "bonusShots")
        {
            inc_ironManShots();
        }
        else if(subject.getClass().getName() == "bonusLife")
        {
            inc_numIronManlives();
        }
        else if(subject.getClass().getName() == "Object1")
        {
            set_object1_hit();
        }
        else if(subject.getClass().getName() == "Object2")
        {
            set_object2_hit();
        }
        else if(subject.getClass().getName() == "Object3")
        {
            set_object3_hit();
        }
        else if(subject.getClass().getName() == "Enemy")
        {
            set_enemy_hit();
        }
    }
}
