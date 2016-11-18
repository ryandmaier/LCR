import java.util.Random;
import java.util.Scanner;
public class LCR
{
    Random rand;
    Scanner read;
    Player[] players;
    int totalCoins;
    public LCR()
    {
        rand = new Random();
        read = new Scanner(System.in);
        getPlayers();
    }
    
    public String[] rollDice(int n)//n is number of dice
    {
        String[] dice = new String[0];
        if(n>=3)
        {
            dice = new String[3];
        } else if(n==2) dice = new String[2];
        else if(n==1) dice = new String[1];
        for(int i = 0; i<dice.length; i++)
        {
            int num = rand.nextInt(6)+1;
            switch(num)
            {
                case 1: dice[i] = "*";
                case 2: dice[i] = "*";
                case 3: dice[i] = "*";
                case 4: dice[i] = "L";
                case 5: dice[i] = "C";
                case 6: dice[i] = "R";
            }
        }
        
        return dice;
    }
    
    public void getPlayers()
    {
        System.out.println("How many players are playing?");
        players = new Player[read.nextInt()];
        read.nextLine();//idk why i need this, but it makes it work
        
        for(int i = 0; i<players.length; i++)
        {
            System.out.println("What is the name of player " + (i+1));
            String n = read.nextLine();
            players[i] = new Player(n, totalCoins);
        }
    }

}
