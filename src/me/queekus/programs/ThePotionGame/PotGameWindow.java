package me.queekus.programs.ThePotionGame;
import javax.swing.*;

public class PotGameWindow  extends JFrame{
	JPanel pnl = new JPanel();
		
	public PotGameWindow(String title, int x, int y){
		super(title);
		setSize(x,y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		setVisible(true);
	}
	
}
