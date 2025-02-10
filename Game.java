import java.util.Scanner;
public class Game
{
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    private boolean bonus;
    public Game()
    {
        levelOne = new Level();
        levelTwo = new Level();
        levelThree = new Level();
    }
    public Level getLevel(int l)
    {
        if(l == 1) return levelOne;
        if(l == 2) return levelTwo;
        if(l == 3) return levelThree;
        return null;
    }
    public boolean isBonus()
    {
        return bonus;
    }
    public void setBonus()
    {
        bonus = true;
    }
    public void play()
    {
        System.out.println("# of points: ");
        Scanner s = new Scanner(System.in);
       levelOne.setPoints(s.nextInt());
       levelOne.reachGoal();

    }
    public int getScore()
    {
        int points = 0;
        if(levelOne.goalReached())
        {
            points += levelOne.getPoints();
            if(levelTwo.goalReached())
            {
                points += levelTwo.getPoints();
                if(levelThree.goalReached()) points += levelThree.getPoints();
            }
        }
        if(this.isBonus()) return points * 3;
        return points;
    }
    public int playManyTimes(int num)
    {
       int max = 0;
       for(int i = 0; i < num; i ++)
       {
        play();
        if(max < getScore()) max = getScore();
       }
       return max;
    }
}