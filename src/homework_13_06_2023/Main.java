package homework_13_06_2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("Укажите путь: ");
            String path = scr.nextLine();
            System.out.println("Укажите название файла: ");
            String fileName = scr.nextLine();
            try {
                String result = searchingFile(path, fileName);
                if (result == null) {
                    System.out.println("Файл не найден. Укажите другой путь к директории или имя файла!");
                } else {
                    System.out.println(result);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String searchingFile(String path, String fileName) throws IOException {
        File file = new File(path);

        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("Указали неверный путь! Укажите путь до папки!");
            } else {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        String tmp = searchingFile(file1.getPath(), fileName);
                        if (tmp != null) {
                            return tmp;
                        }
                    } else if (file1.isFile() && file1.getName().equals(fileName)) {
                        return file1.getAbsolutePath();
                    }
                }
            }
        } else {
            throw new FileNotFoundException();
        }
        return null;
    }
}