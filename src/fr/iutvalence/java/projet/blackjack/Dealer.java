/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author thevenba
 *
 */
public class Dealer
{
	public List<Card> hand;
	
	public Dealer()
	{
		this.hand = new LinkedList<>();
	}
	
	public void resetHand()
	{
		this.hand = new LinkedList<>();
	}
	
	public void hit(Deck deck)
	{
		this.hand.add(deck.randomCard());
	}
	
	public int reckonScore()
	{
		int score = 0;
		for (int cardIndex = 0; cardIndex < this.hand.size(); cardIndex++)
			score += this.hand.get(cardIndex).getRank().getValue();
		return score;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Dealer [hand=" + hand + "]";
	}
	
	
}
