import greenfoot.*;  
import greenfoot.Color;
public class Laser extends Actor
{
    private boolean toRemoveEnemy;
    private int vx=3;
    private static int lives =3;
    public void addedToWorld(World MyWorld)
    {
        GreenfootImage image=new GreenfootImage(50,10);
        image.setColor(Color.BLACK);
        image.drawLine(0,5,image.getWidth()-1,5);
        setImage(image);
    }
    
    public void act() 
    {
        if(!toRemoveEnemy)
        {
            setLocation(getX()+vx,getY());
            Actor actor=getOneIntersectingObject(Enemy.class);
            Actor obj1,obj2,obj3;
            obj1 = getOneIntersectingObject(Object1.class);
            obj2 = getOneIntersectingObject(Object2.class);
            obj3 = getOneIntersectingObject(Object3.class);
            if(obj1!=null)
            {
                getWorld().removeObject(obj1);
            }
            
            if(obj2!=null)
            {
                getWorld().removeObject(obj2);
            }
            
            if(obj3!=null)
            {
                getWorld().removeObject(obj3);
            }
            if(actor!=null)
            {
                ((Enemy)actor).destroy();
            }
            if(getX()>getWorld().getWidth()+200) toRemoveEnemy=true;
        }
            else
            {
                getWorld().removeObject(this);
            }
    }    
}
