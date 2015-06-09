/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.java.projet.blackjack.Hand;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 *
 */
public class BetAndBudgetPanel extends JPanel
{
	private Player player;
	
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
