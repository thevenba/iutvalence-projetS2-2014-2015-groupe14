/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.Hand;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 *
 */
public class PlayerDisplay extends JPanel
{
	private BetAndBudgetPanel betAndBudgetPanel;
	private PlayerHandPanel handPanel;
	private JSplitPane separator;
	
	public PlayerDisplay(Player player){
		GridLayout layout= new GridLayout(2,1);
		this.setLayout(layout);
		this.handPanel = new PlayerHandPanel(player); 
		this.betAndBudgetPanel = new BetAndBudgetPanel(player);
		handPanel.setSize(500, 500);
		this.add(betAndBudgetPanel);
		this.add(handPanel);
	}

	/**
	 * @return the betAndBudgetPanel
	 */
	public BetAndBudgetPanel getBetAndBudgetPanel()
	{
		return betAndBudgetPanel;
	}

	/**
	 * @return the handPanel
	 */
	public PlayerHandPanel getHandPanel()
	{
		return handPanel;
	}
}

