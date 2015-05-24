/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author thevenba
 * The deck of game
 */
public class Deck
{
	/**
	 * List of cards
	 */
	private List<Card> cards;
	
	/**
	 * Constuctor of the deck
	 */
	public Deck()
	{
		this.cards = new ArrayList<>();
		this.cards.add(new Card(Suit.CLUBS, Rank.ACE));
		this.cards.add(new Card(Suit.CLUBS, Rank.KING));
		this.cards.add(new Card(Suit.CLUBS, Rank.QUEEN));
		this.cards.add(new Card(Suit.CLUBS, Rank.JACK));
		this.cards.add(new Card(Suit.CLUBS, Rank.TEN));
		this.cards.add(new Card(Suit.CLUBS, Rank.NINE));
		this.cards.add(new Card(Suit.CLUBS, Rank.EIGHT));
		this.cards.add(new Card(Suit.CLUBS, Rank.SEVEN));
		this.cards.add(new Card(Suit.CLUBS, Rank.SIX));
		this.cards.add(new Card(Suit.CLUBS, Rank.FIVE));
		this.cards.add(new Card(Suit.CLUBS, Rank.FOUR));
		this.cards.add(new Card(Suit.CLUBS, Rank.THREE));
		this.cards.add(new Card(Suit.CLUBS, Rank.TWO));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.KING));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.TEN));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.NINE));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.EIGHT));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.SEVEN));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.SIX));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.FIVE));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.FOUR));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
		this.cards.add(new Card(Suit.DIAMONDS, Rank.TWO));
		this.cards.add(new Card(Suit.HEARTS, Rank.ACE));
		this.cards.add(new Card(Suit.HEARTS, Rank.KING));
		this.cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
		this.cards.add(new Card(Suit.HEARTS, Rank.JACK));
		this.cards.add(new Card(Suit.HEARTS, Rank.TEN));
		this.cards.add(new Card(Suit.HEARTS, Rank.NINE));
		this.cards.add(new Card(Suit.HEARTS, Rank.EIGHT));
		this.cards.add(new Card(Suit.HEARTS, Rank.SEVEN));
		this.cards.add(new Card(Suit.HEARTS, Rank.SIX));
		this.cards.add(new Card(Suit.HEARTS, Rank.FIVE));
		this.cards.add(new Card(Suit.HEARTS, Rank.FOUR));
		this.cards.add(new Card(Suit.HEARTS, Rank.THREE));
		this.cards.add(new Card(Suit.HEARTS, Rank.TWO));
		this.cards.add(new Card(Suit.SPADES, Rank.ACE));
		this.cards.add(new Card(Suit.SPADES, Rank.KING));
		this.cards.add(new Card(Suit.SPADES, Rank.QUEEN));
		this.cards.add(new Card(Suit.SPADES, Rank.JACK));
		this.cards.add(new Card(Suit.SPADES, Rank.TEN));
		this.cards.add(new Card(Suit.SPADES, Rank.NINE));
		this.cards.add(new Card(Suit.SPADES, Rank.EIGHT));
		this.cards.add(new Card(Suit.SPADES, Rank.SEVEN));
		this.cards.add(new Card(Suit.SPADES, Rank.SIX));
		this.cards.add(new Card(Suit.SPADES, Rank.FIVE));
		this.cards.add(new Card(Suit.SPADES, Rank.FOUR));
		this.cards.add(new Card(Suit.SPADES, Rank.THREE));
		this.cards.add(new Card(Suit.SPADES, Rank.TWO));
	}
	
	/**
	 *  Give a random card
	 * @return a random card
	 */
	public Card randomCard()
	{
		Collections.shuffle(cards);
		return this.cards.remove(0);
	}
}
