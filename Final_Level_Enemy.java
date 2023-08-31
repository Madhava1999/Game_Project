import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final_Level_Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Final_Level_Enemy extends Ship
{
    /**
     * Act - do whatever the Final_Level_Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Final_Level_Enemy(int speed)
    {
        super(speed);
       reduceShipSize(2);
    }
     public void reduceShipSize(int size)
    {
        GreenfootImage heroShipImage = getImage();
        heroShipImage.scale(heroShipImage.getWidth()/size,heroShipImage.getHeight()/size);
       
    }
    public void act()
    {
        dealyTime++;
        aroundMove();
        adding_Bomb();
        checkCollision();        
    }
    private int count=0;
    public void checkCollision()
    {
        Bomb bomb =(Bomb)getOneIntersectingObject(Bomb.class);
        if (bomb!=null )
        {
           World world=getWorld();
           
           bomb.hitShipcount++;
           HeroShip.score++;
           count++;
           if (count==10)
           {
             world.removeObject(this);  
           }
           
        }
    }
    public int x=300;
       public  int y=104;
       
      public int x1=580;
       public  int y1=104;
       
        public int x2=16;
       public  int y2=668;
       
       public int x3=580;
       public  int y3=668;
       
       public int x4=16;
       public  int y4=104;
       
    public void aroundMove()
    {
       // move(speed);
       
             if (getX()==x && getY()==y)
        {
            x=x+speed;
            setLocation(getX()+speed, getY());
            if (x==580)
            {
                x=0;
            }
        }
          
        if (getX()==x1 && getY()==y1)
        {
            x1=x1-4;
            y1=y1+4;
            setLocation(getX()-speed, getY()+speed);
             if (x1==16 && y1==668)
            {
                x1=580;
                y1=104;
            }
            
        }
        if (getX()==x2 && getY()==y2)
        {
            x2=x2+4;
            
            setLocation(getX()+speed, getY());
           if(x2==580 && y2==668)
           {
               x2=16;
               y2=668;
           }
            
            
        }
         if (getX()==x3 && getY()==y3)
        {
            x3=x3-4;
            y3=y3-4;
            setLocation(getX()-speed, getY()-speed);
            if(x3==16 && y3==104)
           {
               x3=580;
               y3=668;
           }
            
        }
        
        if (getX()==x4 && getY()==y4)
        {
            x4=x4+speed;
            
            setLocation(getX()+speed, getY());
            if (x4==580 && y4==104)
            {
                x4=16;
                
                
            }
           
            
        }
      
         
    }
     private final static int shipReloadTime=50;
    private int dealyTime=0;
    public void adding_Bomb()
    {
        if(dealyTime==shipReloadTime)
        {
        World world=getWorld();
        Enemy_Bombs bomb =new Enemy_Bombs();
        world.addObject(bomb,getX(),getY());
        dealyTime=0;
       }
    }
   
}
