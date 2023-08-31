import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2EnemyShip extends Ship
{
    /**
     * Act - do whatever the Level2EnemyShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public Level2EnemyShip(int speed)
    {
        super(speed);
        reduceShipSize(4);
    }
    public   String color; 
    public Level2EnemyShip(int speed,String color)
    {
        super(speed);
        this.color=color;
        setImage("ship1.png");
        reduceShipSize(4);
    }
    public void act()
    {
        dealyTime++;
         aroundMove();
        checkCollision();
        move(speed);
       adding_Bomb();
       
        
    }
    public void reduceShipSize(int size)
    {
        GreenfootImage heroShipImage = getImage();
        heroShipImage.scale(heroShipImage.getWidth()/size,heroShipImage.getHeight()/size);
       
    }
   public void checkCollision()
    {
        Bomb bomb =(Bomb)getOneIntersectingObject(Bomb.class);
        if (bomb!=null)
        {
           World world=getWorld();
           world.removeObject(this);
           bomb.hitShipcount++;
           HeroShip.score++;
           
           
        }
    }
    
   
   
    public void aroundMove()
    {
      
        
        if (getX()==599)
        {
          speed=-4;
          setLocation(getX(),getY()+10);
        }
        else if (getX()==0)
        {
            speed=4;
           setLocation(getX(),getY()+10);
        }
        if (getY()==749)
        {
            setLocation(getX(), 0);
        }
       /*if(getX()==599)
        {
            setLocation(0, getY());
        }
        else
        if(getX()==0)
        {
            setLocation(599, getY());
        }
         if(getY()==749)
        {
            setLocation(getX(), 0);
        }
        else
        if(getY()==0)
        {
            setLocation(getX(), 749);
        }*/

    }
  
    private int dealyTime=0;
    int Ramdom=Greenfoot.getRandomNumber(1000);
    public void adding_Bomb()
    {
        if(dealyTime>Ramdom)
        {
        World world=getWorld();
        Enemy_Bombs bomb =new Enemy_Bombs();
        world.addObject(bomb,getX(),getY());
        dealyTime=0;
        
       Ramdom=Greenfoot.getRandomNumber(1000);
       }
    }
   
   
    
}
