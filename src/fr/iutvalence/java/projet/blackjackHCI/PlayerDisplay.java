/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

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
		this.handPanel = new PlayerHandPanel(player);
		this.betAndBudgetPanel = new BetAndBudgetPanel(player);
		JSplitPane separator = new JSplitPane(JSplitPane.VERTICAL_SPLIT,this.betAndBudgetPanel,this.handPanel);
		this.separator.setEnabled(false);
		this.separator.setResizeWeight(0.1);
	}
}
