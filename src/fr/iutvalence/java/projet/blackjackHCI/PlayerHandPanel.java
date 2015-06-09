/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.GridLayout;
import java.awt.Panel;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.Card;
import fr.iutvalence.java.projet.blackjack.Dealer;
import fr.iutvalence.java.projet.blackjack.Hand;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 *
 */
public class PlayerHandPanel extends Panel
{
	
	private List<Card> subHand;
	private Player player;
	private JSplitPane separator;
	private MainHandPanel mainHandPanel;
	private SubHandPanel subHandPanel;
	
	public PlayerHandPanel(Player player)
	{
		
		this.player = player;
		this.subHand=this.player.getSubHand().getCards();

		if(this.subHand.size() > 0)
		{
			this.mainHandPanel = new MainHandPanel(player,true);
			this.subHandPanel = new SubHandPanel(player);
			this.separator=new JSplitPane(JSplitPane.VERTICAL_SPLIT,this.mainHandPanel,this.subHandPanel);
			this.separator.setEnabled(false);
			this.separator.setResizeWeight(0.1);
			this.add(this.separator);
		}
		else
		{
			this.mainHandPanel = new MainHandPanel(player,true);
			this.add(mainHandPanel);
		}
	}

	/**
	 * @return the mainHandPanel
	 */
	public MainHandPanel getMainHandPanel()
	{
		return mainHandPanel;
	}

	/**
	 * @return the subHandPanel
	 */
	public SubHandPanel getSubHandPanel()
	{
		return subHandPanel;
	}
	
	

	
}
