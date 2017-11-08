import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor implements GameObserver
{
    //private ArrayList<GameObservers> observers = new ArrayList<GameObservers>();
    private GreenfootImage counter;
    private static int numIronManlives = 3;
    private static int alienShipsHit = 0;
    private static int alienSoldiersHit = 0;
    private static int aliensHit = 0;
    private static int numVillainLives = 0;
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
    
    public int getVillanLives()
    {
        return numVillainLives;
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
    
    public void set_aliensHitCount()
    {
        aliensHit++;
    }
    
    public void setVillanLives()
    {
        numVillainLives--;
    }
  
    public void reset_score()
    {
        numIronManlives = 3;
        alienShipsHit = 0;
        alienSoldiersHit = 0;
        aliensHit = 0;
    }
    
    public void act() 
    {
       
    }    
    
    public void updateScore(Objects subject)
    {
        if(subject.getClass().getName() == "IronMan")
        {
            set_numIronManlives();
        }
        else if(subject.getClass().getName() == "Object2")
        {
            set_alienShipsHitCount();
        }
        else if(subject.getClass().getName() == "Object1")
        {
            set_alienSoldierHitCount();
        }
        else if(subject.getClass().getName() == "Object3")
        {
            set_aliensHitCount();
        }
        else if(subject.getClass().getName() == "Villain")
        {
            setVillanLives();
        }
      
    }
    
    
}
