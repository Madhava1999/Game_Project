import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sub_Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sub_Enemy extends Ship
{
    /**
     * Act - do whatever the Sub_Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
       
        dealyTime++;
        moveDown();
       //checkCollision();
        
         
       
        adding_Bomb();
        if(getY()>=740)
        {
          getWorld().removeObject(this); 
        }
        
        
        
        
    }
    public Sub_Enemy(int speed)
    {
       super(speed);
        reduceShipSize(4);
    }
    public void reduceShipSize(int size)
    {
        GreenfootImage heroShipImage = getImage();
        heroShipImage.scale(heroShipImage.getWidth()/size,heroShipImage.getHeight()/size);
       
    }
    public void moveDown()
    {
        setLocation(getX(),getY()+3);
    }
    
    private int dealyTime=0;
    int Ramdom=Greenfoot.getRandomNumber(600);
    public void adding_Bomb()
    {
        if(dealyTime>Ramdom)
        {
        World world=getWorld();
        Enemy_Bombs bomb =new Enemy_Bombs();
        world.addObject(bomb,getX(),getY());
        dealyTime=0;
        
       Ramdom=Greenfoot.getRandomNumber(600);
       }
    }
    
    public void checkCollision()
    {
        Bomb bomb =(Bomb)getOneIntersectingObject(Bomb.class);
        if (bomb!=null)
        {
           World world=getWorld();
           world.removeObject(this);
           
           
        }
    }
    
    
    
}
