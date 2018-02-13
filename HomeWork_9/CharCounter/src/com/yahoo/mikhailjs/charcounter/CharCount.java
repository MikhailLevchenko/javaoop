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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + character;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharCount other = (CharCount) obj;
		if (character != other.character)
			return false;
		return true;
	}
	
}
