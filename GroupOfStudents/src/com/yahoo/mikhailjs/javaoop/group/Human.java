package com.yahoo.mikhailjs.javaoop.group;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Human {
	private String firstName;
	private String lastName;
	private Date birthDate;
	private boolean sex;

	/**
	 * </b>Human<b>(String firstName, String lastName, Date birthDate, boolean sex)
	 */
	public Human(String firstName, String lastName, Date birthDate, boolean sex) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public int getAge() {
		Calendar current = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		int years;
		
		birth.setTime(birthDate);
		years = current.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		if (current.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
			years--;
		} else if (current.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)
				&& current.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
			years--;
		}
		return years;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public boolean isSex() {
		return sex;
	}

	@Override
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd MMMM y");
		
		return String.format("%s %s %s", firstName, lastName, fmt.format(birthDate));
	}
}
