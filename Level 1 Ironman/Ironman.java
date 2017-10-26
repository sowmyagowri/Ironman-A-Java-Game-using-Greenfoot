import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ironman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ironman extends Character
{
    private GreenfootImage[] images;

    private GreenfootSound explosionSound;
    private GreenfootSound shotPlayerSound;
    
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
       images = new GreenfootImage [3];
       images[0] = new GreenfootImage("Ironman.png");
       images[1] = new GreenfootImage("Ironman.png");
       images[2] = new GreenfootImage("Ironman.png");
     
       explosionSound = new GreenfootSound("explosionNave.wav");
       shotPlayerSound = new GreenfootSound("shotPlayer.wav");
       
       lives = 3;
       health = 50;
       numShots = 30;
       points=0;
        
       hasShotState = new HasShotState(this, shotTimer);
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
        this.mover();
        this.attack();
        this.isTouchingEnemy();        
        this.generateBonus();
    }       
    
    /**
     * When the player presses the spacebar, "Shaktimaan" will launch a shot. 
     * Each shot has a delay of 250 milliseconds.
     * When you press the letter z launches three rays.
     */
    public void attack()
    {
        if(shotTimer.millisElapsed() > 250){
            if(Greenfoot.isKeyDown("space")){
                shotPlayerSound.play();
                currState.attackEnemy();
            }
        }
    }
}
