package fr.iutvalence.java.projet.blackjackHCI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 * BetAndBudgetPanel is a panel where we display the bet and the budget 
 */
public class BetAndBudgetPanel extends JPanel
{
	/** player the Player*/
	private Player player;
	
	/**
	 * the constructor of BetAndSBudgetPanel
	 * @param player the Player
	 */
	public BetAndBudgetPanel(Player player){
		JLabel label = new JLabel("Bet : ");
		JLabel sum = new JLabel(""+this.player.getMainHand().getBet());
		JLabel label1 = new JLabel("Budget : ");
		JLabel sum1 = new JLabel(""+this.player.getBudget());
		this.add(label);
		this.add(sum);
		this.add(label1);
		this.add(sum1);
	}
}
