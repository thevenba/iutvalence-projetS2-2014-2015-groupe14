/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * Exception of Ace in the method switchAceValue()
 * @author thevenba
 */
public class InvalidAceException extends Exception
{

	/**
	 * Return the exception's message
	 * @param message the message to display
	 */
	public InvalidAceException(String message)
	{
		super(message);
	}

}
