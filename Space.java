import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

    /**
     * Constructor for objects of class Space.
     * 
     */
    
    //private static HeroShip heroship;
    // public  static HeroHealth health ;
    public HeroShip heroship;
    public HeroHealth health;
    public EnemyShip enemyship;
   
    
   /* public static HeroShip getHeroShip()
    {
        return heroship;
    }
    public static HeroHealth getHeroHealth()
    {
        return health;
    }*/
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 750, 1);
        heroship=new HeroShip(5);
        addObject(heroship, 300, 700);
        for(int i=1;i<=10;i++)
        {
            addLocation();
        }
        for(int i=1;i<=4;i++)
        {
           addAnOtherShip() ;
        }
        health=new HeroHealth();
        addObject(health,480 ,20 );
       
        /* HeroHealth health=new HeroHealth();
        addObject(health,480 ,20 );*/
        

        
    }
    public void act()
    {
        dealyTime++;
        displayScore();
        if(HeroShip.score==14)
        {
           nextLevel();
           
        }
       // healthLevels(); 
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
             hero.healtOfHreo=5;
             hero.score=0;
             hero.k=0;
            }
           }
    }
    public void healthLevels()
    {
       HeroShip ship=new HeroShip(5);
         showText(" = "+ship.healtOfHreo,520 , 20); 
    }
    
     private int x=60;
    private int y=50;
     private int count=0;
    
    public void addLocation()
    {
        enemyship=new EnemyShip(1);
         if(y==50)
        {
            
          addObject(enemyship,x , y);
          x=x+120;
          count++;
          if (count==5)
          {
             y=y+200; 
             x=70;
          }
        }
        else if(y==250)
        {
            addObject(enemyship,x , y);
            x=x+120;
        }
     }
     private int anotherY=140;
     private int anotherX=106;
     public void addAnOtherShip()
     {
        
        if(anotherY==140)
        {
         addObject(new EnemyShip(1,"Red"),anotherX,140); 
         anotherX+=125;
        }
     }
     public void displayScore()
     {
         showText("score : "+HeroShip.score,81 , 42);
     }
      private final static int shipReloadTime=300;
    private int dealyTime=0;
   
     private void nextLevel()
    {
        Enemy_Bombs bombs=new Enemy_Bombs();
        removeObject(bombs);
       heroship.move();
      if(dealyTime>=shipReloadTime)
      {
         setBackground("level-2.jpg");
          showText(" MOVING TO LEVEL-2 ",300 , 400);
        showText(" YOUR SCORE :- "+HeroShip.score,320 , 440);
      }
     
      if(heroship.isAtEdge())
      {
          
          
        removeObject(heroship);
        Greenfoot.setWorld(new MilkyWay());        
      }
    }

     
    
}











