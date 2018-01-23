package com.yahoo.mikhailjs.javaoop.group;

import java.util.Arrays;

public class Group {
	private Student[] members;

	public Group(int maxMembers, Student[] people) {
		this(maxMembers);
		try {
			addStudents(people);
		} catch (GroupInsertionException e) {
			System.out.println(e.getMessage());
		}
	}

	public Group(int maxMembres) {
		super();
		members = new Student[maxMembres];
	}

	public Group() {
		this(10);
	}

	public Student[] getMembers() {
		return Arrays.copyOf(members, members.length);
	}

	/**
	 * 
	 * @param students
	 * @throws GroupInsertExeption
	 */
	public void setMembers(Student[] students) 
			throws GroupInsertionException {
		addStudents(students);
	}

	/**
	 * 
	 * @param students
	 * @throws GroupInsertExeption
	 */
	private void addStudents(Student[] students) 
			throws GroupInsertionException {
		for (Object i : students) {
			try {
				addStudent((Student) i);
			} catch (GroupOverflowException e) {
				break;
			}
		}
	}

	/**
	 * 
	 * @param student
	 * @throws GroupInsertExeption
	 * @throws GroupOverflowException
	 */
	public Student addStudent(Student student) throws GroupInsertionException {

		String lastName = student.getLastName();
		String message;

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {
				continue;
			} else if (isInGroup(lastName)) {
				message = String.format("Студент с фамилией"
							+ " %s уже в гуппе.", lastName)
				throw new GroupInsertionException(message);
			} else {
				members[i] = student;
				return members[i];
			}
		}
		throw new GroupOverflowException("Group overflowing.");
	}

	private boolean isInGroup(String lastName) {
		return (getStudByLastName(lastName) != null);
	}
	
	public Student removeByLastName(String lastName) {
		Student student = null;
		
		for(int i = 0; i < members.length; i++) {
			if (members[i] == null) {
				continue;
			} else if (members[i].getLastName().equals(lastName)) {
				student = members[i];
				members[i] = null;
				break;
			}
		}
		return student;
	}

	public Student getStudByLastName(String lastName) {
		Student student = null;

		for (Student i : members) {
			if (i == null) {
				continue;
			} else if (i.getLastName().equals(lastName)) {
				student = i;
			}
		}
		return student;
	}

	public boolean isEmpty() {
		boolean empty = true;
		
		for(Student i : members) {
			if(i != null) {
				empty = false;
				break;
			}
		}
		return empty;
	}

	@Override
	public String toString() {
		String sep = System.lineSeparator();
		StringBuilder sb = new StringBuilder();
		int counter = 0;

		for (Student i = getFirstStud(); i != null; i = getNextStud(i)) {
			counter++;
			sb.append(String.format("%d). %s%s", counter, i, sep));
		}
		return sb.toString();
	}

	private Student getFirstStud() {
		Student stud = null;

		for (Student i : members) {
			if (i == null) {
				continue;
			}
			if (stud == null) {
				stud = i;
			} else if (stud.getLastName().compareTo(i.getLastName()) > 0) {
				stud = i;
			}
		}
		return stud;
	}

	private Student getNextStud(Student stud) {
		Student next = null;

		for (Student i : members) {
			if (i == null) {
				continue;
			}
			if (next == null) {
				if (stud.getLastName().compareTo(i.getLastName()) < 0) {
					next = i;
				}
			} else {
				if ((stud.getLastName().compareTo(i.getLastName()) < 0)) {
					if (next.getLastName().compareTo(i.getLastName()) > 0) {
						next = i;
					}
				}
			}
		}
		return next;
	}
	
	public int getMaxMembers() {
		return members.length;
	}
}
