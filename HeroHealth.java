import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroHealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroHealth extends Actor
{
    /**
     * Act - do whatever the HeroHealth wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
 
    
    public void act()
    {
      
        // Add your action code here.
    }
    //public int health=5;
    
    
    public HeroHealth()
    {
        reduceShipSize(10);
    }
     public void reduceShipSize(int size)
    {
        GreenfootImage enemyShipImage = getImage();
        int newWidth=enemyShipImage.getWidth()/size;
        int newHeigth=enemyShipImage.getHeight()/size;
        enemyShipImage.scale(newWidth,newHeigth);
        
    }
    public int count=0;
   
    
}
