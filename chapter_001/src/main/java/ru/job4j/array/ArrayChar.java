package ru.job4j.array;

/**
 *Класс ArrayChar для проверки префикса.
 *
 *@author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 *@version 1.0
 *@since 2018.11.22
 */
/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data; 
	
	public ArrayChar(String line) {
		this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return true, если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
		for (int i = 0; i < value.length; i++) {
			if (data[i] != value[i]) {
				result = false;
				break;
			}
		}        
        return result;
    }
}
			