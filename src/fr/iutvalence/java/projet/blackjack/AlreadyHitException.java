/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

/**
 * Exception when the player want to double
 * but he has already hit
 * @author DraikkaiZ
 */
public class AlreadyHitException extends Exception
{

	/**
	 * Take the message when the player want to double
	 * but he has already hit
	 * @param message the message to display
	 */
	public AlreadyHitException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

}
