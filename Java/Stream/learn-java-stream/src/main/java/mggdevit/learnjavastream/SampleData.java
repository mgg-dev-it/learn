package mggdevit.learnjavastream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class SampleData {
	public static String[] createFruitArray() {
		String[] s = { "apple", "apricot", "avocado", "banana", "blackberry", "blackcurrant", "blueberry",
				"boysenberry", "cherry", "coconut", "fig", "grape", "grapefruit", "kiwifruit", "lemon", "lime",
				"lychee", "mandarin", "mango", "melon", "nectarine", "orange", "papaya", "passion fruit", "peach",
				"pear", "pineapple", "plum", "pomegranate", "quince", "raspberry", "strawberry", "watermelon" };
		return (s);
	}

	public static String[] createRandomOrderedFruitArray() {
		String[] s = { "apple", "apricot", "avocado", "banana", "blackberry", "blackcurrant", "blueberry",
				"boysenberry", "cherry", "coconut", "fig", "grape", "grapefruit", "kiwifruit", "lemon", "lime",
				"lychee", "mandarin", "mango", "melon", "nectarine", "orange", "papaya", "passion fruit", "peach",
				"pear", "pineapple", "plum", "pomegranate", "quince", "raspberry", "strawberry", "watermelon" };
		List<String> ls = Arrays.asList(s);
		Collections.shuffle(ls);
		return (ls.toArray(new String[0]));
	}

}
