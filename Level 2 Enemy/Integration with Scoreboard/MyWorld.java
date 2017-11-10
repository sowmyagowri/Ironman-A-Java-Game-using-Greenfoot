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
    private ScoreDisplay display5;
    //private ScoreBoard scorekeeper1;
    //private ScoreBoard scorekeeper2;
 //   private IronMan man;
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
            //createRndmObjs();
            counter = 0;
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    /*public void createRndmObjs()
    {

    int y = ((Greenfoot.getRandomNumber(700)));
    if(y < 200) y = y + 50;
    int x = Greenfoot.getRandomNumber(2000) + 1000;

    AlienShip alienShip = new AlienShip(display2);

    if((Greenfoot.getRandomNumber(1000)) < 200)
    {
    addObject(alienShip,x,y);
    } 

    y = ((Greenfoot.getRandomNumber(500)) + 200);
    if(y < 200) y = y + 50;
    x = Greenfoot.getRandomNumber(1000) + 1000;

    AlienSoldier alienSoldier = new AlienSoldier(display3);

    if((Greenfoot.getRandomNumber(1000)) < 200)
    {
    addObject(alienSoldier,x,y);
    }

    y = ((Greenfoot.getRandomNumber(300)) + 200);
    if(y < 200) y = y + 50;
    x = Greenfoot.getRandomNumber(1500) + 1000;

    Alien alien = new Alien(display4);

    if((Greenfoot.getRandomNumber(1000)) < 200)
    {
    addObject(alien,x,y);
    }
    }
     */

    private void prepare()
    {
        img0 = new Background();
        addObject(img0, getWidth()/2, getHeight()/2);
        img1 = new Background();
        addObject(img1, getWidth() + getWidth()/2, getHeight()/2);

        ScoreDisplay display1 = new ScoreDisplay(scorekeeper.get_numIronManlives(), new GreenfootImage("Iron-Man.png"));
        addObject(display1, 100,31);
        IronMan man = new IronMan(display1);
        addObject(man,122,135);

        display2 = new ScoreDisplay(scorekeeper.get_alienShipsHitCount(),new GreenfootImage("Alien-Ship.png"));
        addObject(display2, 275,31);

        display3  = new ScoreDisplay(scorekeeper.get_alienSoldierHitCount(),new GreenfootImage("Alien-Sold.png"));
        addObject(display3, 450,31);

        display4  = new ScoreDisplay(scorekeeper.get_aliensHitCount(),new GreenfootImage("Alien1.png"));
        addObject(display4, 630,31);

        display5  = new ScoreDisplay(scorekeeper.getVillanLives(),new GreenfootImage("Alien1.png"));
        addObject(display5, 800,31);
        Villain enemy = new Villain(display2, display3, display4, display5);
        addObject(enemy,761,230);

    }
}
