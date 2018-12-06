package ru.job4j.test_hunt4pro;

public class ParameterTransfer {

	public static void main(String[] args) {
		String name = "Dog";
		change(name);
		System.out.println(name);
		name = change(name);
		System.out.println(name);
	}

	public static String change(String name) {
		name = name + "Cat";
		String surname = "Kotov";
		return surname;
	}
}