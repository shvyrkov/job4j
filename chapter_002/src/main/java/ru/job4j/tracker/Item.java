package ru.job4j.tracker;

/**
 * Класс Item - заявка.
 *
 * @author Shvyrkov Yuri (mailto: shvyrkov@yandex.ru)
 * @version 1.0
 * @since 2019.01.08
 */
public class Item {
    /**
     * id - уникальный номер заявки.
     */
    private String id;
    /**
     * name - имя.
     */
    private String name;
    /**
     * desc - Описание заявки.
     */
    private String desc;
    /**
     * created - дата создания заявки.
     */
    private long created;
    /**
     * comments - список комментариев.
     */
    private String[] comments;

    public Item() {
    }

    public Item(String name, String desc, long created) {
 //       this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
 //       this.comments = comments; //?
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return this.created;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String[] getComments() {
        return this.comments;
    }
}