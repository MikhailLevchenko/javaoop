package com.yahoo.mikhailjs.files;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		File fOne = new File("./src/com/yahoo/mikhailjs/files/Main.java");
		File fTwo = new File("./src/com/yahoo/mikhailjs/files/UniqueWords.java");
		File fOut = new File("./UniqueWords.txt");

		try {
			Intersecting.filesIntersect(fOne, fTwo, fOut);
		} catch (FileNotFoundException e) {
			System.out.print(e.getMessage());
			return;
		}

		System.out.println("Result in file:");
		System.out.println(fOut.toPath().toAbsolutePath().normalize());
	}

}
