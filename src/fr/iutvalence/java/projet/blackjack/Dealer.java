/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author thevenba
 * The Dealer the opponent of the player
 */
public class Dealer
{
	/** 
	 * The hand of dealer 
	 */
	public List<Card> hand;
	
	/**
	 * Constructor of the class
	 */
	public Dealer()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 * ResetHand : Reset the hand of dealer
	 */
	public void resetHand()
	{
		this.hand = new LinkedList<>();
	}
	
	/**
	 * 
	 * @param deck
	 *  add a card in the hand of dealer
	 */
	public void hit(Deck deck)
	{
		this.hand.add(deck.randomCard());
	}
	
	/**
	 *  Give the score of the dealer
	 * @return score
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
