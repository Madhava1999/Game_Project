import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final_Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Final_Level extends World
{

    /**
     * Constructor for objects of class Final_Level.
     * 
     */
     private HeroShip heroship;
     private Sub_Enemy sub_Enemy;
    private  Final_Level_Enemy finalEnemy;
    public Final_Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 750, 1);
        heroship=new HeroShip(5);
       // sub_Enemy=new Sub_Enemy(5);
        finalEnemy=new Final_Level_Enemy(4);
        addObject(heroship, 300, 700);
        addObject(finalEnemy, 300, 104);
         HeroHealth health=new HeroHealth();
        addObject(health,480 ,20 );
        
    }
    public void act()
    {
        dealyTime++;
        displayScore2();
        if (HeroShip.score==34)
        {
            gameOver();
        }
        addingSmallEnemys();
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
     public void displayScore2()
     {
         showText("score : "+HeroShip.score,81 , 42);
     }
     
    public void gameOver()
    {
        numberOfSub_Enemy=0;
        removeObject(sub_Enemy);
       heroship.move();
       Enemy_Bombs enemybombs=new Enemy_Bombs();
        if(heroship.isAtEdge())
      {
          Enemy_Bombs bombs=new Enemy_Bombs();
            removeObject(enemybombs);
          Sub_Enemy sub=new Sub_Enemy(4);
          removeObject(sub);
           removeObject(heroship);
         removeObject(bombs);
        setBackground("gameOver1.jpg");
        
       }
    }
    
    //adding sub_space
    private final static int shipRe_Load=50;
    private int dealyTime=0;
    private int enemySub_spaceRanmodTime=Greenfoot.getRandomNumber(200);
    private int numberOfSub_Enemy=50;
    public void addingSmallEnemys()
    {
       
       for(int i=1;i<=numberOfSub_Enemy;i++)
       {
           if(dealyTime>enemySub_spaceRanmodTime)
         {
           int x_axis=Greenfoot.getRandomNumber(599);
           int y_axis=Greenfoot.getRandomNumber(50);
           addObject(new Sub_Enemy(5),x_axis , y_axis);
           dealyTime=0;
         enemySub_spaceRanmodTime=Greenfoot.getRandomNumber(200);
         }
       }
     }
    
     
    
}
