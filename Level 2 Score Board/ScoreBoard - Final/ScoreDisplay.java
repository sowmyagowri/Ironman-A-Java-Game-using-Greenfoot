import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (Ishwarya Varadarajan) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private int score = 0;
    GreenfootImage mainDisplay;
    GreenfootImage scoredisplay;
    GreenfootImage text;
    GreenfootImage imagE;
    String name;
    public void act() 
    {
    }    
    
    public ScoreDisplay(String string)
    {
        score = 0;
        name = string;
        imagE = new GreenfootImage(string, 30, Color.BLACK, transparent);
        display(score, imagE, name);
    }
    
    public ScoreDisplay(int points, GreenfootImage image)
    {
        score = points;
        name = " ";
        display(score, image, name);
    }
    
    public ScoreDisplay(int points, GreenfootImage image, String obj_name)
    {
        score = points;
        name = obj_name;
        display(score, image, name);
    }
    
    public void display(int points, GreenfootImage image, String obj_name)
    {
        scoredisplay = getImage();
        mainDisplay = new GreenfootImage(500, 100);
        if(obj_name == "ironman")
        {
            scoredisplay.drawImage(image, 15, 20);
            int img_x_pos = 50;
            GreenfootImage img = new GreenfootImage("heart.png");
            for(int i=0; i<points; i++)
            {
                scoredisplay.drawImage(img, img_x_pos, 20);
                img_x_pos = img_x_pos + 20;
            }
        }
        else if(obj_name == "Level 1")
        {   
            scoredisplay.drawImage(image, 25, 20);
        }
        else if(obj_name == "Level 2")
        {   
            scoredisplay.drawImage(image, 25, 20);
        }
        else
        {
            text = new GreenfootImage("     =" +  points, 24, Color.BLACK, transparent);
            scoredisplay.drawImage(image, 15, 20);
            scoredisplay.drawImage(text, 40, 20);
            scoredisplay.scale(150, 75);
        }
        mainDisplay.drawImage(scoredisplay, (mainDisplay.getWidth() - scoredisplay.getWidth())/2,
                             (mainDisplay.getHeight() - scoredisplay.getHeight())/2);
                             
        setImage(mainDisplay);
    }
    
    public void updateDisplay(Objects obj)
    {
        
        if(obj.getClass().getName() == "Ironman" || obj.getClass().getName() == "bonusLife")
        {
            score = obj.get_scoreboard().get_numIronManlives();
            imagE = new GreenfootImage("Iron-Man.png");
            name = "ironman";
        }
        else if(obj.getClass().getName() == "AlienShip")
        {
            score = obj.get_scoreboard().get_alienShipsHitCount();
            imagE = new GreenfootImage("Alien-Ship.png");
        }
        else if(obj.getClass().getName() == "AlienSoldier")
        {
            score = obj.get_scoreboard().get_alienSoldierHitCount();
            imagE = new GreenfootImage("Alien-Sold.png");
        }
        else if(obj.getClass().getName() == "Alien")
        {
            score = obj.get_scoreboard().get_aliensHitCount();
            imagE = new GreenfootImage("Alien1.png");
        }
        else if(obj.getClass().getName() == "shot" || obj.getClass().getName() == "bonusShots")
        {
            score = obj.get_scoreboard().get_ironManShots();
            imagE = new GreenfootImage("Bullet1.png");
        }
        else if(obj.getClass().getName() == "Object1")
        {
            score = obj.get_scoreboard().get_object1_hit();
            imagE = new GreenfootImage("Bullet1.png");
        }
        else if(obj.getClass().getName() == "Object2")
        {
            score = obj.get_scoreboard().get_object2_hit();
            imagE = new GreenfootImage("Bullet1.png");
        }
        else if(obj.getClass().getName() == "Object3")
        {
            score = obj.get_scoreboard().get_object3_hit();
            imagE = new GreenfootImage("Bullet1.png");
        }
        else if(obj.getClass().getName() == "Enemy")
        {
            score = obj.get_scoreboard().get_enemy_hit();
            imagE = new GreenfootImage("EFINAL.png");
        }
        scoredisplay.clear();
        setImage("yellow.png");
        display(score, imagE, name);    
    }
}
