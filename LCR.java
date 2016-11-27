import java.util.Random;
import java.util.Scanner;
public class LCR
{
    Random rand;
    Scanner read;
    Player[] players;
    int totalCoins;
    int centerCoins = 0;
    public LCR()
    {
        rand = new Random();
        read = new Scanner(System.in);
        getPlayers();
        playGame();
    }

    public void playGame()
    {
        int count = 0;
        while(gameContinue())
        {
            playTurn(players[count]);
            if(count+1>=players.length)
            {
                count = 0;
            } else count++;
        }
        int winner = whoWon().getPos();
        players[winner].addCoins(centerCoins);
        centerCoins = 0;
        printStuff();

    }

    public void printStuff()
    {
        System.out.println('\u000C');
        System.out.println("Center: " + centerCoins);
        for(Player p : players)
        {
            System.out.println("Player " + p.getName() + ": " + p.getCoins());
        }
    }

    public Player whoWon()
    {
        Player ret = new Player();
        for(Player p : players)
        {
            if(p.getCoins()>0)
            {
                ret = p;;
            }
        }
        return ret;
    }

    public void playTurn(Player p)
    {
        String[] dice = rollDice(p.getCoins());
        for(String d : dice)
        {
            if(d.equals("L"))
            {
                p.addCoins(-1);
                if(p.getPos()-1<0)
                {
                    players[players.length-1].addCoins(1);
                } else players[p.getPos()-1].addCoins(1);
            } else if(d.equals("R"))
            {
                p.addCoins(-1);
                if(p.getPos()+1>=players.length)
                {
                    players[0].addCoins(1);
                } else players[p.getPos()+1].addCoins(1);
            } else if(d.equals("C"))
            {
                p.addCoins(-1);
                centerCoins++;
            }
        }   

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
                case 1: dice[i] = "*"; break;
                case 2: dice[i] = "*"; break;
                case 3: dice[i] = "*"; break;
                case 4: dice[i] = "L"; break;
                case 5: dice[i] = "C"; break;
                case 6: dice[i] = "R"; break;
            }
        }

        printStuff();
        for(String d : dice)
        {
            System.out.println("Roll: " + d);
        }

        return dice;
    }

    public boolean gameContinue()
    {
        boolean ret = false;
        int count = 0; 
        for(int i = 0; i<players.length; i++)
        {
            if(players[i].getCoins()>0) { count++; }
            if(count>1) { ret = true; i = players.length; }
        }
        return ret;
    }

    public void getPlayers()
    {
        System.out.println("How many coins will each player get?");
        totalCoins = read.nextInt();
        System.out.println("How many players are playing?");
        players = new Player[read.nextInt()];
        read.nextLine();//idk why i need this, but it makes it work

        for(int i = 0; i<players.length; i++)
        {
            System.out.println("What is the name of player " + (i+1));
            String n = read.nextLine();
            players[i] = new Player(n, totalCoins, i);
        }
    }

}
