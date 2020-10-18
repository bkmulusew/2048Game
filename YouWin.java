import java.awt.Component;
import javax.swing.JOptionPane;

// Checks if the player won the game.
@SuppressWarnings("unused")
public class YouWin {
	public static void checkIfWinner(int[][] arr) {
		
		// Checks if 2048 is present in any entry of the array.
		// If so, it prints a congratulation message to the player.
		// Also reminds the player to restart or quit the game.
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 2048) {
					JOptionPane.showMessageDialog(null, "Congrats!!! You've won!!!\\nPress 'R' to RESTART or 'Q' to QUIT.");
				}
			}
			
		}
		
	}

}
