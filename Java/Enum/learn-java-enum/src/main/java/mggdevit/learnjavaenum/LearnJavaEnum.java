package mggdevit.learnjavaenum;

import java.util.Arrays;

public class LearnJavaEnum {

	private enum Fruits {
		APPLE, BANANA, ORANGE
	}

	private enum Numbers {

		ONE(1000), TWO(2000), THREE(3000);

		private int value;

		private Numbers(int value) {
			this.value = value;
		}

		public int getValue() {
			return (value);
		}
	}

	public static void main(String[] args) {
		LearnJavaEnum.learn();
	}

	public static void learn() {
		System.out.println("");
		System.out.println("LEARNING ENUMS");
		System.out.println("");

		Fruits apple = Fruits.APPLE;
		Fruits banana = Fruits.BANANA;
		Fruits orange = Fruits.ORANGE;
		System.out.println("");

		System.out.println(apple);
		System.out.println(banana);
		System.out.println(orange);
		System.out.println("");

		System.out.println(apple.ordinal());
		System.out.println(banana.ordinal());
		System.out.println(orange.ordinal());
		System.out.println("");

		for (Fruits fruit : Fruits.values()) {
			System.out.println(fruit.name() + " " + fruit.ordinal());
		}
		System.out.println("");

		System.out.println(Fruits.values()); //
		System.out.println(Arrays.asList(Fruits.values()));
		System.out.println("");

		System.out.println(apple == Fruits.APPLE);
		System.out.println(apple == Fruits.ORANGE);
		System.out.println("");

		Fruits f = Fruits.valueOf("BANANA");
		switch (f) {
		case APPLE:
			System.out.println("apple");
			break;
		case BANANA:
			System.out.println("banana");
			break;
		case ORANGE:
			System.out.println("orange");
			break;
		default:
			break;
		}
		System.out.println("");

		Numbers one = Numbers.ONE;
		Numbers two = Numbers.TWO;
		Numbers three = Numbers.THREE;

		for (Numbers number : Numbers.values()) {
			System.out.println(number.name() + " " + number.ordinal() + " " + number.getValue());
		}
		System.out.println("");

	}
}
