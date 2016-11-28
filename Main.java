import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    //public static void main(String[] args)
    JLabel coinCenter;
        //timer
    Timer t = new Timer();
    int secondsPassed=0;
    TimerTask task;
    ArrayList<Integer> infoArrayList = new ArrayList<Integer>();
    //final  JPanel centerPanel;
    //int finalCount=0;
    public Main()
    {
        //create frame
        JFrame fr = new JFrame("LCR Dice Game");
        fr.setSize(800,800);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new BorderLayout());
        
        //create labels
        ImageIcon img1 = new ImageIcon("harambe.png");        
        JLabel har = new JLabel(img1);
        JLabel coin1 = new JLabel("5 coins");
        
        ImageIcon img2 = new ImageIcon("cage.png");        
        JLabel cage = new JLabel(img2);
        JLabel coin2 = new JLabel("5 coins");
        
        ImageIcon img3 = new ImageIcon("biden.png");        
        JLabel biden = new JLabel(img3);
        JLabel coin3 = new JLabel("5 coins");
        
        ImageIcon img4 = new ImageIcon("snoop.png");        
        JLabel snoop = new JLabel(img4);    
        JLabel coin4 = new JLabel("5 coins");
        
        JLabel coinCenter = new JLabel("0 coins");
        
        //create panels
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(har,BorderLayout.NORTH);
        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new GridLayout(1,3));
        subPanel1.add(new JLabel());
        subPanel1.add(coin1);
        panel1.add(subPanel1,BorderLayout.SOUTH);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(cage,BorderLayout.SOUTH);
        JPanel subPanel2 = new JPanel();
        subPanel2.setLayout(new GridLayout(1,3));
        subPanel2.add(new JLabel());
        subPanel2.add(coin2);
        panel2.add(subPanel2,BorderLayout.NORTH);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(biden,BorderLayout.EAST);
        panel3.add(coin3,BorderLayout.WEST);
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.add(snoop,BorderLayout.WEST);
        panel4.add(coin4,BorderLayout.EAST);        
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3,3));
        centerPanel.add(new JLabel());
        centerPanel.add(new JLabel());
        centerPanel.add(new JLabel());
        //centerPanel.add(new JLabel());
        centerPanel.add(coinCenter);
        
        //add panels to frame
        fr.add(panel1,BorderLayout.NORTH);
        fr.add(panel2,BorderLayout.SOUTH);
        fr.add(panel3,BorderLayout.EAST);
        fr.add(panel4,BorderLayout.WEST);
        fr.add(centerPanel,BorderLayout.CENTER);
                
        //set Frame as visible
        fr.setVisible(true);
        
        //construct an lcr
        LCR game = new LCR();
        //infoArrayList=game.printStuff();
        //int finalCount=0;
        
        task = new TimerTask() 
        {
            public void run() 
            {
               if(game.gameContinue())
               {
                   for(int i = 0;i<4;i++)
                   {
                       game.playTurn(game.players[i]);
                   }
                   infoArrayList=game.printStuff();
               } else
               {
                   int winner = game.whoWon().getPos();
                   game.players[winner].addCoins(game.centerCoins);
                   game.centerCoins=0;
                   infoArrayList=game.printStuff();
                   //finalCount++;
                   //int winner = game.whoWon().getPos(); 
                   //if(winner=
                   //fr.remove(centerPanel);
                   //fr.add(cage,BorderLayout.CENTER);
               }
               String status = "";
               if(!game.gameContinue())
               {
                   if(game.whoWon().getPos()==0) status = ": WINNER"; 
                   else status = "";
               }
               coin1.setText(String.valueOf(infoArrayList.get(1)) + " coins" + status);
               if(!game.gameContinue())
               {
                   if(game.whoWon().getPos()==1) status = ": WINNER";
                   else status = "";
               }
               coin2.setText(String.valueOf(infoArrayList.get(2)) + " coins" + status);
               if(!game.gameContinue())
               {
                   if(game.whoWon().getPos()==2) status = ": WINNER";
                   else status = "";     
                }
               coin3.setText(String.valueOf(infoArrayList.get(3)) + " coins" + status);
               if(!game.gameContinue())
               {
                   if(game.whoWon().getPos()==3) status = ": WINNER";
                   else status = "";           
               }
               coin4.setText(String.valueOf(infoArrayList.get(4)) + " coins" + status);   
               coinCenter.setText(String.valueOf(infoArrayList.get(0)) + " coins");               
                //infoArrayList=game.printStuff();               
               //secondsPassed++;
               //System.out.println(secondsPassed);
               //coinCenter.setText(String.valueOf(secondsPassed));
               //setTheText(String.valueOf(secondsPassed));
            }
        };
    }
    public void setTheText(String s)
    {
        coinCenter.setText(s);
    }
    
    public void start()
    {
        t.scheduleAtFixedRate(task,250,250);
    }
}
