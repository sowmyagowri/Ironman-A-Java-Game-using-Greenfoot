import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Objects
{
    private int bulletCount = 0;
    //private int touchCount = 0; 
    //private static int numlives = 0;
    /**
     * Act - do whatever the IronMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public IronMan(ScoreBoard sb)
    {
         super(sb);
    }
    public void act() 
    {
        // Add your action code here.
        display();
        move_actor();
        shoot();
        killIronman();
    }    
    
    public void move_actor()
    {
        if(Greenfoot.isKeyDown("Up"))
        {
            setLocation(getX(), getY()-5);
        }
        else if(Greenfoot.isKeyDown("Down"))
        {
            setLocation(getX(), getY()+5);
        }
    }
    
    public void shoot()
    {
        World w = getWorld();
        bulletCount++;
        if(Greenfoot.isKeyDown("space"))
        {
                if(bulletCount >= 10)
                {
                    w.addObject(new Bullet(), getX()+150, getY());
                    bulletCount = 0;
                }   
        }
        
    }
    
    public void killIronman()
    {
        if(isTouching(AlienBullet.class))
        {  
            World w = getWorld();
            ScoreBoard scoreB = get_scoredet();
            if((get_scoredet().get_numIronManlives() > 0))
            {
                scoreB.setState("IronManHit"); 
                scoreB.removeObservers(this);
                w.removeObject(this);
                
                IronMan man2 = new IronMan(get_scoredet());
                w.addObject(man2,122,135);
                get_scoredet().addObservers(man2);
            }
            else
            {
                scoreB.reset_score();
                w.removeObject(this);
                GameOver gameover = new GameOver();
                w.addObject(gameover, w.getWidth()/2, w.getHeight()/2);
            }
        }
    }
    
    public void updateScore()
    {
        if(get_scoredet().getState() == "IronManHit")
        {
            get_scoredet().set_numIronManlives();
        }
    }
    
    public void display()
    {
        ScoreBoard scoreB = get_scoredet();
        GreenfootImage iman_lives = scoreB.getImage();
        GreenfootImage iman_score = new GreenfootImage(iman_lives);
        GreenfootImage text = new GreenfootImage("Lives: " +  scoreB.get_numIronManlives(), 24, Color.BLACK, Color.GREEN);
        iman_score.drawImage(text, (iman_score.getWidth() - text.getWidth())/2,
                             (iman_score.getHeight() - text.getHeight())/2);
       scoreB.setImage(iman_score);
    }
    
}
