/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iutvalence.java.projet.blackjack.Card;
import fr.iutvalence.java.projet.blackjack.Dealer;

/**
 * @author duboitho
 *
 */
public class DealersCards extends JPanel
{
	private Dealer dealer;
	
	private List<Card> hand;
	
	public DealersCards(Dealer dealer){
		
		this.dealer = dealer;
		this.hand=this.dealer.getHand();
		
		for(int i=0;i<hand.size();i++)
		{
			JButton button = new JButton(""+this.dealer.getHand().get(i));
			this.add(button);
			button.setEnabled(false);
		}
	}
}
