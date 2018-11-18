package mggdevit.learnjavacollection;

public class LearnJavaCollection {
	public static void main(String[] args) {
//		LearnArrayList.learn();
//		LearnHashSet.learn();
//		LearnTreeSet.learn();
		LearnJavaCollection.learn();
	}

	public static void learn() {
		// https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html
		// https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
		// https://docs.oracle.com/javase/8/docs/api/java/util/List.html
		// https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
		// https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
		// https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
		System.out.println("");
		System.out.println("LEARNING COLLECTIONS");
		System.out.println("");
		System.out.println("List: ordered, indexed");
		System.out.println("Set: no duplicates");
		System.out.println("Queue: ordered (eg. fifo)");
		System.out.println("Map: key-value pairs (no duplicate keys)");
		System.out.println("");
		System.out.println("Common methods: add(), remove(), isEmpty(), size(), clear(), contains()");
		System.out.println("");
		System.out.println("LIST");
		System.out.println("ArrayList, LinkedList, Vector, Stack");
		System.out.println("");
		LearnArrayList.learn();
		LearnHashSet.learn();
		LearnTreeSet.learn();
		System.out.println("");
	}

}
