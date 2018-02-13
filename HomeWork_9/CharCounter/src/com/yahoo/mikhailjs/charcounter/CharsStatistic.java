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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chkList == null) ? 0 : chkList.hashCode());
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
		CharsStatistic other = (CharsStatistic) obj;
		if (chkList == null) {
			if (other.chkList != null)
				return false;
		} else if (!chkList.equals(other.chkList))
			return false;
		return true;
	}
	
}
