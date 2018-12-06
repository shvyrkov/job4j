package ru.job4j.test_hunt4pro;

public class RefTask {
    public static void main(String[] args) {
        Integer value = 1;
        RefTask.change(value);
        System.out.println(value);
    }

    public static void change(Integer value) {
        ++value;
    }
}