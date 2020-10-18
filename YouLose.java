import java.awt.Component;
import java.util.Arrays;
import javax.swing.JOptionPane;

//Checks if the player lose the game.
@SuppressWarnings("unused")
public class YouLose {
	public static void checkIfLoser(int[][] arr1, int[][] arr2, int[][] arr3, int[][] arr4) {
		
		// Every time a player hits one of the arrow keys, the new values are stored in an array. Since there are 4 arrow keys, 4 arrays are used to keep track of the values.
		// Therefore, this function checks if all the 4 arrays are equal. Meaning no change or no more new move can be made by pressing the arrow keys.
		// If so, it prints a message telling that player that he/she has no more moves.
		// Also reminds the player to restart or quit the game.
		if(Arrays.deepEquals(arr1, arr2) && Arrays.deepEquals(arr2, arr3) && Arrays.deepEquals(arr3, arr4)) {
			JOptionPane.showMessageDialog(null, "No more moves left!!! You've lost!!!\nPress 'R' to RESTART or 'Q' to QUIT.");
		}
		
	}

}