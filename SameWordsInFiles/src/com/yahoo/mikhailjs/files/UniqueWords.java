package com.yahoo.mikhailjs.files;

import java.util.Arrays;

public class UniqueWords {
	private String[] array;

	public UniqueWords() {
		super();
		array = new String[] {};
	}
	
	public static boolean isUnique(String string, String[] array) {
		for(String i : array) {
			if(string.compareTo(i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void addUnique(String string) {
		if(isUnique(string, array)) {
			int index = array.length;
			array = Arrays.copyOf(array, index+1);
			array[index] = string;
		}
	}
	
	public UniqueWords sort() {
		Arrays.sort(array, (a, b) -> a.compareTo(b));
		return this;
	}

	public String[] getArray() {
		return Arrays.copyOf(array, array.length);
	}

	public int getArrayLength() {
		return array.length;
	}
	
}
