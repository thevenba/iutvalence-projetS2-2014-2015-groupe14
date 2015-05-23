/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

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
		Round round = new Round(player, dealer, deck);
		round.startRound();
	}
}
