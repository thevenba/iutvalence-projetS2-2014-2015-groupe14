/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.awt.Panel;

import javax.swing.JButton;

import fr.iutvalence.java.projet.blackjack.Hand;

/**
 * @author duboitho
 *
 */
public class HandPanel extends Panel
{
	private Hand hand;
	
	
	public HandPanel(Hand hand)
	{
		for(int i=0;i<11;i++)
		{
			JButton button = new JButton(""+this.hand.getCards().get(i));
			this.add(button);
			button.setEnabled(false);
		}
	}
}
