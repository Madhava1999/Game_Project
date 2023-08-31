import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bomb()
    {
        
      reduceShipSize(3);
    }
    public void act()
    {
        move(10);
        removeBomb();
    }
     public int hitShipcount=0;// it is using for when bomb touchs the hero then remoing the bomb
   
     public void reduceShipSize(int size)
    {
        GreenfootImage enemyShipImage = getImage();
        int newWidth=enemyShipImage.getWidth()/size;
        int newHeigth=enemyShipImage.getHeight()/size;
        enemyShipImage.scale(newWidth,newHeigth);
        
    }
    public void removeBomb()
    {
        if (hitShipcount==1|| isAtEdge())
        {
            World world =getWorld();
            world.removeObject(this);
           
        }
    }
    public void move(int distance)
    {
        setLocation(getX(), getY()-distance);
    }
    
    
}
