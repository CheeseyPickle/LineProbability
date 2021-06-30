
public class LineGame {

	public static boolean trial() {
		// For the sake of the problem, I'm saying the lines are vertical, bc you can always rotate them

		// the y-value of the initial point really doesn't matter, and the x can be modded by l
		// So, I guess l = 1 for the sake of this
		double x = Math.random();

		// To make this point into a random line, I'll choose the other endpoint through getting a random angle
		double angle = Math.random() * 2 * Math.PI;

		if (x + Math.cos(angle) <= 0 || x + Math.cos(angle) >= 1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int trials = 1000000;
		int success = 0;
		for (int i = 0; i < trials; i++) {
			if (trial()) {
				success++;
			}
		}
		System.out.println(success * 1.0 / trials);
	}

}
