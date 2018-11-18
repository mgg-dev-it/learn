package mggdevit.learnjavacollection;

import java.util.Set;
import java.util.TreeSet;

public class LearnTreeSet {

	public LearnTreeSet() {

	}

	public static void learn() {
		System.out.println("");
		System.out.println("Learning TreeSet");
		System.out.println("");
		System.out.println("TreeSet");
		Set<Integer> treeSet = new TreeSet<>();
		System.out.println("set.add(66) " + treeSet.add(66));
		System.out.println("set.add(10) " + treeSet.add(10));
		System.out.println("set.add(66) " + treeSet.add(66));
		System.out.println("set.add(8) " + treeSet.add(8));
		for (Integer integer : treeSet) {
			System.out.print(integer + ",");
		}
		System.out.println("");
	}
}
