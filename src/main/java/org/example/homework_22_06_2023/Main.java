package org.example.homework_22_06_2023;

import java.util.Scanner;

public class Main {

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@yandex.ru == HeLLO@YANdex.RU
        - вывод на печать должен быть в нижнем регистре
           hello@yandex.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    private static EmailList emailList = new EmailList();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("[1] - ADD EMAIL\n[2] - LIST EMAILS\n[3] - EXIT");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.print("Enter the email: ");
                    String email = scanner.nextLine();
                    emailList.add(email);
                }
                case "2" -> emailList.getSortedEmails();
                case "3" -> run = false;
                default -> System.out.println("Wrong command! Enter one of these: ");
            }

            //TODO: write code here

        }
    }
}