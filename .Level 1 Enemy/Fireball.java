import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    private int targetx=0, targety=0,jeda=0;
    private boolean toRemove=false;
    public void addedToWorld(World MyWorld)
    {
            targetx=getX();
            targety=getY();
    }
    public Fireball()
    {
        GreenfootImage myImage = getImage();
        
        int myNewHeight = (int)myImage.getHeight()/5;
        int myNewWidth = (int)myImage.getWidth()/5;
        myImage.scale( myNewWidth, myNewHeight);
    }
    GifImage myFireBall = new GifImage("fireball.gif");
    
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage( myFireBall.getCurrentImage() );
       
        if(Greenfoot.isKeyDown("left"))
        {
            
            move(-2);
        }
         if(Greenfoot.isKeyDown("right"))
        {
             move(2);
        }
        if(Greenfoot.isKeyDown("up"))
        {
           int x = getX();
           int y = getY();
           int ny  = getY()-3;
           setLocation(x,ny) ;
        }
         if(Greenfoot.isKeyDown("down"))
        {
               int x = getX();
               int y = getY();
               int ny = getY()+2;
               setLocation(x,ny) ;
        }
        if(jeda>0) jeda--;
        if(jeda==0) jeda=50;
    }    
}
   
