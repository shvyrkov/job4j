package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**Тест для проверки глупого бота.
 * @author Yuri Shvyrkov (mailto:shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2018.11.08
 */
public class DummyBotTest {	
/**
*Если пришла фаза "Привет, Бот." бот отвечает "Привет, умник."
*/
	    @Test
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Привет, Бот."),
                is("Привет, умник.")
        );
    }
/**
*Если пришла фаза "Пока." бот отвечает "До скорой встречи."
*/
    @Test
    public void whenByuBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Пока."),
                is("До скорой встречи.")
        );
    }
/**
*Если пришла любая другая фраза  бот отвечает "Это ставит меня в тупик. Спросите другой вопрос."
*/
    @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Сколько будет 2 + 2?"),
                is("Это ставит меня в тупик. Спросите другой вопрос.")
        );
    }
}