import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ironman here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class Ironman extends Objects implements Game
{
    private GreenfootImage[] images;

    private GreenfootSound explosionSound;
    private GreenfootSound shotPlayerSound;
    
    private int lives; // Total Lives of Player
    private int numShots; //Number of shots the player has
    
    private IronmanState hasShotState;
    private IronmanState noShotState;
    private IronmanState currentState = noShotState;
    
    private ScoreDisplay scoredisplay;
    
    private timer shotTimer;
    /**
     * Ironman builder class. Ironman images are loaded, variable life, health, and points are initialized. Attacks sounds are loaded.
     */
    public Ironman(ScoreDisplay display)
    {
       images = new GreenfootImage [3];
       images[0] = new GreenfootImage("Ironman.png");
       images[1] = new GreenfootImage("Ironman.png");
       images[2] = new GreenfootImage("Ironman.png");
     
       explosionSound = new GreenfootSound("explosionNave.wav");
       shotPlayerSound = new GreenfootSound("shotPlayer.wav");
       
       this.scoredisplay = display;
       
       lives = get_scoreboard().get_numIronManlives();
       numShots = 30;
       
       shotTimer = new timer();
       shotTimer.shot();
       
       hasShotState = new hasShotState(this,shotTimer);
       noShotState = new noShotState(this);
       if(numShots > 0)
            this.currentState = hasShotState;
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
     */
    public void attack()
    {
        if(shotTimer.millisecondsElapsed() > 250){
            if(Greenfoot.isKeyDown("space")){
                shotPlayerSound.play();
                currentState.attackEnemy();
            }
        }
    }
    
    /**
     * Check if Ironman is touching an enemy and destroys it.
    */
    public void isTouchingEnemy()
    {
       //level 1 enemies
       AlienShip as = (AlienShip)getOneIntersectingObject(AlienShip.class);
       Alien alien = (Alien)getOneIntersectingObject(Alien.class);
       AlienSoldier aliensoldier = (AlienSoldier)getOneIntersectingObject(AlienSoldier.class);
       //Level 2 enemies
       Object1 obj1 = (Object1)getOneIntersectingObject(Object1.class);
       Object2 obj2 = (Object2)getOneIntersectingObject(Object2.class);
       Object3 obj3 = (Object3)getOneIntersectingObject(Object3.class);
       Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
       if((get_scoreboard().get_numIronManlives() > 0))
       {
           if(as!=null)
           {
               Scenario es = (Scenario)getWorld();
               explosionSound.play();
               getWorld().addObject(new Boom(), as.getX(), as.getY());
               getWorld().removeObject(as);
               notifyObservers();
               scoredisplay.updateDisplay(this);
               this.reduceLife();
           }
           
           if(alien!=null)
           {
               Scenario es = (Scenario)getWorld();
               explosionSound.play();
               getWorld().addObject(new Boom(), alien.getX(), alien.getY());
               getWorld().removeObject(alien);
               notifyObservers();
               scoredisplay.updateDisplay(this);
               this.reduceLife();
           }
           
           if(aliensoldier!=null)
           {
               Scenario es = (Scenario)getWorld();
               explosionSound.play();
               getWorld().addObject(new Boom(), aliensoldier.getX(), aliensoldier.getY());
               getWorld().removeObject(aliensoldier);
               notifyObservers();
               scoredisplay.updateDisplay(this);
               this.reduceLife();
           }
           
           if(obj1!=null)
           {
               Scenario es = (Scenario)getWorld();
               explosionSound.play();
               getWorld().addObject(new Boom(), obj1.getX(), obj1.getY());
               getWorld().removeObject(obj1);
               notifyObservers();
               scoredisplay.updateDisplay(this);
               this.reduceLife();
           }
           
           if(obj2!=null)
           {
               Scenario es = (Scenario)getWorld();
               explosionSound.play();
               getWorld().addObject(new Boom(), obj2.getX(), obj2.getY());
               getWorld().removeObject(obj2);
               notifyObservers();
               scoredisplay.updateDisplay(this);
               this.reduceLife();
           }
           
           if(obj3!=null)
           {
               Scenario es = (Scenario)getWorld();
               explosionSound.play();
               getWorld().addObject(new Boom(), obj3.getX(), obj3.getY());
               getWorld().removeObject(obj3);
               notifyObservers();
               scoredisplay.updateDisplay(this);
               this.reduceLife();
           }
        }
        else
        {
            GameOver gameover = new GameOver();
            getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
            get_scoreboard().reset_score();
            getWorld().removeObject(this);
            //getWorld().stopped();
        }
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
                getWorld().addObject(new bonusShots(),
                Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
            }
        }
        
        if(Greenfoot.getRandomNumber(18000) < 5 && lives<5)
        {
            getWorld().addObject(new bonusLife(), 
            Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
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
     * Getter function - Returns the number of shots the player has
    */
    public int getNumShots()
    {
        return numShots;
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
    
    public void notifyObservers()
    {
       get_scoreboard().updateScore(this); 
    }
    
    /**
     * Increase Life
     */
    public void increaseLife()
    {
        lives = get_scoreboard().get_numIronManlives();
    }
    
    /**
     * Increase Life
     */
    public void reduceLife()
    {
        lives = get_scoreboard().get_numIronManlives();
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