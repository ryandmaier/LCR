
public class Player
{
    String name;
    int coins;
    int position;
    public Player() {}
    
    public Player(String name, int startCoins, int pos)
    {
        this.name = name;
        coins = startCoins;
        position = pos;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getCoins()
    {
        return coins;
    }
    
    public int getPos()
    {
        return position;
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
    
    public void setPos(int pos)
    {
        position = pos;
    }

}
