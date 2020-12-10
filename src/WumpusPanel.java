//Godson Edewor / Tully/ 6th Period
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class WumpusPanel extends JPanel implements KeyListener
{
	public static final int PLAYING = 0;
	public static final int DEAD = 1;
	public static final int WON = 2;
	int status;
	WumpusPlayer player;
	WumpusMap map;
	private BufferedImage arrow;
	private BufferedImage black;
	private BufferedImage gold;
	private BufferedImage ladder;
	private BufferedImage pit;
	private BufferedImage breeze;
	private BufferedImage wumpus;
	private BufferedImage deadWumpus;
	private BufferedImage stench;
	private BufferedImage playerUp;
	private BufferedImage playerDown;
	private BufferedImage playerLeft;
	private BufferedImage playerRight;
	private BufferedImage floor;
	boolean wb = false;//win
	boolean kb = false;//kill wumpus
	boolean xb = false;//hack
	boolean firstb = false; 
	boolean immort = false;  
	public WumpusPanel()
	{
		super();
		setSize(700,700);
        addKeyListener(this);
		try
		{
			/*arrow = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\arrow.gif"));
			black = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\black.gif"));
			gold = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\gold.gif"));
			ladder = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\ladder.gif"));
			pit = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\pit.gif"));
			breeze = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\breeze.gif"));
			wumpus = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\wumpus.gif"));
			deadWumpus = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\deadwumpus.gif"));
			stench = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\stench.gif"));
			playerUp = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\playerUp.png"));
			playerDown = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\playerDown.png"));
			playerLeft = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\playerLeft.png"));
			playerRight = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\playerRight.png"));
			floor = ImageIO.read(new File("C:\\Users\\othscs019\\Dropbox\\Wompus world\\images\\Floor.gif"));*/
			arrow = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\arrow.gif"));
			black = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\black.gif"));
			gold = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\gold.gif"));
			ladder = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\ladder.gif"));
			pit = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\pit.gif"));
			breeze = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\breeze.gif"));
			wumpus = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\wumpus.gif"));
			deadWumpus = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\deadwumpus.gif"));
			stench = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\stench.gif"));
			playerUp = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\playerUp.png"));
			playerDown = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\playerDown.png"));
			playerLeft = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\playerLeft.png"));
			playerRight = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\playerRight.png"));
			floor = ImageIO.read(new File("C:\\Users\\Godson\\Dropbox\\Computer Science 1 Notes\\Wompus world\\images\\Floor.gif"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		reset();
		System.out.println(map.toString());
	}
	public void reset()
	{
		status = PLAYING;
		map = new WumpusMap();
		player = new WumpusPlayer();
		player.setRowPosition(map.getLadderRow());
		player.setColPosition(map.getLadderCol());
		xb = false;
	}
	public void paint(Graphics g)
	{
	    Font s = new Font("Times New Roman",Font.BOLD,23);
		Font q = new Font("Times New Roman",Font.BOLD,18);
	    g.setFont(s);
	    String b = "Messages:";
	    String v = "Inventory:";
	    String br = "You feel a breeze.";
	    String wum = "You smell a stench.";
	    String gol = "You see a glimmer.";
	    String lad = "You bump into a ladder.";
	    String pi = "You fell down a pit to your death. Game Over. (N for new game)";
	    String eat = "You are eaten by the Wumpus. Game Over. (N for new game)";
	    String scr = "You hear a scream";
	    String win = "You win. (N for new game)";
		g.setColor(Color.GRAY);
		g.fillRect(0,0,700,700);
		for(int x = 0;x<10;x++) {
		    for(int y = 0;y<10;y++) {
                g.drawImage(floor, 50 * x + 100, 50*y + 50, null);
            }
        }

        g.setColor(Color.BLACK);
		//Inventory
        g.fillRect(0,600,175,100);
        //Messages
        g.fillRect(180,600,800,100);
        
        g.setColor(Color.GREEN);
        g.drawString(b,190,625);
        g.drawString(v,5,625);
        
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c).isWumpus() == true) {
					g.drawImage(wumpus, r * 50 + 100, c * 50 + 50, null);
				}
				else if(map.getSquare(r,c).isDeadWumpus() == true)
				{
					g.drawImage(deadWumpus, r * 50 + 100, c * 50 + 50, null);
				}
			}
		}
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c).isBreeze() == true) {
					g.drawImage(breeze, r * 50 + 100, c * 50 + 50, null);
				}
			}
		}
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c).isStench() == true) {
					g.drawImage(stench, r * 50 + 100, c * 50 + 50, null);
				}
				if(player.isArrow() == true)
				{
					g.drawImage(arrow,10,635,null);
				}
			}
		}
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c).isLadder() == true) {
					g.drawImage(ladder, r * 50 + 100, c * 50 + 50, null);
					map.getSquare(r,c).setVisited(true);
				}
				
			}
		}
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c).isGold() == true) {
					g.drawImage(gold, r * 50 + 100, c * 50 + 50, null);
				}
				if(player.isGold() == true)
				{
					g.drawImage(gold,75,635,null);
				}
			}
		}
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c).isPit() == true) {
					g.drawImage(pit, r * 50 + 100, c * 50 + 50, null);
				}
			}
		}
		
		g.setColor(Color.RED);
		g.setFont(q);
		int x = 639;
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c) == map.getSquare(player.isRowPosition(),player.isColPosition()))
				{
					if(player.isDirection() == 0)
					{
						g.drawImage(playerUp, player.isColPosition() * 50 + 100, player.isRowPosition() * 50 + 50, null);
						//System.out.println(player.isRowPosition());
						//System.out.println(player.isColPosition());	
					}
					else if(player.isDirection() == 1)
					{
						g.drawImage(playerRight, player.isColPosition() * 50 + 100, player.isRowPosition() * 50 + 50, null);
						//System.out.println(player.isRowPosition());
						//System.out.println(player.isColPosition());
					}
					else if(player.isDirection() == 2)
					{
						g.drawImage(playerDown, player.isColPosition() * 50 + 100, player.isRowPosition() * 50 + 50, null);
						//System.out.println(player.isRowPosition());
						//System.out.println(player.isColPosition());
					}
					else if(player.isDirection() == 3)
					{
						g.drawImage(playerLeft, player.isColPosition() * 50 + 100, player.isRowPosition() * 50 + 50, null);
						//System.out.println(player.isRowPosition());
						//System.out.println(player.isColPosition());
					}
					if(map.getSquare(c,r).isPit() == true)
					{
						g.drawString(pi,190,640);
					}
					else if(map.getSquare(c,r).isWumpus() == true)
					{
						g.drawString(eat,190,640);
					}
					else if(wb != false)
					{
						g.drawString(win,190,640);
					}
					else if(map.getSquare(c,r).isPit() == false && map.getSquare(c,r).isWumpus() == false)
					{
						if(map.getSquare(c,r).isLadder() == true)
						{
							if(x == 639)
							{
								x = 640;
							}
							else if(x == 640)
							{
								x = 655;
							}
							else if(x == 655)
							{
								x = 670;
							}
							else if(x == 670)
							{
								x = 685;
							}
							g.drawString(lad,190,x);
						}
						if(map.getSquare(c,r).isBreeze() == true)
						{
							if(x == 639)
							{
								x = 640;
							}
							else if(x == 640)
							{
								x = 655;
							}
							else if(x == 655)
							{
								x = 670;
							}
							else if(x == 670)
							{
								x = 685;
							}
							g.drawString(br,190,x);
						}
						if(map.getSquare(c,r).isStench() == true)
						{
							if(x == 639)
							{
								x = 640;
							}
							else if(x == 640)
							{
								x = 655;
							}
							else if(x == 655)
							{
								x = 670;
							}
							else if(x == 670)
							{
								x = 685;
							}
							g.drawString(wum,190,x);
						}
						if(map.getSquare(c,r).isGold() == true)
						{
							if(x == 639)
							{
								x = 640;
							}
							else if(x == 640)
							{
								x = 655;
							}
							else if(x == 655)
							{
								x = 670;
							}
							else if(x == 670)
							{
								x = 685;
							}
							g.drawString(gol,190,x);
						}
						if(kb == true)
						{
							if(x == 639)
							{
								x = 640;
							}
							else if(x == 640)
							{
								x = 655;
							}
							else if(x == 655)
							{
								x = 670;
							}
							else if(x == 670)
							{
								x = 685;
							}
							g.drawString(scr,190,x);
							kb = false;
						}
					}
				}
			}
		}
		for(int r = 0;r<10;r++) {
			for(int c = 0;c<10;c++)
			{
				if(map.getSquare(r,c).isVisited() != true)
				{
					if(xb == false)
					{
						g.drawImage(black, r * 50 + 100, c * 50 + 50, null);
					}
				}
			}
		}	
	}
	public void keyTyped(KeyEvent e)
	{
		char key = e.getKeyChar();
		System.out.println("hi");
		//North
		if( key=='w')
		{	
			if(player.isRowPosition()==0 || map.getSquare(player.isColPosition(),player.isRowPosition()).isPit() == true || map.getSquare(player.isColPosition(),player.isRowPosition()).isWumpus() == true || wb == true)
			{
				if(immort == false)
				{
					player.setRowPosition(player.isRowPosition());
				}
				else if(immort == true)
				{
					player.setDirection(0);
					player.setRowPosition(player.isRowPosition()-1);
				}
			}
			else
			{
				player.setDirection(0);
				player.setRowPosition(player.isRowPosition()-1);
			}
		}
		//South
		else if(key == 's')
		{	
			if(player.isRowPosition()==9 || map.getSquare(player.isColPosition(),player.isRowPosition()).isPit() == true || map.getSquare(player.isColPosition(),player.isRowPosition()).isWumpus() == true || wb == true)
			{
				if(immort == false)
				{
					player.setRowPosition(player.isRowPosition());
				}
				else if(immort == true)
				{
					player.setDirection(2);
					player.setRowPosition(player.isRowPosition()+1);
				}
			}
			else
			{
				player.setDirection(2);
				player.setRowPosition(player.isRowPosition()+1);
			}
		}
		//West
		else if(key == 'a')
		{
			if(player.isColPosition()==0 || map.getSquare(player.isColPosition(),player.isRowPosition()).isPit() == true || map.getSquare(player.isColPosition(),player.isRowPosition()).isWumpus() == true || wb == true)
			{
				if(immort == false)
				{
					player.setColPosition(player.isColPosition());
				}
				else if(immort == true)
				{
					player.setDirection(3);
					player.setColPosition(player.isColPosition()-1);
				}
			}
			else
			{
				player.setDirection(3);
				player.setColPosition(player.isColPosition()-1);
			}
		}
		//East
		else if(key == 'd')
		{
			if(player.isColPosition()==9 || map.getSquare(player.isColPosition(),player.isRowPosition()).isPit() == true || map.getSquare(player.isColPosition(),player.isRowPosition()).isWumpus() == true || wb == true)
			{
				if(immort == false)
				{
					player.setColPosition(player.isColPosition());
				}
				else if(immort == true)
				{
					player.setDirection(1);
					player.setColPosition(player.isColPosition()+1);
				}
			}
			else
			{
				player.setDirection(1);
				player.setColPosition(player.isColPosition()+1);
			}
		}
		if(key == 'n' && map.getSquare(player.isColPosition(),player.isRowPosition()).isPit() == true)
		{
			player.setGold(false);
			reset();
		}
		if(key == 'n' && map.getSquare(player.isColPosition(),player.isRowPosition()).isWumpus() == true)
		{
			player.setGold(false);
			reset();
		}
		if(key == 'n' && wb == true)
		{
			player.setGold(false);
			immort = false;
			wb = false;
			reset();
		}
		if(key == 'p' && map.getSquare(player.isColPosition(),player.isRowPosition()).isGold() == true)
		{
			map.getSquare(player.isColPosition(),player.isRowPosition()).setGold(false);
			player.setGold(true);
		}
		if(key == 'c' && player.isGold() == true && map.getSquare(player.isColPosition(),player.isRowPosition()).isLadder() == true)
		{
			wb = true;
		}
		if(key == 'i' && player.isArrow() == true)
		{
			for(int r = (player.isRowPosition()- 1); r>=0;r--)
			{
				if(map.getSquare(player.isColPosition(),r).isWumpus() == true) {
					map.getSquare(player.isColPosition(), r).setDeadWumpus(true);
					map.getSquare(player.isColPosition(), r).setWumpus(false);
					kb = true;
					break;
				}
			}
			player.setDirection(0);
			player.setArrow(false);
		}
		else if(key == 'k' && player.isArrow() == true)
		{
			for(int r = (player.isRowPosition()+ 1); r<=9;r++)
			{
				if(map.getSquare(player.isColPosition(),r).isWumpus() == true) {
					map.getSquare(player.isColPosition(), r).setDeadWumpus(true);
					map.getSquare(player.isColPosition(), r).setWumpus(false);
					kb = true;
					break;
				}
			}
			player.setDirection(2);
			player.setArrow(false);
		}
		else if(key == 'j' && player.isArrow() == true)
		{
			for(int r = (player.isColPosition()- 1); r>=0;r--)
			{
				if(map.getSquare(r ,player.isRowPosition()).isWumpus() == true) {
					map.getSquare(r ,player.isRowPosition()).setDeadWumpus(true);
					map.getSquare(r ,player.isRowPosition()).setWumpus(false);
					kb = true;
					break;
				}
			}
			player.setDirection(3);
			player.setArrow(false);
		}
		else if(key == 'l' && player.isArrow() == true)
		{
			for(int r = (player.isColPosition()+ 1); r<=9;r++)
			{
				if(map.getSquare(r ,player.isRowPosition()).isWumpus() == true) {
					map.getSquare(r ,player.isRowPosition()).setDeadWumpus(true);
					map.getSquare(r ,player.isRowPosition()).setWumpus(false);
					kb = true;
					break;
				}
			}
			player.setDirection(1);
			player.setArrow(false);
		}
		if(key == '*' && firstb != true)
		{
			xb = true;
			firstb = true;
		}
		else if(firstb == true && key == '*')
		{
			xb = false;
			firstb = false;
		}
		if(key == 'x')
		{
			immort = true;
		}
		map.getSquare(player.isColPosition(),player.isRowPosition()).setVisited(true);
		repaint();
	}
	public void keyPressed(KeyEvent e)
	{

	}
	public void keyReleased(KeyEvent e)
	{
		
	}
	public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
}
