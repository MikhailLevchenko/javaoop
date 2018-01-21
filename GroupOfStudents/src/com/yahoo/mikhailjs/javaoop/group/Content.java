package com.yahoo.mikhailjs.javaoop.group;

import java.util.Date;
import java.util.Calendar;
import java.util.Random;

public class Content {

	private static String[] firstNamesMale = new String[] {"Сергей", "Антон",
			"Владимир", "Игорь", "Борис", "Алексей", "Юрий", "Тарас", "Олег",
			"Ярослав", "Денис", "Степан", "Виктор", "Захар", "Арсен", "Назар",
			"Виталий","Мстислав", "Ростислав", "Григорий"};
	private static String[] lastNamesMale = new String[] {"Володин", "Исаев",
			"Смирнов", "Мельник", "Бойко", "Шевчук", "Неделин","Цыбин",
			"Захарчук", "Дашков", "Терюшин", "Кузнецов","Олейник", "Афонов",
			"Остапчук", "Хорунжий", "Устимов", "Пермин", "Репьев", "Журов"};
	private static String[] firstNames = new String[] {"Инна", "Лина", "Ольга",
			"Ксения", "Полина", "Дарья", "Мария", "Ирина", "София","Вероника",
			"Оксана", "Олеся", "Галина", "Карина", "Алиса", "Лариса", "Марина",
			"Виктория", "Светлана", "Людмила"};
	private static String[] lastNames = new String[] { "Володина", "Исаева",
			"Смирнова", "Мельник", "Бойко", "Шевчук", "Неделина", "Цыбина",
			"Захарчук", "Дашкова", "Терюшина","Кузнецова", "Олейник",
			"Афонова", "Остапчук", "Хорунжая", "Устимова", "Перминова",
			"Репьева", "Журова"};
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
		String lastName = randomLastName(sex);
		Calendar naw = Calendar.getInstance();
		int age = (int) (16+Math.random()*30);
		Date birthDate;
		
		naw.add(Calendar.YEAR, -age);
		naw.set(Calendar.DAY_OF_YEAR,
                randoms.nextInt(naw.getActualMaximum(Calendar.DAY_OF_YEAR)));
		naw.set(Calendar.MILLISECOND, 0);
		naw.set(Calendar.SECOND, 0);
		naw.set(Calendar.MINUTE, 0);
		naw.set(Calendar.HOUR_OF_DAY, 0);
		birthDate = naw.getTime();
		return new Human(firstName, lastName, birthDate, sex);
	}
}
