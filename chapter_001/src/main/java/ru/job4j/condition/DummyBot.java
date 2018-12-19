package ru.job4j.condition;

/** 
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.11.08
 */
public class DummyBot {
    /**
     * Глупый бот умеет отвечать только на три Фразы:
	 *1.Если пришла фаза "Привет, Бот." бот отвечает "Привет, умник."
	 *2.Если пришла фаза "Пока." бот отвечает "До скорой встречи."
	 *3.Если пришла любая другая фраза  бот отвечает "Это ставит меня в тупик. Спросите другой вопрос."
	 *
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";              
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
		return rsl;
     }
}

