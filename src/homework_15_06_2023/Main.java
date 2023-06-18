package homework_15_06_2023;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File htmlFile = new File("src/homework_15_06_2023/data/code.html");
        try {
            Document doc = Jsoup.parse(htmlFile, "UTF-8");
            Elements link = doc.select("a");
            for (Element element : link) {
                System.out.println(element.text());
                System.out.println(element.attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}