/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.LinkedList;
import java.util.List;

/**
 * The player's hand
 * @author thevenba
 */
public class Hand
{
	/** The bet by default*/
	public static final int BET_DEFAULT = 0;
	
	/**The bet with a value of one */
	public static final int BET_ONE = 1;
	
	/**The bet with a value of five */
	public static final int BET_FIVE = 5;
	
	/**The bet with a value of twenty-five */
	public static final int BET_TWENTY_FIVE = 25;
	
	/**The bet with a value of one hundred */
	public static final int BET_ONE_HUNDRED = 100;
	
	/**The bet with a value of five hundred */
	public static final int BET_FIVE_HUNDRED = 500;
	
	/** List of hand's cards*/
	private List<Card> cards;
	
	/** Bet for one hand*/
	private int bet;
	
	/**
	 * Create a new hand, with a bet and cards 
	 */
	public Hand()
	{
		this.bet = Hand.BET_DEFAULT;
		this.cards = new LinkedList<>();
	}

	/**
	 * Get the bet of one hand
	 * @return bet the bet of one hand
	 */
	public int getBet()
	{
		return this.bet;
	}
	
	/**
	 * Set the bet of one hand
	 * @param bet the bet to set
	 */
	public void setBet(int bet)
	{
		this.bet = bet;
	}

	/**
	 * Get the hand's cards
	 * @return cards the hand's cards
	 */
	public List<Card> getCards()
	{
		return cards;
	}

	/**
	 * Set the hand's cards
	 * @param cards the cards to set
	 */
	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}
	
	/**
	 * Remove cards 
	 * @param index the number of cards
	 */
	public void removeCard(int index)
	{
		this.cards.remove(index);
	}
	
	/**
	 * Hit cards from the deck to the hand
	 * @param deck the game's deck
	 */
	public void hit(Deck deck)
	{
		this.cards.add(deck.randomCard());
	}
	
	
	/* TODO changement as automatique */
	public int reckonScore()
	{
		int score = 0;
		for (int cardIndex = 0; cardIndex < this.cards.size(); cardIndex++)
			score += this.cards.get(cardIndex).getRank().getValue();
		return score;
	}
}
