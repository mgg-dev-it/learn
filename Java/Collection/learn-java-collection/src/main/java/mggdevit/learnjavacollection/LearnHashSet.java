package mggdevit.learnjavacollection;

import java.util.HashSet;
import java.util.Set;

public class LearnHashSet {

	public LearnHashSet() {

	}

	public static void learn() {
		System.out.println("");
		System.out.println("Learning HashSet");
		System.out.println("");
		System.out.println("HashSet");
		Set<Integer> hashSet = new HashSet<>();
		System.out.println("set.add(66) " + hashSet.add(66));
		System.out.println("set.add(10) " + hashSet.add(10));
		System.out.println("set.add(66) " + hashSet.add(66));
		System.out.println("set.add(8) " + hashSet.add(8));
		for (Integer integer : hashSet) {
			System.out.print(integer + ",");
		}
		System.out.println("");
	}
}
