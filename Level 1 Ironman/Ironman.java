import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ironman here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class Ironman extends Character
{
    private GreenfootImage[] images;

    private GreenfootSound explosionSound;
    private GreenfootSound shotPlayerSound;
    
    private int lives; // Total Lives of Player
    private int health; // Player health.
    private int points; //Total points obtained by the player
    private int numShots; //Number of shots the player has
    
    private IronmanState hasShotState;
    private IronmanState noShotState;
    private IronmanState currentState = noShotState;
    
    private Observer observer;

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
        
       hasShotState = new hasShotState(this,shotTimer);
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
        this.move();
        this.attack();
        this.isTouchingEnemy();        
        this.generateBonus();
    }       
    
    public void move()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            this.setImage(images[0]);
            if(this.getX()+this.getImage().getWidth()/2 < getWorld().getWidth())
                this.setLocation(this.getX() + 5,this.getY());
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            this.setImage(images[0]);
            if(this.getX()-this.getImage().getWidth()/2 > 0)
                this.setLocation(this.getX() - 5, this.getY());
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            this.setImage(images[1]);
            if(this.getY()-this.getImage().getHeight()/2 > 0)
                this.setLocation(this.getX(), this.getY() - 5);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            this.setImage(images[2]);
            if(this.getY()+this.getImage().getHeight()/2 < getWorld().getHeight())
                this.setLocation(this.getX(), this.getY() + 5);
        }
    }
    
    /**
     * When the player presses the spacebar, "Ironman" will launch a shot. 
     * Each shot has a delay of 250 milliseconds.
     * When you press the letter z launches three rays.
     */
    public void attack()
    {
        if(shotTimer.millisElapsed() > 250){
            if(Greenfoot.isKeyDown("space")){
                shotPlayerSound.play();
                currentState.attackEnemy();
            }
        }
    }
    
    /**
     * Subtraction method 'h' Player health.
     * And if health reaches 0 subtract one life and restore 50 health.
     */
    public void reduceHealth(int h)
    {
        
        if(health > 0){
            health-=h;
            if(health <= 0){
                 lives--;
                 health = 50;
                 if(lives==0)
                    health=0;
            }
        }
        else if(health <= 0)
        {
            lives--;
            health = 50;
            if(lives==0)
                health=0;
        }
    }
    
    /**
     * Getter function - Returns the number of lives the player has.
    */
    public int getLives()
    {
        return lives;
    }
    
    /**
     * Getter function - Returns the health the player has
    */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Getter function - Returns the number of shots the player has
    */
    public int getNumShots()
    {
        return numShots;
    }
   
    /**
     * Getter function - Returns the points the player has
    */
    public int getPoints()
    {
        return points;
    }
    
    /**
     * Setter function - Assigns the shots to the player
    */
    public void setNumShots(int d)
    {
        numShots = d;
    }
    
    /**
     * Setter function - Assigns the total number of shots the player has
    */
    public void setShots()
    {
        numShots = 100;
    }
    
    /**
     * Setter function - Assigns the health of the player
    */
    public void setHealth(int s)
    {
        health = s;
    }
    
    /**
     * Assign a value to the points..
     */
    public void setPoints(int p)
    {
        points += p;
        notifyObservers();
    }
    
    public void notifyObservers()
    {
       observer.updatePoints(points); 
    }
    
    /**
     * Increase Life
     */
    public void increaseLife()
    {
        lives++;
    }
    
    /**
     * Randomly generated bonus throughout the game.
     */
    public void generateBonus()
    {
        if(numShots < 15)
        {
            if(Greenfoot.getRandomNumber(5000) < 20)
            {
                getWorld().addObject( new bonusShots(),
                Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
            }
        }
        
        if(Greenfoot.getRandomNumber(18000) < 5 && lives<5)
        {
            getWorld().addObject( new bonusLife(), 
            Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
        }
        
    }
    
    public void setCurrentState(IronmanState state) {
        this.currentState = state;
    }
    
    public IronmanState getnoShotState(){
        return this.noShotState;
    }
    
    public IronmanState gethasShotState(){
        return this.hasShotState;
    }
}