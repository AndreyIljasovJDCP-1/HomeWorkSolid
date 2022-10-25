package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);
        products.put("Пирожное", 60);
        int productLineSize = products.size();
        printProductLine(products);

        Basket basket = new Basket(productLineSize);

        while (true) {
            System.out.println("Введите два слова: название товара и количество" +
                    " через пробел или end - для выхода.");
            String line = scanner.nextLine();

            if ("end".equals(line)) break;

            String[] parts = line.split(" ");
            if (parts.length != 2) {
                printError("введено не 2 значения: " + line);
                continue;
            }

            String product = parts[0];
            if (!products.containsKey(product)) {
                printError("товара нет в ассортименте: " + parts[0]);
                continue;
            }

            try {
                int count = Integer.parseInt(parts[1]);
                basket.addPurchase(product, count);
            } catch (NumberFormatException e) {
                printError("некорректное количество: " + parts[1]);
            }

        }
        basket.printBasket(products);
    }

    private static void printProductLine(Map<String, Integer> products) {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey()
                    + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }

    private static void printError(String message) {
        System.out.println("ошибка ввода: " + message);
    }
}
