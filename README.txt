Name: Beakal Lemeneh
Net ID: 31390484
Project Number: 01

I did not collaborate with anyone in this project.


This project is done by creating 5 subsystems, in the form of class, and combining into one whole system, class GameConstructed, to build this game. And I also used GUI to do this project.



Subsystem 1

YouWin class checks if the player has won the game. It iterates through the 2D matrix anytime an arrow key is pressed to check if any entry has the number 2048. If the number 2048 is present, then a message board pops on the screen congratulating the player.



Subsystem 2

YouLose class checks if the player has lost the game. This is done by keeping track of what the entries were when each of the arrow keys were pressed. Every time a player hits one of the arrow keys, the new values of the entries are updated in their respective storages. Since there are 4 arrow keys, 4 storages (arrays) are used to keep track of the values.

If there is no change in the values of the entries once all four of the arrow keys are pressed, meaning that all the 4 storages are equal, a message pops out of the screen telling the player he/she lost.



Subsystem 3

AddTwoOrFour class adds either 2, 80% chance, or 4, 20% chance, in one of the randomly selected zero entries of the game. This class just adds 2 or 4 in a zero entry. It doesn't check if the player made a valid move. Check for a valid move is made in class GameConstructed.



Subsystem 4

The class ArrowKeyFunction does all the manipulation of the table once any of the arrow keys are pressed. This is the class which adds two elements with the same value in a consecutive entry of the same row or column and brings all the non-zero elements to the right, left, top, or bottom based on which arrow key is pressed.



Subsystem 5

InitializeGame class is the class that prints either 2, 80% chance, or 4, 20% chance, by randomly choosing 2 entries and sets the remaining entries to zero. This class is mainly used to initialize the game once the player opens the window and to restart the game based on the players preference.



Class GameConstructed

This is the class where all the systems come together to build the game. All the GUI features are written in this class. Plus, this class runs on a 2 millisecond timer to constantly update the frame on which the game run on if there's any one the player has made. All the calculations are done on arrays on the backend and the final values are printed on the screen constantly.



Class PlayGame

The game is run from this class.



Message for the TA grading this project: Try playing this game on a full screen by maximizing the window for a better feature.


