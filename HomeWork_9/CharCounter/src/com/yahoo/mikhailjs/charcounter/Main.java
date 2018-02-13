package com.yahoo.mikhailjs.charcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		File inputFile = new File("./src/com/yahoo/mikhailjs/charcounter/CharsStatistic.java");
		Scanner sc = null;

		try {
			sc = new Scanner(inputFile);
			CharsStatistic chstat = new CharsStatistic();

			sc.useDelimiter(Pattern.compile("[^a-zA-Z]+"));
			for (; sc.hasNext();) {
				for (char i : sc.next().toCharArray()) {
					chstat.add(i);
				}
			}
			chstat.sort();
			System.out.println(chstat);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
