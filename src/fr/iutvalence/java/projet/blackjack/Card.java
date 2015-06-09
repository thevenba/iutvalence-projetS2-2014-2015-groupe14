/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * Game's cards
 * @author thevenba
 */
public class Card
{
	/** Card's suit */
	private Suit suit;
	
	/** Card's rank */
	private Rank rank;
	
	/**
	 * Create a card with a suit and a rank 
	 * @param suit the card's suit
	 * @param rank the card's rank
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Get the rank of the card
	 * @return rank the rank of the card
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * Switch the Ace's value or return an exception
	 * @throws InvalidAceException The exception if the player doesn't have an ace
	 * 
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
	
