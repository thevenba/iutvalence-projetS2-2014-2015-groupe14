/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

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
		System.out.println("J'ai reçu une nouvelle carte : " +player.hit());
		System.out.println("J'ai reçu une nouvelle carte : " +player.hit());
	}

}
