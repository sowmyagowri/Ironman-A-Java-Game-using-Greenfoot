import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Background img0, img1;
    private ScoreBoard scorekeeper = new ScoreBoard();
    private ScoreDisplay display2;
    private ScoreDisplay display3;
    private ScoreDisplay display4;
   
    private int counter = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(930, 700, 1, false); 
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            img0.scroll();
            img1.scroll();

        }
        counter++;

        if(counter >= 20)
        {
            createRndmObjs();
            counter = 0;
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void createRndmObjs()
    {
       
       
        DestructionElementFactory theDestructionFactory = new DestructionElementFactory();
        Objects  theEnemy = null;       
        int enemyType = Greenfoot.getRandomNumber(3);        
        if(enemyType >= 0){
           
            theEnemy = theDestructionFactory.selectDestructionElementFactory(enemyType, display2, display3, display4);
        
            addObject(theEnemy, 600, Greenfoot.getRandomNumber(400));           
        }    
        
        
      
    }

    private void prepare()
    {
        img0 = new Background();
        addObject(img0, getWidth()/2, getHeight()/2);
        img1 = new Background();
        addObject(img1, getWidth() + getWidth()/2, getHeight()/2);
        
        ScoreDisplay display1 = new ScoreDisplay(scorekeeper.get_numIronManlives(), new GreenfootImage("Iron-Man.png"));
        addObject(display1, 150,31);
        IronMan man = new IronMan(display1);
        addObject(man,122,135);
        
        display2 = new ScoreDisplay(scorekeeper.get_alienShipsHitCount(),new GreenfootImage("Alien-Ship.png"));
        addObject(display2, 325,31);
        
        display3  = new ScoreDisplay(scorekeeper.get_alienSoldierHitCount(),new GreenfootImage("Alien-Sold.png"));
        addObject(display3, 500,31);
        
        display4  = new ScoreDisplay(scorekeeper.get_alienSoldierHitCount(),new GreenfootImage("Alien1.png"));
        addObject(display4, 700,31);
    }
}

