package com.yahoo.mikhailjs.javaoop.group;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Group studGroup = new Group();

		for (;;) {
			try {
				addRandomStud(studGroup);
			} catch (GroupOverflowException e) {
				break;
			}
		}

		System.out.println(studGroup);

		Scanner sc = new Scanner(System.in);
		String s = null;

		for (;;) {
			s = dlgActions(sc);
			if (s == null || s.length() < 1) {
				continue;
			}
			if (s.charAt(0) == 'Q') {
				break;
			}
			switch (s.charAt(0)) {
			case 'W': 
				printGroupRows(studGroup);
				break;
			case 'R':
				System.out.println(" Remove fom group by last name:");
				studGroup.removeByLastName(sc.nextLine());
				break;
			case 'P':
				printGroup(studGroup);
				break;
			case 'A':
				try {
					addRandomStud(studGroup);
				} catch (GroupOverflowException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
		sc.close();
		System.out.println("Quit Program.");

	}

	public static String dlgActions(Scanner sc) {
		System.out.println("P print, W print rows, R remove,"
	+ " A add random, Q exit:");
		return sc.nextLine();
	}

	public static void printGroup(Group group) {
		System.out.println(group);
	}

	public static void printGroupRows(Group group) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;

		for (Student i : group.getMembers()) {
			counter++;
			if (i == null) {
				sb.append(String.format("%d). [ empty ]", counter));
				sb.append(System.lineSeparator());
				continue;
			}
			sb.append(String.format("%d). [ %s %s ]", counter,
						i.getFirstName(), i.getLastName()));
			sb.append(System.lineSeparator());
		}
		System.out.print(sb);
	}

	public static Student addRandomStud(Group group)
			throws GroupOverflowException {
		for (;;) {
			try {
				return group.addStudent(new Student(Content.randomHuman(),
								    "Cyber Security"));
			} catch (GroupOverflowException e) {
				throw e;
			} catch (GroupInsertionException e) {
				continue;
			}
		}
	}
}
