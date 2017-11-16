import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class myLevel2 here.
 * 
 * @author Rucha Apte
 * @version (a version number or a date)
 */
public class myLevel2 extends World
{
    GreenfootSound backgroundMusic2 = new GreenfootSound("Night_Runner_level2.mp3");
    private static final String bgImageName = "f3.jpg";    //level2
    private ScoreBoard scorekeeper_l2 = new ScoreBoard();
    private ScoreDisplay display2;
    private ScoreDisplay display3;
    private ScoreDisplay display4;
    private ScoreDisplay display5;
    /**
     * Constructor for objects of class myLevel2.
     * 
     */
    public myLevel2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);
        setBackground(bgImageName);
        backgroundMusic2.playLoop();
        prepare();
        
  }
    
    public void act()
    {
    /*    if(!backgroundMusic2.isPlaying())
        {
            backgroundMusic2.playLoop();
        }
    */    
        if(scorekeeper_l2.get_object1_hit() + scorekeeper_l2.get_object2_hit() + scorekeeper_l2.get_object3_hit()== 10 )
//      if (Greenfoot.isKeyDown("x"))
        {
            backgroundMusic2.stop();
            Text WinMessage = new Text();
            addObject(WinMessage, getWidth()/2, getHeight()/2);
            WinMessage.setText("YOU WON!!!!!");
            Greenfoot.delay(10000);
            removeObject(WinMessage);
            Greenfoot.setWorld(new Menu());
        }
    }
    
    private void prepare()
    {   
        ScoreDisplay display_level = new ScoreDisplay("Level 2");
        addObject(display_level, 70,31);
        
        ScoreDisplay display0 = new ScoreDisplay(scorekeeper_l2.get_numIronManlives(), new GreenfootImage("Iron-Man.png"), "ironman");
        addObject(display0, 205,31);
        
        ScoreDisplay display1  = new ScoreDisplay(scorekeeper_l2.get_ironManShots(),new GreenfootImage("Bullet1.png"));
        addObject(display1, 340,31);
        Ironman man = new Ironman(display0, display1);
        addObject(man,122,135);
        
        display2 = new ScoreDisplay(scorekeeper_l2.get_object1_hit(),new GreenfootImage("Alien-Ship.png"));
        addObject(display2, 475,31);

        display3  = new ScoreDisplay(scorekeeper_l2.get_object2_hit(),new GreenfootImage("Alien-Sold.png"));
        addObject(display3, 610,31);

        display4  = new ScoreDisplay(scorekeeper_l2.get_object3_hit(),new GreenfootImage("Alien1.png"));
        addObject(display4, 745,31);
        
        display5  = new ScoreDisplay(scorekeeper_l2.get_enemy_hit(),new GreenfootImage("Bullet1.png"));
        addObject(display5, 880,31);
        Enemy enemy = new Enemy(display5, display2, display3, display4);
        addObject(enemy, getWidth()-50, 300);
  
    }

}
