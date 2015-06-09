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
	
	private List<Card> mainHand;
	private List<Card> subHand;
	
	
	public PlayerHandPanel(Player player)
	{
		this.player=player;
		this.mainHand=this.player.getMainHand().getCards();	
		this.subHand=this.player.getSubHand().getCards();
		
		if(this.subHand.size() != 0)
		{
					
			for(int i=0;i<mainHand.size();i++)
			{
				JButton button = new JButton(""+this.player.getMainHand().getCards().get(i));
				this.add(button);
				button.setEnabled(true);
			}
			for(int i=0;i<subHand.size();i++)
			{
				JButton button = new JButton(""+this.player.getSubHand().getCards().get(i));
				this.add(button);
				button.setEnabled(true);
			}
		}
		else
		{			
			for(int i=0;i<mainHand.size();i++)
			{
				JButton button = new JButton(""+this.player.getMainHand().getCards().get(i));
				this.add(button);
				button.setEnabled(true);
			}
		}
	}
	
}
