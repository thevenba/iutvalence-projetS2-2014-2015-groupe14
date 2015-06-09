/**
 * 
 */
package fr.iutvalence.java.projet.blackjackHCI;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.iutvalence.java.projet.blackjack.Card;
import fr.iutvalence.java.projet.blackjack.Player;

/**
 * @author duboitho
 *
 */
public class SubHandPanel extends JPanel
{

	private Player player;
	private List<Card> subHand;	
	private JButton subButton = new JButton();
	
	public SubHandPanel(Player player){
		
		this.player=player;
		this.subHand=this.player.getSubHand().getCards();
		
		for(int i=0;i<subHand.size();i++)
		{
			JButton button = new JButton(""+this.player.getSubHand().getCards().get(i));
			this.add(button);
			button.setEnabled(true);
		}
	}
	
	public void refreshPlayerSubHand(){
		this.subHand=this.player.getSubHand().getCards();
		this.subButton.setText(""+this.player.getSubHand().getCards().get(subHand.size()-1));
		this.add(subButton);
	}
	
}
