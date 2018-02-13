package com.yahoo.mikhailjs.charcounter;

import java.util.ArrayList;
import java.util.Comparator;

public class CharsStatistic {
	ArrayList<CharCount> chkList = new ArrayList<>();

	public void add(char ch) {
		for (CharCount i : chkList) {
			if (i.getCharacter() == ch) {
				i.increase();
				return;
			}
		}
		chkList.add(new CharCount(ch));
	}

	public void sort() {
		chkList.sort(new Comparator<CharCount>() {
			@Override
			public int compare(CharCount o1, CharCount o2) {
				return Integer.compare(o2.getRepeating(),
							o1.getRepeating());
			}
		});
	}

	@Override
	public String toString() {
		int n = 0;
		StringBuilder sb = new StringBuilder();
		for (CharCount i : chkList) {
			if (n > 0) {
				sb.append(System.lineSeparator());
			}
			n = n + 1;
			sb.append(String.format("%d). %s %d", n, i.getCharacter(),
						i.getRepeating()));
		}
		return sb.toString();
	}
}
