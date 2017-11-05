import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor implements Game
{
    private ArrayList<GameObservers> observers = new ArrayList<GameObservers>();
    private GreenfootImage counter;
    private static int numIronManlives = 3;
    private static int alienShipsHit = 0;
    private static int alienSoldiersHit = 0;
    private String state = "Initial";
    
    public ScoreBoard()
    {
        counter = getImage();
    }
    
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
    
    public void set_alienShipsHitCount()
    {
        alienShipsHit++;
    }
    
    public void set_alienSoldierHitCount()
    {
        alienSoldiersHit++;
    }
    
    public int get_alienSoldierHitCount()
    {
        return alienSoldiersHit;
    }
    
    public void set_numIronManlives()
    {
       System.out.println(numIronManlives);
       numIronManlives =  numIronManlives - 1;
    }
    
    public void setState(String State)
    {
          state = State;
          notifyObservers();
    }
    
    public void addObservers(GameObservers O)
    {
        observers.add(O);
    }
    
    public void removeObservers(GameObservers O)
    {
        observers.remove(O);
    }
    
    public void notifyObservers()
    {
        for(GameObservers obj : observers)
        {
            obj.updateScore();
        }
    }
  
    public void reset_score()
    {
        numIronManlives = 3;
        alienShipsHit = 0;
    }
    
    public void act() 
    {
       
    }    
    
    
}
