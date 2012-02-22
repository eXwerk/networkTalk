/*
.__.__.__.__.__.
|  | x|  |  |  |	
|__|__|__|__|__|			  SCORES
| o| x|  |  |  |	   .--------.--------.
|__|__|__|__|__|	   |Player 1|Player 2|
| o| x| o|  | o|	   -------------------
|__|__|__|__|__|	   |	 2  |  0	 |
| o| x| x| o| o|	   -------------------
|__|__|__|__|__|		      
| x| x| o| x| o|
|__|__|__|__|__|	'Player 1 it's your turn!'
 */

package five_in_a_row;

import java.util.Arrays;

public class Grid {
	
	public enum State {
		FREE, ME, YOU, DEBUG;
		
		public String toString() {
			switch (this) {
			case ME:
				return "x";
			case YOU:
				return "o";
			case FREE:
				return " ";
			case DEBUG:
				return "#";
			}
			return null;
		}
	}

	public int limiter;
	public State[][] grid;
	
	public Grid() {
		limiter = 8;
		grid = new State[limiter][limiter];
		
		for (State[] row : grid) {
			Arrays.fill(row, State.DEBUG);
		}
	}
	
	public void setCoin(int column) throws InterruptedException {
		int row = 0;
		while (row < grid.length) {
			if (grid[row][column] == State.DEBUG) {
				grid[row][column] = State.ME;
				clearConsole();
				printGrid();
				System.out.println("\n");
				Thread.sleep(500);
				grid[row][column] = State.DEBUG;
				row++;				
			}
			//TODO: Endlosschleife hier
		}
//		grid[row][column] = State.ME;
//		clearConsole();
//		printGrid();
	}

	public void printGrid() {
		int i = 0;
		String test = "";
		
		for (State[] row : grid) {
			while (i  < row.length) {
				test = test + row[i];
				i++;
			}
			System.out.println(test);
			i = 0;
			test = "";
		}		
	}
	
    public void clearConsole() {
        for (int i = 0; i < 25; i++) {
        	System.out.println("\n");
        }
    }

	public static void main(String[] args) throws InterruptedException {
		Grid grid = new Grid();
		//line, row(starting with 0)
//		for (int i = 0; i < 5; i++) {
//			grid.clearConsole();
//			grid.setCoin(i, 0);
//			grid.printGrid();
//			Thread.sleep(500);
//		}
		grid.grid[7][0] = State.ME;
		grid.setCoin(0);
		System.out.println("--------------------");
		grid.grid[6][0] = State.ME;
		grid.setCoin(0);		
//		grid.printGrid();
	}
}
