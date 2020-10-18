import javax.swing.JFrame;

// Run this class to play the game.
public class PlayGame {
	public static void main(String [] args) {
		JFrame frame = new JFrame("2048 Game");
		GameConstructed playGame = new GameConstructed();
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(playGame);
		frame.pack();
	
	}
}
