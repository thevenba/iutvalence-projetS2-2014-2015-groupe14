/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 * Representation of all cards.
 */
public class Card
{
	private Suit suit;
	
	private Rank rank;
	
	/**
	 * Give a suit and a rank to the card
	 * @param suit the suit of the card
	 * @param rank the rank of the card
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Get the card's rank
	 * @return rank the card's rank
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * Switch the Ace's value or an exception if the player doesn't have Ace.
	 * @throws InvalidAceException the exception if the card's rank isn't a Ace 
	 */
	public void switchAceValue() throws InvalidAceException
	{
		if (this.rank != Rank.ACE)
			throw new InvalidAceException("This card is not an ACE");
		if (this.rank.getValue() == 1)
			this.rank.setValue(11);
		else
			this.rank.setValue(1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}
	
	
	
}
	
