package com.yahoo.mikhailjs.javaoop.group;

import java.util.Date;
import java.util.Calendar;
import java.util.Random;

public class Content {

	private static String[] firstNamesMale = new String[] {"Сергей",
			"Владимир", "Антон", "Игорь", "Борис", "Алексей",
			"Григорий", "Юрий", "Олег", "Ярослав","Мстислав",
			"Денис", "Виктор", "Захар", "Арсен", "Тарас", "Назар",
			"Виталий", "Степан", "Ростислав"};
	private static String[] lastNamesMale = new String[] {"Кузнецов",
			"Смирнов", "Мельник", "Бойко", "Шевчук", "Неделин",
			"Цыбин", "Захарчук", "Дашков", "Терюшин", "Володин",
			"Олейник", "Исаев", "Афонов", "Остапчук", "Хорунжий",
			"Устимов", "Пермин", "Репьев", "Журов"};
	private static String[] firstNames = new String[] {"Инна",
			"Лариса", "Ольга", "Ксения", "Полина", "Светлана",
			"Мария", "Ирина", "София", "Людмила", "Оксана", "Олеся",
			"Виктория", "Галина", "Вероника", "Лина", "Дарья",
			"Алиса", "Марина", "Карина"};
	private static String[] lastNames = new String[] {"Кузнецова",
			"Смирнова", "Мельник", "Бойко", "Шевчук", "Неделина",
			"Цыбина", "Захарчук", "Дашкова", "Терюшина", "Володина",
			"Олейник", "Исаева", "Афонова", "Остапчук", "Хорунжая",
			"Устимова", "Перминова", "Репьева", "Журова"};
	private static Random randoms = new Random();
	
	public static String randomFristName(boolean sex) {
		String firstName;
		
		if(sex) {
			firstName = firstNamesMale[randoms.nextInt(firstNamesMale.length)];
		} else {
			firstName = firstNames[randoms.nextInt(firstNames.length)];
		}
		return firstName;
	}
	
	public static String randomLastName(boolean sex) {
		String lastName;

		if(sex) {
			lastName = lastNamesMale[randoms.nextInt(lastNamesMale.length)];
		} else {
			lastName = lastNames[randoms.nextInt(lastNames.length)];
		}
		return lastName;
	}
	
	public static Human randomHuman() {

		boolean sex = randoms.nextBoolean();
		String firstName = randomFristName(sex);
		String laststName = randomLastName(sex);
		Calendar naw = Calendar.getInstance();
		int age = (int) (16+Math.random()*30);
		Date birthDate;
		
		naw.add(Calendar.YEAR, -age);
		naw.set(Calendar.DAY_OF_YEAR, randoms.nextInt(naw.getActualMaximum(Calendar.DAY_OF_YEAR)));
		naw.set(Calendar.MILLISECOND, 0);
		naw.set(Calendar.SECOND, 0);
		naw.set(Calendar.MINUTE, 0);
		naw.set(Calendar.HOUR_OF_DAY, 0);
		birthDate = naw.getTime();
		return new Human(firstName, laststName, birthDate, sex);
	}
}
