import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Objects implements Game
{
     private int bulletCount = 0;
     private ScoreDisplay sd;
     private int count = 0;
     
    public IronMan(ScoreDisplay display)
    {
        this.sd = display;
    }
    
    public void act() 
    {
        // Add your action code here.
        //display();
        move_actor();
        shoot();
        count++;
        if(count >= 10)
        {
            killIronman();
            count = 0;
        }
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
        Actor actor = getOneIntersectingObject(Object1.class);
        if(actor != null)
       // if(isTouching(AlienBullet.class))
        {  
            World w = getWorld();
            if((get_sb().get_numIronManlives() > 0))
            {
                notifyObservers();
                sd.updateDisplay(this);
                w.removeObject(this);
                IronMan man2 = new IronMan(sd);
                w.addObject(man2,122,135);
            }
            else
            {
                GameOver gameover = new GameOver();
                w.addObject(gameover, w.getWidth()/2, w.getHeight()/2);
                get_sb().reset_score();
                w.removeObject(this);
                //getWorld().stopped();
                Greenfoot.stop();
            }
        }
    }
    
    public void notifyObservers()
    {
        get_sb().updateScore(this);
    }
    
}
