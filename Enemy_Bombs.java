import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_Bombs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_Bombs extends Actor
{
    /**
     * Act - do whatever the Enemy_Bombs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
       move(5);
       removeBomb();
    }
    public Enemy_Bombs()
    {
       // reduceShipSize(2); note:- note using size 
    }
    public void reduceShipSize(int size)
    {
        GreenfootImage enemyShipImage = getImage();
        int newWidth=enemyShipImage.getWidth()/size;
        int newHeigth=enemyShipImage.getHeight()/size;
        enemyShipImage.scale(newWidth,newHeigth);
        
    }
     public void move(int distance)
    {
        setLocation(getX(), getY()+distance);
    }
    
    
     private int count=0;
   public void removeBomb()
    {
        HeroShip hero=(HeroShip)getOneIntersectingObject(HeroShip.class);
        if (hero!=null )
        {
            World world=getWorld();
            world.removeObject(this);
            hero.bombhits++;
           
          
        }
        else if(isAtEdge())
        {
            World world=getWorld();
           world.removeObject(this);            
        }
    }
}
