/**
 * 
 */
package fr.iutvalence.java.projet.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

/** TODO A remplacer par une 'vraie' IHM
 */

/**
 * @author thevenba
 *
 */
public class Round
{
	private Player player;
	private Dealer dealer;
	private Deck deck;
	
	/**
	 * @param player
	 * @param dealer
	 * @param deck
	 */
	public Round(Player player, Dealer dealer, Deck deck)
	{
		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
	}
	
	public void startRound()
	{
		player.resetHand();
		dealer.resetHand();
		firstBetChoice();
		otherBetChoices();
		this.dealer.hit(this.deck);
		cardChoice();
		while (this.dealer.reckonScore() <= 16)
			this.dealer.hit(this.deck);
		if (this.dealer.reckonScore() > 21)
		{
			System.out.println("Dealer is going bust !");
			win();
		}
		else if (this.player.reckonScore() > this.dealer.reckonScore()) 
			win();
		else if (this.player.reckonScore() == this.dealer.reckonScore())
		{
			/* TODO egalite */
			System.out.println("Egalité");
		}
		else
			busting();
	}
	
	/**
	 * @param player
	 */
	private void firstBetChoice()
	{
		displayRound();
		System.out.println("What do you want :\n");
		System.out.println("1 : Bet 1\n");
		System.out.println("2 : Bet 5\n");
		System.out.println("3 : Bet 25\n");
		System.out.println("4 : Bet 100\n");
		System.out.println("5 : Bet 500\n");
		Scanner ChoiceScan = new Scanner(System.in);
		int Choice = 0;
		try
		{
			Choice = ChoiceScan.nextInt();
		} catch (InputMismatchException e)
		{
		}
		switch (Choice)
		{
			case 1:
				try
				{
					this.player.setBetOne();
				} catch (BudgetNotEnoughException e2)
				{
					e2.printStackTrace();
				}
				break;
			case 2:
				try
				{
					this.player.setBetFive();
				} catch (BudgetNotEnoughException e2)
				{
					e2.printStackTrace();
				}
				break;
			case 3:
				try
				{
					this.player.setBetTwentyFive();
				} catch (BudgetNotEnoughException e2)
				{
					e2.printStackTrace();
				}
				break;
			case 4:
				try
				{
					this.player.setBetOneHundred();
				} catch (BudgetNotEnoughException e2)
				{
					e2.printStackTrace();
				}
				break;
			case 5:
				try
				{
					this.player.setBetFiveHundred();
				} catch (BudgetNotEnoughException e2)
				{
					e2.printStackTrace();
				}
				break;
			default:
				System.out.println("You must type a number between 1 and 5");
				firstBetChoice();
		};
	}

	/**
	 * @param player
	 * @param deck
	 */
	private void otherBetChoices()
	{
		while(true)
		{
			displayRound();
			System.out.println("What do you want :\n");
			System.out.println("1 : Bet 1\n");
			System.out.println("2 : Bet 5\n");
			System.out.println("3 : Bet 25\n");
			System.out.println("4 : Bet 100\n");
			System.out.println("5 : Bet 500\n");
			System.out.println("6 : Deal\n");
			Scanner choiceScan = new Scanner(System.in);
			int choice = 0;
			try
			{
				choice = choiceScan.nextInt();
			} catch (InputMismatchException e)
			{
			}
			switch (choice)
			{
				case 1:
					try
					{
						this.player.setBetOne();
					} catch (BudgetNotEnoughException e2)
					{
						e2.printStackTrace();
					}
					break;
				case 2:
					try
					{
						this.player.setBetFive();
					} catch (BudgetNotEnoughException e2)
					{
						e2.printStackTrace();
					}
					break;
				case 3:
					try
					{
						this.player.setBetTwentyFive();
					} catch (BudgetNotEnoughException e2)
					{
						e2.printStackTrace();
					}
					break;
				case 4:
					try
					{
						this.player.setBetOneHundred();
					} catch (BudgetNotEnoughException e2)
					{
						e2.printStackTrace();
					}
					break;
				case 5:
					try
					{
						this.player.setBetFiveHundred();
					} catch (BudgetNotEnoughException e2)
					{
						e2.printStackTrace();
					}
					break;
				case 6:
					this.player.deal(deck);
					break;
				default:
					System.out.println("You must type a number between 1 and 6");
					otherBetChoices();
			}
			if (choice == 6)
				break;
		}
	}

	private void cardChoice()
	{
		while(true)
		{
			displayRound();
			System.out.println("What do you want :\n");
			System.out.println("1 : Stand\n");
			System.out.println("2 : Hit\n");
			System.out.println("3 : Double");
			Scanner choiceScan = new Scanner(System.in);
			int choice = 0;
			try
			{
				choice = choiceScan.nextInt();
			} catch (InputMismatchException e)
			{
			}
			switch (choice)
			{
				case 1:
					break;
				case 2:
					this.player.hit(deck);
					break;
				case 3:
					try
					{
						this.player.doubleDown(deck);
					} catch (BudgetNotEnoughException e2)
					{
						e2.printStackTrace();
						cardChoice();
					}
					break;
				default:
					System.out.println("You must type a number between 1 and 3");
					cardChoice();
			}
			if (this.player.reckonScore() > 21)
			{
				busting();
				return;
			}
			if ((choice == 1 || choice == 3))
			{
				break;
			}
		}
	}

	private void busting()
	{
		displayRound();
		System.out.println("You are going bust !");
		this.player.resetBet();
		tryAgain();
	}

	private void win()
	{
		displayRound();
		System.out.println("Winner, winner, chicken dinner");
		this.player.setBudget(player.getBet()*2);
		this.player.resetBet();
		tryAgain();
	}

	/**
	 * 
	 */
	private void tryAgain()
	{
		System.out.println("Try again ?");
		System.out.println("1 : YES\n2 : NO");
		Scanner choiceScan = new Scanner(System.in);
		int choice = 0;
		try
		{
			choice = choiceScan.nextInt();
		} catch (InputMismatchException e)
		{
		}
		if (choice == 1)
			startRound();
		else
			System.exit(0);
	}
	
	private void displayRound()
	{
		System.out.println(this.player+"\n");
		System.out.println(this.dealer);
	}
	
}
