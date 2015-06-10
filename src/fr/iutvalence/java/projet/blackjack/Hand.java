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
public class Hand
{
	/** */
	public static final int BET_DEFAULT = 0;
	public static final int BET_ONE = 1;
	public static final int BET_FIVE = 5;
	public static final int BET_TWENTY_FIVE = 25;
	public static final int BET_ONE_HUNDRED = 100;
	public static final int BET_FIVE_HUNDRED = 500;
	
	private List<Card> cards;
	private int bet;
	
	public Hand()
	{
		this.bet = Hand.BET_DEFAULT;
		this.cards = new LinkedList<>();
	}

	/**
	 * @return the bet
	 */
	public int getBet()
	{
		return this.bet;
	}
	
	/**
	 * @param bet the bet to set
	 */
	public void setBet(int bet)
	{
		this.bet = bet;
	}

	/**
	 * @return the cards
	 */
	public List<Card> getCards()
	{
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}
	
	public void removeCard(int index)
	{
		this.cards.remove(index);
	}
	
	public void hit(Deck deck)
	{
		this.cards.add(deck.randomCard());
	}
	
	public int reckonScore()
	{
		int score = 0;
		for (int cardIndex = 0; cardIndex < this.cards.size(); cardIndex++)
			score += this.cards.get(cardIndex).getRank().getValue();
		if (score > 21)
			for (final Card card : this.cards)
				if (card.getRank() == Rank.ACE)
				{
					card.switchAceValue();
					score = 0;
					for (int cardIndex = 0; cardIndex < this.cards.size(); cardIndex++)
						score += this.cards.get(cardIndex).getRank().getValue();
					if (score <= 21)
						return score;
				}
		return score;
	}
}
