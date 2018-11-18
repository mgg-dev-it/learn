package mggdevit.learnjavacollection;

import java.util.ArrayList;
import java.util.List;

public class LearnArrayList {

	public LearnArrayList() {
	}

	public static void learn() {
		System.out.println("");
		System.out.println("Learning ArrayList");
		System.out.println("");
		List<String> list = new ArrayList<>();
		System.out.println("List<String> list = new ArrayList<>() : " + list.toString());
		list.add("SD");
		System.out.println("list.add(\"SD\") : " + list.toString());
		list.add(0, "NY");
		System.out.println("list.add(0, \"NY\") : " + list.toString());
		list.set(1, "FL");
		System.out.println("list.set(1, \"FL\") : " + list.toString());
		list.remove("NY");
		System.out.println("list.remove(\"NY\") : " + list.toString());
		list.remove(0);
		System.out.println("list.remove(0) : " + list.toString());

		list.add("OH");
		System.out.println("list.add(\"OH\") : " + list.toString());
		list.add("CO");
		System.out.println("list.add(\"CO\") : " + list.toString());
		list.add("NJ");
		System.out.println("list.add(\"NJ\") : " + list.toString());
		String state = list.get(0);
		System.out.println("String state = list.get(0) : " + state);
		int index = list.indexOf("NJ");
		System.out.println("int index = list.indexOf(\"NJ\") : " + index);
	}

}
