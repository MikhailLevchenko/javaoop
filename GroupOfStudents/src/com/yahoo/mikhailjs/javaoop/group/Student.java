package com.yahoo.mikhailjs.javaoop.group;

public class Student extends Human {
	String specialty;
	
	public Student(Human human, String specialty ) {
		super(human.getFirstName(), human.getLastName(), human.getBirthDate(),
		      human.isSex());
		this.specialty = specialty;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s study \"%s\"", getFirstName(),
				     getLastName(), getSpecialty());
	}
}
