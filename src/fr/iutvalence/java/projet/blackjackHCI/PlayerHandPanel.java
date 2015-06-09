/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.Panel;
import java.util.List;

import javax.swing.JButton;

import fr.iutvalence.java.projet.blackjack.Card;
import fr.iutvalence.java.projet.blackjack.Hand;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 *
 */
public class PlayerHandPanel extends Panel
{
	
	private Player player;
	
	private boolean test;
	
	private List<Card> hand;
	private List<Card> subHand;
	
	
	public PlayerHandPanel(Player player)
	{
		this.player=player;
		
		if(this.player.getSplit())
		{
			this.hand=this.player.getMainHand().getCards();
			this.subHand=this.player.getSubHand().getCards();
			
			for(int i=0;i<hand.size();i++)
			{
				JButton button = new JButton(""+this.player.getMainHand().getCards().get(i));
				this.add(button);
				button.setEnabled(false);
			}
			for(int i=0;i<subHand.size();i++)
			{
				JButton button = new JButton(""+this.player.getSubHand().getCards().get(i));
				this.add(button);
				button.setEnabled(false);
			}
		}
		else
		{
			this.hand=this.player.getMainHand().getCards();
			
			for(int i=0;i<hand.size();i++)
			{
				JButton button = new JButton(""+this.player.getMainHand().getCards().get(i));
				this.add(button);
				button.setEnabled(false);
			}
		}
	}
	
}
