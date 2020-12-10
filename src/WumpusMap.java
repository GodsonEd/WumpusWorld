//Godson Edewor / Tully/ 6th Period
public class WumpusMap
{
	public static final int NUM_ROWS = 10;
	public static final int NUM_COLUMN = 10;
	public static final int NUM_PITS = 10;
	public WumpusSquare[][]grid = new WumpusSquare[NUM_ROWS][NUM_COLUMN];
	int ladderC;
	int ladderR;

	public WumpusMap()
	{
		createMap();
	}
	public void createMap()
	{
		int rnC = 0;
		int rnR = 0;

		grid = new WumpusSquare[NUM_ROWS][NUM_COLUMN];

		for(int gr = 0; gr < 10; gr++)
		{
			for(int ab = 0; ab < 10; ab++)
			{
				grid[gr][ab] = new WumpusSquare();
			}
		}
		//pit
		for (int x = 0; x < NUM_PITS; x++)
		{
			while(true)
			{
				rnC = (int) (Math.random() * 10) + 0;
				rnR = (int) (Math.random() * 10) + 0;
				if (grid[rnR][rnC].isWumpus() == false && grid[rnR][rnC].isGold() == false && grid[rnR][rnC].isLadder() == false && grid[rnR][rnC].isPit() == false)
				{
					grid[rnR][rnC].setPit(true);
					if (rnC - 1 >= 0 && grid[rnR][rnC - 1].isPit() == false) {
						grid[rnR][rnC - 1].setBreeze(true);
					}
					if (rnC + 1 <= 9 && grid[rnR][rnC + 1].isPit() == false) {
						grid[rnR][rnC + 1].setBreeze(true);
					}
					if (rnR + 1 <= 9 && grid[rnR + 1][rnC].isPit() == false) {
						grid[rnR + 1][rnC].setBreeze(true);
					}
					if (rnR - 1 >= 0 && grid[rnR - 1][rnC].isPit() == false) {
						grid[rnR - 1][rnC].setBreeze(true);
					}
					break;
				}
			}
		}
		//gold
		while(true)
		{
			rnC = (int) (Math.random() * 10) + 0;
			rnR = (int) (Math.random() * 10) + 0;
			if (grid[rnR][rnC].isWumpus() == false &&grid[rnR][rnC].isPit() == false && grid[rnR][rnC].isLadder() == false)
			{
				grid[rnR][rnC].setGold(true);
				break;
			}	
		}
		//wumpus
		//for (int x = 0; x < 8; x++)
		{
			while(true)
			{
				rnC = (int) (Math.random() * 10) + 0;
				rnR = (int) (Math.random() * 10) + 0;
				if (grid[rnR][rnC].isPit() == false && grid[rnR][rnC].isLadder() == false /*&& grid[rnR][rnC].isGold() == false*/)
				{
					grid[rnR][rnC].setWumpus(true);
					if (rnC - 1 >= 0) {
						grid[rnR][rnC - 1].setStench(true);
					}
					if (rnC + 1 <= 9) {
						grid[rnR][rnC + 1].setStench(true);
					}
					if (rnR + 1 <= 9) {
						grid[rnR + 1][rnC].setStench(true);
					}
					if (rnR - 1 >= 0) {
						grid[rnR - 1][rnC].setStench(true);
					}
					break;
				}
			}
		}
		//ladder
		while(true)
		{
			rnC = (int) (Math.random() * 10) + 0;
			rnR = (int) (Math.random() * 10) + 0;
			ladderC = rnC;
			ladderR = rnR;
			if (grid[rnR][rnC].isGold() == false && grid[rnR][rnC].isWumpus() == false && grid[rnR][rnC].isPit() == false) {
				grid[ladderR][ladderC].setLadder(true);
				break;
			}
		}
	}
	public int getLadderCol()
	{
		return ladderC;
	}
	public int getLadderRow()
	{
		return ladderR;
	}
	public WumpusSquare getSquare(int col,int row)
	{
		if(col<=9&&col>=0&&row<=9&&row>=0)
		{
			return grid[row][col];
		}
		return null;
	}
	public String toString()
	{
		String s1 = "";
		for(int r = 0;r<grid.length;r++)
		{
			WumpusSquare[]row = grid[r];
			for(int c = 0;c<row.length;c++)
			{
				if(row[c] != null)
				{
					System.out.print(row[c] + "");
				}
			}
			System.out.print("\n");
		}
		return s1;
	}
}
