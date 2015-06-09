/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.LinkedList;
import java.util.List;

/**
 * Dealer the player's opponent
 * @author thevenba
 */
public class Dealer
{
	/** The dealer's hand */
	public List<Card> hand;
	
	/**
	 * Create a dealer with a hand
	 */
	public Dealer()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 * Reset the hand of the dealer
	 */
	public void resetHand()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 * Add a card from the deck to the hand of the dealer
	 * @param deck the game's deck
	 */
	public void hit(Deck deck)
	{
		this.hand.add(deck.randomCard());
	}
	
	/**
	 * Takes the dealer's score
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
