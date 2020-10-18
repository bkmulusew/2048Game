// This class adds either 2 or 4 in one of the randomly selected zero entries of the game.
// This program just adds 2 or 4. It doesn't check if the player made a valid move.
// Check for a valid move is made in class GameConstructed.
@SuppressWarnings("unused")
public class AddTwoOrFour {
	
	public static void zeroReplaced(int[][] arr) {
		int count = 0;
		int[] tempArr1 = new int[16];
		int[] tempArr2 = new int[16];
		
		// Finds out the empty entries in the game, and stores their indexes in another array. 
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) {
					tempArr1[count] = i;
					tempArr2[count] = j;
					count++;
				}
			}
		}
		int rnd = (int)(Math.random() * (count)); // Selects random zero entry to add either 2 or 4.
		int r = (int)(Math.random() * 100);
	    
	    // 80% chance that 2 is added to a zero entry.
	    // 20% chance that 4 is added to a zero entry.
	    if (r <= 80) arr[tempArr1[rnd]][tempArr2[rnd]] = 2;
	    else arr[tempArr1[rnd]][tempArr2[rnd]] = 4;
	    
	}

}
