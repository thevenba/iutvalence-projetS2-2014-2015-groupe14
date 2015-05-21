/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * @author thevenba
 *
 */
public class Card
{
	private Suit suit;
	
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	/**
	 * @return the rank
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	/**
	 * @throws InvalidAceException 
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
	
}
	
