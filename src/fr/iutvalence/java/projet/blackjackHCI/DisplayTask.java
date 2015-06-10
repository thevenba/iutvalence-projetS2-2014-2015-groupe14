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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(true);
			this.playerPanel.getPlayerDisplay().getBetAndBudgetPanel().refresh();
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal())
		{
			this.player.deal(deck);
			this.dealer.getHand().hit(deck);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOne().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFive().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetTwentyFive().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetOneHundred().setEnabled(false);
			this.playerPanel.getPlayerControl().getBetButtonsPanel().getBetFiveHundred().setEnabled(false);
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getDeal().setEnabled(false);
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getHit().setEnabled(true);
			this.playerPanel.getPlayerControl().getActionButtonsPanel().getStand().setEnabled(true);
			this.playerPanel.getPlayerDisplay().getHandPanel().getMainHandPanel().refreshPlayerMainHand();
			this.dealerPanel.getDealersCards().refreshDealerHand();
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getHit())
		{
			if (this.currentHand == this.player.getMainHand())
			{
				/** TODO pouvoir relancer un round, une partie
				 * reset l'interface
				 */
				this.player.getMainHand().hit(deck);
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
				this.player.getSubHand().hit(deck);
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
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getInsurrance())
		{
			
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getSplit())
		{
			
		}
		else if (source == this.playerPanel.getPlayerControl().getActionButtonsPanel().getStand())
		{
			while (this.dealer.getHand().reckonScore() <= 16)
			{
				this.dealer.getHand().hit(this.deck);
				this.dealerPanel.getDealersCards().refreshDealerHand();
			}
			if (this.dealer.getHand().reckonScore() > 21)
				JOptionPane.showMessageDialog(window,
					    "Dealer is going bust !",
					    "Win",
					    JOptionPane.PLAIN_MESSAGE);
			else if (this.player.getMainHand().reckonScore() > this.dealer.getHand().reckonScore())
				JOptionPane.showMessageDialog(window,
					    "Winner, winner, chicken dinner",
					    "Win",
					    JOptionPane.PLAIN_MESSAGE);
			else if (this.player.getMainHand().reckonScore() == this.dealer.getHand().reckonScore())
				JOptionPane.showMessageDialog(window,
					    "Push",
					    "Push",
					    JOptionPane.PLAIN_MESSAGE);
			else
				JOptionPane.showMessageDialog(window,
					    "You are going bust !",
					    "Busting",
					    JOptionPane.PLAIN_MESSAGE);
				
		}
	}
}
