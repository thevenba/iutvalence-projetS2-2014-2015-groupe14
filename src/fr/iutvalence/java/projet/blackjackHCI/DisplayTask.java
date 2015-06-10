/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import fr.iutvalence.java.projet.blackjack.AlreadyHitException;
import fr.iutvalence.java.projet.blackjack.BudgetNotEnoughException;
import fr.iutvalence.java.projet.blackjack.Dealer;
import fr.iutvalence.java.projet.blackjack.Deck;
import fr.iutvalence.java.projet.blackjack.Hand;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author thevenba
 *
 */
public class DisplayTask implements Runnable, ActionListener
{
	private Dealer dealer;
	private Deck deck;
	private Player player;
	private Hand currentHand;
	private JFrame window;
	private DealerPanel dealerPanel;
	private PlayerPanel playerPanel;
	private JSplitPane separator;
	
	
	public DisplayTask(Dealer dealer, Deck deck, Player player)
	{
		this.dealer = dealer;
		this.deck = deck;
		this.player = player;
		this.currentHand = player.getMainHand();
	}

	@Override
	public void run()
	{
		this.initGraphicInterface();		
	}

	private void initGraphicInterface()
	{
		this.window = new JFrame();
		this.window.setTitle("Black Jack");
		this.window.setSize(1280, 720);
		this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.window.setResizable(false);
		this.dealerPanel = new DealerPanel(dealer);
		this.playerPanel = new PlayerPanel(this.player,this);
		this.separator = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.dealerPanel, this.playerPanel);
		this.separator.setEnabled(false);
		this.separator.setResizeWeight(0.1);
		this.window.getContentPane().add(this.separator);
		this.window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		JButton source = (JButton) event.getSource();
		if (source == this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOne())
		{
			try
			{
				this.player.setBetOne();
			} catch (BudgetNotEnoughException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(true);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
		}
		else if (source == this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFive())
		{
			try
			{
				this.player.setBetFive();
			} catch (BudgetNotEnoughException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(true);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
		}
		else if (source == this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetTwentyFive())
		{
			try
			{
				this.player.setBetTwentyFive();
			} catch (BudgetNotEnoughException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(true);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
		}
		else if (source == this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOneHundred())
		{
			try
			{
				this.player.setBetOneHundred();
			} catch (BudgetNotEnoughException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(true);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
		}
		else if (source == this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFiveHundred())
		{
			try
			{
				this.player.setBetFiveHundred();
			} catch (BudgetNotEnoughException e)
			{
				JOptionPane.showMessageDialog(window,
					    e.toString(),
					    "Inane warning",
					    JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(true);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal())
		{
			this.player.deal(this.deck);
			this.dealer.getHand().hit(this.deck);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOne().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFive().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetTwentyFive().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOneHundred().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFiveHundred().setEnabled(false);
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(false);
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getHit().setEnabled(true);
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getStand().setEnabled(true);
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDoubleDown().setEnabled(true);
			this.player.getMainHand().reckonScore();
			this.playerPanel.getPlayerDisplay().getHandPanel().getMainHandPanel().refreshPlayerMainHand();
			this.dealerPanel.getDealersCards().refreshDealerHand();
			if (dealer.hand.getCards().size() == 1 )
			{
				/*if (dealer.getHand().reckonScore() == 11)
				{*/
					this.playerPanel.getPlayerControl().getActionButtonsPanel().getInsurrance().setEnabled(true);
				/*}*/
			}
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getHit())
		{
			if (this.currentHand == this.player.getMainHand())
			{
				/** TODO pouvoir relancer un round, une partie
				 * reset l'interface
				 */
				this.player.getMainHand().hit(this.deck);
				int score = this.player.getMainHand().reckonScore();
				this.playerPanel.getPlayerDisplay().getHandPanel().getMainHandPanel().refreshPlayerMainHand();
				if (score > 21)
				{
					JOptionPane.showMessageDialog(window,
						    "You are going bust !",
						    "Busting",
						    JOptionPane.PLAIN_MESSAGE);
				}
			}
			else
			{
				/** TODO pouvoir relancer un round, une partie
				 * reset l'interface
				 */
				this.player.getSubHand().hit(this.deck);
				int score = this.player.getSubHand().reckonScore();
				if (score > 21)
				{
					JOptionPane.showMessageDialog(window,
						    "You are going bust !",
						    "Busting",
						    JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getDoubleDown())
		{
			if (this.currentHand == this.player.getMainHand())
			{
				try
				{
					this.player.doubleDownMainHand(this.deck);
				} catch (AlreadyHitException | BudgetNotEnoughException e)
				{
					JOptionPane.showMessageDialog(window,
						    e.toString(),
						    "Inane warning",
						    JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
				this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
				int score = this.player.getMainHand().reckonScore();
				this.playerPanel.getPlayerDisplay().getHandPanel().getMainHandPanel().refreshPlayerMainHand();
				this.playerPanel.getPlayerControl().getActionButtonsPanel().getHit().setEnabled(false);
				if (score > 21)
				{
					Object[] choices = {"Next Round", "New Game", "Quit"};
					String s = (String)JOptionPane.showInputDialog(this.window,
							"You are going bust !",
						    "Busting", JOptionPane.PLAIN_MESSAGE, null, choices, "Next Round");;
				    if (s == "Next Round")
				    {
				    	this.nextRound();
				    }
				    else if (s == "New Game")
				    {
				    	this.newGame();
				    }
				    else
				    {
				    	System.exit(0);
				    }
				}
			}
			else
			{
				/** TODO faire avec deuxieme main */
			}
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getInsurrance())
		{
			try{
				this.player.insurance();
			}catch(BudgetNotEnoughException e)
			{
				JOptionPane.showMessageDialog(window,
					    "You can't do that fella !",
					    "Wrong action",
					    JOptionPane.PLAIN_MESSAGE);
			}
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDoubleDown().setEnabled(false);

		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getSplit())
		{
			
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getStand())
		{
			this.proceed();
		}
	}
	
	public void proceed()
	{
		while (this.dealer.getHand().reckonScore() <= 16)
		{
			this.dealer.getHand().hit(this.deck);
			this.dealerPanel.getDealersCards().refreshDealerHand();
		}
		if (this.dealer.getHand().reckonScore() > 21)
		{
			this.player.setBudget(this.player.getMainHand().getBet()*2);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
			Object[] choices = {"Next Round", "New Game", "Quit"};
			String s = (String)JOptionPane.showInputDialog(this.window,
					"Dealer is going bust !",
				    "Win", JOptionPane.PLAIN_MESSAGE, null, choices, "Next Round");;
		    if (s == "Next Round")
		    {
		    	this.nextRound();
		    }
		    else if (s == "New Game")
		    {
		    	this.newGame();
		    }
		    else
		    {
		    	System.exit(0);
		    }
		}
		else if (this.player.getMainHand().reckonScore() > this.dealer.getHand().reckonScore())
		{
			this.player.setBudget(this.player.getMainHand().getBet()*2);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
			Object[] choices = {"Next Round", "New Game", "Quit"};
			String s = (String)JOptionPane.showInputDialog(this.window,
					"Winner, winner, chicken dinner",
				    "Win", JOptionPane.PLAIN_MESSAGE, null, choices, "Next Round");;
		    if (s == "Next Round")
		    {
		    	this.nextRound();
		    }
		    else if (s == "New Game")
		    {
		    	this.newGame();
		    }
		    else
		    {
		    	System.exit(0);
		    }
		}
		else if (this.player.getMainHand().reckonScore() == this.dealer.getHand().reckonScore())
		{
			this.player.setBudget(this.player.getMainHand().getBet());
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
			Object[] choices = {"Next Round", "New Game", "Quit"};
			String s = (String)JOptionPane.showInputDialog(this.window,
					"Push",
				    "Push", JOptionPane.PLAIN_MESSAGE, null, choices, "Next Round");;
		    if (s == "Next Round")
		    {
		    	this.nextRound();
		    }
		    else if (s == "New Game")
		    {
		    	this.newGame();
		    }
		    else
		    {
		    	System.exit(0);
		    }
		} 
		
		else
		{
			Object[] choices = {"Next Round", "New Game", "Quit"};
			String s = (String)JOptionPane.showInputDialog(this.window,
					"You are going bust !",
				    "Busting", JOptionPane.PLAIN_MESSAGE, null, choices, "Next Round");;
		    if (s == "Next Round")
		    {
		    	
		    	this.nextRound();
		    }
		    else if (s == "New Game")
		    {
		    	this.newGame();
		    }
		    else
		    {
		    	System.exit(0);
		    }
		}	
	}
	
	public void nextRound()
	{
		this.player.resetHand();
		this.dealer.resetHand();
		this.dealerPanel.getDealersCards().removeAll();
		this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
		this.playerPanel.getPlayerDisplay().getHandPanel().getMainHandPanel().refreshPlayerMainHand();
		this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOne().setEnabled(true);
		this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFive().setEnabled(true);
		this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetTwentyFive().setEnabled(true);
		this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOneHundred().setEnabled(true);
		this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFiveHundred().setEnabled(true);
		this.playerPanel.getPlayerControl().getActionButtonsPanel().getHit().setEnabled(false);
		this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(false);
		this.playerPanel.getPlayerControl().getActionButtonsPanel().getDoubleDown().setEnabled(false);
		this.playerPanel.getPlayerControl().getActionButtonsPanel().getSplit().setEnabled(false);
		this.playerPanel.getPlayerControl().getActionButtonsPanel().getInsurrance().setEnabled(false);
		this.playerPanel.getPlayerControl().getActionButtonsPanel().getStand().setEnabled(false);
	}
	
	public void newGame()
	{
		this.deck = new Deck();
		this.player = new Player();
		this.currentHand = this.player.getMainHand();
		this.nextRound();
	}
}
