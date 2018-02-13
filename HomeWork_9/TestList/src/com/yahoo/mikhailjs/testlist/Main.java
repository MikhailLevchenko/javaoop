package com.yahoo.mikhailjs.testlist;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		testList();
	}

	public static void testList() {
		ArrayList<String> somethingList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			somethingList.add("Something " + (i + 1));
		}
		somethingList.remove(0);
		somethingList.remove(0);
		somethingList.remove(somethingList.size() - 1);
		System.out.println(somethingList);
	}

}
