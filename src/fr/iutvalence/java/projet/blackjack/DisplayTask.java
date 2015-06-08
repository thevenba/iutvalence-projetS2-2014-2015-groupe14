/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

/**
 * @author thevenba
 *
 */
public class DisplayTask implements Runnable
{
	private Dealer dealer;
	private Deck deck;
	private Player player;
	private JFrame window;
	private DealerPanel dealerPanel;
	private PlayerPanel playerPanel;
	private JSplitPane separator;
	
	
	public DisplayTask(Dealer dealer, Deck deck, Player player)
	{
		this.dealer = dealer;
		this.deck = deck;
		this.player = player;
	}

	@Override
	public void run()
	{
		this.initGraphicInterface();		
	}

	private void initGraphicInterface()
	{
		this.window = new JFrame();
		this.window.setTitle("Black Jack");
		this.window.setSize(1280, 720);
		this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.window.setResizable(false);
		this.dealerPanel = new DealerPanel();
		this.playerPanel = new PlayerPanel();
		this.separator = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.dealerPanel, this.playerPanel);
		this.separator.setEnabled(false);
		this.separator.setResizeWeight(0.1);
		this.window.getContentPane().add(this.separator);
		this.window.setVisible(true);
	}

}
