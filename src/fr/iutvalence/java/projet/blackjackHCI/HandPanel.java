/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.Panel;

import javax.swing.JButton;

import fr.iutvalence.java.projet.blackjack.Hand;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 *
 */
public class HandPanel extends Panel
{
	
	private Player player;
	
	private boolean test;
	
	
	public HandPanel(Player player)
	{
		this.player=player;
		
		if(this.player.getSplit())
		{
			for(int i=0;i<2/*TODO change 11 to the number of card in the hand+1 */;i++)
			{
				JButton button = new JButton(""+this.player.getMainHand().getCards().get(i));
				this.add(button);
				button.setEnabled(false);
			}
			for(int i=0;i<2;i++)
			{
				JButton button = new JButton(""+this.player.getSubHand().getCards().get(i));
				this.add(button);
				button.setEnabled(false);
			}
		}
		else
		{
			for(int i=0;i<2;i++)
			{
				JButton button = new JButton(""+this.player.getMainHand().getCards().get(i));
				this.add(button);
				button.setEnabled(false);
			}
		}
	}
	
}
