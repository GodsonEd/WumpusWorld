//Godson Edewor / Tully/ 6th Period
import java.awt.*;
import javax.swing.*;

public class WumpusFrame extends JFrame
{
	public WumpusFrame(String WumpusWorld)
	{
		super(WumpusWorld);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		
		WumpusPanel p = new WumpusPanel();
		Insets insets = getInsets();
		
		int width = p.getWidth()+(insets.left+insets.right);
		int height = p.getHeight()+(insets.top+insets.bottom);
		
		setPreferredSize(new Dimension(width,height));
		
		setLayout(null);
		add(p);
		pack();
		setVisible(true);
	}
}
