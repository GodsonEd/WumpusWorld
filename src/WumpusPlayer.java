//Godson Edewor / Tully/ 6th Period
public class WumpusPlayer
{
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	int direction;
	boolean arrow;
	boolean gold;
	int colPosition;
	int rowPosition;
	public WumpusPlayer()
	{
		direction = NORTH;
		gold = false;
		arrow = true;
	}
	public int isDirection()
	{
		return direction;
	}
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
	public boolean isArrow()
	{
		return arrow;
	}
	public void setArrow(boolean arrow)
	{
		this.arrow = arrow;
	}
	public boolean isGold()
	{
		return gold;
	}
	public void setGold(boolean gold)
	{
		this.gold = gold;
	}
	public int isColPosition()
	{
		return colPosition;
	}
	public void setColPosition(int colPosition)
	{
		this.colPosition = colPosition;
	}
	public int isRowPosition()
	{
		return rowPosition;
	}
	public void setRowPosition(int rowPosition)
	{
		this.rowPosition = rowPosition;
	}
}
