package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.GridLayout;

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
	private JLabel betSumLabel = new JLabel();
	private JLabel budgetSumLabel = new JLabel();
	
	/**
	 * the constructor of BetAndSBudgetPanel
	 * @param player the Player
	 */
	public BetAndBudgetPanel(Player player){
		GridLayout layout = new GridLayout(2, 2);
		this.setLayout(layout);
		this.player = player;
		JLabel betLabel = new JLabel("Bet : ");
		this.betSumLabel.setText(""+this.player.getMainHand().getBet());
		JLabel budgetLabel = new JLabel("Budget : ");
		this.budgetSumLabel.setText(""+this.player.getBudget());
		this.add(betLabel);
		this.add(betSumLabel);
		this.add(budgetLabel);
		this.add(budgetSumLabel);
	}
	
	public void refresh(){
		this.betSumLabel.setText(""+this.player.getMainHand().getBet());
		this.budgetSumLabel.setText(""+this.player.getBudget());
	}
}
