package fr.iutvalence.java.projet.blackjack;

/**
 * 
 * @author Tajic
 * The exception when the player take an invalide choice
 */
public class InvalideChoiceException extends Exception
{
	/**
	 * Return the exception's message
	 * @param message the message to display
	 */
	public InvalideChoiceException(String message)
	{
		super(message);
	}
}
