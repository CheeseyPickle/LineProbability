import java.util.ArrayList;

public class DiceGame {

	public static int trial() {
		int[][] board = new int[6][6];
		int realX = (int) (Math.random() * 6);
		int realY = (int) (Math.random() * 6);
		int rounds = 0;
		boolean playing = true;
		// System.out.println("We've rolled " + (realX + 1) + ", " + (realY + 1));
		do {
			rounds++;

			// Guessing
			select: for (int r = 0; r < 6; r++) {
				for (int c = 0; c < 6; c++) {
					if (board[r][c] == 0) {
						// System.out.println("Guessing " + (r + 1) + ", " + (c + 1));
						board[r][c] = 1;
						if (r == realX && c == realY)
							playing = false;
						break select;
					}
				}
			}

			// Eliminating
			int tempX = (int) (Math.random() * 6);
			int tempY = (int) (Math.random() * 6);
			// System.out.println("Eliminating " + (tempX + 1) + ", " + (tempY + 1));
			if (tempX > realX) {
				for (int r = 0; r < 6; r++) {
					for (int c = 0; c < 6; c++) {
						if (r >= tempX) {
							board[r][c] = 1;
						}
					}
				}
			} else if (tempX == realX) {
				for (int r = 0; r < 6; r++) {
					for (int c = 0; c < 6; c++) {
						if (r != tempX) {
							board[r][c] = 1;
						}
					}
				}
			} else {
				for (int r = 0; r < 6; r++) {
					for (int c = 0; c < 6; c++) {
						if (r <= tempX) {
							board[r][c] = 1;
						}
					}
				}
			}

			if (tempY > realY) {
				for (int r = 0; r < 6; r++) {
					for (int c = 0; c < 6; c++) {
						if (c >= tempY) {
							board[r][c] = 1;
						}
					}
				}
			} else if (tempY == realY) {
				for (int r = 0; r < 6; r++) {
					for (int c = 0; c < 6; c++) {
						if (c != tempY) {
							board[r][c] = 1;
						}
					}
				}
			} else {
				for (int r = 0; r < 6; r++) {
					for (int c = 0; c < 6; c++) {
						if (c <= tempY) {
							board[r][c] = 1;
						}
					}
				}
			}
		} while (playing);
		return rounds;
	}

	public static void main(String[] args) {
		// System.out.println("That was " + trial() + " turns.");
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			results.add(trial());
		}
		double mean = 0;
		for (int x : results) {
			mean += x;
		}
		mean /= results.size();

		double stdd = 0;
		for (int x : results) {
			stdd += (x - mean) * (x - mean);
		}
		stdd = Math.sqrt(stdd / results.size());
		System.out.println("Mean: " + mean);
		System.out.println("Standard Deviation: " + stdd);
	}

}
