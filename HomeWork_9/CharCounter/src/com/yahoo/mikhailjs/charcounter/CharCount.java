package com.yahoo.mikhailjs.charcounter;

public class CharCount {
	private char character;
	private int repeating;

	public CharCount(char a) {
		super();
		this.character = a;
		this.repeating = 1;
	}

	public char getCharacter() {
		return character;
	}

	public int getRepeating() {
		return repeating;
	}

	public void increase() {
		repeating = repeating + 1;
	}
}
