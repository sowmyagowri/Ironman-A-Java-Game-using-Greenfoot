import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ironman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ironman extends Character
{
    private GreenfootImage[] arrImages; 
    private int lives; // Life of Players
    private int health; // Number of player health.
    private int points;
    
    private int numShots; //Number of shots that can make the player.
    private IronmanState hasShotState;
    private IronmanState noShotState;
    private IronmanState currentState = noShotState;
    
    private PointsObserver obs;

    /**
     * Ironman builder class. Ironman images are loaded, variable life, health, and points are initialized. Attacks sounds are loaded.
     */
    public Ironman()
    {
        lives = 3;
        health = 50;
        numShots = 30;
        points=0;
        
        hasShotState = new HasShotState(this);
        noShotState = new noShotState(this);
        if(numShots > 0){
            this.currentState = hasShotState;
        }
    }
    
    /**
     * Act - do whatever the Ironman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
