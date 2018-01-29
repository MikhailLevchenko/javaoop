package com.yahoo.mikhailjs.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Intersecting {
	
	/**
	 * @param fInOne Input file.
	 * @param fInTwo Input file.
	 * @param fOut	 Output file.
	 * @throws FileNotFoundException
	 */
	public static void filesIntersect(File fInOne, File fInTwo, File fOut) throws FileNotFoundException {
		try (Scanner scOne = new Scanner(fInOne);
				Scanner scTwo = new Scanner(fInTwo);
				PrintWriter pw = new PrintWriter(fOut)) {
			UniqueWords unique = new UniqueWords();
			Pattern delimiter = Pattern.compile("[\\p{Space},\\p{Cntrl},\\p{Punct}]+");

			scOne.useDelimiter(delimiter);
			scTwo.useDelimiter(delimiter);
			while (scOne.hasNext()) {
				unique.addUnique(scOne.next());
			}

			UniqueWords intersect = new UniqueWords();
			String[] array = unique.getArray();
			String string;

			while (scTwo.hasNext()) {
				string = scTwo.next();
				if (!UniqueWords.isUnique(string, array)) {
					intersect.addUnique(string);
				}
			}

			for (String i : intersect.sort().getArray()) {
				pw.println(i);
			}
		}
	}
	
}
