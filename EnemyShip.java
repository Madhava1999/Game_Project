import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip extends Ship

{
    /**
     * Act - do whatever the EnemyShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public EnemyShip(int speed)
    {
        super(speed);
        reduceShipSize(2);
        
              
    }
    
    public   String color; 
    public EnemyShip(int speed,String color)
    {
        super(speed);
        this.color=color;
        setImage("ship1.png");
        reduceShipSize(4);
        
    }
    
    
    
    public void act()
    {
        dealyTime++;
                move(speed);
                checkCollision();
          adding_Bomb();
                
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
    public void reduceShipSize(int size)
    {
        GreenfootImage heroShipImage = getImage();
        heroShipImage.scale(heroShipImage.getWidth()/size,heroShipImage.getHeight()/size);
       
    }
    private int count=0;
    private int count1=0;
    
    private int y2=250;
     private int anOtherCount1=0;
    private int anOtherCount2=0;
    private int y=140;
     private int yy=440;
    public void move(int distance)
    {
        
      if (count<=25 && getY()==50)
      {
           count++;
          setLocation(getX()+distance,getY());
         
          if (count==25)
          {
              count1=0;
             
          }
          
      }
      else if(count1<=26 && getY()==50)
      {
          setLocation(getX()-distance,getY());
          count1++;
          if(count1==26)
          {
              count=0;
          }
      }
      
       if (count<=25 && getY()==250)
      {
           count++;
          setLocation(getX()-distance,getY());
         
          if (count==25)
          {
              count1=0;
          }
          
      }
      else if(count1<=26 && getY()==250)
      {
          setLocation(getX()+distance,getY());
          count1++;
          if(count1==26)
          {
              count=0;
          }
      }
       
      /* note */
      if(getY()==y)
      {
        setLocation(getX(), y+3); 
        y=y+3;
        if(y==440)
        {
          y=140;  
        }
      }
     
      if(getY()==yy)
      {
         setLocation(getX(), yy-3);  
         yy=yy-3;
         if(yy==140)
         {
            yy=440; 
         }
      }
    
     
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
