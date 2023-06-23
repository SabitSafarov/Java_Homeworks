package org.example.homework_22_06_2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    List<String> emails = new ArrayList<>();
    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        Pattern pattern = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() && !emails.contains(email.toLowerCase())) {
            emails.add(email.toLowerCase());
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        Collections.sort(emails);
        emails.forEach(System.out::println);
        return emails;
    }

}
