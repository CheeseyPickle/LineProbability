package bashers;

import java.util.ArrayList;

public class TriangleArea {

	public static double trial() {
		double a = Math.random() * 0.5;
		double x = 0.5 - (Math.random() * a);
		double s = 0.5;
		return Math.sqrt(s * (s - a) * (s - x) * (x + a - s));
	}

	public static void main(String[] args) {
		int trials = 10000000;
		ArrayList<Double> results = new ArrayList<Double>();
		double ev = 0;
		for (int i = 0; i < trials; i++)
			results.add(trial());
		for (double result : results) {
			ev += result;
		}
		ev /= trials;
		double stdd = 0;
		for (double result : results) {
			stdd += (ev - result) * (ev - result);
		}
		stdd = Math.sqrt(stdd / trials);
		System.out.println(ev);
		System.out.println(stdd);
	}

}
