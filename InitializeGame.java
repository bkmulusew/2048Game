// Initializes the game.
// Prints two or four on two random entries and sets the remaining entries to zero. 
public class InitializeGame  {
	
	public static void initializeGame(int[][] arr) {
	    
		// Sets all the entries to zero.
		for(int a = 0; a < arr.length; a++) {
			for(int b = 0; b < arr[a].length; b++) {
				arr[a][b] = 0;
			}
		}
		
		// Generates two random coordinates (i, j) and (k, l).
		int i = (int)(Math.random()*4);
		int j = (int)(Math.random()*4);
		int k = (int)(Math.random()*4);
		int l = (int)(Math.random()*4);
		
		// Makes sure (i, j) is not equal to (k, l).
		while(i == k && j == l) {
			k = (int)(Math.random()*4);
			l = (int)(Math.random()*4);
		}
		
		int probability1 = (int)(Math.random() * 100);
		int probability2 = (int)(Math.random() * 100);
	    
		// 80% chance that 2 will be the value in (i, j).
		// 20% chance that 4 will be the value in (i, j).
	    if (probability1 <= 80) arr[i][j] = 2;
	    else arr[i][j] = 4;
	    
	    // 80% chance that 2 will be the value in (k, l).
	    // 20% chance that 4 will be the value in (i, j).
	    if (probability2 <= 80) arr[k][l] = 2;
	    else arr[k][l] = 4;
	}
}