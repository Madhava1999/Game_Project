import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroShip extends Ship
{
    /**
     * Act - do whatever the HeroShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private final static int shipReloadTime=50;
    private int dealyTime=0;
    public static int score=0;
    public HeroShip( int speed)
    {
        super(speed);
        reduceShipSize(4);
        
    }
    public void act()
    {
        dealyTime1++;
        dealyTime++;
        move(speed);
        wrapeAround();
        fire();
        removeHero();
      
        
    }
    public void reduceShipSize(int size)
    {
        GreenfootImage heroShipImage = getImage();
        heroShipImage.scale(heroShipImage.getWidth()/size,heroShipImage.getHeight()/size);
        
    }
    public void move(int distance)
    {
        if(Greenfoot.isKeyDown("right"))
        {
            super.move(distance);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            super.move(-distance);
        }
     
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-distance);
        }
        
         if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+distance);
        }
    }
    public void wrapeAround()
    {
        if(getX()==599)
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
        }
         
    }
    public void fire()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            releaseBomb();
        }
    }
    
    public void releaseBomb()
    {
        if(dealyTime>=shipReloadTime)
        {
        World world=getWorld();
        Bomb bomb=new Bomb();
        world.addObject(bomb, getX(), getY());
        dealyTime=0;
        }
    }
    public void move()
    {
        setLocation(getX(), getY()-10);
    }
    public  int bombhits=0;
public static int k=0;
public static int healtOfHreo=5-k;
     private final static int shipReloadTime1=50;
    private int dealyTime1=0;
     public void removeHero()
    {
        if (bombhits==1)
        {
            World world =getWorld();
            world.removeObject(this);
             
              healtOfHreo--;
              
              if (dealyTime1>shipReloadTime1 && healtOfHreo!=0)
              {
                //  world.addObject(Space.getHeroShip(),300 ,700 );
                  world.addObject(this,300 ,700 );
                  k++;
                  bombhits=0;
                  dealyTime1=0;
                 
              }
            
              
          }
          
    }
   
    
    
}
