import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario extends World
{
    private static final Color transparent = new Color(0,0,0,0);
    private static final String bgImageName = "space.jpg";
    private GreenfootSound backgroundSound;
    private static final double scrollSpeed = 2.5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
 
    private GreenfootImage bgImage, bgBase;
    
    private int scrollPosition = 0;
    
    //private Ironman ironman;
    private ScoreBoard scorekeeper = new ScoreBoard();
    private ScoreDisplay display2;
    private ScoreDisplay display3;
    private ScoreDisplay display4;
    private ScoreDisplay display5;
    private int counter = 0;
    //private int totalEnemiesHit = 0;
    //private GreenfootImage total = new GreenfootImage("Total: " + totalEnemiesHit + "/50", 30, Color.BLACK, transparent);
    public Scenario()
    {    
        super(2000, 1200, 1, false);
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        backgroundSound = new GreenfootSound("TN.mp3");
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        prepare();
    }
     
     public void act()
    {
        backgroundSound.playLoop();
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint(scrollPosition);
        
        counter++;

        if(counter >= 20)
        {
            createRndmObjs();
            counter = 0;
        }
        
        //display5.display(totalEnemiesHit, total, "Total: ");
    }
     
     private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {   
        ScoreDisplay display_level = new ScoreDisplay("Level 1");
        addObject(display_level, 70,31);
        
        ScoreDisplay display0 = new ScoreDisplay(scorekeeper.get_numIronManlives(), new GreenfootImage("Iron-Man.png"), "ironman");
        addObject(display0, 205,31);
        
        ScoreDisplay display1  = new ScoreDisplay(scorekeeper.get_ironManShots(),new GreenfootImage("Bullet1.png"));
        addObject(display1, 340,31);
        Ironman man = new Ironman(display0, display1);
        addObject(man,122,135);

        display2 = new ScoreDisplay(scorekeeper.get_alienShipsHitCount(),new GreenfootImage("Alien-Ship.png"));
        addObject(display2, 475,31);

        display3  = new ScoreDisplay(scorekeeper.get_alienSoldierHitCount(),new GreenfootImage("Alien-Sold.png"));
        addObject(display3, 610,31);

        display4  = new ScoreDisplay(scorekeeper.get_aliensHitCount(),new GreenfootImage("Alien1.png"));
        addObject(display4, 745,31);
        
        /*display5 = new ScoreDisplay(totalEnemiesHit, total, "Total");
        addObject(display5, 880,31);*/
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
       if(enemyType >= 0)
       {
           theEnemy = theDestructionFactory.selectDestructionElementFactory(enemyType, display2, display3, display4);
           addObject(theEnemy, 1000, Greenfoot.getRandomNumber(600));           
       }    
    }
}