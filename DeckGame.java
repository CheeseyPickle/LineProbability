import java.util.ArrayList;

public class DeckGame {

	public static boolean trial() {
		// make a deck
		ArrayList<Integer> deck = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++)
			deck.add(i);

		// transfer cards randomly to another deck
		ArrayList<Integer> transferDeck = new ArrayList<Integer>();
		while (!deck.isEmpty()) {
			transferDeck.add(deck.remove((int) (Math.random() * deck.size())));
		}

		// check
		for (int i = 0; i < transferDeck.size(); i++) {
			if (transferDeck.get(i) == i)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int trials = 10000;
		int success = 0;
		for (int i = 0; i < trials; i++) {
			if (trial())
				success++;
		}
		double prob = success * 1.0 / trials;
		System.out.println(prob);
		System.out.println(1 / (1 - prob));
	}

}
