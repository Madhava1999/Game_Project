import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MilkyWay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MilkyWay extends World
{

    /**
     * Constructor for objects of class MilkyWay.
     * 
     */
    private HeroShip heroship;
    private Level2EnemyShip level2;
    public MilkyWay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 750, 1);
        addEnemyShipRandom();
        heroship=new HeroShip(5);
        addObject(heroship, 300, 700);
         HeroHealth health= new HeroHealth();
        addObject(health,480 ,20 );
       
       
    }
    public void act()
    {
        dealyTime++;
      displayScore1();
      if(HeroShip.score==24)
        {
           nextLeve2();
           
        }
         HeroShip ship=new HeroShip(5);
         showText(" = "+ship.healtOfHreo,520 , 20);
          if(ship.healtOfHreo==0)
           {
               showText(" YOUR SCORE :- "+HeroShip.score,320 , 440);  
             showText("if you want to re-try click on Enter",300, 350);
            if(Greenfoot.isKeyDown("enter"))
             {
             Greenfoot.setWorld(new Space());
             HeroShip hero=new HeroShip(5);
             hero.healtOfHreo=0;
             hero.score=0;
             hero.k=0;
            }
            
           }
         
    }
     public void displayScore1()
     {
         showText("score : "+HeroShip.score,81 , 42);
     }
     public int x=156;
     public int y=50;
     public int count=4;
    
    public void addEnemyShipRandom()
    {
       
        
        for (int i=1;i<=4;i++)
        {
            
          for (int j=1;j<=count;j++)
          {
               int randomNumber=Greenfoot.getRandomNumber(2);
             if (randomNumber==0)
             {
               addObject(level2=new Level2EnemyShip(4),x,y) ; 
               x+=100;
               
             }
             else if (randomNumber==1)
             {
               addObject(level2=new Level2EnemyShip(4,"Red"),x,y) ; 
               x+=100;
               
             }
          }
          count--;
          if (count==3)
          {
            x=206;
            y+=70;  
          }
          if (count==2)
          {
            x=256;
            y+=70;  
          }

          if (count==1)
          {
            x=306;
            y+=70;  
          }

        }
         
    }
    private final static int shipReloadTime=300;
    private int dealyTime=0;
    
     private void nextLeve2()
    {
        Enemy_Bombs bombs=new Enemy_Bombs();
        removeObject(bombs);
       heroship.move();
      if(dealyTime>=shipReloadTime)
      {
         setBackground("level-2.jpg");
          showText(" MOVING TO FINAL LEVEL ",300 , 400);
        showText(" YOUR SCORE :- "+HeroShip.score,350 , 440);
      }
     
      if(heroship.isAtEdge())
      {
         
        removeObject(heroship);
       Greenfoot.setWorld(new Final_Level());
        
       
        
      }
    }
    
    
}
