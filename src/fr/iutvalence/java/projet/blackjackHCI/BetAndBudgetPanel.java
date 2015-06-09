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
		this.player = player;
		JLabel betLabel = new JLabel("Bet : ");
		JLabel betSumLabel = new JLabel(""+this.player.getMainHand().getBet());
		JLabel budgetLabel = new JLabel("Budget : ");
		JLabel budgetSumLabel = new JLabel(""+this.player.getBudget());
		this.add(betLabel);
		this.add(betSumLabel);
		this.add(budgetLabel);
		this.add(budgetSumLabel);
	}
}
