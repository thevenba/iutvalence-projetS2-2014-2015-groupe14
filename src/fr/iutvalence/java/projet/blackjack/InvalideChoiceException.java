package fr.iutvalence.java.projet.blackjack;

/**
 * 
 * @author Tajic
 * The exception when the player take an invalide choice
 */
public class InvalideChoiceException extends Exception
{
	public InvalideChoiceException(String message)
	{
		super(message);
	}
}
