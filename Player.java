
public class Player
{
    String name;
    int coins;
    public Player(String name, int startCoins)
    {
        this.name = name;
        coins = startCoins;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getCoins()
    {
        return coins;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setCoins(int c)
    {
        coins = c;
    }
    
    public void addCoins(int c)
    {
        coins+=c;
    }

}
