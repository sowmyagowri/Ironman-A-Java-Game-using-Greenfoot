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
    private static int numIronManlives = 3;
    private static int alienShipsHit = 0;
    private static String state = "Initial";
    
    public ScoreBoard()
    {
        GreenfootImage score = new GreenfootImage(300, 30);
        score.drawString("Score : " +  alienShipsHit + "   Lives :" + numIronManlives, 5, 25);
        setImage(score);
    }
    
    public void displayScore()
    {
        GreenfootImage changeScore = getImage();
        changeScore.clear();
        changeScore.drawString("Score : " +  alienShipsHit + "   Lives :" + numIronManlives, 5, 25);
        setImage(changeScore);
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
    
    public void set_numIronManlives()
    {
        numIronManlives--;
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
  
    
    public void act() 
    {
        displayScore();
    }    
    
    
}
