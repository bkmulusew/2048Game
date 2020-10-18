// This class does all the manipulation of the table once any of the arrow keys are pressed.
public class ArrowKeyFunction {
	
	// RIGHT ARROW KEY
	public static void rightArrow(int [][] arr) {
		
		// Brings all the non-zero elements to the right.
		for(int i = 0; i < arr.length; i++) {
			int cnt = arr[i].length - 1;
			for(int j = arr[i].length - 1; j >= 0; j--) {
				if(arr[i][j] != 0) {
					arr[i][cnt] = arr[i][j];
            			cnt--;
				}
			}
			while (cnt >= 0) {
				arr[i][cnt] = 0;
				cnt--;
			}
		}
		
		// Adds two elements with the same value in a consecutive entry of the same row.
		// Addition from left to right.
		for(int a = 0; a < arr.length; a++) {
			for(int b = arr[a].length - 1; b > 0; b--) {
				if(arr[a][b] == arr[a][b - 1]) {
					arr[a][b] = arr[a][b] + arr[a][b - 1];
					arr[a][b - 1] = 0;
				}
			}
		}
		
		// Brings all the non-zero elements to the right if some are left behind during the addition process.
		for(int i = 0; i < arr.length; i++) {
			int cnt = arr[i].length - 1;
			for(int j = arr[i].length - 1; j >= 0; j--) {
				if(arr[i][j] != 0) {
					arr[i][cnt] = arr[i][j];
            			cnt--;
				}
			}
			while (cnt >= 0) {
				arr[i][cnt] = 0;
				cnt--;
			}
		}
	}
		
	// LEFT ARROW KEY
	public static void leftArrow(int [][] arr) {
		
		// Brings all the non-zero elements to the left.
		for(int i = 0; i < arr.length; i++) {
			int cnt = 0;
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 0) {
					arr[i][cnt] = arr[i][j];
            			cnt++;
				}
			}
			while (cnt < arr.length) {
				arr[i][cnt] = 0;
				cnt++;
			}
		}
		
		// Adds two elements with the same value in a consecutive entry of the same row.
		// Addition from right to left.
		for(int a = 0; a < arr.length; a++) {
			for(int b = 0; b < arr[a].length - 1; b++) {
				if(arr[a][b] == arr[a][b + 1]) {
					arr[a][b] = arr[a][b] + arr[a][b + 1];
					arr[a][b + 1] = 0;
				}
			}
		}
		
		// Brings all the non-zero elements to the left if some are left behind during the addition process.
		for(int i = 0; i < arr.length; i++) {
			int cnt = 0;
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 0) {
					arr[i][cnt] = arr[i][j];
            			cnt++;
				}
			}
			while (cnt < arr.length) {
				arr[i][cnt] = 0;
				cnt++;
			}
		}
	}
		
	// UP ARROW KEY
	public static void upArrow(int [][] arr) {
		
		// Brings all the non-zero elements to the top.
		for(int i = 0; i < arr.length; i++) {
			int cnt = 0;
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[j][i] != 0) {
					arr[cnt][i] = arr[j][i];
            			cnt++;
				}
			}
			while (cnt < arr.length) {
				arr[cnt][i] = 0;
				cnt++;
			}
		}
		
		// Adds two elements with the same value in a consecutive entry of the same column.
		// Addition from top to bottom.
		for(int a = 0; a < arr.length; a++) {
			for(int b = 0; b < arr[a].length - 1; b++) {
				if(arr[b][a] == arr[b + 1][a]) {
					arr[b][a] = arr[b][a] + arr[b + 1][a];
					arr[b + 1][a] = 0;
				}
			}
		}
		
		// Brings all the non-zero elements to the top if some are left behind during the addition process.
		for(int i = 0; i < arr.length; i++) {
			int cnt = 0;
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[j][i] != 0) {
					arr[cnt][i] = arr[j][i];
            			cnt++;
				}
			}
			while (cnt < arr.length) {
				arr[cnt][i] = 0;
				cnt++;
			}
		}
	}

	// DOWN ARROW KEY
	public static void downArrow(int [][] arr) {
		
		// Brings all the non-zero elements to the bottom.
		for(int i = 0; i < arr.length; i++) {
			int cnt = arr[i].length - 1;
			for(int j = arr[i].length - 1; j >= 0; j--) {
				if(arr[j][i] != 0) {
					arr[cnt][i] = arr[j][i];
            			cnt--;
				}
			}
			while (cnt >= 0) {
				arr[cnt][i] = 0;
				cnt--;
			}
		}
		
		// Adds two elements with the same value in a consecutive entry of the same column.
		// Addition from bottom to top.
		for(int a = 0; a < arr.length; a++) {
			for(int b = arr[a].length - 1; b > 0; b--) {
				if(arr[b][a] == arr[b - 1][a]) {
					arr[b][a] = arr[b][a] + arr[b - 1][a];
					arr[b - 1][a] = 0;
				}
			}
		}
		
		// Brings all the non-zero elements to the bottom if some are left behind during the addition process.
		for(int i = 0; i < arr.length; i++) {
			int cnt = arr[i].length - 1;
			for(int j = arr[i].length - 1; j >= 0; j--) {
				if(arr[j][i] != 0) {
					arr[cnt][i] = arr[j][i];
            			cnt--;
				}
			}
			while (cnt >= 0) {
				arr[cnt][i] = 0;
				cnt--;
			}
		}
	}
}
