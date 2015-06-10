/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.util.ArrayList;
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
	private final Dealer dealer;
	private List<JButton> hand;
	
	public DealersCards(Dealer dealer){
		this.dealer = dealer;
	    this.hand = new ArrayList();
	}
	
    public void refreshDealerHand()
    {
        for (JButton buttonToDelete : this.hand) {
            this.remove(buttonToDelete);
        }
        List<Card> handToLook;
        handToLook = this.dealer.getHand().getCards();
 
        for (Card CardToAdd : handToLook) {
            JButton buttonToAdd = new JButton("" + CardToAdd.getRank().toString() + " " + CardToAdd.getRank().getValue());
            this.revalidate();
            this.add(buttonToAdd);
            this.hand.add(buttonToAdd);
        }
    }
}
