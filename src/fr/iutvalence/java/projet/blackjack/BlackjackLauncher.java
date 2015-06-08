/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import javax.swing.SwingUtilities;

/**
 * Launch a game.
 * 
 * @author thevenba
 *
 */
public class BlackjackLauncher
{
	/**
	 * private and empty constructor.
	 */
	private BlackjackLauncher()
	{
		/* NOTHING */
	}

	/**
	 * Where the application starts.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args)
	{
		Player player = new Player();
		Dealer dealer = new Dealer();
		Deck deck = new Deck();
		DisplayTask displayTask = new DisplayTask(dealer, deck, player);
		SwingUtilities.invokeLater(displayTask);
	}
}
