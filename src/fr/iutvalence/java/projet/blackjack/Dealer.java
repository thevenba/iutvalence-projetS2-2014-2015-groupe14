/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author thevenba
 * The Dealer, the opponent of the player
 */
public class Dealer
{
	/** 
	 * The dealer's hand
	 */
	public List<Card> hand;
	
	/**
	 * Create a dealer with a hand
	 */
	public Dealer()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 * Reset the dealer's hand
	 */
	public void resetHand()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 * Add a card in the dealer's hand
	 * @param deck the list of cards in the game
	 */
	public void hit(Deck deck)
	{
		this.hand.add(deck.randomCard());
	}
	
	/**
	 * Give the score of the dealer
	 * @return score the dealer's score
	 */
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
