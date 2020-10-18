import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

// Main construction of the game.
@SuppressWarnings("serial")
public class GameConstructed extends JPanel implements KeyListener, ActionListener{
	private int [][] arr;
	private int [][] arrCheckRight;
	private int [][] arrCheckLeft;
	private int [][] arrCheckUp;
	private int [][] arrCheckDown;
	private int movesCount; // Keeps track of the valid moves made by the player.
	private InitializeGame startGame;
	private ArrowKeyFunction arrowDetect;
	private AddTwoOrFour addTwoOrFour;
	private YouWin winner;
	private YouLose loser;
	private Timer timer;
	private int delay = 2;
	
	@SuppressWarnings("static-access")
	public GameConstructed() {
		setBackground(Color.BLACK); // Window set to black color.
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
		// Keeps the grid of numbers the player sees in an array form.
		// All the calculations are made on this array.
		arr = new int [4][4];
		
		// Stores the most recent values of the entries of the grid of numbers when each of the arrow keys is pressed.
		arrCheckRight = new int [4][4];
		arrCheckLeft = new int [4][4];
		arrCheckUp = new int [4][4];
		arrCheckDown = new int [4][4];
		
		movesCount = 0; // Number of moves made by the player set to 0.
		
		arrowDetect = new ArrowKeyFunction();
		addTwoOrFour = new AddTwoOrFour();
		winner = new YouWin();
		startGame = new InitializeGame();
		loser = new YouLose();
		
		startGame.initializeGame(arr); // Initializes the game.
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension d = this.getSize();
		int num1 = 0, num2 = 0;
		
		// Places a 4x4 matrix on the screen.
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				g.setFont(new Font("serif", Font.BOLD, 30));
				if(arr[i][j] == 0) { // Sets color to gray for zero entries.
					g.setColor(Color.GRAY);
				}
				else {
					g.setColor(Color.RED); // Sets color to red for non-zero entries.
				}
				g.drawString("" + arr[i][j], (d.width/2)-150 + num1, ((d.height/2))-150 + num2);
				num1 += 100;
				if(j == 3) {
					num2 += 100;
					num1 = 0;
				}
			}
		}
		
		// Reminds the players on how to quit or restart the game.
		// Printed at the bottom of the screen.
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString("Press 'R' to RESTART or 'Q' to QUIT.", (d.width/2) - 500, ((d.height) - 50));
		
		// Prints the game title in a colorful way.
		g.setFont(new Font("Arial", Font.BOLD, 40));
		int gr = (int) (Math.random()*256);
		int bl = (int) (Math.random()*256);
		int re = (int) (Math.random()*256);
		Color col = new Color(re, gr, bl);
		g.setColor(col);
		g.drawString("2048 GAME", (getWidth()/2) - 70, (getHeight()/2) - 300);
		
		// Counts the number of moves made by the player live on the bottom of the screen.
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(Color.green);
		g.drawString("Moves: " + movesCount, (getWidth()/2) - 25, (getHeight()/2) + 250);

	}
	
	// Updates the screen every 2 milliseconds if there are any new moves made by the player.
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	// Keeps track of what happens when any of the arrow keys are typed.
	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		// Operates if the up arrow key is pressed.
		if (keyCode == KeyEvent.VK_UP) {
			System.out.print("Up arrow key pressed. "); // Informs that the up arrow key is pressed in the console.
			int[][] arrCopy = new int [4][4];
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCopy[i][j] = arr[i][j];
				}
			}
			arrowDetect.upArrow(arr); // Does the row manipulation when the up arrow key is pressed.
			winner.checkIfWinner(arr); // Checks if the player won the game.

			// Checks if new movements are made.
			// If so, increases the number of valid moves and adds 2 or 4 to a zero entry.
			// Also prints 'Valid Move' on the console.
			if(!Arrays.deepEquals(arr, arrCopy)) {
				System.out.println("Valid move.");
				addTwoOrFour.zeroReplaced(arr);
				movesCount++;
				System.out.println("Valid Moves Made: " + movesCount); // Prints the number of valid moves made on the console.
			}
			
			// If not, prints invalid move on the console.
			else {
				System.out.println("Inalid move.");
			}
			
			// Upgrades the array the keeps track of the values when the up key is pressed.
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCheckUp[i][j] = arr[i][j];
				}
			}
			loser.checkIfLoser(arrCheckRight, arrCheckLeft, arrCheckUp, arrCheckDown); // Checks if the player lost the game.
		}
		
		// Operates if the down arrow key is pressed.
		if (keyCode == KeyEvent.VK_DOWN) {
			System.out.print("Down arrow key pressed. "); // Informs that the down arrow key is pressed in the console.
			int[][] arrCopy = new int [4][4];
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCopy[i][j] = arr[i][j];
				}
				
			}
			
			arrowDetect.downArrow(arr); // Does the row manipulation when the down arrow key is pressed.
			winner.checkIfWinner(arr); // Checks if the player won the game.
			
			// Checks if new movements are made.
			// If so, increases the number of valid moves and adds 2 or 4 to a zero entry.
			// Also prints 'Valid Move' on the console.
			if(!Arrays.deepEquals(arr, arrCopy)) {
				System.out.println("Valid move.");
				addTwoOrFour.zeroReplaced(arr);
				movesCount++;
				System.out.println("Valid Moves Made: " + movesCount); // Prints the number of valid moves made on the console.
			}
			
			// If not, prints 'Invalid move'.
			else {
				System.out.println("Invalid move.");
			}
			
			// Upgrades the array the keeps track of the values when the down key is pressed.
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCheckDown[i][j] = arr[i][j];
				}
				
			}
			loser.checkIfLoser(arrCheckRight, arrCheckLeft, arrCheckUp, arrCheckDown); // Checks if the player lost the game.
		}
		
		// Operates if the right arrow key is pressed.
		if (keyCode == KeyEvent.VK_RIGHT) {
			System.out.print("Right arrow key pressed. "); // Informs that the right arrow key is pressed in the console.
			int[][] arrCopy = new int [4][4];
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCopy[i][j] = arr[i][j];
				}
				
			}
			
			arrowDetect.rightArrow(arr); // Does the row manipulation when the right arrow key is pressed.
			winner.checkIfWinner(arr); // Checks if the player won the game.
			
			// Checks if new movements are made.
			// If so, increases the number of valid moves and adds 2 or 4 to a zero entry.
			// Also prints 'Valid Move' on the console.
			if(!Arrays.deepEquals(arr, arrCopy)) {
				System.out.println("Valid move.");
				addTwoOrFour.zeroReplaced(arr);
				movesCount++;
				System.out.println("Valid Moves Made: " + movesCount); // Prints the number of valid moves made on the console.
			}
			
			// If not, prints 'Invalid move'.
			else {
				System.out.println("Invalid move.");
			}
			
			// Upgrades the array the keeps track of the values when the right key is pressed.
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCheckRight[i][j] = arr[i][j];
				}
				
			}
			loser.checkIfLoser(arrCheckRight, arrCheckLeft, arrCheckUp, arrCheckDown); // Checks if the player lost the game.
		}
		
		// Operates if the down arrow key is pressed.
		if (keyCode == KeyEvent.VK_LEFT) {
			System.out.print("Left arrow key pressed. "); // Informs that the left arrow key is pressed in the console.
			int[][] arrCopy = new int [4][4];
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCopy[i][j] = arr[i][j];
				}
				
			}
			
			arrowDetect.leftArrow(arr); // Does the row manipulation when the left arrow key is pressed.
			winner.checkIfWinner(arr); // Checks if the player won the game.
			
			// Checks if new movements are made.
			// If so, increases the number of valid moves and adds 2 or 4 to a zero entry.
			// Also prints 'Valid Move' on the console.
			if(!Arrays.deepEquals(arr, arrCopy)) {
				System.out.println("Valid move.");
				addTwoOrFour.zeroReplaced(arr);
				movesCount++;
				System.out.println("Valid Moves Made: " + movesCount); // Prints the number of valid moves made on the console.
			}
			
			// If not, prints 'Invalid move'.
			else {
				System.out.println("Inalid move.");
			}
			
			// Upgrades the array the keeps track of the values when the left key is pressed.
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arrCheckLeft[i][j] = arr[i][j];
				}
				
			}
			loser.checkIfLoser(arrCheckRight, arrCheckLeft, arrCheckUp, arrCheckDown); // Checks if the player lost the game.
		}
		
		// Operates if the 'Q' is pressed.
		if (keyCode == KeyEvent.VK_Q) {
			System.out.print("Letter 'Q' is pressed. "); // Informs that the letter 'Q' is pressed in the console.
			
			// Asks the player if he/she wants to quit the game.
			// If so, quits out of the game.
			int result = JOptionPane.showConfirmDialog((Component) null, "Are you sure you want to quit ?", "ALERT!!!", JOptionPane.OK_CANCEL_OPTION);
			if(result == 0) {
				System.out.println("Valid Moves Made: " + movesCount); // Prints the number of valid moves made on the console.
				System.exit(0);
			}
		}
		
		// Operates if the 'R' is pressed.
		if (keyCode == KeyEvent.VK_R) {
			System.out.print("Letter 'R' is pressed. "); // Informs that the letter 'R' is pressed in the console.
			
			// Asks the player if he/she wants to restart the game.
			// If so, sets the score to 0 and restarts the game.
			int result = JOptionPane.showConfirmDialog((Component) null, "Are you sure you want to restart ?", "ALERT!!!", JOptionPane.OK_CANCEL_OPTION);
			if(result == 0) {
				System.out.print("Valid Moves Made: " + movesCount); // Prints the number of valid moves made on the console.
				movesCount = 0;
				startGame.initializeGame(arr);
			}
		}
	}
}
